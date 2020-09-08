package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemovaEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("removendo empresa com servlet �nica e Classe unica");

		String paramId = request.getParameter("id"); // m�todo request.getParameter sempre retorna uma String , mas
		// nosso ID � integer ent�o devemos fazer a convers�o
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		return "redirect:entrada?acao=ListaEmpresas";

	}

}
