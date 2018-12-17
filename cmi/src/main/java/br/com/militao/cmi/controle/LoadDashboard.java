package br.com.militao.cmi.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Dashboard;
import br.com.militao.cmi.modelo.DashboardBuilder;
import br.com.militao.cmi.modelo.componente.Componente;
import br.com.militao.cmi.modelo.componente.ComponenteCreator;
import br.com.militao.cmi.modelo.dao.NotificacaoDao;

public class LoadDashboard implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){

		Dashboard dashboard;
		
		HttpSession session = req.getSession();

		if (session.getAttribute("dashboard") == null) {

			ComponenteCreator creator = new ComponenteCreator();
			Componente painelStatus = creator.create(ComponenteCreator.PAINEL_STATUS);

			dashboard = new DashboardBuilder().
					comPainelStatus(painelStatus.criar()).geraDashboard();

			session.setAttribute("dashboard", dashboard);

		} else {

			dashboard = (Dashboard) session.getAttribute("dashboard");
		}
		
		NotificacaoDao notDao = new NotificacaoDao();
		session.setAttribute("notificacoes", notDao.getList());
		
		req.setAttribute("painelStatus", dashboard.getPainel());

		return "/WEB-INF/jsps/dashboard.jsp";
	}

}