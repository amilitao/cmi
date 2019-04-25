package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.StatusPecaImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ManutencaoDao;

public class ManutencaoDetalhada implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ManutencaoDao manuDao = new  ManutencaoDao();	
		
		int id_manutencao = Integer.parseInt(req.getParameter("id_manutencao"));
			
		req.setAttribute("manutencao", manuDao.getManutencaoById(id_manutencao));
		req.setAttribute("status", StatusPecaImpressoraEnum.values());
		
		return "/WEB-INF/jsps/manutencao/detalhes-manutencao.jsp";
	}
	
	

}
