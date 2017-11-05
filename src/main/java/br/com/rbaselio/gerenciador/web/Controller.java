package br.com.rbaselio.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = -1670810149590081047L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		// qual tarefa quero executar?
		String tarefa = req.getParameter("tarefa");
		if (tarefa == null)
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");

		String nomeDaClasse = "br.com.rbaselio.gerenciador.web." + tarefa;

		try {
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) type.newInstance();
			String pagina = instancia.executa(req, resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
