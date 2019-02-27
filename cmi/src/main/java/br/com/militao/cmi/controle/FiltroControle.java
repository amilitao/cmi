package br.com.militao.cmi.controle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Usuario;

@WebFilter(urlPatterns="/controle")
public class FiltroControle implements Filter {

	/**
	 * Default constructor.
	 */
	public FiltroControle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		Usuario user = (Usuario) session.getAttribute("usuarioLogado");
		
		if (user == null) {
	
			session.invalidate();
			resp.sendRedirect("index.jsp");
			
		} else if (req.getParameter("logica") != null){
			resp.setHeader("Cache-control", "no-cache, no-store");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Expires", "-1");
			chain.doFilter(req, resp);
		}else {			
			
			req.setAttribute("logica", "LoadDashboard");
			chain.doFilter(req, resp);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
