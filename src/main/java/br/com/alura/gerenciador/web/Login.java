package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;


@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// pegando parametros da url
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		// autenticando email e senha do método buscaporemailesenha no usuarioDAO
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		// criando writer para aparecer mensagem na tela
		PrintWriter write = resp.getWriter();
		// criando condição de nulo ou não
		if(usuario == null) {
			write.println("<html><body>Usuário Inválido</body></html>");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario); 
			write.println("<html><body>Usuário logado:" + email +  "</body></html>");
		}
		
	}

}
