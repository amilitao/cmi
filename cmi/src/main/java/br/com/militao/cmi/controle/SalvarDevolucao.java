package br.com.militao.cmi.controle;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.dao.DevolucaoDao;

public class SalvarDevolucao implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		DevolucaoDao devolucaoDao = new DevolucaoDao();
		Devolucao devolucao = new Devolucao();

		devolucao.setEmprestimo(new Emprestimo(Integer.parseInt(req.getParameter("idEmprestimo"))));
		devolucao.setDtDevolucao(LocalDate.now());
		devolucao.setNumNfeDevolucao(req.getParameter("numNfeDevolucao"));
		devolucao.setRecebedor(req.getParameter("recebedor"));

		devolucaoDao.insert(devolucao);

		req.setAttribute("confirmaDao", true);
		
		// atualiza dashboard
		HttpSession session = req.getSession();
		session.setAttribute("dashboard", null);

		return new ListarEmprestimo().executa(req, resp);
	}

}