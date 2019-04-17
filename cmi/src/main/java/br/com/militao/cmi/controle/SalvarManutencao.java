package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Assistencia;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.dao.ManutencaoDao;

public class SalvarManutencao implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ManutencaoDao manuDao = new ManutencaoDao();
		
		
		Manutencao manutencao = new Manutencao(
				new Assistencia(Integer.parseInt(req.getParameter("id_assistencia"))),
				new Impressora(Integer.parseInt(req.getParameter("id_impressora"))));
		
		manuDao.insert(manutencao);	
		
		req.setAttribute("confirmaDao", true);		
		
		// atualiza dashboard
				HttpSession session = req.getSession();
				session.setAttribute("dashboard", null);

		
		return new ListarManutencao().executa(req, resp);
	}

}
