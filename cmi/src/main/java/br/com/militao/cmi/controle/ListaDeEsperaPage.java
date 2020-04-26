package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;
import br.com.militao.cmi.modelo.dao.ListaDeEsperaDao;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class ListaDeEsperaPage implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){
	
		LojaDao lojaDao = new LojaDao();
		ImpressoraDao impDao = new ImpressoraDao();
		ListaDeEsperaDao listaDeEsperaDao = new ListaDeEsperaDao();

		
		req.setAttribute("lojas", lojaDao.getList());	
		req.setAttribute("impressoras", impDao.getListPorStatus(StatusImpressoraEnum.DISPONIVEL));	
		req.setAttribute("listaDeEspera", listaDeEsperaDao.getList());


		return "forward:lista-de-espera.jsp";

	}

}
