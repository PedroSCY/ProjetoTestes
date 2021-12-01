package com.tt.ProjetoTestes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tt.ProjetoTestes.repositorys.CentralDoSistemaRepository;
import com.tt.ProjetoTestes.util.CentralDoSistema;

@Service
public class CentralDoSistemaService {

	@Autowired
	private CentralDoSistemaRepository centralDoSistemaRepository;
	
	private CentralDoSistema arquivoConfiguracao;
	
	public CentralDoSistemaService() {
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
	
//	public static void main (String[]args ) {
//		
//		CentralDoSistemaService centralDoSistemaService = new CentralDoSistemaService();
//		
//		CentralDoSistema cds = centralDoSistemaService.getInstance();
//		
//		cds.setValorBase(5);
//		
//		centralDoSistemaService.salvarCentralDoSistema(cds);
//		
//		System.out.println(cds.getValorBase());
//		
//		System.out.println(centralDoSistemaService.getInstance().getValorBase());
//	}
	
}
