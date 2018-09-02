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
		System.out.println(session.getAttribute("dashboard"));
		
		if (session.getAttribute("dashboard") == null) {
			Dashboard dashboard = new DashboardBuilder().comPainelStatus(new PainelStatus()).geraDashboard();
			System.out.println(dashboard.toString());
			req.setAttribute("dashboard", dashboard);
			
		}
		

		return "/WEB-INF/jsps/dashboard.jsp";
	}

}
