package br.com.militao.cmi.controle;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class EmprestimoPage implements Logica{	
	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
				
		LojaDao lojaDao = new LojaDao();
		ImpressoraDao impressoraDao = new ImpressoraDao();
		
		req.setAttribute("lojas", lojaDao.getList());
		req.setAttribute("impressoras", impressoraDao.getListPorStatus(StatusImpressoraEnum.DISPONIVEL));			


		return "forward:emprestimo/emprestimo.jsp";

		
	}
	
	

}
