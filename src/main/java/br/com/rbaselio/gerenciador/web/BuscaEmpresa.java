package br.com.rbaselio.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rbaselio.gerenciador.Empresa;
import br.com.rbaselio.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {
	private static final long serialVersionUID = -5377677393209983318L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Resultado da busca:<br/>");

		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		writer.println("<ul>");
		for (Empresa empresa : empresas) {
			writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
		}
		writer.println("</ul>");

		writer.println("</body>");
		writer.println("</html>");
	}

}
