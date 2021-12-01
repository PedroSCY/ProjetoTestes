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
	
	private static TelaPrincipalAutenticacao telaPrincipalAutenticacao;
	
	@Autowired
	private TelaCadastroEstacionamento telaCadastroEstacionamento;
	
	@Autowired
	private ControllerTelaCriarConta controllerTelaCriarConta;
	
	private boolean primeiroAcesso;
	
	public void setTela(TelaPrincipalAutenticacao tpa) {
		telaPrincipalAutenticacao = tpa;
	}
	
	public boolean isPrimeiroAcesso() {
		return controllerTelaCriarConta.isPrimeiroAcesso();
		
	}
	
	public static void encerrarJanela() {
		telaPrincipalAutenticacao.dispose();
	}
		
	public void setPrimeiroAcesso(boolean primeiroAcesso) {
		
		this.primeiroAcesso = primeiroAcesso;
	}
	
	public void proximaTela(){
		telaCadastroEstacionamento.Iniciar();;
	}
	
	public boolean getPrimeiroAcesso() {
		return primeiroAcesso;
	}
	

	
}
