package com.tt.ProjetoTestes.view.autenticacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.ProjetoTestes.controller.autenticacao.ControllerTelaPrincipalAutenticacao;
import com.tt.ProjetoTestes.util.FactorySwingComponents;
import com.tt.ProjetoTestes.view.projetos.FabricaTela;
import com.tt.ProjetoTestes.view.projetos.FabricaTelaSwing;



/**
 * 
 * @author NPG
 *
 * Esta é a primeira tela do projeto, fica responsável por intermediar entre a tela de login e a tela 
 * de cadastro de contas. Recorrendo à condição de primeiro acesso, instancia primeiramente a tela de cadastro 
 * para que o administrador (que é o primeiro a ser cadastrado) seja cadastrado, caso não seja o primeiro acesso
 * a primeira tela instanciada será a de login.
 * 
 *
 */
@Component
public class TelaPrincipalAutenticacao extends JFrame {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ControllerTelaPrincipalAutenticacao controllerTelaPrincipalAutenticacao;
	
	@Autowired
	private FabricaTelaSwing fabricaTelaSwing;
	
	@Autowired
	private TelaCadastroEstacionamento telaCadastroEstacionamento;
	
	private boolean isPrimeiroAcesso; 
	private JButton btnAutenticacao;
	private FabricaTela fabricaTelaCadastro;
	private TelaCriarConta telaCriarConta;
	private TelaAutenticacao telaAutenticacao;
	private TelaPrincipalAutenticacao telaPrincipalAutenticacao = this;


	public void Iniciar() {
		controllerTelaPrincipalAutenticacao.setTela(this);
		isPrimeiroAcesso = controllerTelaPrincipalAutenticacao.isPrimeiroAcesso();
		fabricaTelaCadastro = fabricaTelaSwing;
		adicionarConfiguracoesBasicas();
		adicionarBotoes();
		telaInicial();
		setVisible(true);	
	}
	
	public class OuvinteDosBotoes implements ActionListener{
		
		boolean cond = false;

		public void actionPerformed(ActionEvent evento) {
	

//			if(evento.getActionCommand().equals("Criar Conta")) {
//				removerJPanel(telaAutenticacao);
//				
//				telaCriarConta = fabricaTelaCadastro.fabricarTelaCriarConta();
//				adicionarJPanel(telaCriarConta);
//				
//				mostrarBotoes(true);
//					
//				
//			} else 
			if(evento.getActionCommand().equals("Fazer Login")) {
				
				if(controllerTelaPrincipalAutenticacao.getPrimeiroAcesso()) {
					telaPrincipalAutenticacao.dispose();
					telaCadastroEstacionamento.Iniciar();
				}
				
				if(!controllerTelaPrincipalAutenticacao.isPrimeiroAcesso()) {
					removerJPanel(telaCriarConta);
					
					telaAutenticacao = (fabricaTelaCadastro.fabricarTelaAutenticacao());
					adicionarJPanel(telaAutenticacao);
					
					mostrarBotoes(false);
				}else {
					JOptionPane.showMessageDialog(null, "[PRIMEIRO ACESSO] Um membro administrador deve ser cadastrado", null, JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
	}
	
	
	private void telaInicial() {
		if(isPrimeiroAcesso) {
			telaCriarConta = fabricaTelaCadastro.fabricarTelaCriarConta();
			adicionarJPanel(telaCriarConta);
			controllerTelaPrincipalAutenticacao.setPrimeiroAcesso(true);

			
		} else {
			telaAutenticacao = fabricaTelaCadastro.fabricarTelaAutenticacao();
			adicionarJPanel(telaAutenticacao);
			controllerTelaPrincipalAutenticacao.setPrimeiroAcesso(false);
		}
	}

	
	private void adicionarBotoes() {
		Font btnFonteComum = new Font("Arial", Font.PLAIN, 15);
		
		btnAutenticacao = new JButton("Fazer Login");
//		btnCriarConta = new JButton("Criar Conta");
		
		btnAutenticacao.setBounds(210,370,150, 30);
//		btnCriarConta.setBounds(210,370,150, 30);
		
		btnAutenticacao.setFont(btnFonteComum);
//		btnCriarConta.setFont(btnFonteComum);
		
		btnAutenticacao.addActionListener(new OuvinteDosBotoes());
//		btnCriarConta.addActionListener(new OuvinteDosBotoes());
		
		add(btnAutenticacao);
//		add(btnCriarConta);
		
		mostrarBotoes(isPrimeiroAcesso);
		
	}
	
	private void mostrarBotoes(boolean condicao) {
		
		btnAutenticacao.setVisible(condicao);
//		btnCriarConta.setVisible(!condicao);
	}
	
	private void modificarTamanho(int x, int y) {
		setSize(x, y);
		setLocationRelativeTo(null);
	}
	
	private void adicionarJPanel(Object jpanel) {
		add((JPanel)jpanel);
	}
	
	private void removerJPanel(Object jpanel) {
		
		this.remove((JPanel) jpanel);
		telaAutenticacao = null;
		telaCriarConta = null;
		revalidate();
		repaint();
	}
		
	private void adicionarConfiguracoesBasicas() {
		FactorySwingComponents.gerarLookAndFeelNimbus();
		
		modificarTamanho(400, 450);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
