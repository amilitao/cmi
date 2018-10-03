package br.com.militao.cmi.controle;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.DevolucaoDao;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.TransporteDao;

public class ListarEmprestimo implements Logica{

	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub		
		
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		TransporteDao transporteDao = new TransporteDao();
		DevolucaoDao devolucaoDao = new DevolucaoDao();			
		
		req.setAttribute("listaDeEmprestimos", emprestimoDao.getList());
		req.setAttribute("listaDeTransporte", transporteDao.getList());		
		req.setAttribute("listaDeDevolucao", devolucaoDao.getList());
		
		
		return  "/WEB-INF/jsps/emprestimo/lista-emprestimo.jsp";
	}
	
	

}
