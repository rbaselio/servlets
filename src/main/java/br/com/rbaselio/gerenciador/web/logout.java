package br.com.rbaselio.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class logout extends HttpServlet {
	
	private static final long serialVersionUID = 6961943027643393088L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		req.getSession().removeAttribute("usuario.logado");
		writer.println("<html><body>Logout efetuado</body></html>");
		
		
	}

	

}
