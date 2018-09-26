package br.com.militao.cmi.modelo.dao;


import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Transporte;

class TransporteDaoTest {

	@Test
	void listaDeTransporte() {
		TransporteDao lista = new TransporteDao();
		for(Object t : lista.getList()) {
			Transporte ta = (Transporte) t;
			System.out.println(ta.getIdTransporte() +"-"+ ta.getNomeTransportadora()+"-"+ ta.getDtEnvio());
		}
	}

}
