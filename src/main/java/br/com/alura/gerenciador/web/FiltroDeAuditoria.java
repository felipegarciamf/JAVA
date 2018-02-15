package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria  implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String usuario = getUsuario(req);
		System.out.println("Usuario acessando a URI " + usuario + uri);
		chain.doFilter(request, response);
	}

	
	// método de verificar usuário no cookie
	private String getUsuario(HttpServletRequest req) {
		// inicial deslogado
		String usuario = "<deslogado>";
		// pegando as requisições cookie e jogando para uma array de cookie
		Cookie[] cookies = req.getCookies();
		// criando condição de cookie, caso seja nulo irá retornar deslogado
		if(cookies == null) return null;
		// criando loope para verificar se o cookie condiz com o usuário logado
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("usuario.logado")) {
				usuario = cookie.getValue();
			}
		}
		// retornando usuário
		return usuario;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
