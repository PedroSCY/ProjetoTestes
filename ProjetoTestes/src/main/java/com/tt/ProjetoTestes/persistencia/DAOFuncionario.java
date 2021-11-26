package com.tt.ProjetoTestes.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.tt.ProjetoTestes.model.entidades.Funcionario;


public class DAOFuncionario1 {

	private HashMap<Long, Funcionario> persistidos;
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("UTF-8"));

	// Neste construtor, foi instanciado o file arquivoColecao e o XStream, tambem é setado as suas restriçoes de permissões.
	// Caso o aquivo XML exista, é usado o método carregarXml(), caso contrario, um novo HashMap<> é criado.
	public DAOFuncionario() {
		arquivoColecao = new File("funcionarios.xml");

		// Restringindo permissões
		xstream.addPermission(NoTypePermission.NONE);
		xstream.allowTypesByRegExp(new String[] { 
				"model.*",
				"persistencia.*",
				"java.util.*",
				"java.lang.Long",
		}
				);

		if (arquivoColecao.exists()) {
			carregarXML();
		} else {
			persistidos = new HashMap<Long, Funcionario>();
		}
	}

	// O método criar() adiciona o objeto passado como parametro ao hashmap.
	public void criar(Funcionario funcionario) throws Exception {
		if(verificar(funcionario)) {			
			persistidos.put(funcionario.getMatricula(), funcionario);
			salvarXML();
			return;
		}
		throw new Exception("Não foi possível salvar o funcionário " + funcionario.getNome());
	}

	public Funcionario consultarFuncionario(long matricula) throws Exception {
		for(long key: persistidos.keySet()) {
			if(matricula == key) {
				return persistidos.get(key);
			}
		}
		throw new Exception("Funcionário não encontrado");
	}
	
	public Funcionario consultarFuncionario(String email) throws Exception {
		for(long key: persistidos.keySet()) {
			if(persistidos.get(key).getEmail().equals(email)) {
				return persistidos.get(key);
			}
		}
		throw new Exception("Funcionário não encontrado");
	}
	//TODO - atualizar UML
	public void FuncionarioNaoExiste(long cpf, long matricula) throws Exception {
		for(long key: persistidos.keySet()) {
			if(matricula == key || persistidos.get(key).getCpf() == cpf) {
				throw new Exception("Funcionário existente");
			}
		}
		
	}

	public Set<Funcionario> consultarTodos() {
		Set<Funcionario> funcionarios = new LinkedHashSet<Funcionario>();

		for(long key : persistidos.keySet()) {
			Funcionario funcionario = persistidos.get(key);
			funcionarios.add(funcionario);
		}

		return funcionarios;
	}

	public boolean atualizar(long matricula, Funcionario funcionario) {
		for(long key : persistidos.keySet()){
			if(key == matricula) {
				persistidos.replace(key, funcionario);
				salvarXML();  // Toda vez que esta função for utilizada, o aquivo xml é atualizado.
				return true;
			}
		}

		System.out.println("Matricula " + matricula + " inexistente");
		return false;
	}

	public void remover(long matricula) throws Exception {
		for(long key : persistidos.keySet()){
			if(key == matricula ) {
				persistidos.remove(key);
				salvarXML(); // Toda vez que esta função for utilizada, o aquivo xml é atualizado.
				return;
			}
		}
		throw new Exception("Matricula " + matricula + " inexistente");
	}

	// TODO [UML] add method
	// O método verificar() verifica se existe algum funcionario com a mesma matricula já registrado.
	public boolean verificar(Funcionario funcionario) throws Exception {
		for(long key: persistidos.keySet()) {
			if(funcionario.getMatricula() == key) {
				return false;
			}
		}
		return true;
	}

	// TODO [UML] add method
	// O método salvarxml() cria um xml que cotem o hashmap persistidos.
	// Logo após, cria um arquivo contendo este xml e o armazena no endereco de arquivoColecao.
	private void salvarXML() {

		String xmlPersistidos = xstream.toXML(persistidos);
		xstream.alias("map", java.util.Map.class);

		try {

			arquivoColecao.createNewFile();
			PrintWriter gravador = new PrintWriter (arquivoColecao);
			gravador.print(xmlPersistidos);
			gravador.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO [UML] add method
	// O método carregarXml() recupera os dados armazenados no arquivo xml no endereço descrito por arquivoColecao.
	@SuppressWarnings("unchecked")
	private void carregarXML() {

		try {

			FileInputStream fis = new FileInputStream(arquivoColecao);
			persistidos = (HashMap<Long, Funcionario>) xstream.fromXML(fis); // Os dados recuperados são passados ao hashmap persistidos.

			return; // Caso nenhuma alteração seja feita, o metodo salvarxml() não será acionado.

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
