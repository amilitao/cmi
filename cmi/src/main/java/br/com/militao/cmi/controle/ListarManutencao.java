package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.dao.ManutencaoDao;


public class ListarManutencao implements Logica{	
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ManutencaoDao manutencaoDao = new ManutencaoDao();	
		
		
		req.setAttribute("listaDeManutencao", manutencaoDao.getList());		
		
		
		return  "/WEB-INF/jsps/manutencao/lista-manutencao.jsp";
	
	}			
	
	
	
}
