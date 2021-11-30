package com.tt.ProjetoTestes.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tt.ProjetoTestes.model.entidades.RegistroPagamento;

@Repository
public interface RegistroPagamentoRepository extends JpaRepository<RegistroPagamento, Integer> {

	// buscar registro pagamento pelo id
	public Optional<RegistroPagamento> findById(long id);

}
