package com.tt.ProjetoTestes.facades.casosdeuso;

import com.tt.ProjetoTestes.util.ValidadoraFormatoEmail;

//import persistencia.dao.DAOFuncionario;

public class FacadeLogin {

	private DAOFuncionario daoFuncionario;
	
	public FacadeLogin() {
		
		daoFuncionario = new DAOFuncionario();
	}
	
	//TODO - atualizar no UML
	public Funcionario fazerLogin(String email, String senha) throws Exception{

		if(!ValidadoraFormatoEmail.validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		
		Funcionario funcionario;
		funcionario = daoFuncionario.consultarFuncionario(email);
		
		if(!funcionario.getSenha().equals(senha)) {
			throw new Exception("Senha inválida");
		}
		
		return funcionario;
	}
	

}
