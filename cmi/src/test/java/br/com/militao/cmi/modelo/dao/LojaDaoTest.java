package br.com.militao.cmi.modelo.dao;

import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Loja;



class LojaDaoTest {

	@Test
	void test() {
		LojaDao dao = new LojaDao();
		
		for(Object o : dao.getList()) {
		Loja loja = (Loja) o;	
			
			System.out.println(loja.getNome());
		}
	}

}
