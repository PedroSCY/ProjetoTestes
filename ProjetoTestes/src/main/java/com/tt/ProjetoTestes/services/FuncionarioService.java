package com.tt.ProjetoTestes.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.repositorys.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	
	/**
	 * Esse método salva ( Adiciona ao banco de dados) um unico objeto Funcionario por vez. 
	 * @param pessoa a ser adicionada ao banco
	 * @throws Exception Caso já exista um objeto Funcionario cadastrado como o mesmo CPF do objeto passado por parametro.
	 */
	public void salvarFuncionario(Funcionario funcionario) throws Exception {
		if(!verificarExistenciaCPF(funcionario.getCpf()) && !verificarExistenciaEmail(funcionario.getEmail())
		&& !verificarExistenciaMatricula(funcionario.getMatricula())) {
			
			funcionarioRepository.save(funcionario);
			
		}else {
			throw new Exception("[ERRO] O CPF, Email ou Matricula: "+ funcionario.getCpf() 
			+" "+ funcionario.getEmail() +" "+ funcionario.getMatricula() + " Já foi cadastrado.");
		}
	}
	
	/**
	 * Esse metodo atualiza as informações de um objeto Funcionario já cadastrado.
	 * @param funcionario Objeto recuperado já alterado.
	 * @throws Exception Caso o email, CPF ou matricula seja alterada.
	 */
	public void atualizarFuncionario(Funcionario funcionario) throws Exception {
		Funcionario funcionarioTemp = recuperarPeloId(funcionario.getId());
	
		if(funcionarioTemp.equals(funcionario)) {
			funcionarioRepository.save(funcionario);
		}else {
			throw new Exception("[ERRO] Email, CPF e Matricula não podem ser alterados.");
		}
	}
	
	
	/**
	 * Este metodo deleta o Funcionario cadastrado com a matricula passada como parametro.
	 * @param matricula matricula do funcionario que deseja-se deletar.
	 * @throws Exception Caso não haja funcionario cadastrado com a matricula passada como parametro.
	 */
	public void excluirFuncionario(long matricula) throws Exception {
		funcionarioRepository.delete(recuperarPeloCPF(matricula));
	}
	
	/**
	 * Esse metodo deleta todos os Funcionarios do banco.
	 */
	public void excluirTudo() {
		funcionarioRepository.deleteAll();
	}
	
	/**
	 * Esse metodo recupera um Funcionario pelo email cadastrado.
	 * @param email Email do funcionario ao qual deseja-se encontrar.
	 * @return retorna o proprio objeto Funcionario encontrado
	 * @throws Exception caso nehnum funcionario seja encontrado.
	 */
	public Funcionario recuperarPeloEmail(String email) throws Exception {
		if(funcionarioRepository.findByEmail(email).size() >= 1) 
			return (Funcionario) funcionarioRepository.findByEmail(email).get(0);
		
		throw new Exception("[ERRO] Email: " + email + " não cadastrado");
		
	}
	
	/**
	 * Esse metodo recupera um Funcionario pelo CPF cadastrado.
	 * @param CPF CPF do funcionario ao qual deseja-se encontrar.
	 * @return retorna o proprio objeto Funcionario encontrado
	 * @throws Exception caso nehnum funcionario seja encontrado.
	 */
	public Funcionario recuperarPeloCPF(long CPF) throws Exception {
		if(funcionarioRepository.findByCPF(CPF).size() >=1) 
			return (Funcionario) funcionarioRepository.findByCPF(CPF);
		
		throw new Exception("[ERRO] CPF: " + CPF + " Não Cadastrado");
	}
	
	/**
	 * Esse metodo recupera um Funcionario pela matricula cadastrado.
	 * @param Matricula Matricula do funcionario ao qual deseja-se encontrar.
	 * @return retorna o proprio objeto Funcionario encontrado
	 * @throws Exception caso nehnum funcionario seja encontrado.
	 */
	public Funcionario recuperarPelaMatricula(long Matricula) throws Exception {
		if(funcionarioRepository.findByMatricula(Matricula).size() >= 1)
			return (Funcionario) funcionarioRepository.findByMatricula(Matricula);
		
		throw new Exception("[ERRO] Matricula: " + Matricula + " Não Cadastrada");
	}
	
	/**
	 * Esse metodo recupera um Funcionario pelo ID cadastrado.
	 * @param id ID do funcionario ao qual deseja-se encontrar.
	 * @return retorna o proprio objeto Funcionario encontrado
	 * @throws Exception caso nehnum funcionario seja encontrado.
	 */
	public Funcionario recuperarPeloId(long id) throws Exception {
		Optional<Funcionario> optional = funcionarioRepository.findById(id);
	
		if(optional.isPresent())
			return optional.get();
		
		throw new Exception("[ERRO] Funcionario não encontrado");
		
	}
	
	
	public Set<Funcionario> recuperarTodos(){
		Set<Funcionario> funcionarios = new HashSet<Funcionario>(funcionarioRepository.findAll());
		return funcionarios;
	}
	
	/**
	 * Esse metodo verifica se existe algum objeto Funcionario cadastrado com o CPF Passado como parametro
	 * @param cpf CPF que se deseja verificar a existencia no banco.
	 * @return valor booleano true caso não encontre ou false caso encontre.
	 */
	public boolean verificarExistenciaCPF(long cpf) {
		try {
			recuperarPeloCPF(cpf);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Esse metodo verifica se existe algum objeto Funcionario cadastrado com o Email Passado como parametro
	 * @param email Email que se deseja verificar a existencia no banco.
	 * @return valor booleano true caso não encontre ou false caso encontre.
	 */
	public boolean verificarExistenciaEmail(String email) {
		try {
			recuperarPeloEmail(email);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Esse metodo verifica se existe algum objeto Funcionario cadastrado com a matricula Passado como parametro
	 * @param email Email que se deseja verificar a existencia no banco.
	 * @return valor booleano true caso não encontre ou false caso encontre.
	 */
	public boolean verificarExistenciaMatricula(long matricula) {
		try {
			recuperarPelaMatricula(matricula);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
