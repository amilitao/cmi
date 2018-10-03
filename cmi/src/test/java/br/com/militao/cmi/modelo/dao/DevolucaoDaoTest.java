package br.com.militao.cmi.modelo.dao;

import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Devolucao;
import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimo;

class DevolucaoDaoTest {

	@Test
	void testeListaDevolucao() {
		DevolucaoDao devDao = new DevolucaoDao();

		for (Object dev : devDao.getList()) {
			Devolucao devolucao = (Devolucao) dev;
			System.out.println(devolucao.getIdDevolucao());
			System.out.println(devolucao.getEmprestimo().getIdEmprestimo());
		}
	}

	@Test
	void insereDevolucaoTest() {
		DevolucaoDao devDao = new DevolucaoDao();
		Devolucao dev = new Devolucao(new Emprestimo(3, StatusEmprestimo.ENCERRADO),
				"123", "adriano");		
		
		devDao.insert(dev);
				
	}

}
