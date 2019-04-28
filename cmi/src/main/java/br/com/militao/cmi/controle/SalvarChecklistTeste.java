package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.ChecklistTeste;
import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.StatusPecaImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ChecklistTesteDao;

public class SalvarChecklistTeste implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ChecklistTesteDao checkDao = new ChecklistTesteDao();
		ChecklistTeste checklist = new ChecklistTeste();
		Manutencao manutencao = new Manutencao();
		
		checklist.setOperador(req.getParameter("operador"));
		checklist.setDesc_problema(req.getParameter("desc_problema"));
		checklist.setStatus_borracha(StatusPecaImpressoraEnum.valueOf(req.getParameter("status_borracha")));
		checklist.setStatus_cabeca_impressao(StatusPecaImpressoraEnum.valueOf(req.getParameter("status_cabeca_impressao")));
		checklist.setStatus_faca(StatusPecaImpressoraEnum.valueOf(req.getParameter("status_faca")));
		checklist.setObservacao(req.getParameter("observacao"));
		
		manutencao.setId_manutencao(Integer.parseInt(req.getParameter("id_manutencao")));
		checklist.setManutencao(manutencao);
		
		checkDao.insert(checklist);		

		HttpSession session = req.getSession();

		req.setAttribute("confirmaDao", true);
		session.setAttribute("dashboard", null);
		
		return new ManutencaoDetalhada().executa(req, resp);		

		
	}

}
