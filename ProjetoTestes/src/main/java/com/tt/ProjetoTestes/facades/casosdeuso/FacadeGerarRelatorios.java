package com.tt.ProjetoTestes.facades.casosdeuso;

//import relatorios.DiretorMontagemRelatorio;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.ProjetoTestes.persistencia.DAORegistroPagamento;
import com.tt.ProjetoTestes.view.projetos.relatorios.DiretorMontagem;
import com.tt.ProjetoTestes.view.projetos.relatorios.MontadorRelatorioSwing;

@Component
public class FacadeGerarRelatorios {

	@Autowired
	private DiretorMontagem diretorMontagemRelatorio; 

	@Autowired
	private DAORegistroPagamento daoRegistroPagamento;
	
	public FacadeGerarRelatorios() {

		daoRegistroPagamento = new DAORegistroPagamento();
		diretorMontagemRelatorio = new DiretorMontagem(new MontadorRelatorioSwing());
	}

	public void criarRelatorioMensal(int mes, int ano) {
		
		diretorMontagemRelatorio.gerarRelatorioMensal(daoRegistroPagamento.consultarTodos(), mes, ano);
		
		
	}

	public void criarRelatorioDiario(LocalDateTime data) {

		diretorMontagemRelatorio.gerarRelatorioDiario(daoRegistroPagamento.consultarTodos(), data);
	}

}
