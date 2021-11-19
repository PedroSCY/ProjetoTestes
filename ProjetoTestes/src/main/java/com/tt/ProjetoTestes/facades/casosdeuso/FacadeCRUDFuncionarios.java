package com.tt.ProjetoTestes.facades.casosdeuso;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.persistencia.DAOFuncionario;
import com.tt.ProjetoTestes.util.ValidadoraFormatoEmail;

@Component
public class FacadeCRUDFuncionarios {

	@Autowired
	private Funcionario funcionario;
	
	@Autowired
	private DAOFuncionario daoFuncionario;
	
	@Autowired
	private FacadeLogin facadeLogin;
	
	public FacadeCRUDFuncionarios() {

		daoFuncionario = new DAOFuncionario();
		facadeLogin = new FacadeLogin();
	}


	public void cadastrarNovoFuncionario( long matriculaFuncionario, String nome, String email, String senha, long cpf, boolean isGerente) throws Exception {

//		if(!daoFuncionario.consultarFuncionario(matriculaGerente).isGerente()) {
//			throw new Exception("Você não é o gerente");
//		}
		if(!validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		
		daoFuncionario.FuncionarioNaoExiste(cpf, matriculaFuncionario);
		
		Funcionario funcionario = new Funcionario(nome, email, senha, cpf, matriculaFuncionario, isGerente);
		
		daoFuncionario.criar(funcionario);
		
	}

	public boolean atualizarCadastroDeFuncionario(long matriculaFuncionario, String nome, String email, String senha, long cpf) throws Exception {
		
//		if(!daoFuncionario.consultarFuncionario(matriculaGerente).isGerente()) {
//			throw new Exception("Você não é o gerente");
//		}
		
		funcionario = facadeLogin.fazerLogin(email, senha);
		
		funcionario.setNome(nome);
		funcionario.setEmail(email);
		funcionario.setSenha(senha);
		
		daoFuncionario.atualizar(matriculaFuncionario, funcionario);
		
		return false;
	}

	public void removerFuncionario(long matricula) throws Exception {

		Funcionario funcionario = daoFuncionario.consultarFuncionario(matricula);
		
		if(funcionario.isGerente()) {
			throw new Exception("O funcionário é um gerente");
		}
		
		daoFuncionario.remover(matricula);
		
	}

	private boolean validarEmail(String email) {
		return ValidadoraFormatoEmail.validarEmail(email);
	}

	public Set<Funcionario> recuperarTodos() {
		return daoFuncionario.consultarTodos();
	}

	public Funcionario[] getTodosOsFuncionarios() {
		Set<Funcionario> funcionariosRegistrados = daoFuncionario.consultarTodos();
		return funcionariosRegistrados.toArray(new Funcionario[funcionariosRegistrados.size()]);
	}
}
