package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//oi

@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

	public OiMundoServlet() {
		System.out.println("Criando Oi mundo na Servlet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("<body>");
		writer.println("Parabéns pela primeira Servlet.");
		writer.println("</body>");
		writer.println("</html>");

		System.out.println("o servlet OiMundo foi chamado.....");
	}

}
