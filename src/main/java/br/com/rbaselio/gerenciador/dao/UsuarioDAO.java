package br.com.rbaselio.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.rbaselio.gerenciador.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("rbaselio", new Usuario("rbaselio","123"));
		USUARIOS.put("roberto", new Usuario("roberto","456"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
