package br.com.militao.cmi.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusPecaImpressoraEnum;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;

public class SalvarEmprestimo implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		EmprestimoDao empDao = new EmprestimoDao();
	/*	ListaDeEsperaDao listaEsperaDao = new ListaDeEsperaDao();	*/	

		String numChamado = req.getParameter("num_chamado");
		Emprestimo emprestimo = new Emprestimo(
				new Loja(Integer.parseInt(req.getParameter("id_loja"))),
				new Impressora(Integer.parseInt(req.getParameter("id_impressora"))), 
				numChamado);	
		
		empDao.insert(emprestimo);				
		
		/*ListaDeEspera lojaAguardando = listaEsperaDao.getByNumberLoja(Integer.parseInt(req.getParameter("id_loja")));
				
		if(lojaAguardando != null) {
			
			lojaAguardando.setStatus(StatusListaDeEsperaEnum.getByDescricao("atendido"));
			listaEsperaDao.update(lojaAguardando);
		}*/
		
		req.setAttribute("confirmaDao", true);

		// atualiza dashboard
		HttpSession session = req.getSession();
		session.setAttribute("dashboard", null);

		return new EmprestimoPage().executa(req, resp);
	}

}
