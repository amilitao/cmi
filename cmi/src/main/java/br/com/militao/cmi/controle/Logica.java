package br.com.militao.cmi.controle;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
