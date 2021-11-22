package com.tt.ProjetoTestes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tt.ProjetoTestes.model.entidades.ClienteMensalista;
import com.tt.ProjetoTestes.repositorys.ClienteMensalistaRepository;

@Service
public class ClienteMensalistaService {

	@Autowired
	private ClienteMensalistaRepository clienteMensalistaRepository;

	// metodo de cadastrar Cliente Mensalista
	public boolean cadastrarClienteMensalista(String nome) {

		ClienteMensalista clienteRecuperado = clienteMensalistaRepository.findByNome(nome);
		System.out.println(clienteRecuperado);
		if (clienteRecuperado == null) {
			ClienteMensalista auxiliar = new ClienteMensalista(nome);
			clienteMensalistaRepository.save(auxiliar);
			return true;
		}
		return false;
	}

}
