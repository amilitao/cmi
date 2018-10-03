package br.com.militao.cmi.controle;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimo;
import br.com.militao.cmi.modelo.dao.DevolucaoDao;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;


public class SalvarDevolucao implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		
		Devolucao devolucao = new Devolucao(
				new Emprestimo(Integer.parseInt(req.getParameter("idEmprestimo")),
				StatusEmprestimo.ENCERRADO), req.getParameter("numNfeDevolucao"),
				req.getParameter("recebedor"));				
		
		System.out.println(devolucao.getEmprestimo().getIdEmprestimo());
		
		if (devolucaoDao.insert(devolucao) && emprestimoDao.update(devolucao.getEmprestimo())) {
			req.setAttribute("confirmaDao", true);
		}	
		
		
		req.setAttribute("listaDeEmprestimos", emprestimoDao.getList());
		req.setAttribute("listaDeTransporte", devolucaoDao.getList());
		req.setAttribute("listaDeDevolucao", devolucaoDao.getList());
		
		
		return "/WEB-INF/jsps/emprestimo/lista-emprestimo.jsp";
	}

	
	
}
