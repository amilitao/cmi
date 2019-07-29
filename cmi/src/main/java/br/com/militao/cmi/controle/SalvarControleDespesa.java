package br.com.militao.cmi.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.StatusManutencaoEnum;
import br.com.militao.cmi.modelo.dao.ManutencaoDao;

public class SalvarControleDespesa implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ManutencaoDao manuDao = new ManutencaoDao();
		Manutencao manutencao = new Manutencao();
		
		manutencao.setId_manutencao(Integer.parseInt(req.getParameter("id_manutencao")));		
		manutencao.setNumero_despesa(Integer.parseInt(req.getParameter("numero_despesa")));
		manutencao.setStatus_manutencao(StatusManutencaoEnum.ANALISE);
				
		manuDao.updateControleDespesa(manutencao);
		
		req.setAttribute("confirmaDao", true);

		// atualiza dashboard
		HttpSession session = req.getSession();
		session.setAttribute("dashboard", null);

		return new ManutencaoDetalhada().executa(req, resp);
	}

}
