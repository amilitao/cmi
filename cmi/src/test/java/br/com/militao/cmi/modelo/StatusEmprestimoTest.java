package br.com.militao.cmi.modelo;



import org.junit.jupiter.api.Test;

class StatusEmprestimoTest {

	@Test
	void statusTest() {
		System.out.println(StatusEmprestimo.EMISSAO_NFE.name());
		StatusEmprestimo e = StatusEmprestimo.valueOf("EMISSAO_NFE");
		
		
		
		System.out.println(e.porcentagem);
	}
}
