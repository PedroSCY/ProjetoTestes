package com.tt.ProjetoTestes.controller.projetos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tt.ProjetoTestes.view.autenticacao.TelaPrincipalAutenticacao;
import com.tt.ProjetoTestes.view.projetos.TelaPrincipal;

/**
 * 
 * @author NPG
 *
 *Essa classe é o controller como realiza operações da tela Principal
 */

@Controller
public class ControllerTelaPrincipal {
	
	@Autowired
	private TelaPrincipal telaprincipal;
	
//	private RegistradorSessaoLogin registradorSessaoLogin = RegistradorSessaoLogin.getInstance();
	
	public ControllerTelaPrincipal(TelaPrincipal telaprincipa){
		this.telaprincipal = telaprincipa;
	}
	
	public void fazerLogoff() {
		telaprincipal.dispose();
		new TelaPrincipalAutenticacao();
	}
	
//	public void voltaPraTelaPonto() {
//		
//	}
	
	
	
}
