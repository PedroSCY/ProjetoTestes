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
	
	private TelaPrincipal telaprincipal;
	
	@Autowired
	private TelaPrincipalAutenticacao telaPrincipalAutenticacao;
	
//	private RegistradorSessaoLogin registradorSessaoLogin = RegistradorSessaoLogin.getInstance();
	
	public void setTela(TelaPrincipal telaprincipa){
		this.telaprincipal = telaprincipa;
	}
	
	public void fazerLogoff() {
//		telaprincipal.dispose();
		telaPrincipalAutenticacao.dispose();
		telaPrincipalAutenticacao.Iniciar();
	}
	
	
	
	
}
