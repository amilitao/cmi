package br.com.militao.cmi.modelo;



import org.junit.jupiter.api.Test;

class StatusEmprestimoEnumTest {

	@Test
	void statusTest() {
		System.out.println(StatusEmprestimoEnum.EMISSAO_NFE.name());
		StatusEmprestimoEnum e = StatusEmprestimoEnum.valueOf("EMISSAO_NFE");
		
		
		
		System.out.println(e.porcentagem);
	}
}
