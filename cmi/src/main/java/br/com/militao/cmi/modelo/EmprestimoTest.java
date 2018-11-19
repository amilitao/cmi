package br.com.militao.cmi.modelo;


import org.junit.jupiter.api.Test;

class EmprestimoTest {

	@Test
	void criaEmprestimo() {
		Emprestimo e = new Emprestimo(1, StatusEmprestimoEnum.ENCERRADO);
		
		System.out.println(e.getDtFim());
	}
	

}
