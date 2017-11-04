package br.com.rbaselio.gerenciador.web.tarefas;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rbaselio.gerenciador.Empresa;
import br.com.rbaselio.gerenciador.dao.EmpresaDAO;
import br.com.rbaselio.gerenciador.web.Tarefa;


public class BuscaEmpresa implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresas.jsp";	
	}
}
