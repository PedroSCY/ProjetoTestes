package com.tt.ProjetoTestes.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ClienteMensalista extends Pessoa {
	
	//@Column(name = "CREDITO_PESSOA")
	private float creditoDisponivel;

	public ClienteMensalista(String nome, String email, String senha, long cpf, float creditoDisponivel) {
		super(nome, email, senha, cpf);
		this.creditoDisponivel = creditoDisponivel;
	}

	public float getCreditoDisponivel() {
		return creditoDisponivel;
	}

	public void setCreditoDisponivel(float creditoDisponivel) {
		this.creditoDisponivel = creditoDisponivel;
	}
}
