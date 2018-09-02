package br.com.militao.cmi.modelo.componente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Impressora;

public class PainelStatus implements Componente {

	private String nome;
	private int qtdDisponivel;
	private int qtdEmprestimo;
	private int qtdManutencao;
	private int qtdDefeito;

	public PainelStatus() {
		this.nome = "painelStatus";
		this.qtdDisponivel = 0;
		this.qtdEmprestimo = 0;
		this.qtdManutencao = 0;
		this.qtdDefeito = 0;
	}

	public PainelStatus(List<Object> impressoras) {
		
		for (Object imp : impressoras) {

			Impressora impressora = (Impressora) imp;

			switch (impressora.getStatus()) {
			case "disponivel":
				qtdDisponivel++;
				break;
			case "emprestimo":
				qtdEmprestimo++;
				break;
			case "manutencao":
				qtdManutencao++;
				break;
			case "defeito":
				qtdDefeito++;

			}
		}

	}

	public String getNome() {
		return nome;
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

	
}
