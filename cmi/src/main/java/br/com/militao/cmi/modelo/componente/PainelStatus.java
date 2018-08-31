package br.com.militao.cmi.modelo.componente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.militao.cmi.modelo.Impressora;

public class PainelStatus {	
	
	private static int qtdDisponivel;
	private static int qtdEmprestimo;
	private static int qtdManuntencao;
	private static int qtdDefeito;		

	public static void atualiza(List<Object> impressoras, HttpServletRequest req) {		
		
		for(Object imp : impressoras) {
			
			Impressora impressora = (Impressora) imp;
			
			switch(impressora.getStatus()) {
			case "disponivel": qtdDisponivel++;break;
			case "emprestimo": qtdEmprestimo++;break;
			case "manutencao": qtdManuntencao++;break;
			case "defeito": qtdDefeito++;		
			
			}
		}
		
		req.setAttribute("qtdDisponivel", qtdDisponivel);
		req.setAttribute("qtdEmprestimo", qtdEmprestimo);
		req.setAttribute("qtdManutencao", qtdManuntencao);
		req.setAttribute("qtdDefeito", qtdDefeito);
		
	}
	
	

}
