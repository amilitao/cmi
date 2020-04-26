package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.EstadoImpressoraEnum;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;

public class SalvarImpressora implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){
		
		Impressora impressora = new Impressora();
		ImpressoraDao impDao = new ImpressoraDao();			
		
		impressora.setLoja(new Loja(Integer.parseInt(req.getParameter("id_loja"))));				
		impressora.setNumero(Integer.parseInt(req.getParameter("num_impressora")));
		impressora.setModelo(req.getParameter("modelo"));		
		impressora.setPip(Integer.parseInt(req.getParameter("pip")));
		impressora.setNumero_serie(req.getParameter("num_serie"));
		impressora.setValor(Double.parseDouble(req.getParameter("valor")));
		impressora.setEstado(EstadoImpressoraEnum.valueOf(req.getParameter("estado")));		
		impressora.setSituacao(StatusImpressoraEnum.valueOf(req.getParameter("situacao")));
		
		if (Integer.parseInt(req.getParameter("id_impressora")) != 0) {				
			
			impressora.setId_impressora(Integer.parseInt(req.getParameter("id_impressora")));
			impDao.update(impressora);			
			
		} else {			
			
			impDao.insert(impressora);		
		}
		
		return "redirect:controle?logica=ImpressoraPage";
	}

}