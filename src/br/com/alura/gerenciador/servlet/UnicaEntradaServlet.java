package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		System.out.println(paramAcao);

		// trecho código que pega a SessionId da requisição e verifica se usuario ja
		// esta logado ou nao, se nao estiver ele retorna para tela login, não
		// conseguindo acessar diretamente as ações sem passar pelo Login

		HttpSession session = request.getSession();
		boolean usuarioNaoLogado = session.getAttribute("usuarioLogado") == null;
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

		if (ehUmaAcaoProtegida && usuarioNaoLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}

		// trecho que recupera os parametros do formulario e direciona para ação correta

		// muitos if e else; gostariamos que fosse assim : paramAcao.executa(req,res);
		// refatoração desta etapa :

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); // carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]); // despachador JSP
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]); // redirecionador JSP
		}

	}

}

// String nome = null;
// if (paramAcao.equals("ListaEmpresas")) {
// ListaEmpresas acao = new ListaEmpresas();
// nome = acao.executa(request, response);
//
// } else if (paramAcao.equals("RemovaEmpresa")) {
// RemovaEmpresa acao = new RemovaEmpresa();
// nome = acao.executa(request, response);
//
// } else if (paramAcao.equals("MostraEmpresa")) {
// MostraEmpresa acao = new MostraEmpresa();
// nome = acao.executa(request, response);
//
// } else if (paramAcao.equals("AlteraEmpresa")) {
// AlteraEmpresa acao = new AlteraEmpresa();
// nome = acao.executa(request, response);
//
// } else if (paramAcao.equals("NovaEmpresa")) {
// NovaEmpresa acao = new NovaEmpresa();
// nome = acao.executa(request, response);
//
// } else if (paramAcao.equals("NovaEmpresaForm")) {
// NovaEmpresaForm acao = new NovaEmpresaForm();
// nome = acao.executa(request, response);
//
// }
