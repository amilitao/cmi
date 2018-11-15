package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.LojaDao;

public class LojaPage implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		LojaDao dao = new LojaDao();
		
		req.setAttribute("lojas", dao.getList());
		
		
		return "/WEB-INF/jsps/cadastro/cad-loja.jsp";
	}
	
	

}
