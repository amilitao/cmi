package br.com.militao.cmi.controle.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Dashboard;


@WebFilter("dashboard.jsp")
public class DashboardFiltro implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		
		HttpSession session = ((HttpServletRequest) req).getSession();
		
		Dashboard dashboard = (Dashboard)session.getAttribute("dashboard");

		
		req.setAttribute("painelStatus", dashboard.getPainel());
		System.out.println("entrou no filtro");	
		
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
