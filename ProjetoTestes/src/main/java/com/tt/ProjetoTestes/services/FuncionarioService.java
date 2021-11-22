package com.tt.ProjetoTestes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.repositorys.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	// metodo cadastrar Funcionario
	public boolean cadastrarFuncionario(String nome) {

		Funcionario funcionarioRecuperado = funcionarioRepository.findByNome(nome);
		System.out.println(funcionarioRecuperado);
		if (funcionarioRecuperado == null) {
			Funcionario auxiliar = new Funcionario(nome);
			funcionarioRepository.save(auxiliar);
			return true;
		}
		return false;
	}
}
