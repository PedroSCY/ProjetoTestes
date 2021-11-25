package com.tt.ProjetoTestes.model.entidades;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa {
	
	@Column(name = "MATRICULA")
	private long matricula;
	
	@Column(name = "ISGERENTE")
	private boolean isGerente;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "funcionario") 
	private Set<RegistroPagamento> registrosRealizados = new LinkedHashSet<RegistroPagamento>();
	
	//TODO - autualizar UML
	public RegistroPagamento registrarPagamento(float valorPago, String placaVeiculo, Funcionario funcionario) {

		RegistroPagamento registroPagamento = new RegistroPagamento(valorPago, funcionario, LocalDateTime.now(), placaVeiculo);
		registroPagamento.setNoEstacionamento(true);
		
		registrosRealizados.add(registroPagamento);
		
		return registroPagamento;
	}
	
	public Funcionario(String nome, String email, String senha, long CPF, long matricula, boolean isGerente) {
		super(nome, email, senha, CPF);
		this.matricula = matricula;
		this.isGerente = isGerente;
	}
	
	public Funcionario(String nome) {
		super(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return matricula == other.matricula && this.getCpf() == other.getCpf() && Objects.equals(this.getEmail(), other.getEmail()) && this.getId() == other.getId();
	}
	
}
