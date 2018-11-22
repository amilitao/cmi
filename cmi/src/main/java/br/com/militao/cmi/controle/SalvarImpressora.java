package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.EstadoImpressoraEnum;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class SalvarImpressora implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Impressora impressora = new Impressora();
		Loja loja = new Loja();
		ImpressoraDao impDao = new ImpressoraDao();
		LojaDao lojaDao = new LojaDao();
		
		loja.setIdLoja(Integer.parseInt(req.getParameter("id_loja")));
		impressora.setLoja(loja);
		int numero_impressora = Integer.parseInt(req.getParameter("num_impressora"));		
		impressora.setNumero(numero_impressora);
		impressora.setModelo(req.getParameter("modelo"));
		int numero_pip = Integer.parseInt(req.getParameter("pip"));
		impressora.setPip(numero_pip);
		impressora.setNumero_serie(req.getParameter("num_serie"));
		impressora.setEstado(EstadoImpressoraEnum.valueOf(req.getParameter("estado")));		
		impressora.setSituacao(StatusImpressoraEnum.valueOf(req.getParameter("situacao")));
		
		if (Integer.parseInt(req.getParameter("id_impressora")) != 0) {					
			
			impressora.setIdImpressora(Integer.parseInt(req.getParameter("id_impressora")));
			impDao.update(impressora);
			req.setAttribute("confirmaDao", true);
			
		} else {				
			
			impDao.insert(impressora);
			req.setAttribute("confirmaDao", true);
		}
		
		// atualiza dashboard
		session.setAttribute("dashboard", null);
		

		return new ImpressoraPage().executa(req, resp);
	}

}
