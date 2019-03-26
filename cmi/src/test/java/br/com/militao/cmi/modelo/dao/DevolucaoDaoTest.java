package br.com.militao.cmi.modelo.dao;

import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;

class DevolucaoDaoTest {


	void testeListaDevolucao() {
		DevolucaoDao devDao = new DevolucaoDao();

		for (Object dev : devDao.getList()) {
			Devolucao devolucao = (Devolucao) dev;
			System.out.println(devolucao.getIdDevolucao());
			System.out.println(devolucao.getEmprestimo().getId_emprestimo());
			System.out.println(devolucao.getDtDevolucaoFormatada());
		}
	}

	@Test
	void buscaDevolucaoTest() {
		DevolucaoDao devDao = new DevolucaoDao();	
		
		for(Devolucao dev : devDao.getDevolucaoPorIdEmprestimo(10)) {
			System.out.println(dev.getIdDevolucao());
		}
				
	}

}
