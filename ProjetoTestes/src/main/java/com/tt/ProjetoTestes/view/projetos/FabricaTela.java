package com.tt.ProjetoTestes.view.projetos;

import com.tt.ProjetoTestes.view.autenticacao.TelaAutenticacao;
import com.tt.ProjetoTestes.view.autenticacao.TelaCriarConta;

//import view.autenticacao.TelaConfiguracaoAdmin;

/**
 * 
 * @author NPG
 *
 *Essa classe representa o super tipo fabrica do padrão abstract factory
 *
 */
public interface FabricaTela {

	public TelaFuncionario fabricarTelaFuncionario();
	public TelaCRUDClientesMensalistas fabricarTelaCRUDClientesMensalistas();
	public TelaCRUDFuncionario fabricarTelaCRUDFuncionarios();
//	public TelaJustificarPonto fabricaTelaJustificarPonto();
	public TelaAutenticacao fabricarTelaAutenticacao();
	public TelaCriarConta fabricarTelaCriarConta();
	
//	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin();
	
}
