package br.com.militao.cmi.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;


public class SalvarEmprestimo implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		EmprestimoDao empDao = new EmprestimoDao();				
		Impressora impressora = new Impressora();
		Loja loja = new Loja();
						
		loja.setIdLoja(Integer.parseInt(req.getParameter("id_loja")));		
		impressora.setIdImpressora(Integer.parseInt(req.getParameter("id_impressora")));				
		String numChamado = req.getParameter("num_chamado");
		Emprestimo emprestimo = new Emprestimo(loja, impressora, numChamado);		
		

		if (empDao.insert(emprestimo)) {
			req.setAttribute("confirmaDao", true);				
		}	
		
		// atualiza dashboard
		session.setAttribute("dashboard", null);		

	    return new EmprestimoPage().executa(req, resp);
	}

}
