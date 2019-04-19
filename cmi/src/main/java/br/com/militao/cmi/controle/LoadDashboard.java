package br.com.militao.cmi.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Dashboard;
import br.com.militao.cmi.modelo.DashboardBuilder;
import br.com.militao.cmi.modelo.componente.Componente;
import br.com.militao.cmi.modelo.componente.ComponenteCreator;


public class LoadDashboard implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){

		Dashboard dashboard;
		
		HttpSession session = req.getSession();

		if (session.getAttribute("dashboard") == null) {

			ComponenteCreator creator = new ComponenteCreator();
			Componente painelStatusImpressora = creator.create(ComponenteCreator.PAINEL_STATUS);
			Componente painelStatusAtendimento = creator.create(ComponenteCreator.PAINEL_ATENDIMENTO);
			Componente painelUltimasAtualizacoes = creator.create(ComponenteCreator.PAINEL_ULT_ATUALIZACOES);

			dashboard = new DashboardBuilder().
					comPainelStatus(painelStatusImpressora.criar()).
					comPainelRegionais(painelStatusAtendimento.criar()).
					comPainelUltimasAtualizacoes(painelUltimasAtualizacoes.criar()).
					geraDashboard();

			session.setAttribute("dashboard", dashboard);

		} else {

			dashboard = (Dashboard) session.getAttribute("dashboard");
		}
		
		
		//criar tabela no banco de dados
		/*NotificacaoDao notDao = new NotificacaoDao();
		session.setAttribute("notificacoes", notDao.getList());*/		
			
		
		req.setAttribute("painelStatusImpressora", dashboard.getPainelStatusImpressora());
		req.setAttribute("painelStatusAtendimento", dashboard.getPainelStatusAtendimento());
		req.setAttribute("painelUltimasAtualizacoes", dashboard.getPainelUltimasAtualizacoes());

		return "/WEB-INF/jsps/dashboard.jsp";
	}

}