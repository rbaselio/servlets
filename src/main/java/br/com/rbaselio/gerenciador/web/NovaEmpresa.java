package br.com.rbaselio.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rbaselio.gerenciador.Empresa;
import br.com.rbaselio.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet{
	
	private static final long serialVersionUID = -9142880845029247758L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Empresa " + nome + " adicionada!</body></html>");
	}

}
