package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.NotificacaoDao;

public class ListarNotificacoes implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		NotificacaoDao notiDao = new NotificacaoDao();
		
		req.setAttribute("notificacoes", notiDao.getList());
		
		return "forward:notificacoes.jsp";
	}

}
