package br.com.militao.cmi.controle;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.StatusEmprestimoEnum;
import br.com.militao.cmi.modelo.Transporte;
import br.com.militao.cmi.modelo.dao.EmprestimoDao;
import br.com.militao.cmi.modelo.dao.TransporteDao;

public class SalvarTransporte implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		Transporte transporte = new Transporte();
		Emprestimo emprestimo = new Emprestimo();
		
		emprestimo.setIdEmprestimo(Integer.parseInt(req.getParameter("idEmprestimo")));
		emprestimo.setSituacao(StatusEmprestimoEnum.ENVIADO);
				
		transporte.setEmprestimo(emprestimo);
		transporte.setNomeTransportadora(req.getParameter("nomeTransportadora"));		 
		transporte.setNumControle(req.getParameter("numControle"));		
		transporte.setNumNfeEnvio(req.getParameter("nfeEnvio"));		
		transporte.setDtEnvio(LocalDate.now());		
		
		
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		TransporteDao transporteDao = new TransporteDao();
		
		if (transporteDao.insert(transporte) && emprestimoDao.update(transporte.getEmprestimo())) {
			
			req.setAttribute("confirmaDao", true);		
		}	
		
		// atualiza dashboard
		session.setAttribute("dashboard", null);
		
		return new ListarEmprestimo().executa(req, resp);
	}
	
	

}
