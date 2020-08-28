package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// primeiro precisamos ler o parametro recebido pela listaEmpresas.jsp bot�o
		// remove

		String paramId = request.getParameter("id"); // m�todo request.getParameter sempre retorna uma String , mas
														// nosso ID � integer ent�o devemos fazer a convers�o
		Integer id = Integer.valueOf(paramId);

		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		response.sendRedirect("listaEmpresas");

	}

}
