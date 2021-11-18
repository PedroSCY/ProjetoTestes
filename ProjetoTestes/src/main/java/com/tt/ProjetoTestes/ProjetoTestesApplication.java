package com.tt.ProjetoTestes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tt.ProjetoTestes.view.autenticacao.TelaPrincipalAutenticacao;


@SpringBootApplication
public class ProjetoTestesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTestesApplication.class, args);
	}
	


	public void run(String... args) throws Exception {
		new TelaPrincipalAutenticacao(); 

	} 

}