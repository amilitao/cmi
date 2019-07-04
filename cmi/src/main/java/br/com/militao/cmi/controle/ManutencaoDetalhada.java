package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.StatusPecaImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ChecklistTesteDao;
import br.com.militao.cmi.modelo.dao.ManutencaoDao;
import br.com.militao.cmi.modelo.dao.OrcamentoDao;

public class ManutencaoDetalhada implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ManutencaoDao manuDao = new  ManutencaoDao();	
		ChecklistTesteDao checklist = new ChecklistTesteDao();
		OrcamentoDao orcDao = new OrcamentoDao();
		
		int id_manutencao = Integer.parseInt(req.getParameter("id_manutencao"));
			
		req.setAttribute("manutencao", manuDao.getManutencaoById(id_manutencao));
		req.setAttribute("checklist_teste", checklist.getByIdManutencao(id_manutencao));
		req.setAttribute("status", StatusPecaImpressoraEnum.values());
		req.setAttribute("listaDeOrcamento", orcDao.getOrcamentoPorIdManutencao(id_manutencao));
		
		return "/WEB-INF/jsps/manutencao/detalhes-manutencao.jsp";
	}
	
	

}
