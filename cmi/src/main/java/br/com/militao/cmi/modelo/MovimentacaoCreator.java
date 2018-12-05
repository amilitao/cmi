package br.com.militao.cmi.modelo;

public class MovimentacaoCreator {
	
	public static final int EMPRESTIMO = 0;
	public static final int MANUTENCAO = 1;
	
	public Movimentacao creator(int tipoDeMovimentacao) {
		
		if(tipoDeMovimentacao == MovimentacaoCreator.EMPRESTIMO) {
			return new MovimentacaoEmprestimo();
		}else if(tipoDeMovimentacao == MovimentacaoCreator.MANUTENCAO) {
			return new MovimentacaoManutencao();
		}else {
			throw new IllegalArgumentException("tipo de movimentacao não suportada");
		}
		
	}

}
