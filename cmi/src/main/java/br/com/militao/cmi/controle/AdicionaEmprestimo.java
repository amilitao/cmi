package br.com.militao.cmi.controle;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class AdicionaEmprestimo implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) {

		EmprestimoDao dao = new EmprestimoDao();
		Loja loja = new LojaDao().getLojaPorNumero(Integer.parseInt(req.getParameter("numero_loja")));
		Impressora impressora = new ImpressoraDao()
				.getImpressoraPorNumero(Integer.parseInt(req.getParameter("numero_impressora")));
		String situacao = "Inicio de emprestimo";
		String numChamado = req.getParameter("numero_chamado");
		

		Emprestimo emprestimo = new Emprestimo(loja, impressora, LocalDate.now(), situacao, numChamado);

		if (!dao.insert(emprestimo)) {
			req.setAttribute("erro_emprestimo", "Erro ao salvar emprestimo");
		}

	}

}
