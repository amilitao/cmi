package br.com.militao.cmi.controle;


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
		
		
		if(emprestimoDao.update(emprestimo)) {
			req.setAttribute("confirmaDao", true);
		}	
				
		
		return new ListarEmprestimo().executa(req, resp);
	}
	
	

}
