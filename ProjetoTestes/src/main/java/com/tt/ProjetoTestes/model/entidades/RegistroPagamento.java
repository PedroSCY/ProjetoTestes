package com.tt.ProjetoTestes.model.entidades;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "TB_REGISTROPAGAMENTO")
@Builder
@Data
@AllArgsConstructor
public class RegistroPagamento {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "VALOR_PAGO")
	private float valorPago;
	
	@ManyToOne
	private Funcionario funcionario;
	
	@Column(name = "DATA")
	private LocalDateTime data;
	
	@Column(name = "PLACA_VEICULO")
	private String placaVeiculo;
	
	@Column(name = "ESTACIONADO")
	private boolean isNoEstacionamento; 
	
	
	public RegistroPagamento(long id) {
		
		this.id = id;
	}

	public RegistroPagamento(float valorPago, Funcionario funcionario, LocalDateTime data, String placaVeiculo) {
		this.valorPago = valorPago;
		this.funcionario = funcionario;
		this.data = data;
		this.placaVeiculo = placaVeiculo;
		this.id = System.currentTimeMillis();
	}
}
