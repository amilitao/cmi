package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.ImpressoraDao;


public class AtualizaDashboard implements Logica {
	
	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
								
		ImpressoraDao impDao = new ImpressoraDao();		
		
		req.setAttribute("numImpDisponivel", 10);
		req.setAttribute("numImpEmprestimo", 2);
		req.setAttribute("numImpManutencao", 5);
		req.setAttribute("numImpDefeito", 7);
		
	}

}
