package br.com.rbaselio.gerenciador.web.tarefas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rbaselio.gerenciador.Empresa;
import br.com.rbaselio.gerenciador.dao.EmpresaDAO;
import br.com.rbaselio.gerenciador.web.Tarefa;


public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		
		req.setAttribute("empresa", empresa);
		return "/WEB-INF/paginas/novaEmpresa.jsp";
		
		
	}

}
