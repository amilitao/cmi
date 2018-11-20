package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.EstadoImpressoraEnum;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;

public class SalvarImpressora implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Impressora impressora = new Impressora();
		ImpressoraDao dao = new ImpressoraDao();

		int numero_impressora = Integer.parseInt(req.getParameter("num_impressora"));
		impressora.setNumero(numero_impressora);
		impressora.setModelo(req.getParameter("modelo"));
		int numero_pip = Integer.parseInt(req.getParameter("pip"));
		impressora.setPip(numero_pip);
		impressora.setNumero_serie(req.getParameter("num_serie"));
		impressora.setEstado(EstadoImpressoraEnum.valueOf(req.getParameter("estado")));
		impressora.setSituacao(StatusImpressoraEnum.valueOf(req.getParameter("situacao")));

		System.out.println(req.getParameter("id_impressora"));
		if (req.getParameter("id_impressora") != null || req.getParameter("id_impressora") != "") {
			impressora.setIdImpressora(Integer.parseInt(req.getParameter("id_impressora")));
			dao.update(impressora);
		} else {

			dao.insert(impressora);
			HttpSession session = req.getSession();

			req.setAttribute("confirmaDao", true);
			// atualiza dashboard
			session.setAttribute("dashboard", null);

		}

		req.setAttribute("lista_situacao", StatusImpressoraEnum.values());
		req.setAttribute("lista_estado", EstadoImpressoraEnum.values());
		req.setAttribute("impressoras", dao.getList());

		return "/WEB-INF/jsps/cadastro/cad-impressora.jsp";
	}

}
