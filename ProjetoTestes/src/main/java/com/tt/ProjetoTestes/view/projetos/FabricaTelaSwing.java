package com.tt.ProjetoTestes.view.projetos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class FabricaTelaSwing implements FabricaTela{

	@Autowired
	TelaFuncionarioSwing telaCadastroProjetosSwing;
	
	@Autowired
	TelaCRUDClientesMensalistasSwing telaCadastroGruposSwing;

	@Autowired
	TelaCRUDFuncionarioSwing telaCadastroEditaisSwing;
	
	@Autowired
	TelaAutenticacaoSwing telaAutenticacao;
	
	@Autowired
	TelaCriarContaSwing telaCriarConta;
	
	
	
	public TelaFuncionario fabricarTelaFuncionario() {
		return telaCadastroProjetosSwing;
	}

	public TelaCRUDClientesMensalistas fabricarTelaCRUDClientesMensalistas() {
		return telaCadastroGruposSwing;
	}

	public TelaCRUDFuncionario fabricarTelaCRUDFuncionarios() {
		return telaCadastroEditaisSwing;
	}

	public TelaAutenticacao fabricarTelaAutenticacao() {
		telaAutenticacao.iniciar();
		return telaAutenticacao;
	}
	
	public TelaCriarConta fabricarTelaCriarConta() {
		telaCriarConta.iniciar();
		return telaCriarConta;
	}
	
//	public TelaJustificarPonto fabricaTelaJustificarPonto() {
//		
//		TelaJustificarPonto telaJustificarPonto = new TelaJustificarPontoSwing();
//		
//		return telaJustificarPonto;
//	}
	

//	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin() {
//
//		TelaConfiguracaoAdminSwing telaConfiguracaoAdmin = new TelaConfiguracaoAdminSwing();
//	
//		return telaConfiguracaoAdmin;
//	}

}
