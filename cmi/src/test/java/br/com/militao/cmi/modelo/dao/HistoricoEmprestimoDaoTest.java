package br.com.militao.cmi.modelo.dao;


import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.HistoricoEmprestimo;

class HistoricoEmprestimoDaoTest {

	
	
	@Test
	void listaHistoricoPorIdEmprestimotest() {
		
		HistoricoEmprestimoDao hdao = new HistoricoEmprestimoDao();
		
		for(HistoricoEmprestimo ocorrencia : hdao.getHistoricoPorIdEmprestimo(2)) {
			System.out.println(ocorrencia.getEmprestimo().getIdEmprestimo());
		}
		
		
	}

}
