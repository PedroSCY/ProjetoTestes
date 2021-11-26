package com.tt.ProjetoTestes.facades.casosdeuso;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.services.FuncionarioService;
import com.tt.ProjetoTestes.util.ValidadoraFormatoEmail;

@Component
public class FacadeCRUDFuncionarios {

	@Autowired
	private Funcionario funcionario;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FacadeLogin facadeLogin;
	
	public FacadeCRUDFuncionarios() {

		funcionarioService = new FuncionarioService();
		facadeLogin = new FacadeLogin();
	}


	public void cadastrarNovoFuncionario( long matriculaFuncionario, String nome, String email, String senha, long cpf, boolean isGerente) throws Exception {

//		if(!funcionarioService.consultarFuncionario(matriculaGerente).isGerente()) {
//			throw new Exception("Você não é o gerente");
//		}
		if(!validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		
		funcionarioService.FuncionarioNaoExiste(cpf, matriculaFuncionario);
		
		Funcionario funcionario = new Funcionario(nome, email, senha, cpf, matriculaFuncionario, isGerente);
		
		funcionarioService.salvarFuncionario(funcionario);
		
	}

	public boolean atualizarCadastroDeFuncionario(long matriculaFuncionario, String nome, String email, String senha, long cpf) throws Exception {
		
//		if(!funcionarioService.consultarFuncionario(matriculaGerente).isGerente()) {
//			throw new Exception("Você não é o gerente");
//		}
		
		funcionario = facadeLogin.fazerLogin(email, senha);
		
		funcionario.setNome(nome);
		funcionario.setEmail(email);
		funcionario.setSenha(senha);
		
		funcionarioService.atualizarFuncionario(funcionario);
		
		return false;
	}

	public void removerFuncionario(long matricula) throws Exception {

		Funcionario funcionario = funcionarioService.recuperarPelaMatricula(matricula);
		
		if(funcionario.isGerente()) {
			throw new Exception("O funcionário é um gerente");
		}
		
		funcionarioService.excluirFuncionario(matricula);
		
	}

	private boolean validarEmail(String email) {
		return ValidadoraFormatoEmail.validarEmail(email);
	}

	public Set<Funcionario> recuperarTodos() {
		return funcionarioService.consultarTodos();
	}

	public Funcionario[] getTodosOsFuncionarios() {
		Set<Funcionario> funcionariosRegistrados = funcionarioService.consultarTodos();
		return funcionariosRegistrados.toArray(new Funcionario[funcionariosRegistrados.size()]);
	}
}
