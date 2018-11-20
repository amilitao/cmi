package br.com.militao.cmi.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class SalvarEmprestimo implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		EmprestimoDao empDao = new EmprestimoDao();	
		ImpressoraDao impDao = new ImpressoraDao();		
		LojaDao lojaDao = new LojaDao();
		
						
		Loja loja = lojaDao
				.getLojaPorId(Integer.parseInt(req.getParameter("id_loja")));		
		Impressora impressora = impDao
				.getImpressoraPorId(Integer.parseInt(req.getParameter("id_impressora")));
		impressora.setSituacao(StatusImpressoraEnum.EM_EMPRESTIMO);
		
		String numChamado = req.getParameter("num_chamado");
		Emprestimo emprestimo = new Emprestimo(loja, impressora, numChamado);		
		

		if (empDao.insert(emprestimo) && impDao.update(impressora)) {
			req.setAttribute("confirmaDao", true);				
		}	
		
		// atualiza dashboard
		session.setAttribute("dashboard", null);
		req.setAttribute("lojas", lojaDao.getList());
		req.setAttribute("impressoras", impDao.getListPorStatus("disponivel"));

		return "/WEB-INF/jsps/emprestimo/emprestimo.jsp";

	}

}
