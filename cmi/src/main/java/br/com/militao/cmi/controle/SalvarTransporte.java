package br.com.militao.cmi.controle;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimo;
import br.com.militao.cmi.modelo.Transporte;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.TransporteDao;

public class SalvarTransporte implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		TransporteDao transporteDao = new TransporteDao();
		
		Transporte transporte = new Transporte(
				new Emprestimo(Integer.parseInt(req.getParameter("idEmprestimo")), 
				StatusEmprestimo.ENVIADO), 
				req.getParameter("nomeTransportadora"), req.getParameter("numControle"),
				req.getParameter("nfeEnvio"), LocalDate.now());
		
		if (transporteDao.insert(transporte) && emprestimoDao.update(transporte.getEmprestimo())) {
			req.setAttribute("confirmaDao", true);
		}					
		
		return new ListarEmprestimo().executa(req, resp);
	}
	
	

}
