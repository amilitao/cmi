package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.ListaDeEspera;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.dao.ListaDeEsperaDao;

public class SalvarListaDeEspera implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		ListaDeEsperaDao dao = new ListaDeEsperaDao();
		ListaDeEspera lista = new ListaDeEspera();
		Loja loja = new Loja();

		loja.setIdLoja(Integer.parseInt(req.getParameter("id_loja")));

		lista.setLoja(loja);

		if (dao.insert(lista)) {

			req.setAttribute("confirmaDao", true);
		}

		session.setAttribute("dashboard", null);

		return new ListaDeEsperaPage().executa(req, resp);
	}

}
