package com.tt.ProjetoTestes.controller.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tt.ProjetoTestes.facades.casosdeuso.FacadeLogin;
import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.view.projetos.TelaPrincipal;

//import facades.casosdeuso.FacadeCasoDeUso2;
//import model.autenticacao.RegistradorSessaoLogin;
//import model.autenticacao.TipoProvedorAutenticacao;
//import view.projetos.TelaPonto;

/**
 * 
 * @author NPG
 * 
 *  Essa classe é o controller que realiza operações do JPanel TelaAutenticacao.
 *
 */
@Controller
public class ControllerTelaAutenticacao {
	
//	private FacadeCasoDeUso2 facadeCasoDeUso2 = new FacadeCasoDeUso2();
//	private RegistradorSessaoLogin registradorSessaoLogin = RegistradorSessaoLogin.getInstance();
	
	@Autowired
	private FacadeLogin facadeLogin;
	
	private boolean isGerente;
	
	public boolean fazerLogin(String email,String senha) throws Exception {
		
//		TipoProvedorAutenticacao tipoProvedor = TipoProvedorAutenticacao.INTERNO;
		
//		if(!tipoProvedorInterno) {
//			tipoProvedor = TipoProvedorAutenticacao.EMAIL_SMTP;
//		}
		
		Funcionario funcionario = facadeLogin.fazerLogin(email, senha);
		
		if(funcionario == null) {
			return false;
		}else {
			
			if(funcionario.isGerente()) {
				
//				isAdmin = registradorSessaoLogin.getMembroLogado().isAdministrador();
				isGerente = true;
			}
			
			return true;
		}
		
		
	}
	
	public void proximaTela() {

		TelaPrincipal telaPrincipal = new TelaPrincipal();
			
		telaPrincipal.validarAdminGerente(isGerente);
		
		ControllerTelaPrincipalAutenticacao.encerrarJanela();
		
	}
	
}
