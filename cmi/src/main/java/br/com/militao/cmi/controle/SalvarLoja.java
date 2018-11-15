package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.dao.LojaDao;

public class SalvarLoja implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Loja loja = new Loja();
		System.out.println(req.getParameter("id_loja"));
		loja.setNumero_loja(Integer.parseInt(req.getParameter("num_loja")));
		loja.setNome(req.getParameter("nome"));
		loja.setCnpj(req.getParameter("cnpj"));
		loja.setTelefone(req.getParameter("telefone"));
		loja.setEndereco(req.getParameter("endereco"));

		LojaDao dao = new LojaDao();

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

		req.setAttribute("lojas", dao.getList());

		return "/WEB-INF/jsps/cadastro/cad-loja.jsp";
	}

}
