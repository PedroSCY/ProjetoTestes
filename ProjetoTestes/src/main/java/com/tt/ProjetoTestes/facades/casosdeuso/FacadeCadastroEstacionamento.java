package com.tt.ProjetoTestes.facades.casosdeuso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.ProjetoTestes.services.CentralDoSistemaService;
import com.tt.ProjetoTestes.util.CentralDoSistema;

@Component
public class FacadeCadastroEstacionamento {

	@Autowired
	private CentralDoSistemaService centralDoSistemaService;
	
	private CentralDoSistema centralDoSistema;
		
	
	public void cadastrarInformacoesDoEstacionamento(float valorBase, float valorTaxa, String CNPJ, String agencia,
			String numeroAgencia, String numeroConta, String variacao, int totalVagas) {
		
//		CentralDoSistema centralDoSistema = CentralDoSistema.getInstance();
		
//		System.out.println(centralDoSistema);
		
		centralDoSistema.setValorBase(valorBase);
		centralDoSistema.setAgenciaBancaria(agencia);
		centralDoSistema.setNumeroAgencia(numeroAgencia);
		centralDoSistema.setNumeroContaEstacionamento(numeroConta);
		centralDoSistema.setVariacao(variacao);
		centralDoSistema.setCNPJ(CNPJ);
		centralDoSistema.setValorBase(valorBase);
		centralDoSistema.setValorPorHoraExtra(valorTaxa);
		centralDoSistema.setQuantidadeVagasDisponiveis(totalVagas);
		
		centralDoSistemaService.salvarCentralDoSistema(centralDoSistema);
	}
	
	public String[] getInformacoes() {
		
		centralDoSistema = centralDoSistemaService.getInstance();
		
		String[] informacoes = new String[8];
		
		informacoes[0] = String.valueOf(centralDoSistema.getValorBase());
		informacoes[1] = String.valueOf(centralDoSistema.getValorPorHoraExtra());
		informacoes[2] = centralDoSistema.getCNPJ();
		informacoes[3] = centralDoSistema.getAgenciaBancaria();
		informacoes[4] = centralDoSistema.getNumeroAgencia();
		informacoes[5] = centralDoSistema.getNumeroContaEstacionamento();
		informacoes[6] = centralDoSistema.getVariacao();
		informacoes[7] = String.valueOf(centralDoSistema.getQuantidadeVagasDisponiveis());
		
		return informacoes;
	}
}
