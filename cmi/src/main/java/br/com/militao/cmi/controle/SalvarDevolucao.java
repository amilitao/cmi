package br.com.militao.cmi.controle;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;
import br.com.militao.cmi.modelo.dao.DevolucaoDao;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;


public class SalvarDevolucao implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {		
		
		Devolucao devolucao = new Devolucao();
		
		devolucao.setEmprestimo(new Emprestimo(Integer.parseInt(req.getParameter("idEmprestimo")),
				StatusEmprestimoEnum.ENCERRADO, LocalDateTime.now()));
		devolucao.setDtDevolucao(LocalDate.now());		
		devolucao.setNumNfeDevolucao(req.getParameter("numNfeDevolucao"));		 
		devolucao.setRecebedor( req.getParameter("recebedor"));		
		
		
		EmprestimoDao emprestimoDao = new EmprestimoDao();		
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		
		if (devolucaoDao.insert(devolucao) && emprestimoDao.update(devolucao.getEmprestimo())) {
			req.setAttribute("confirmaDao", true);
		}			
	
		return new ListarEmprestimo().executa(req, resp);
	}

	
	
}
