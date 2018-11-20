package br.com.militao.cmi.modelo.dao;

import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.ListaDeEspera;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusListaDeEsperaEnum;

class ListaDeEsperaDaoTest {

	@Test
	void test() {
		
		ListaDeEsperaDao dao = new ListaDeEsperaDao();
		
		for(Object o : dao.getList()) {
			ListaDeEspera lista = (ListaDeEspera) o;
			System.out.println("id " + lista.getId_reserva());
			System.out.println("numero " + lista.getLoja().getNumero_loja());
			System.out.println("nome "+  lista.getLoja().getNome());
			System.out.println("descricao " + lista.getStatus().getDescricao());
			
		}
		
		
		
		
	}

}
