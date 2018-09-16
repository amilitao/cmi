package br.com.militao.cmi.controle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Dashboard;
import br.com.militao.cmi.modelo.DashboardBuilder;
import br.com.militao.cmi.modelo.componente.PainelStatus;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;

public class LoadDashboard implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Dashboard dashboard;
		
		ImpressoraDao impDao = new ImpressoraDao();
		List<Object> impressoras = impDao.getList();
		
		HttpSession session = req.getSession();

		if (session.getAttribute("dashboard") == null) {
			
			dashboard = new DashboardBuilder().
					comPainelStatus(new PainelStatus(impressoras)).geraDashboard();
			session.setAttribute("dashboard", dashboard);
			//System.out.println("criando novo dashboard");
		} else {
		
			dashboard = (Dashboard) session.getAttribute("dashboard");			
		}
		
		req.setAttribute("painelStatus", dashboard.getPainel());
		
		return "/WEB-INF/jsps/dashboard.jsp";
	}

}