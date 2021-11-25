package com.tt.ProjetoTestes.model.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "TB_PESSOA") 
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "CPF")
	private long cpf;	
	
	public Pessoa(String nome, String email, String senha, long CPF) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = CPF;
	}

	public Pessoa(String nome) {
		this.nome = nome;
	}

}
