package br.com.rbaselio.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {
	String executa(HttpServletRequest request, HttpServletResponse response);

}
