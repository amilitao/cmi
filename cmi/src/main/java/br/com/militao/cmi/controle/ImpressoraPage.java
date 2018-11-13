package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.StatusImpressoraEnum;


public class ImpressoraPage implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setAttribute("lista_situacao", StatusImpressoraEnum.values());
		
		return "/WEB-INF/jsps/cadastro/cad-impressora.jsp";

	}
}
