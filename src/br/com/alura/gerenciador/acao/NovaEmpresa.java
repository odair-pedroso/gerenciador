package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa via Classe unica ........");

		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // usando classe para transformar um String em Date
																	// (servlet só recebe string do formulario)
		Date dataAberturaParse = null;

		try {
			dataAberturaParse = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);

		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAberturaParse);

		Banco banco = new Banco(); // simulando um banco de dados para gravação da empresa
		banco.adiciona(empresa);

		System.out.println("Nova empresa cadastrada via Classe unica: " + empresa.getNome() + " data abertura"
				+ empresa.getDataAbertura());

		request.setAttribute("empresa", empresa.getNome());
		return "redirect:entrada?acao=ListaEmpresas";

	}

}
