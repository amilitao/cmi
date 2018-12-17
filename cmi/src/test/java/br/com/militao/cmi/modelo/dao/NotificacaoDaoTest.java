package br.com.militao.cmi.modelo.dao;


import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Notificacao;

class NotificacaoDaoTest {

	@Test
	public void listaNotificacao() {
		NotificacaoDao dao = new NotificacaoDao();
		for(Notificacao n : dao.getList()) {
			System.out.println(n.getDescricao());
		}
	}

}
