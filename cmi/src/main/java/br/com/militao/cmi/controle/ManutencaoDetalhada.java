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
		
		int idManutencao = Integer.parseInt(req.getParameter("id_manutencao"));
			
		req.setAttribute("manutencao", manuDao.getManutencaoById(idManutencao));
		req.setAttribute("checklist_teste", checklist.getByIdManutencao(idManutencao));
		req.setAttribute("status", StatusPecaImpressoraEnum.values());
		req.setAttribute("listaDeOrcamento", orcDao.getOrcamentoPorIdManutencao(idManutencao));
		
		return "forward:manutencao/detalhes-manutencao.jsp";
	}
	
	

}
