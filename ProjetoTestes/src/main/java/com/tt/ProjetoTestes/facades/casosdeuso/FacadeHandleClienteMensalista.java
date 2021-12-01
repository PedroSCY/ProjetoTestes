package com.tt.ProjetoTestes.facades.casosdeuso;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.ProjetoTestes.model.entidades.ClienteMensalista;
import com.tt.ProjetoTestes.services.ClienteMensalistaService;
import com.tt.ProjetoTestes.util.ValidadoraFormatoEmail;

//import dao.ClienteMensalistaService;

@Component
public class FacadeHandleClienteMensalista {


	@Autowired
	private ClienteMensalistaService clienteMensalistaService;

	private ClienteMensalista clienteMensalista;


	//TODO - atualizar UML
	public void registrarCredito(long matricula, long cpf, float valorCreditado) throws Exception {

		clienteMensalista = clienteMensalistaService.recuperarPeloCPF(cpf);

		clienteMensalista.setCreditoDisponivel(valorCreditado);
		
		clienteMensalistaService.atualizarclienteMensalista(clienteMensalista);
		
		
	}

	//TODO -atualizar o UML
	public void cadastrarNovoCliente(String nome, String email, String senha, long cpf) throws Exception {

		if(!validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		
		clienteMensalistaService.ClienteMensalistaNaoExiste(cpf);
		
		ClienteMensalista clienteMensalista = new ClienteMensalista(nome, email, senha, cpf, 0);
		
		clienteMensalistaService.salvarclienteMensalista(clienteMensalista);
	}

	public ClienteMensalista recuperarCliente(long cpf) throws Exception {
		return clienteMensalistaService.recuperarPeloCPF(cpf);
	}

	public Set<ClienteMensalista> listarClientes() {
		return clienteMensalistaService.recuperarTodos();
	}
//TODO - atualizar UML
	public void atualizarCadastroDeCliente(String nome, String email, String senha, long cpf) throws Exception {
		
		if(!validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		
		clienteMensalista = clienteMensalistaService.recuperarPeloEmail(email);
		
		clienteMensalista.setNome(nome);
		clienteMensalista.setSenha(senha);
		
		clienteMensalistaService.atualizarclienteMensalista(clienteMensalista);
		
		
	}

	public void removerCliente(long cpf) throws Exception {

		clienteMensalistaService.excluirclienteMensalista(cpf);
	}

	private boolean validarEmail(String email) {
		return ValidadoraFormatoEmail.validarEmail(email);
	}
	
	public ClienteMensalista[] getTodosOsClientesMensalistas() {
		Set<ClienteMensalista> clientesMensalistasRegistrados = listarClientes();
		return clientesMensalistasRegistrados.toArray(new ClienteMensalista[clientesMensalistasRegistrados.size()]);
	}

	public void adicionarCredito(long cpf, float valor) throws Exception{
		
		clienteMensalista = clienteMensalistaService.recuperarPeloCPF(cpf);
		clienteMensalista.setCreditoDisponivel(clienteMensalista.getCreditoDisponivel()+valor);
		clienteMensalistaService.atualizarclienteMensalista(clienteMensalista);
		
		
	}
}
