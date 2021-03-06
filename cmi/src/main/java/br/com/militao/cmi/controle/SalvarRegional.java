package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Regional;
import br.com.militao.cmi.modelo.dao.RegionalDao;

public class SalvarRegional implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		RegionalDao regDao = new RegionalDao();
		Regional regional = new Regional();

		regional.setNome_regional(req.getParameter("nome_regional"));
		regional.setNum_filial_base(Integer.parseInt(req.getParameter("num_filial_base")));
		regional.setQtd_impressora(Integer.parseInt(req.getParameter("qtd_impressora")));
		
		if (req.getParameter("id_regional") != "") {

			regional.setId_regional(Integer.parseInt(req.getParameter("id_regional")));

			regDao.update(regional);		

		} else {

			regDao.insert(regional);

		}


		return "redirect:controle?logica=RegionalPage";

	}

}
