package com.tt.ProjetoTestes.services;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tt.ProjetoTestes.model.entidades.RegistroPagamento;
import com.tt.ProjetoTestes.repositorys.RegistroPagamentoRepository;

@Service
public class RegistroPagamentoService {

	@Autowired
	private RegistroPagamentoRepository registroPagamentoRepository;


	public void salvarRegistro(RegistroPagamento pagamento) throws Exception {
		if(!verificar(pagamento.getId())) {
			registroPagamentoRepository.save(pagamento);
		}else {
			throw new Exception("[ERRO] Este registro já foi cadastrado");
		}
		
	}
	
	public void atualizarRegistro(RegistroPagamento pagamento) throws Exception {
		RegistroPagamento rpTemp = recuperarPorId(pagamento.getId());
	
		if(rpTemp.equals(pagamento)) {
			registroPagamentoRepository.save(pagamento);
		}else {
			throw new Exception("[ERRO] Registro não pode ser alterados.");
		}
	}
	
	public Set<RegistroPagamento> consultarTodos() {
		Set<RegistroPagamento> registros = new LinkedHashSet<RegistroPagamento>(registroPagamentoRepository.findAll());
		return registros;
	}

	public void excluirRegistro(long id) throws Exception {
		registroPagamentoRepository.delete(recuperarPorId(id));
	}
	
	public void excluirTudo() {
		registroPagamentoRepository.deleteAll();
	}
	
	public RegistroPagamento recuperarPorId(long id) throws Exception {
		Optional<RegistroPagamento> optional = registroPagamentoRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		throw new Exception("[ERRO] Registro de Pagamento não encontrado");
		
	}
	
	private boolean verificar(long id) {
		try {
			recuperarPorId(id);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	

}
