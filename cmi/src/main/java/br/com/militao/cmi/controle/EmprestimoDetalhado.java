package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.DevolucaoDao;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.HistoricoEmprestimoDao;
import br.com.militao.cmi.modelo.dao.TransporteDao;

public class EmprestimoDetalhado implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {		
		
		EmprestimoDao empDao = new EmprestimoDao();
		TransporteDao transDao = new TransporteDao();
		DevolucaoDao devDao = new DevolucaoDao();	
		HistoricoEmprestimoDao histDao = new HistoricoEmprestimoDao();
		
		int id_emprestimo = Integer.parseInt(req.getParameter("idEmprestimo"));		
		
		req.setAttribute("emprestimo", 
				empDao.getEmprestimoPorId(id_emprestimo));		
		req.setAttribute("listaDeTransportes", transDao.getTransportePorIdEmprestimo(id_emprestimo));
		req.setAttribute("listaDeDevolucoes", devDao.getDevolucaoPorIdEmprestimo(id_emprestimo));
		req.setAttribute("historicos", histDao.getHistoricoPorIdEmprestimo(id_emprestimo));
		
		return "/WEB-INF/jsps/emprestimo/detalhes-emprestimo.jsp";
	}

}
