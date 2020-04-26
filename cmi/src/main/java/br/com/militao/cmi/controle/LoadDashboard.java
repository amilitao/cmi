package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Dashboard;
import br.com.militao.cmi.modelo.DashboardBuilder;
import br.com.militao.cmi.modelo.componente.Componente;
import br.com.militao.cmi.modelo.componente.ComponenteCreator;

public class LoadDashboard implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		ComponenteCreator creator = new ComponenteCreator();
		Componente painelStatusImpressora = creator.create(ComponenteCreator.PAINEL_STATUS);
		Componente painelUltimasAtualizacoes = creator.create(ComponenteCreator.PAINEL_ULT_ATUALIZACOES);

		Dashboard dashboard = new DashboardBuilder().comPainelStatus(painelStatusImpressora.criar())
				.comPainelUltimasAtualizacoes(painelUltimasAtualizacoes.criar()).geraDashboard();

		// criar tabela no banco de dados
		/*
		 * NotificacaoDao notDao = new NotificacaoDao();
		 * session.setAttribute("notificacoes", notDao.getList());
		 */

		req.setAttribute("painelStatusImpressora", dashboard.getPainelStatusImpressora());
		req.setAttribute("painelUltimasAtualizacoes", dashboard.getPainelUltimasAtualizacoes());

		return "forward:dashboard.jsp";
	}

}