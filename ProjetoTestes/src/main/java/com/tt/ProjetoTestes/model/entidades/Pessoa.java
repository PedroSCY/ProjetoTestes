package com.tt.ProjetoTestes.model.entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Pessoa {
	
	@Id
	@Column(name = "ID_PESSOA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "NOME_PESSOA")
	private String nome;
	@Column(name = "EMAIL_PESSOA")
	private String email;
	@Column(name = "SENHA_PESSOA")
	private String senha;
	@Column(name = "CPF_PESSOA")
	private long cpf;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public Pessoa(String nome, String email, String senha, long cpf) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}
	
	
}
