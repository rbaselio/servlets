package br.com.rbaselio.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.rbaselio.gerenciador.Usuario;
import br.com.rbaselio.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		PrintWriter writer = resp.getWriter();
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if (usuario == null) {
	        writer.println("<html><body>Usuário ou senha inválida</body></html>");
	    } else {
	    	HttpSession session = req.getSession();
	    	session.setAttribute("usuario.logado", usuario);
	    	writer.println("<html><body>Usuário logadão: " + email + "</body></html>");
	    }
		
		
		
	}
}
