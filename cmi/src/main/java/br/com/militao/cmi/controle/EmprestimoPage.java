package br.com.militao.cmi.controle;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmprestimoPage implements Logica{
	
	

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		PrintWriter out = resp.getWriter();
		
		out.print("document.getElementById('emprestimo').style.display='block'");
		
		
	}
	
	

}
