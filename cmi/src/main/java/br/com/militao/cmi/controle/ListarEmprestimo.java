package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.EmprestimoDao;

public class ListarEmprestimo implements Logica{

	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub		
		
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		
		req.setAttribute("listaDeEmprestimos", emprestimoDao.getList());
		
		
		return  "/WEB-INF/jsps/emprestimo/lista-emprestimo.jsp";
	}
	
	

}
