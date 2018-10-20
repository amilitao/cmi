package br.com.militao.cmi.controle;


import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.HistoricoEmprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.HistoricoEmprestimoDao;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class SalvarEmprestimo implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		EmprestimoDao empDao = new EmprestimoDao();	
		ImpressoraDao impDao = new ImpressoraDao();
		HistoricoEmprestimoDao historicoDao = new HistoricoEmprestimoDao();
		LojaDao lojaDao = new LojaDao();
		
						
		Loja loja = lojaDao
				.getLojaPorId(Integer.parseInt(req.getParameter("id_loja")));		
		Impressora impressora = impDao
				.getImpressoraPorId(Integer.parseInt(req.getParameter("id_impressora")));		
		String numChamado = req.getParameter("num_chamado");
		Emprestimo emprestimo = new Emprestimo(loja, impressora, numChamado);

		if (empDao.insert(emprestimo)) {
			req.setAttribute("confirmaDao", true);				
		}	
		
		req.setAttribute("lojas", lojaDao.getList());
		req.setAttribute("impressoras", impDao.getListPorStatus("disponivel"));

		return "/WEB-INF/jsps/emprestimo/emprestimo.jsp";

	}

}
