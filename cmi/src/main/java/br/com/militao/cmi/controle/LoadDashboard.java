package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Dashboard;

public class LoadDashboard implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		
		Dashboard dash = (Dashboard)session.getAttribute("dashboard");
		
		req.setAttribute("painelStatus",dash.get("painelStatus"));
		
		return null;
	}

}
