package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.LojaDao;
import br.com.militao.cmi.modelo.dao.RegionalDao;

public class LojaPage implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){
		
		LojaDao lojaDao = new LojaDao();
		RegionalDao regDao = new RegionalDao();
		
		req.setAttribute("lojas", lojaDao.getList());
		req.setAttribute("regionais", regDao.getList());
		
		
		return "forward:cadastro/cad-loja.jsp";
	}
	
	

}
