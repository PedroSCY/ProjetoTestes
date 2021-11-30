package com.tt.ProjetoTestes.controller.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tt.ProjetoTestes.facades.casosdeuso.FacadeCRUDFuncionarios;
import com.tt.ProjetoTestes.model.entidades.Funcionario;

/**
 * 
 * @author NPG
 *
 *  Essa classe é o controller que realiza operações do JPanel TelaCriarConta.
 *  
 */
@Controller
public class ControllerTelaCriarConta {

	@Autowired
	private FacadeCRUDFuncionarios facadeCRUDFuncionarios;
	
	public void cadastrarConta(String nome,long matricula,String login,String senha, String cpf) throws Exception {
		
//		if(!facadeCasoDeUso1.cadastrarConta(nome, matricula, login, senha)) {
//			throw new Exception("Nao foi possivel cadastrar conta");
//		}
		
		facadeCRUDFuncionarios.cadastrarNovoFuncionario( matricula, nome, login, senha, Long.parseLong(cpf),isPrimeiroAcesso());
		
	}
	
	public void atualizarConta(long matricula , String nome, String login, String senha, long cpf) throws Exception {
		
//		if(!facadeCasoDeUso1.atualizar(matricula, nome, login, senha)) {
//			throw new Exception("Nao foi possivel atualizar conta");
//		}
		
		facadeCRUDFuncionarios.atualizarCadastroDeFuncionario(matricula, nome, login, senha, cpf);
		
	}
	
	
	public boolean isPrimeiroAcesso() {
		System.out.println("Chwguei no controller de tela criar conta");
		Funcionario[] funcionarios = facadeCRUDFuncionarios.getTodosOsFuncionarios();
		
		if(funcionarios.length == 0)
			return true;
		
		return false;
		
	}
	
//	public void proximaTela() {
//		ControllerTelaPrincipalAutenticacao.getTelaPrincipalAutenticacao().dispose();
//		new TelaCadastroEstacionamento();
//	}
	

}
