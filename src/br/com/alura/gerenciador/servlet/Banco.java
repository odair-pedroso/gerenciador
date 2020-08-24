package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>(); // o banco possui uma lista de empresas

	static { // metodo fake para inicializar o banco sempre com duas empresas para nao perder
				// as empresas ao reiniciar o servidor , uma vez que estamos simulando um banco
				// de dados.

		Empresa empresa = new Empresa();
		empresa.setNome("Alura");

		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");

		lista.add(empresa);
		lista.add(empresa2);

	}

	public void adiciona(Empresa empresa) { // metodo que adiciona empresas ao Banco

		Banco.lista.add(empresa);

	}

	public List<Empresa> getEmpresas() { // método que retorna a lista de empresas do banco

		return Banco.lista;
	}

}
