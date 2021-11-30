package com.tt.ProjetoTestes.facades.casosdeuso;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.ProjetoTestes.model.entidades.ClienteMensalista;
import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.model.entidades.RegistroPagamento;
import com.tt.ProjetoTestes.services.CentralDoSistemaService;
import com.tt.ProjetoTestes.services.ClienteMensalistaService;
import com.tt.ProjetoTestes.services.FuncionarioService;
import com.tt.ProjetoTestes.services.RegistroPagamentoService;
import com.tt.ProjetoTestes.util.CentralDoSistema;
import com.tt.ProjetoTestes.util.ValidadoraDatas;

//import persistencia.dao.RegistroPagamentoService;

@Component
public class FacadePagamentos {

	@Autowired
	private Funcionario funcionario;

	@Autowired
	private RegistroPagamento registroPagamento;
	
	@Autowired
	private RegistroPagamentoService registroPagementoService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private ClienteMensalistaService clienteMensalistaService;

	@Autowired
	private CentralDoSistemaService central;
	
	
	public FacadePagamentos() {
		
	}

//	private RegistroPagamentoService dAORegistroPagamento;

	public void registrarPagamento(long matricula, float valorPago, long id) throws Exception {

		
		
		funcionario = funcionarioService.recuperarPelaMatricula(matricula);
		registroPagamento = registroPagementoService.recuperarPorId(id);
		
		registroPagamento.setValorPago(valorPago);
		registroPagamento.setNoEstacionamento(false);
		registroPagamento.setFuncionario(funcionario);
		
				
		registroPagementoService.atualizarRegistro(registroPagamento);
		funcionarioService.atualizarFuncionario(funcionario);
		
		CentralDoSistema cds = central.getInstance();
		cds.setQuantidadeVagasDisponiveis(central.getInstance().getQuantidadeVagasDisponiveis()+1);
		central.salvarCentralDoSistema(cds);
		
	}
	
	public void descontarDeCredito(long matricula, float valorAPagar, long id, long cpf) throws Exception {
	
		ClienteMensalista clienteMensalista = clienteMensalistaService.recuperarPeloCPF(cpf);
		
		clienteMensalistaService.atualizarclienteMensalista(realizarPagamento(clienteMensalista, valorAPagar));
		
		registrarPagamento(matricula, valorAPagar, id);
		
	}
	
	public void receberVeiculo(String placaVeiculo, long matricula) throws Exception{
		
		
		funcionario = funcionarioService.recuperarPelaMatricula(matricula);
		registroPagamento = funcionario.registrarPagamento(0, placaVeiculo, funcionario);
				
		registroPagementoService.salvarRegistro(registroPagamento);
	
		if(verificarVagasDisponiveis() < 1) {
			throw new Exception("Não há vagas disponíveis");
		}
		
		CentralDoSistema cds = central.getInstance();
		cds.setQuantidadeVagasDisponiveis(central.getInstance().getQuantidadeVagasDisponiveis()-1);
		central.salvarCentralDoSistema(cds);
		
		
//		funcionarioService.atualizar(matricula, funcionario);
		
	}

	public int verificarVagasDisponiveis() {
		
		return central.getInstance().getQuantidadeVagasDisponiveis();
		
	}
	
	public float calcularTotalAPagar(LocalDateTime data) throws Exception {
		
//		CentralDoSistema centralDoSistema = daoCentralDoSistema.recuperarCentral();
		
		float horaTotal = ValidadoraDatas.calcularQuantidadeDeHoraEntreDatas(data, LocalDateTime.now());
		float horaExtra = horaTotal - 1;
		
		return central.getInstance().getValorBase() + (central.getInstance().getValorPorHoraExtra()*horaExtra);
	}
	
	public RegistroPagamento[] getTodosOsRegstrosDePagamento() {
		Set<RegistroPagamento> registrosDePagamento = registroPagementoService.consultarTodos();
		return registrosDePagamento.toArray(new RegistroPagamento[registrosDePagamento.size()]);
	}
	
	private ClienteMensalista realizarPagamento(ClienteMensalista clienteMensalista, float valorAPagar) throws Exception{
		
		float valorNaConta = clienteMensalista.getCreditoDisponivel();
		
		if(valorNaConta < valorAPagar) {
			throw new Exception("Valor de crédito inferior ao pagamento");
		}
		
		clienteMensalista.setCreditoDisponivel(valorNaConta-valorAPagar);
		return clienteMensalista;
	}

}
