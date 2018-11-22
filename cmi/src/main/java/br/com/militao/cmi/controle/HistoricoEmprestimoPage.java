package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.HistoricoEmprestimoDao;

public class HistoricoEmprestimoPage implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HistoricoEmprestimoDao histDao = new HistoricoEmprestimoDao();
		EmprestimoDao empDao = new EmprestimoDao();
		
		req.setAttribute("historicos", histDao.getList());
		req.setAttribute("emprestimos", empDao.getList());
		
		
		return "/WEB-INF/jsps/lista-historico.jsp";
	}

}
