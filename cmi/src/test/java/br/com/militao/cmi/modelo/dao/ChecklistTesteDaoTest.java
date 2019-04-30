package br.com.militao.cmi.modelo.dao;


import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.ChecklistTeste;

class ChecklistTesteDaoTest {

	@Test
	void buscarTestPorId() {
		
		ChecklistTesteDao checklist = new ChecklistTesteDao();		
		
		ChecklistTeste teste = checklist.getByIdManutencao(1);
		
		System.out.println(teste.getDesc_problema());
		
	}

}
