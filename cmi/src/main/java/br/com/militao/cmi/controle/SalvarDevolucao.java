package br.com.militao.cmi.controle;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.DevolucaoDao;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;


public class SalvarDevolucao implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {		
		
		HttpSession session = req.getSession();
		EmprestimoDao emprestimoDao = new EmprestimoDao();		
		DevolucaoDao devolucaoDao = new DevolucaoDao();	
		ImpressoraDao impressoraDao = new ImpressoraDao();
		
		Devolucao devolucao = new Devolucao();
		Emprestimo emprestimo = new Emprestimo();
				
		emprestimo.setIdEmprestimo(Integer.parseInt(req.getParameter("idEmprestimo")));	
		
		devolucao.setEmprestimo(emprestimo);
		devolucao.setDtDevolucao(LocalDate.now());		
		devolucao.setNumNfeDevolucao(req.getParameter("numNfeDevolucao"));		 
		devolucao.setRecebedor( req.getParameter("recebedor"));
		
		Impressora impressora = impressoraDao.getImpressoraPorId(emprestimo.getImpressora().getIdImpressora());
		impressora.setSituacao(StatusImpressoraEnum.DISPONIVEL);
				
		if (devolucaoDao.insert(devolucao) && impressoraDao.update(impressora)) {
			req.setAttribute("confirmaDao", true);
		}	
		
		// atualiza dashboard
		session.setAttribute("dashboard", null);
	
		return new ListarEmprestimo().executa(req, resp);
	}

	
	
}
