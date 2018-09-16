package br.com.militao.cmi.modelo.dao;



import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Emprestimo;

class EmprestimoDaoTest {

	@Test
	void emprestimoDaoTest() {
		EmprestimoDao dao = new EmprestimoDao();
		
		for(Object o : dao.getList()) {
			Emprestimo e = (Emprestimo) o;
			System.out.println(e.getIdEmprestimo());
			System.out.println(e.getDataInicioFormatada());
			System.out.println(e.getDataFimFormatada());
			System.out.println(e.getLoja());
			System.out.println(e.getImpressora());
			System.out.println(e.getNum_chamado());
			System.out.println(e.getSituacao());
			System.out.println(e.getPrazoDevolucaoFormatada());
		}
		
		
		
	}

}
