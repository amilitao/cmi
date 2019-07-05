package br.com.militao.cmi.controle;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Manutencao;
import br.com.militao.cmi.modelo.StatusManutencaoEnum;
import br.com.militao.cmi.modelo.dao.ManutencaoDao;

public class EnviarParaManutencao implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ManutencaoDao manuDao = new ManutencaoDao();
		Manutencao manutencao = new Manutencao();
		
		manutencao.setId_manutencao(Integer.parseInt(req.getParameter("id_manutencao")));		
		manutencao.setDt_envio(LocalDateTime.now());
		manutencao.setNfe_envio(req.getParameter("nfe_envio"));
		manutencao.setStatus_manutencao(StatusManutencaoEnum.valueOf(req.getParameter("status_manutencao")));
		
		//falta alterar modal-nfe-envio e criar metodo na classe ManutencaoDao para salvar dados de envio
		
		manuDao.update(manutencao);
		
		req.setAttribute("confirmaDao", true);

		// atualiza dashboard
		HttpSession session = req.getSession();
		session.setAttribute("dashboard", null);

		return new ManutencaoDetalhada().executa(req, resp);
	}

}
