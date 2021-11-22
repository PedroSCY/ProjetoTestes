package com.tt.ProjetoTestes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tt.ProjetoTestes.model.entidades.RegistroPagamento;

public interface RegistroPagamentoRepository extends JpaRepository<RegistroPagamento, Integer> {

	// buscar registro pagamento pelo id
	public RegistroPagamento findByID(long id);

}
