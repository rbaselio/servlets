package br.com.rbaselio.gerenciador.web.tarefas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.rbaselio.gerenciador.Usuario;
import br.com.rbaselio.gerenciador.dao.UsuarioDAO;
import br.com.rbaselio.gerenciador.web.Tarefa;

public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if (usuario == null) {
			return "/WEB-INF/paginas/login.jsp";

		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			return "/WEB-INF/paginas/login.jsp";
		}

	}
}
