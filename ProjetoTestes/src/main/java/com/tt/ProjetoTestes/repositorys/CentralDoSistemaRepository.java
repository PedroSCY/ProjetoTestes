package com.tt.ProjetoTestes.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tt.ProjetoTestes.util.CentralDoSistema;

@Repository
public interface CentralDoSistemaRepository extends JpaRepository<CentralDoSistema, Integer> {

	public Optional<CentralDoSistema> findById(int id);
	
}
