package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemovaEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("removendo empresa com servlet única e Classe unica");

		String paramId = request.getParameter("id"); // método request.getParameter sempre retorna uma String , mas
		// nosso ID é integer então devemos fazer a conversão
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		return "redirect:entrada?acao=ListaEmpresas";

	}

}
