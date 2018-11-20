package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.LojaDao;

public class ListaDeEsperaPage implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		LojaDao lojaDao = new LojaDao();

		
		req.setAttribute("lojas", lojaDao.getList());		


		return "/WEB-INF/jsps/lista-de-espera.jsp";

	}

}
