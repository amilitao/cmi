package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.AssistenciaDao;

public class AssistenciaPage implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		AssistenciaDao assDao = new AssistenciaDao();

		req.setAttribute("assistencias", assDao.getList());

		return "forward:cadastro/cad-assistencia.jsp";
	}

}
