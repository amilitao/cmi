package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Assistencia;
import br.com.militao.cmi.modelo.dao.AssistenciaDao;

public class SalvarAssistencia implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		Assistencia assistencia = new Assistencia();
		AssistenciaDao assisDao = new AssistenciaDao();

		assistencia.setRazao_social(req.getParameter("razao_social"));
		assistencia.setCnpj(req.getParameter("cnpj"));
		assistencia.setEmail(req.getParameter("email"));
		assistencia.setTelefone_assistencia(req.getParameter("telefone_assistencia"));
		assistencia.setEndereco(req.getParameter("endereco"));		
		

		if (req.getParameter("id_assistencia") != "") {

			assistencia.setId_assistencia(Integer.parseInt(req.getParameter("id_assistencia")));
			assisDao.update(assistencia);			

		} else {

			assisDao.insert(assistencia);		
		}
		return "redirect:controle?logica=AssistenciaPage"; 

	}

}
