package com.tt.ProjetoTestes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tt.ProjetoTestes.repositorys.CentralDoSistemaRepository;
import com.tt.ProjetoTestes.util.CentralDoSistema;
import com.tt.ProjetoTestes.view.projetos.TelaPrincipal.OuvinteAtualizar;

public class CentralDoSistemaService {

	@Autowired
	private CentralDoSistemaRepository centralDoSistemaRepository;
	
	private CentralDoSistema arquivoConfiguracao;
	
	public CentralDoSistemaService() {
		try {
			arquivoConfiguracao = recuperarCentralDoSistemaPeloId();
		}catch (Exception e) {
			arquivoConfiguracao = new CentralDoSistema();
		}	
	}
	
	public void salvarCentralDoSistema(CentralDoSistema centralDoSistema) {
		centralDoSistemaRepository.save(centralDoSistema);
		arquivoConfiguracao = centralDoSistema;
	}
	
	public CentralDoSistema recuperarCentralDoSistemaPeloId() throws Exception {
		Optional<CentralDoSistema> optional = centralDoSistemaRepository.findById(1);
	
		if(optional.isPresent())
			return optional.get();
	
		throw new Exception("[ERRO] Central não Cadastrada");
	}

	public CentralDoSistema getInstance() {
		try {
			arquivoConfiguracao = recuperarCentralDoSistemaPeloId();
		}catch (Exception e) {
			arquivoConfiguracao = new CentralDoSistema();
		}	
		return arquivoConfiguracao;
	}
	
}
