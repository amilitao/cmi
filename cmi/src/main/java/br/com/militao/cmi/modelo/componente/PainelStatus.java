package br.com.militao.cmi.modelo.componente;

import java.util.List;

import br.com.militao.cmi.modelo.Impressora;
import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;

public class PainelStatus implements Componente{

	private int qtdDisponivel;
	private int qtdEmprestimo;
	private int qtdManutencao;
	private int qtdDefeito;
	private int qtdLocadaRegional;
	private ImpressoraDao dao;
	private List<Impressora> impressoras;

	public PainelStatus() {
		this.qtdDisponivel = 0;
		this.qtdEmprestimo = 0;
		this.qtdManutencao = 0;
		this.qtdDefeito = 0;
		this.qtdLocadaRegional = 0;
		this.dao = new ImpressoraDao();		
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
	
	public int getQtdLocadaRegional() {
		return qtdLocadaRegional;
	}


	@Override
	public Componente criar() {
		
		impressoras = dao.getList();
		
		for (Impressora impressora : impressoras) {			
			
			if(impressora.getSituacao() == StatusImpressoraEnum.DISPONIVEL) {
				qtdDisponivel++;
			}else if(impressora.getSituacao() == StatusImpressoraEnum.EM_EMPRESTIMO) {
				qtdEmprestimo++;
			}else if(impressora.getSituacao() == StatusImpressoraEnum.EM_MANUTENCAO) {
				qtdManutencao++;
			}else if(impressora.getSituacao() == StatusImpressoraEnum.COM_DEFEITO) {
				qtdDefeito++;
			}else if(impressora.getSituacao() == StatusImpressoraEnum.LOCADO_NA_REGIONAL){
				 qtdLocadaRegional++;
			}else {
				throw new IllegalArgumentException("Situacao de impressora incorreta");
			}	
			
		}
		
		return this;
	}

	
	
}
