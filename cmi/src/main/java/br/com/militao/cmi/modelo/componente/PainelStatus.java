package br.com.militao.cmi.modelo.componente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Impressora;

public class PainelStatus {	
	
	private  int qtdDisponivel;
	private  int qtdEmprestimo;
	private  int qtdManutencao;
	private  int qtdDefeito;	
	
	public PainelStatus() {
		this.qtdDisponivel = 0;
		this.qtdEmprestimo = 0;
		this.qtdManutencao = 0;
		this.qtdDefeito = 0;
	}	
	
	
	
	public int getQtdDisponivel() {
		return qtdDisponivel;
	}

	
	public int getQtdEmprestimo() {
		return qtdEmprestimo;
	}

	

	public int getQtdManutencao() {
		return qtdManutencao;
	}

	

	public int getQtdDefeito() {
		return qtdDefeito;
	}

	

	public void atualiza(List<Object> impressoras, HttpServletRequest req, HttpServletResponse resp) {		
		
		for(Object imp : impressoras) {
			
			Impressora impressora = (Impressora) imp;			
			
			switch(impressora.getStatus()) {
			case "disponivel": qtdDisponivel++;break;
			case "emprestimo": qtdEmprestimo++;break;
			case "manutencao": qtdManutencao++;break;
			case "defeito": qtdDefeito++;		
			
			}
		}		
		
		
	}
	
	

}
