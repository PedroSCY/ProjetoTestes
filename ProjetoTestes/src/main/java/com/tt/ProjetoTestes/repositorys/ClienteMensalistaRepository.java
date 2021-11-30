package com.tt.ProjetoTestes.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tt.ProjetoTestes.model.entidades.ClienteMensalista;

@Repository
public interface ClienteMensalistaRepository extends JpaRepository<ClienteMensalista, Integer> {

	// buscar pessoa pelo nome
	public List<ClienteMensalista> findByNome(String nome);

	// buscar pessoa pelo ID
	public Optional<ClienteMensalista> findById(long id);
	
	// buscar pessoa pelo CPF
	public List<ClienteMensalista> findByCPF(long CPF);

	public List<ClienteMensalista> findByEmail(String email);
	
}
