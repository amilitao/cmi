package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.RegionalDao;

public class RegionalPage implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
				
		RegionalDao regDao = new RegionalDao();
		
		req.setAttribute("regionais", regDao.getList());
		
		return "forward:cadastro/cad-regional.jsp";
	}

}
