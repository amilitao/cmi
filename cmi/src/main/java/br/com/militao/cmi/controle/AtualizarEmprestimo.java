package br.com.militao.cmi.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;

public class AtualizarEmprestimo implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		Emprestimo emprestimo = new Emprestimo();		
		
		
		emprestimo.setIdEmprestimo(Integer.parseInt(req.getParameter("idEmprestimo")));			
		emprestimo.setSituacao(StatusEmprestimoEnum.valueOf(req.getParameter("situacao")));	
		
		
		if(emprestimoDao.update(emprestimo)) {
			req.setAttribute("confirmaDao", true);
		}	
		
		// atualiza dashboard
		session.setAttribute("dashboard", null);
		
		return new ListarEmprestimo().executa(req, resp);
	}
	
	

}
