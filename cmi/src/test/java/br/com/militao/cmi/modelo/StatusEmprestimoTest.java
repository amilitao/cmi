package br.com.militao.cmi.modelo;



import org.junit.jupiter.api.Test;

class StatusEmprestimoTest {

	@Test
	void statusTest() {
		System.out.println(StatusEmprestimo.NFE.name());
		StatusEmprestimo e = StatusEmprestimo.valueOf("NFE");
		
		
		
		System.out.println(e.porcentagem);
	}
}
