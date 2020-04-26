package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.militao.cmi.modelo.ListaDeEspera;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusListaDeEsperaEnum;
import br.com.militao.cmi.modelo.dao.ListaDeEsperaDao;

public class SalvarListaDeEspera implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		ListaDeEsperaDao listaDao = new ListaDeEsperaDao();
		Loja loja = new Loja(Integer.parseInt(req.getParameter("id_loja")));
		ListaDeEspera lista = new ListaDeEspera(loja, StatusListaDeEsperaEnum.AGUARDANDO);

		listaDao.insert(lista);

		return "redirect:controle?logica=ListaDeEsperaPage";
	
	}

}
