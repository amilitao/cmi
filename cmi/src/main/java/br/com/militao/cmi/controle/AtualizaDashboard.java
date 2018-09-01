package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.componente.PainelStatus;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;


public class AtualizaDashboard implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
								
		ImpressoraDao impDao = new ImpressoraDao();	
						
		PainelStatus painel = new PainelStatus();
		painel.atualiza(impDao.getList(), req, resp);
		req.setAttribute("painel", painel);
		
		return "/WEB-INF/jsps/dashboard.jsp";
		
	}

}
