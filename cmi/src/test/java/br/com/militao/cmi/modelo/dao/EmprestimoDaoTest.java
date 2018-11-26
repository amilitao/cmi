package br.com.militao.cmi.modelo.dao;



import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;

class EmprestimoDaoTest {

	@Test
	void emprestimoDaoTest() {
		EmprestimoDao dao = new EmprestimoDao();
		
		for(Object o : dao.getList()) {
			Emprestimo e = (Emprestimo) o;
			System.out.println("emprestimo: "+e.getIdEmprestimo());
			System.out.println(e.getDtInicioFormatada());
			System.out.println(e.getDtFimFormatada());
			System.out.println(e.getLoja());
			System.out.println(e.getLoja().getCnpj());
			System.out.println(e.getImpressora());
			System.out.println(e.getNum_chamado());
			System.out.println(e.getSituacao());	
			System.out.println(e.getPrazoDevolucaoFormatada());
		}
		
		
		
	}
	
	void criarEmprestimo() {
		
/**
		EmprestimoDao dao = new EmprestimoDao();	
		ImpressoraDao impDao = new ImpressoraDao();		
		LojaDao lojaDao = new LojaDao();
		
		
		Loja loja = lojaDao
				.getLojaPorId(1);		
		Impressora impressora = impDao
				.getImpressoraPorId(1);
		impressora.setSituacao(StatusImpressoraEnum.EM_EMPRESTIMO);
		
		dao.insert(new Emprestimo(loja, impressora, "123"));
		**/
	}

}
