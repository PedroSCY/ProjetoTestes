package com.tt.ProjetoTestes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.ProjetoTestes.model.entidades.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	// buscar pessoa pelo nome
	public Funcionario findByNome(String nome);

	// buscar pessoa pelo ID
	public Funcionario findById(int id);
}
