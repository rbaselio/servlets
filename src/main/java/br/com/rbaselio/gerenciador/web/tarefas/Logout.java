package br.com.rbaselio.gerenciador.web.tarefas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rbaselio.gerenciador.web.Tarefa;


public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		req.getSession().removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.html";
		

	}

}
