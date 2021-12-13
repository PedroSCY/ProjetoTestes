package com.tt.ProjetoTestes;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tt.ProjetoTestes.services.FuncionarioService;

@SpringBootTest
public class FuncionarioServiceTest {
	
	@Autowired
	private FuncionarioService funcService;
	
	
	@Test
	public void verificarExistenciaMatricula() {
		boolean retornoDoMetodoTestado;
		
		retornoDoMetodoTestado = funcService.verificarExistenciaMatricula(123);
		System.out.println(retornoDoMetodoTestado);
		Assert.assertTrue(retornoDoMetodoTestado);
		
		retornoDoMetodoTestado = funcService.verificarExistenciaMatricula(0);
		System.out.println(retornoDoMetodoTestado);
		Assert.assertFalse(retornoDoMetodoTestado);
		
		
	}
	
	@Test
	public void verificarExistenciaEmail() {
		boolean retornoDoMetodoTestado;
		
//		retornoDoMetodoTestado = funcService.verificarExistenciaEmail(null);
//		System.out.println(retornoDoMetodoTestado);
//		Assert.assertFalse(retornoDoMetodoTestado);
		
		retornoDoMetodoTestado = funcService.verificarExistenciaEmail("jose@gmail.com");
		System.out.println(retornoDoMetodoTestado);
		Assert.assertTrue(retornoDoMetodoTestado);
		
		
	}
}
