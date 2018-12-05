package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Movimentacao;
import br.com.militao.cmi.modelo.MovimentacaoCreator;
import br.com.militao.cmi.modelo.dao.DevolucaoDao;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.TransporteDao;

public class EmprestimoDetalhado implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {		
		
		MovimentacaoCreator movCreator = new MovimentacaoCreator();				
		Movimentacao movimentacao = movCreator.creator(MovimentacaoCreator.EMPRESTIMO);
		
		movimentacao.relacionar(Integer.parseInt(req.getParameter("id_emprestimo")));
		
		req.setAttribute("movimentacao", movimentacao );		
		
		
		return "/WEB-INF/jsps/emprestimo/detalhes-emprestimo.jsp";
	}

}
