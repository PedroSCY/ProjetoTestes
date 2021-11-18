package com.tt.ProjetoTestes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tt.ProjetoTestes.view.autenticacao.TelaPrincipalAutenticacao;


@SpringBootApplication
public class ProjetoTestesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTestesApplication.class, args);
	}
	
	
	@Override
	public void run(String... args)  {
		new TelaPrincipalAutenticacao(); 
		System.out.println("Teste");
	}

}