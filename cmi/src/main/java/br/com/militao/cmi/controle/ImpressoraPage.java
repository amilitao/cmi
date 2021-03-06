package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.EstadoImpressoraEnum;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;
import br.com.militao.cmi.modelo.dao.LojaDao;


public class ImpressoraPage implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){
		
				
		ImpressoraDao impDao = new ImpressoraDao();
		LojaDao lojaDao = new LojaDao();
		
		/*req.setAttribute("lista_situacao", StatusImpressoraEnum.values());
		req.setAttribute("lista_estado", EstadoImpressoraEnum.values());*/
		
		req.setAttribute("status_impressora", StatusImpressoraEnum.values());
		req.setAttribute("estado_impressora", EstadoImpressoraEnum.values());
		req.setAttribute("impressoras", impDao.getList());
		req.setAttribute("lojas", lojaDao.getList());
		
		return "forward:cadastro/cad-impressora.jsp";

	}
}
