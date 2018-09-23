package br.com.militao.cmi.controle;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimo;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;

public class AtualizarEmprestimo implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		Emprestimo emprestimo = new Emprestimo();		
		
		
		emprestimo.setIdEmprestimo(Integer.parseInt(req.getParameter("idEmprestimo")));		
		emprestimo.setSituacao(StatusEmprestimo.valueOf(req.getParameter("situacao")));	
		
	
		if(req.getAttribute("dtFim") != null) {			
			emprestimo.setDtFim(LocalDateTime.parse(req.getParameter("dtFim")));
		}else {			
			emprestimo.setDtFim(null);		
		}	
		
		emprestimoDao.update(emprestimo);	
		
		
		req.setAttribute("listaDeEmprestimos", emprestimoDao.getList());				
		
		return "/WEB-INF/jsps/emprestimo/lista-emprestimo.jsp";
	}
	
	

}
