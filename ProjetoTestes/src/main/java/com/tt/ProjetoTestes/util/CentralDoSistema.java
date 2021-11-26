package com.tt.ProjetoTestes.util;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//import persistencia.DAOCentralDoSistema;

@Entity
@Table(name = "TB_CENTRALDOSISTEMA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentralDoSistema {

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

}
