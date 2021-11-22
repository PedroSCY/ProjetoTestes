package com.tt.ProjetoTestes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tt.ProjetoTestes.model.entidades.RegistroPagamento;
import com.tt.ProjetoTestes.repositorys.RegistroPagamentoRepository;

@Service
public class RegistroPagamentoService {

	@Autowired
	private RegistroPagamentoRepository registroPagamentoRepository;

	// metodo de salvar Registro de Pagamentos
	public boolean salvarRegistroPagamento(long ID) {

		RegistroPagamento registro = registroPagamentoRepository.findByID(ID);
		System.out.println(registro);
		if (registro == null) {
			RegistroPagamento auxiliar = new RegistroPagamento(ID);
			registroPagamentoRepository.save(auxiliar);
			return true;
		}
		return false;
	}

}
