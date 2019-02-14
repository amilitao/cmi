package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.Regional;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class SalvarLoja implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		LojaDao dao = new LojaDao();
		Loja loja = new Loja();
		Regional regional = new Regional();

		regional.setId_regional(Integer.parseInt(req.getParameter("id_regional")));
		loja.setRegional(regional);
		loja.setNumero_loja(Integer.parseInt(req.getParameter("num_loja")));
		loja.setNome(req.getParameter("nome"));
		loja.setCnpj(req.getParameter("cnpj"));
		loja.setTelefone(req.getParameter("telefone"));
		loja.setEndereco(req.getParameter("endereco"));

		if (Integer.parseInt(req.getParameter("id_loja")) != 0) {

			loja.setIdLoja(Integer.parseInt(req.getParameter("id_loja")));
			dao.update(loja);
			
			req.setAttribute("confirmaDao", true);

		} else {

			dao.insert(loja);
			req.setAttribute("confirmaDao", true);
		}

		HttpSession session = req.getSession();

		req.setAttribute("confirmaDao", true);
		session.setAttribute("dashboard", null);

		return new LojaPage().executa(req, resp);
	}

}
