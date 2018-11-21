package br.com.militao.cmi.modelo.dao;

import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.Regional;



class LojaDaoTest {

	@Test
	void test() {
		LojaDao dao = new LojaDao();
		
		for(Object o : dao.getList()) {
		Loja loja = (Loja) o;	
			
			System.out.println(loja.getNome());
			System.out.println(loja.getRegional().getNome_regional());
		}
	}
	
	
	void insereLoja() {
		LojaDao dao = new LojaDao();
		
		Loja loja = new Loja();
		Regional regional = new Regional();
		
		loja.setNumero_loja(1);
		loja.setNome("Matriz ADM");
		loja.setCnpj("123");
		loja.setTelefone("123456");
		loja.setEndereco("rua 9");
		regional.setId_regional(1);
		loja.setRegional(regional);		
		
		dao.insert(loja);
		
		
	}

}
