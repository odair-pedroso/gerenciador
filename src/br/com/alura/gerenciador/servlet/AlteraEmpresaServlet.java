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

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Alterando uma empresa via Servlet........");

		String nomeEmpresa = request.getParameter("nome"); // ler os parametros enviados pelo formulario
		String dataEmpresa = request.getParameter("data");
		String idEmpresa = request.getParameter("id");

		Integer id = Integer.valueOf(idEmpresa); // transformar o parametro id recebido pelo formulario (String) , no
													// real tipo dele que é Integer conforme classe Empresa

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // usando método SimpleDateFormat para transformar um
																	// String em Date
																	// (servlet só recebe string do formulario)
		Date dataAberturaParse = null;

		try {
			dataAberturaParse = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);

		}

		System.out.println(id);

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAberturaParse);

		response.sendRedirect("listaEmpresas");

	}

}
