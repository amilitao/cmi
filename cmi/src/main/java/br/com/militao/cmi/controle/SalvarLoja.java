package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.Regional;
import br.com.militao.cmi.modelo.dao.LojaDao;
import br.com.militao.cmi.modelo.dao.RegionalDao;

public class SalvarLoja implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		LojaDao dao = new LojaDao();
		RegionalDao regDao = new RegionalDao();
		Loja loja = new Loja();
		Regional regional = new Regional();
		
		regional.setId_regional(Integer.parseInt(req.getParameter("id_regional")));
		loja.setRegional(regional);
		loja.setNumero_loja(Integer.parseInt(req.getParameter("num_loja")));
		loja.setNome(req.getParameter("nome"));
		loja.setCnpj(req.getParameter("cnpj"));
		loja.setTelefone(req.getParameter("telefone"));
		loja.setEndereco(req.getParameter("endereco"));		

		if (req.getParameter("id_loja") != "") {

			loja.setIdLoja(Integer.parseInt(req.getParameter("id_loja")));

			if (dao.update(loja)) {

				HttpSession session = req.getSession();

				req.setAttribute("confirmaDao", true);
				session.setAttribute("dashboard", null);
			}

		} else {

			if (dao.insert(loja)) {
				HttpSession session = req.getSession();

				req.setAttribute("confirmaDao", true);
				session.setAttribute("dashboard", null);
			}
		}		

		return new LojaPage().executa(req, resp);
	}

}
