package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Dashboard;
import br.com.militao.cmi.modelo.DashboardBuilder;
import br.com.militao.cmi.modelo.componente.PainelStatus;

public class LoadDashboard implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		HttpSession session = req.getSession();	
		
		if(session.getAttribute("dashboard") == null) {
			
			Dashboard dashboard = new DashboardBuilder().comPainelStatus(new PainelStatus()).geraDashboard();
			session.setAttribute("dashboard", dashboard);
		
			req.setAttribute("painelStatus", dashboard.getPainel());						
		}		
		
		return "/WEB-INF/jsps/dashboard.jsp";
	}

}