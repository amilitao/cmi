package br.com.militao.cmi.controle;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Transporte;
import br.com.militao.cmi.modelo.dao.TransporteDao;

public class SalvarTransporte implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_emprestimo = Integer.parseInt(req.getParameter("id_emprestimo"));

		TransporteDao transporteDao = new TransporteDao();
		Transporte transporte = new Transporte();

		transporte.setEmprestimo(new Emprestimo(id_emprestimo));
		transporte.setNomeTransportadora(req.getParameter("nomeTransportadora"));
		transporte.setNumNfeEnvio(req.getParameter("nfeEnvio"));
		transporte.setDtEnvio(LocalDate.now());

		transporteDao.insert(transporte);		

		return "redirect:controle?logica=EmprestimoDetalhado&id_emprestimo=" + id_emprestimo ;
	}

}
