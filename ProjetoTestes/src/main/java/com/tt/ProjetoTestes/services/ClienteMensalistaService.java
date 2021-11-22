package com.tt.ProjetoTestes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tt.ProjetoTestes.model.entidades.ClienteMensalista;
import com.tt.ProjetoTestes.repositorys.ClienteMensalistaRepository;

@Service
public class ClienteMensalistaService {

	@Autowired
	private ClienteMensalistaRepository clienteMensalistaRepository;

	/**
	 * Esse método salva ( Adiciona ao banco de dados) um unico objeto clienteMensalista por vez. 
	 * @param ClienteMensalista objeto a ser adicionada ao banco
	 * @throws Exception Caso já exista um objeto clienteMensalista cadastrado como o mesmo CPF ou email do objeto passado por parametro.
	 */
	public void salvarclienteMensalista(ClienteMensalista clienteMensalista) throws Exception {
		if(!verificarExistenciaCPF(clienteMensalista.getCpf()) && !verificarExistenciaEmail(clienteMensalista.getEmail())) {
			
			clienteMensalistaRepository.save(clienteMensalista);
			
		}else {
			throw new Exception("[ERRO] O CPF ou Email"+ clienteMensalista.getCpf() +" "+ clienteMensalista.getEmail() + " Já foi cadastrado.");
		}
	}
	
	/**
	 * Esse metodo atualiza as informações de um objeto clienteMensalista já cadastrado.
	 * @param clienteMensalista Objeto recuperado já alterado.
	 * @throws Exception Caso o email, CPF ou matricula seja alterada.
	 */
	public void atualizarclienteMensalista(ClienteMensalista clienteMensalista) throws Exception {
		ClienteMensalista clienteMensalistaTemp = recuperarPeloId(clienteMensalista.getId());
	
		if(clienteMensalistaTemp.equals(clienteMensalista)) {
			clienteMensalistaRepository.save(clienteMensalista);
		}else {
			throw new Exception("[ERRO] Email e CPF  não podem ser alterados.");
		}
	}
	
	
	/**
	 * Este metodo deleta o clienteMensalista cadastrado com a CPF passada como parametro.
	 * @param CPF CPF do clienteMensalista que deseja-se deletar.
	 * @throws Exception Caso não haja clienteMensalista cadastrado com a matricula passada como parametro.
	 */
	public void excluirclienteMensalista(long CPF) throws Exception {
		clienteMensalistaRepository.delete(recuperarPeloCPF(CPF));
	}
	
	/**
	 * Esse metodo deleta todos os clienteMensalistas do banco.
	 */
	public void excluirTudo() {
		clienteMensalistaRepository.deleteAll();
	}
	
	/**
	 * Esse metodo recupera um clienteMensalista pelo email cadastrado.
	 * @param email Email do clienteMensalista ao qual deseja-se encontrar.
	 * @return retorna o proprio objeto clienteMensalista encontrado
	 * @throws Exception caso nehnum clienteMensalista seja encontrado.
	 */
	public ClienteMensalista recuperarPeloEmail(String email) throws Exception {
		if(clienteMensalistaRepository.findByEmail(email).size() >= 1) 
			return (ClienteMensalista) clienteMensalistaRepository.findByEmail(email).get(0);
		
		throw new Exception("[ERRO] Email: " + email + " não cadastrado");
		
	}
	
	/**
	 * Esse metodo recupera um clienteMensalista pelo CPF cadastrado.
	 * @param CPF CPF do clienteMensalista ao qual deseja-se encontrar.
	 * @return retorna o proprio objeto clienteMensalista encontrado
	 * @throws Exception caso nehnum clienteMensalista seja encontrado.
	 */
	public ClienteMensalista recuperarPeloCPF(long CPF) throws Exception {
		if(clienteMensalistaRepository.findByCPF(CPF).size() >=1) 
			return (ClienteMensalista) clienteMensalistaRepository.findByCPF(CPF);
		
		throw new Exception("[ERRO] CPF: " + CPF + " Não Cadastrado");
	}
	
	
	/**
	 * Esse metodo recupera um clienteMensalista pelo ID cadastrado.
	 * @param id ID do clienteMensalista ao qual deseja-se encontrar.
	 * @return retorna o proprio objeto clienteMensalista encontrado
	 * @throws Exception caso nehnum clienteMensalista seja encontrado.
	 */
	public ClienteMensalista recuperarPeloId(long id) throws Exception {
		Optional<ClienteMensalista> optional = clienteMensalistaRepository.findById(id);
	
		if(optional.isPresent())
			return optional.get();
		
		throw new Exception("[ERRO] clienteMensalista não encontrado");
		
	}
	
	/**
	 * Esse metodo verifica se existe algum objeto clienteMensalista cadastrado com o CPF Passado como parametro
	 * @param cpf CPF que se deseja verificar a existencia no banco.
	 * @return valor booleano true caso não encontre ou false caso encontre.
	 */
	public boolean verificarExistenciaCPF(long cpf) {
		try {
			recuperarPeloCPF(cpf);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Esse metodo verifica se existe algum objeto clienteMensalista cadastrado com o Email Passado como parametro
	 * @param email Email que se deseja verificar a existencia no banco.
	 * @return valor booleano true caso não encontre ou false caso encontre.
	 */
	public boolean verificarExistenciaEmail(String email) {
		try {
			recuperarPeloEmail(email);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

}
