package com.tt.ProjetoTestes.view.projetos;

import com.tt.ProjetoTestes.view.autenticacao.TelaAutenticacao;
import com.tt.ProjetoTestes.view.autenticacao.TelaAutenticacaoSwing;
import com.tt.ProjetoTestes.view.autenticacao.TelaCriarConta;
import com.tt.ProjetoTestes.view.autenticacao.TelaCriarContaSwing;

//import view.autenticacao.TelaConfiguracaoAdmin;
//import view.autenticacao.TelaConfiguracaoAdminSwing;

/**
 * 
 * @author NPG
 * 
 * Essa classe representa a fabrica concreta do padrão abstract factory
 *
 */
public class FabricaTelaSwing implements FabricaTela{

	
	public TelaFuncionario fabricarTelaFuncionario() {
		
		TelaFuncionarioSwing telaCadastroProjetosSwing = new TelaFuncionarioSwing();
		
		return telaCadastroProjetosSwing;
	}

	public TelaCRUDClientesMensalistas fabricarTelaCRUDClientesMensalistas() {
		
		TelaCRUDClientesMensalistasSwing telaCadastroGruposSwing = new TelaCRUDClientesMensalistasSwing();
		
		return telaCadastroGruposSwing;
	}

	public TelaCRUDFuncionario fabricarTelaCRUDFuncionarios() {
		
		TelaCRUDFuncionarioSwing telaCadastroEditaisSwing = new TelaCRUDFuncionarioSwing();
		
		return telaCadastroEditaisSwing;
	}
	
//	public TelaJustificarPonto fabricaTelaJustificarPonto() {
//		
//		TelaJustificarPonto telaJustificarPonto = new TelaJustificarPontoSwing();
//		
//		return telaJustificarPonto;
//	}
	
	public TelaAutenticacao fabricarTelaAutenticacao() {
		
		TelaAutenticacaoSwing telaAutenticacao = new TelaAutenticacaoSwing();
		
		return telaAutenticacao;
	}

	public TelaCriarConta fabricarTelaCriarConta() {

		TelaCriarContaSwing telaCriarConta = new TelaCriarContaSwing();
		
		return telaCriarConta;
	}

//	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin() {
//
//		TelaConfiguracaoAdminSwing telaConfiguracaoAdmin = new TelaConfiguracaoAdminSwing();
//	
//		return telaConfiguracaoAdmin;
//	}

}
