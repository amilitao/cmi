package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.StatusImpressora;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;

public class SalvarImpressora implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Impressora impressora = new Impressora();
		
		int numero_impressora = Integer.parseInt(req.getParameter("num_impressora"));
		impressora.setNumero(numero_impressora);
		impressora.setModelo(req.getParameter("modelo"));
		int numero_pip = Integer.parseInt(req.getParameter("pip"));
		impressora.setPip(numero_pip);
		impressora.setNumero_serie(req.getParameter("num_serie"));
		impressora.setEstado(req.getParameter("estado"));
		impressora.setSituacao(StatusImpressora.valueOf(req.getParameter("situacao")));		
		
		ImpressoraDao dao = new ImpressoraDao();	
		
		if(dao.insert(impressora)) {
			req.setAttribute("confirmaDao", true);
		}		
		
		return "/WEB-INF/jsps/cadastro/cad-impressora.jsp";
	}

}
