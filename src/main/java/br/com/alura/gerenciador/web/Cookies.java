package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;

	}

	public Cookie buscaUsuarioLogado() {
		// criando condição de cookie, caso seja nulo irá retornar deslogado
		if (cookies == null)
			return null;
		// criando loope para verificar se o cookie condiz com o usuário logado
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				return cookie;
			}
		}
		return null;
	}

}
