package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.ListaDeEspera;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusListaDeEsperaEnum;
import br.com.militao.cmi.modelo.dao.ListaDeEsperaDao;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class SalvarListaDeEspera implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		
		HttpSession session = req.getSession();
		ListaDeEsperaDao dao = new ListaDeEsperaDao();
		ListaDeEspera lista = new ListaDeEspera();
		LojaDao lojaDao = new LojaDao();

		Loja loja = lojaDao.getLojaPorId(Integer.parseInt(req.getParameter("id_loja")));
		
		lista.setLoja(loja);
		lista.setStatus(StatusListaDeEsperaEnum.AGUARDANDO);

		if (dao.insert(lista)) {

			req.setAttribute("confirmaDao", true);
		}

		session.setAttribute("dashboard", null);

		return new ListaDeEsperaPage().executa(req, resp);
	}

}
