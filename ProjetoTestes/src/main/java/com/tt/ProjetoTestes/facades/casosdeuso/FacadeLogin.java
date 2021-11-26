package com.tt.ProjetoTestes.facades.casosdeuso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.services.FuncionarioService;
import com.tt.ProjetoTestes.util.ValidadoraFormatoEmail;

//import persistencia.dao.FuncionarioService;

@Component
public class FacadeLogin {

	@Autowired
	private FuncionarioService funcionarioService;
	
	public FacadeLogin() {
		
		funcionarioService = new FuncionarioService();
	}
	
	//TODO - atualizar no UML
	public Funcionario fazerLogin(String email, String senha) throws Exception{

		if(!ValidadoraFormatoEmail.validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		
		Funcionario funcionario;
		funcionario = funcionarioService.recuperarPeloEmail(email);
		
		if(!funcionario.getSenha().equals(senha)) {
			throw new Exception("Senha inválida");
		}
		
		return funcionario;
	}
	

}
