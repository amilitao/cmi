package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;

public class AtualizarEmprestimo implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		EmprestimoDao emprestimoDao = new EmprestimoDao();
		Emprestimo emprestimo = new Emprestimo();
		Impressora impressora = new Impressora();

		emprestimo.setId_emprestimo(Integer.parseInt(req.getParameter("id_emprestimo")));
		emprestimo.setSituacao(StatusEmprestimoEnum.getByDescricao(req.getParameter("situacao")));
		impressora.setId_impressora(Integer.parseInt(req.getParameter("id_impressora")));
		emprestimo.setImpressora(impressora);		
		
		
		emprestimoDao.update(emprestimo);
		
		req.setAttribute("confirmaDao", true);

		// atualiza dashboard
		HttpSession session = req.getSession();
		session.setAttribute("dashboard", null);

		return new EmprestimoDetalhado().executa(req, resp);
	}

}
