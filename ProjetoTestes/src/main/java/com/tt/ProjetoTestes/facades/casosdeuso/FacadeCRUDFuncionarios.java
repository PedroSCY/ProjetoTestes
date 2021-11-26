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

//		daoFuncionario = new DAOFuncionario();
//		facadeLogin = new FacadeLogin();
	}

	public void cadastrarNovoFuncionario(long matriculaFuncionario, String nome, String email, String senha, long cpf,
			boolean isGerente) throws Exception {

//		if(!daoFuncionario.consultarFuncionario(matriculaGerente).isGerente()) {
//			throw new Exception("Você não é o gerente");
//		}
		if (!validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		if (!funcionarioService.verificarExistenciaCPF(cpf)) {
			Funcionario funcionario = new Funcionario(nome, email, senha, cpf, matriculaFuncionario, isGerente);
			funcionarioService.salvarFuncionario(funcionario);
		} else
			throw new Exception("Erro no cadastro!");

	}

	public boolean atualizarCadastroDeFuncionario(long matriculaFuncionario, String nome, String email, String senha,
			long cpf) throws Exception {

//		if(!daoFuncionario.consultarFuncionario(matriculaGerente).isGerente()) {
//			throw new Exception("Você não é o gerente");
//		}

		funcionario = facadeLogin.fazerLogin(email, senha);
		
		
		funcionario.setNome(nome);
		funcionario.setEmail(email);
		funcionario.setSenha(senha);
		
//		daoFuncionario.atualizar(matriculaFuncionario, funcionario);
		funcionarioService.atualizarFuncionario(funcionario);

		return false;
	}

	public void removerFuncionario(long matricula) throws Exception {
		
		Funcionario funcionario = funcionarioService.recuperarPelaMatricula(matricula);
		

		if (funcionario.isGerente()) {
			throw new Exception("O funcionário é um gerente");
		}
		funcionarioService.recuperarPelaMatricula(matricula);

	}

	private boolean validarEmail(String email) {
		return ValidadoraFormatoEmail.validarEmail(email);
	}

	public Set<Funcionario> recuperarTodos() {
		return funcionarioService.recuperarTodos();
	}

	public Funcionario[] getTodosOsFuncionarios() {
		Set<Funcionario> funcionariosRegistrados = recuperarTodos();
		return funcionariosRegistrados.toArray(new Funcionario[funcionariosRegistrados.size()]);
	}
}
