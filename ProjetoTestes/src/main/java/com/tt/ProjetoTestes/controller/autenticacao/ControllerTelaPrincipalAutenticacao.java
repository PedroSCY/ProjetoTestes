package com.tt.ProjetoTestes.controller.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tt.ProjetoTestes.view.autenticacao.TelaCadastroEstacionamento;
import com.tt.ProjetoTestes.view.autenticacao.TelaPrincipalAutenticacao;

/**
 * 
 * @author NPG
 *
 *  Essa classe é o controller que realiza operações do JFrame TelaPrincipalAutenticacao.
 *  
 */

@Controller
public class ControllerTelaPrincipalAutenticacao {
	
	@Autowired
	private static TelaPrincipalAutenticacao telaPrincipalAutenticacao;
	
	private boolean primeiroAcesso;
	
	public ControllerTelaPrincipalAutenticacao(TelaPrincipalAutenticacao tpa) {
		telaPrincipalAutenticacao = tpa;
	}
	
	public boolean isPrimeiroAcesso() {
		return ControllerTelaCriarConta.isPrimeiroAcesso();
		
	}
	
	public static void encerrarJanela() {
		telaPrincipalAutenticacao.dispose();
	}
		
	public void setPrimeiroAcesso(boolean primeiroAcesso) {
		
		this.primeiroAcesso = primeiroAcesso;
	}
	
	public void proximaTela(){
		new TelaCadastroEstacionamento();
	}
	
	public boolean getPrimeiroAcesso() {
		return primeiroAcesso;
	}
	

	
}
