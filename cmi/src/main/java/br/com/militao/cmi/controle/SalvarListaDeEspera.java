package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.ListaDeEspera;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusListaDeEsperaEnum;
import br.com.militao.cmi.modelo.dao.ListaDeEsperaDao;

public class SalvarListaDeEspera implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		ListaDeEsperaDao listaDao = new ListaDeEsperaDao();
		ListaDeEspera lista = new ListaDeEspera(new Loja(Integer.parseInt(req.getParameter("id_loja"))),
				StatusListaDeEsperaEnum.AGUARDANDO);

		if (listaDao.insert(lista)) {

			req.setAttribute("confirmaDao", true);
		}

		//Atualiza dashboard
		HttpSession session = req.getSession();
		session.setAttribute("dashboard", null);

		return new ListaDeEsperaPage().executa(req, resp);
	}

}
