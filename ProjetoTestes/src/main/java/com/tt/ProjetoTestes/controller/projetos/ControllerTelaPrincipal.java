package com.tt.ProjetoTestes.controller.projetos;

import com.tt.ProjetoTestes.view.autenticacao.TelaPrincipalAutenticacao;
import com.tt.ProjetoTestes.view.projetos.TelaPrincipal;

/**
 * 
 * @author NPG
 *
 *Essa classe é o controller como realiza operações da tela Principal
 */
public class ControllerTelaPrincipal {
	
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
