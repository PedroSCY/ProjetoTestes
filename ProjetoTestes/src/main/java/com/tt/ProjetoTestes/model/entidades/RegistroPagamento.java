package com.tt.ProjetoTestes.model.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegistroPagamento {
	
	@Id
	@Column(name = "ID_REGISTRO_PAGAMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "VALOR_REGISTRO_PAGAMENTO")
	private float valorPago;
	//@Column(name = "ID_REGISTRO_PAGAMENTO")
	private Funcionario funcionario;
	@Column(name = "DATA_REGISTRO_PAGAMENTO")
	private LocalDateTime data;
	@Column(name = "PLACA_REGISTRO_PAGAMENTO")
	private String placaVeiculo;
	//@Column(name = "ID_REGISTRO_PAGAMENTO")
	private boolean isNoEstacionamento; //TODO - atualizar UML
	
	
	public RegistroPagamento() {
		System.out.println("OPA CHEGUEI AQUI");
		this.id = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		System.out.println(getId());
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isNoEstacionamento() {
		return isNoEstacionamento;
	}

	public void setIsNoEstacionamento(boolean isNoEstacionamento) {
		this.isNoEstacionamento = isNoEstacionamento;
	}

	public RegistroPagamento(float valorPago, Funcionario funcionario, LocalDateTime data, String placaVeiculo) {
		this.valorPago = valorPago;
		this.funcionario = funcionario;
		this.data = data;
		this.placaVeiculo = placaVeiculo;
		this.id = System.currentTimeMillis();
	}
}
