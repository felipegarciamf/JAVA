package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


public class BuscaEmpresa implements Tarefa {
	
	public BuscaEmpresa() {
		System.out.println("Contruindo uma servlet do tipo BuscaEmpresa" + this);
	}
	
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
			String filtro = request.getParameter("filtro");
		
		/* faz com que demore este tempo para continuar o restante do código
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		request.setAttribute("empresas", empresas);
		return "WEB-INF/paginas/buscaEmpresa.jsp";
	}
	
}
