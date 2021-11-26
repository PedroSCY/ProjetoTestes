package com.tt.ProjetoTestes.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.ProjetoTestes.util.CentralDoSistema;

public interface CentralDoSistemaRepository extends JpaRepository<CentralDoSistema, Integer> {

	public Optional<CentralDoSistema> findById(int id);
	
}
