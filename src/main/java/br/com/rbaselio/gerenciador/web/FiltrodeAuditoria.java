package br.com.rbaselio.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.rbaselio.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltrodeAuditoria implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String usuario = getUsuario(req);

		System.out.println("Usuario " + usuario + " acessando a URI " + req.getRequestURI());
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
		if (usuario == null)
			return "<deslogado>";
		return usuario.getEmail();
	}

}
