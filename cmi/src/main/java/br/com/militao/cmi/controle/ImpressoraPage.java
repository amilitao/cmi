package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.EstadoImpressoraEnum;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;


public class ImpressoraPage implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ImpressoraDao dao = new ImpressoraDao();
		
		req.setAttribute("lista_situacao", StatusImpressoraEnum.values());
		req.setAttribute("lista_estado", EstadoImpressoraEnum.values());
		req.setAttribute("impressoras", dao.getList());
		
		return "/WEB-INF/jsps/cadastro/cad-impressora.jsp";

	}
}
