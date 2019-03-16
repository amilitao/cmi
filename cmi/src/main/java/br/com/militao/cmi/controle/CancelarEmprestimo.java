package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;

public class CancelarEmprestimo implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		EmprestimoDao emprestimoDao = new EmprestimoDao();
		Emprestimo emprestimo = new Emprestimo();
		ImpressoraDao impressoraDao = new ImpressoraDao();
		Impressora impressora = new Impressora();

		emprestimo.setIdEmprestimo(Integer.parseInt(req.getParameter("idEmprestimo")));
		emprestimo.setSituacao(StatusEmprestimoEnum.getByDescricao(req.getParameter("situacao")));

		impressora.setIdImpressora(Integer.parseInt(req.getParameter("idImpressora")));
		impressora.setSituacao(StatusImpressoraEnum.getByDescricao(req.getParameter("statusImpressora")));

		emprestimoDao.update(emprestimo);

		impressoraDao.updateSituacao(impressora);

		req.setAttribute("confirmaDao", true);

		// atualiza dashboard
		HttpSession session = req.getSession();
		session.setAttribute("dashboard", null);

		return new EmprestimoDetalhado().executa(req, resp);
	}

}
