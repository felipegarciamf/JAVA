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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		
		String uri = req.getRequestURI();
		String usuario = "<deslogado>";
		
		if(usuarioLogado != null) {
			usuario = usuarioLogado.getEmail();
		}
		
		System.out.println("Usuario " + usuario + " acessando a URI " +  uri);
		chain.doFilter(request, response);
	}

	
	// método de verificar usuário no cookie
	private String getUsuario(HttpServletRequest req) {
		// pegando o atributo da sessão usuario e jogando para entidade usuario
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario==null) return "<deslogado>";
		// retornando usuário
		return usuario.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
