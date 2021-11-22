package com.tt.ProjetoTestes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.ProjetoTestes.model.entidades.ClienteMensalista;

public interface ClienteMensalistaRepository extends JpaRepository<ClienteMensalista, Integer> {

	// buscar pessoa pelo nome
	public ClienteMensalista findByNome(String nome);

	// buscar pessoa pelo ID
	public ClienteMensalista findById(int id);
}
