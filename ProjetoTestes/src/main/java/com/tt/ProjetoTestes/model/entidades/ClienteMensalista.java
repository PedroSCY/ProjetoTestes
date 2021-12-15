package com.tt.ProjetoTestes.model.entidades;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ClienteMensalista other = (ClienteMensalista) obj;
		return this.getCpf() == other.getCpf() && Objects.equals(this.getEmail(), other.getEmail()) && this.getId() == other.getId();
	}


}
