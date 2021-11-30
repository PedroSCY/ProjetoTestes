package com.tt.ProjetoTestes;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.tt.ProjetoTestes.facades.casosdeuso.FacadeCRUDFuncionarios;


@SpringBootApplication
public class ProjetoTestesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ApplicationContext contexto = new SpringApplicationBuilder(ProjetoTestesApplication.class)
				.web(WebApplicationType.NONE)
				.headless(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
		SpringApplication.run(ProjetoTestesApplication.class, args);
	}
	
	
	@Override
	public void run(String... args)  {
//		new TelaPrincipalAutenticacao(); 
		
		FacadeCRUDFuncionarios ffun = new FacadeCRUDFuncionarios();
		
		try {
			ffun.cadastrarNovoFuncionario( Long.parseLong("201915020025") , "pedro", "pedro@user.com", "senha1", Long.parseLong("10944351476") , true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		System.out.println("Aqui Agora ");
//		
//		CentralDoSistema cds = CentralDoSistema.getInstance();
//		
//		cds.setValorBase(2);
//		
//		cds.salvar();
//		
//		System.out.println(CentralDoSistema.getInstance().getValorBase());
		
		
	}

}