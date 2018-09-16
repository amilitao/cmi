package br.com.militao.cmi.controle;



import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;

class ListarEmprestimoTest {

	
	
	@Test
	void listaEmprestimo() {
		EmprestimoDao dao = new EmprestimoDao();
		for(Object o : dao.getList()) {
			Emprestimo e = (Emprestimo) o;
			System.out.println(e.getIdEmprestimo());
		}
	}

}
