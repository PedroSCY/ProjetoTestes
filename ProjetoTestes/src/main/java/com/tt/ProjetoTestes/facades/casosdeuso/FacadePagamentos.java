package com.tt.ProjetoTestes.facades.casosdeuso;

import java.time.LocalDateTime;
import java.util.Set;

import com.tt.ProjetoTestes.model.entidades.ClienteMensalista;
import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.model.entidades.RegistroPagamento;
import com.tt.ProjetoTestes.persistencia.DAOClienteMensalista;
import com.tt.ProjetoTestes.persistencia.DAOFuncionario;
import com.tt.ProjetoTestes.persistencia.DAORegistroPagamento;
import com.tt.ProjetoTestes.util.CentralDoSistema;
import com.tt.ProjetoTestes.util.ValidadoraDatas;

//import persistencia.dao.DAORegistroPagamento;

public class FacadePagamentos {

	private Funcionario funcionario;
	private RegistroPagamento registroPagamento;
	
	private DAORegistroPagamento daoRegistroPagamento;
	private DAOFuncionario daoFuncionario;
//	private DAOCentralDoSistema daoCentralDoSistema;
	private DAOClienteMensalista daoClienteMensalista;
	private CentralDoSistema central = CentralDoSistema.getInstance();
	
	
	public FacadePagamentos() {
		
		daoRegistroPagamento = new DAORegistroPagamento();
		daoFuncionario = new DAOFuncionario();
//		daoCentralDoSistema = new DAOCentralDoSistema();
		daoClienteMensalista = new DAOClienteMensalista();
	}

//	private DAORegistroPagamento dAORegistroPagamento;

	public void registrarPagamento(long matricula, float valorPago, long id) throws Exception {

		
		
		funcionario = daoFuncionario.consultarFuncionario(matricula);
		registroPagamento = daoRegistroPagamento.consultarRegistro(id);
		
		registroPagamento.setValorPago(valorPago);
		registroPagamento.setNoEstacionamento(false);
		registroPagamento.setFuncionario(funcionario);
		
				
		daoRegistroPagamento.atualizar(id, registroPagamento);
		daoFuncionario.atualizar(matricula, funcionario);
		central.setQuantidadeVagasDisponiveis(central.getQuantidadeVagasDisponiveis()+1);
		central.salvarCentral();
		
	}
	
	public void descontarDeCredito(long matricula, float valorAPagar, long id, long cpf) throws Exception {
	
		ClienteMensalista clienteMensalista = daoClienteMensalista.consultarCliente(cpf);
		
		daoClienteMensalista.atualizar(cpf, realizarPagamento(clienteMensalista, valorAPagar));
		
		registrarPagamento(matricula, valorAPagar, id);
		
	}
	
	public void receberVeiculo(String placaVeiculo, long matricula) throws Exception{
		
		
		funcionario = daoFuncionario.consultarFuncionario(matricula);
		registroPagamento = funcionario.registrarPagamento(0, placaVeiculo, funcionario);
				
		daoRegistroPagamento.criar(registroPagamento);
	
		if(verificarVagasDisponiveis() < 1) {
			throw new Exception("Não há vagas disponíveis");
		}
		central.setQuantidadeVagasDisponiveis(central.getQuantidadeVagasDisponiveis()-1);
		central.salvarCentral();
//		daoFuncionario.atualizar(matricula, funcionario);
		
	}

	public int verificarVagasDisponiveis() {
		
		return central.getQuantidadeVagasDisponiveis();
		
	}
	
	public float calcularTotalAPagar(LocalDateTime data) throws Exception {
		
//		CentralDoSistema centralDoSistema = daoCentralDoSistema.recuperarCentral();
		
		float horaTotal = ValidadoraDatas.calcularQuantidadeDeHoraEntreDatas(data, LocalDateTime.now());
		float horaExtra = horaTotal - 1;
		
		return central.getValorBase() + (central.getValorPorHoraExtra()*horaExtra);
	}
	
	public RegistroPagamento[] getTodosOsRegstrosDePagamento() {
		Set<RegistroPagamento> registrosDePagamento = daoRegistroPagamento.consultarTodos();
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
