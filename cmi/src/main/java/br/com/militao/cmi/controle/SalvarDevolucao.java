package br.com.militao.cmi.controle;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimo;
import br.com.militao.cmi.modelo.dao.DevolucaoDao;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.TransporteDao;


public class SalvarDevolucao implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		TransporteDao transporteDao = new TransporteDao();
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		
		Devolucao devolucao = new Devolucao(
				new Emprestimo(Integer.parseInt(req.getParameter("idEmprestimo")),
				StatusEmprestimo.ENCERRADO, LocalDateTime.now()), 
				req.getParameter("numNfeDevolucao"), req.getParameter("recebedor"));				
		
		System.out.println(devolucao.getEmprestimo().getIdEmprestimo());
		
		if (devolucaoDao.insert(devolucao) && emprestimoDao.update(devolucao.getEmprestimo())) {
			req.setAttribute("confirmaDao", true);
		}	
		
		
		req.setAttribute("listaDeEmprestimos", emprestimoDao.getList());
		req.setAttribute("listaDeTransporte", transporteDao.getList());
		req.setAttribute("listaDeDevolucao", devolucaoDao.getList());
		
		
		return "/WEB-INF/jsps/emprestimo/lista-emprestimo.jsp";
	}

	
	
}
