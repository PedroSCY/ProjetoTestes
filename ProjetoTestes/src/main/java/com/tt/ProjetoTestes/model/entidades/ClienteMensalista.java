package com.tt.ProjetoTestes.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CLIENTEMENSALISTA")
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteMensalista extends Pessoa {
	
	@Column(name = "CREDITO")
	private float creditoDisponivel;

	public ClienteMensalista(String nome, String email, String senha, long cpf, float creditoDisponivel) {
		super(nome, email, senha, cpf);
		this.creditoDisponivel = creditoDisponivel;
	}
	
	public ClienteMensalista(String nome) {
		super(nome);
	}

}
