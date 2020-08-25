package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa via Servlet........");

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

		System.out.println(
				"Nova empresa cadastrada Servlet: " + empresa.getNome() + " data abertura" + empresa.getDataAbertura());

		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("listaEmpresas"); // nao pode ter barra

		// // chamar o JSP
		// RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		// request.setAttribute("empresa", empresa.getNome());
		// rd.forward(request, response);

	}

}
