package br.com.rbaselio.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class logout extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		
		if (cookie == null) {
			 writer.println("<html><body>Usuario não logado</body></html>");
			return;
		}
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		 writer.println("<html><body>Logout efetuado</body></html>");
		
		
	}

	

}
