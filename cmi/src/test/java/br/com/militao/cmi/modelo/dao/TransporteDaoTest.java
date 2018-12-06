package br.com.militao.cmi.modelo.dao;


import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Transporte;

class TransporteDaoTest {


	void listaDeTransporte() {
		TransporteDao lista = new TransporteDao();
		for(Object t : lista.getList()) {
			Transporte ta = (Transporte) t;
			System.out.println(ta.getIdTransporte() +"-"+ ta.getNomeTransportadora()+"-"+ ta.getDtEnvio());
		}
	}
	
	@Test
	void buscaTransporteTest() {
		TransporteDao transDao = new TransporteDao();	
		
		for(Transporte trans : transDao.getTransportePorIdEmprestimo(1)) {
			System.out.println(trans.getIdTransporte());
		}
				
	}

}
