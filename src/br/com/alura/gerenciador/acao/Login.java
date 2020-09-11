package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println("logando com login : " + login + " senha : " + senha);

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);

		if (usuario != null) {
			System.out.println("Usuario existe");
			HttpSession session = request.getSession(); // lendo a session ID da requisi��o HTTP e armazenando em um
														// objeto do tipo HttpSession de nome session

			session.setAttribute("usuarioLogado", usuario);// para guardar um usuario logado atraves do session ID
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
