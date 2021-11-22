package com.tt.ProjetoTestes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.ProjetoTestes.model.entidades.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	// buscar pessoa pelo nome
	public Pessoa findByNome(String nome);

	// buscar pessoa pelo ID
	public Pessoa findById(int id);

	// buscar pessoa pelo CPF
	public Pessoa findByCPF(long CPF);

}
