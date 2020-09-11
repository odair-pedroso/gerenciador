package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>(); // o banco possui uma lista de empresas
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static { // metodo fake para inicializar o banco sempre com duas empresas para nao perder
				// as empresas ao reiniciar o servidor , uma vez que estamos simulando um banco
				// de dados.

		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++); // simulando o id sequencial de um canco de dados relacional através de uma
											// variavel chaveSequencial incremental
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("12345");

		listaUsuarios.add(u1);
		listaUsuarios.add(u2);

	}

	public void adiciona(Empresa empresa) { // metodo que adiciona empresas ao Banco
		empresa.setId(Banco.chaveSequencial++); // apenas setando um id sequencial para cada empresa que for criada
		Banco.lista.add(empresa);

	}

	public List<Empresa> getEmpresas() { // método que retorna a lista de empresas do banco

		return Banco.lista;
	}

	public void removeEmpresa(Integer id) { // tivemos que usar o iterator para manter a opção de exluir um item de
											// lista do ArrayList

		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa empresa = it.next();

			if (empresa.getId() == id) {
				it.remove();

			}
		}

	}

	public Empresa buscaEmpresaPeloId(Integer id) {

		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}

		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {

		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
