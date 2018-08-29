package br.com.militao.cmi.modelo.dao;


import org.junit.jupiter.api.Test;

class LojaDaoTest {

	@Test
	void testeBuscarLoja() {
	
		LojaDao dao = new LojaDao();		
		
		System.out.println(dao.getLojaPorNumero(1).getNome());
		
	}

}
