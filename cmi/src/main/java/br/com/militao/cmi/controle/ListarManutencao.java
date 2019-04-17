package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.StatusImpressoraEnum;
import br.com.militao.cmi.modelo.dao.AssistenciaDao;
import br.com.militao.cmi.modelo.dao.ImpressoraDao;
import br.com.militao.cmi.modelo.dao.ManutencaoDao;


public class ListarManutencao implements Logica{	
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ManutencaoDao manutencaoDao = new ManutencaoDao();	
		ImpressoraDao impressoraDao = new ImpressoraDao();
		AssistenciaDao assistenciaDao = new AssistenciaDao();
		
		
		req.setAttribute("listaDeManutencao", manutencaoDao.getList());	
		req.setAttribute("listaDeImpressoras", impressoraDao.getListPorStatus(StatusImpressoraEnum.COM_DEFEITO));
		req.setAttribute("listaDeAssistencias", assistenciaDao.getList());
		
		
		return  "/WEB-INF/jsps/manutencao/lista-manutencao.jsp";
	
	}			
	
	
	
}
