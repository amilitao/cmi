package br.com.militao.cmi.controle;


import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.Loja;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;

class AdicionaEmprestimoTest {
	
	
	@Test
	void testeAdicionaEmprestimo() {
		EmprestimoDao dao = new EmprestimoDao();
		Loja loja = new Loja();
		Impressora imp = new Impressora();
		
		loja.setIdLoja(1);
		imp.setId_impressora(1);		
		
		Emprestimo emp = new Emprestimo(loja, imp, LocalDate.now(), "inicio de processo", "123456");
		
		if (!dao.insert(emp)) {
			System.out.println("Erro ao salvar emprestimo");
		}
		
	}

}
