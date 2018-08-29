package br.com.militao.cmi.exception;


public class InsereDadosNoBancoException extends Exception {
	
	public InsereDadosNoBancoException(String msg){
		super("Erro ao inserir dados no banco de dados " + msg);
	}

}
