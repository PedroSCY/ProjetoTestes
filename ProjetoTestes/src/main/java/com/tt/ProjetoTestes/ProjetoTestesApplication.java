package com.tt.ProjetoTestes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tt.ProjetoTestes.view.autenticacao.TelaPrincipalAutenticacao;





@SpringBootApplication
public class ProjetoTestesApplication implements CommandLineRunner{

	@Autowired
	TelaPrincipalAutenticacao telaPrincipalAutenticacao;
	
//	public static void main(String[] args) {
//		ApplicationContext contexto = new SpringApplicationBuilder(ProjetoTestesApplication.class)
//				.web(WebApplicationType.NONE)
//				.headless(false)
//				.bannerMode(Banner.Mode.OFF)
//				.run(args);
//		SpringApplication.run(ProjetoTestesApplication.class, args);
//	}
	
	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(ProjetoTestesApplication.class, args);		
	}
	
	
	@Override
	public void run(String... args)  {
		System.out.println("deu certo finalmente");
		telaPrincipalAutenticacao.Iniciar();
		
//		FacadeCRUDFuncionarios ffun = new FacadeCRUDFuncionarios();
//		
//		try {
//			ffun.cadastrarNovoFuncionario( Long.parseLong("201915020025") , "pedro", "pedro@user.com", "senha1", Long.parseLong("10944351476") , true);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
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