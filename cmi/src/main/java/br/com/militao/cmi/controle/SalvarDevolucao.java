package br.com.militao.cmi.controle;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.dao.DevolucaoDao;

public class SalvarDevolucao implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		int id_emprestimo = Integer.parseInt(req.getParameter("id_emprestimo"));
		
		DevolucaoDao devolucaoDao = new DevolucaoDao();
		Devolucao devolucao = new Devolucao();

		devolucao.setEmprestimo(new Emprestimo(id_emprestimo));
		devolucao.setDtDevolucao(LocalDate.now());
		devolucao.setNumNfeDevolucao(req.getParameter("numNfeDevolucao"));
		devolucao.setRecebedor(req.getParameter("recebedor"));

		devolucaoDao.insert(devolucao);		
		

		return "redirect:controle?logica=EmprestimoDetalhado&id_emprestimo=" + id_emprestimo;
	}

}