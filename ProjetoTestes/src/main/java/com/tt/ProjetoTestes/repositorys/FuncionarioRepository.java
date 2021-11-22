package com.tt.ProjetoTestes.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.ProjetoTestes.model.entidades.Funcionario;
import com.tt.ProjetoTestes.model.entidades.Pessoa;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	// buscar pessoa pelo nome
	public List<Funcionario> findByNome(String nome);

	// buscar pessoa pelo ID
	public Optional<Funcionario> findById(long id);
	
	public List<Funcionario> findByEmail(String email);
	
	public List<Funcionario> findByMatricula(long matricula);

	// buscar pessoa pelo CPF
	public List<Funcionario> findByCPF(long CPF);
}
