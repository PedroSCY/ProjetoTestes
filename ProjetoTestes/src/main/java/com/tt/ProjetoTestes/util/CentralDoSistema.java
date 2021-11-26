package com.tt.ProjetoTestes.util;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.tt.ProjetoTestes.repositorys.CentralDoSistemaRepository;
import com.tt.ProjetoTestes.services.CentralDoSistemaService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//import persistencia.DAOCentralDoSistema;

@Entity
@Table(name = "TB_CENTRALDOSISTEMA")
@Data
@NoArgsConstructor
public class CentralDoSistema {
	
	@Autowired
	private static CentralDoSistemaService centralDoSistemaService;
	
	@Id
	@Column(name = "ID")
	private int id = 1; 
	
	@Column(name = "VALORBASE")
	private float valorBase;
	
	@Column(name = "VALORPORHORAEXTRA")
	private float valorPorHoraExtra;
	
	@Column(name = "CNPJ")
	private String CNPJ;
	
	@Column(name = "AGENCIABANCARIA")
	private String agenciaBancaria;
	
	@Column(name = "NUMEROAGENCIA")
	private String numeroAgencia;
	
	@Column(name = "NUMEROCONTAESTACIONAMENTO")
	private String numeroContaEstacionamento;
	
	@Column(name = "VARIAÇAO")
	private String variacao;
	
	@Column(name = "QUANTIDADEVAGASDISPONIVEIS")
	private int quantidadeVagasDisponiveis;

	public void salvar() {
		centralDoSistemaService.salvarCentralDoSistema(this);
	}
	
	public static CentralDoSistema getInstance() {
		return centralDoSistemaService.getInstance();
	}

	public CentralDoSistema(float valorBase, float valorPorHoraExtra, String cNPJ, String agenciaBancaria,
			String numeroAgencia, String numeroContaEstacionamento, String variacao, int quantidadeVagasDisponiveis) {
		super();
		this.valorBase = valorBase;
		this.valorPorHoraExtra = valorPorHoraExtra;
		CNPJ = cNPJ;
		this.agenciaBancaria = agenciaBancaria;
		this.numeroAgencia = numeroAgencia;
		this.numeroContaEstacionamento = numeroContaEstacionamento;
		this.variacao = variacao;
		this.quantidadeVagasDisponiveis = quantidadeVagasDisponiveis;
	}
}
