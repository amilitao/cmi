package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.Regional;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class SalvarLoja implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		LojaDao dao = new LojaDao();
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

			loja.setId_loja(Integer.parseInt(req.getParameter("id_loja")));
			dao.update(loja);			

		} else {

			dao.insert(loja);		
		}

		return "redirect:controle?logica=LojaPage";
	}

}
