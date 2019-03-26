package br.com.militao.cmi.controle;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.Transporte;
import br.com.militao.cmi.modelo.dao.TransporteDao;

public class SalvarTransporte implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		TransporteDao transporteDao = new TransporteDao();
		Transporte transporte = new Transporte();

		transporte.setEmprestimo(new Emprestimo(Integer.parseInt(req.getParameter("id_emprestimo"))));
		transporte.setNomeTransportadora(req.getParameter("nomeTransportadora"));
		transporte.setNumNfeEnvio(req.getParameter("nfeEnvio"));
		transporte.setDtEnvio(LocalDate.now());

		transporteDao.insert(transporte);

		req.setAttribute("confirmaDao", true);

		// atualiza dashboard
		HttpSession session = req.getSession();
		session.setAttribute("dashboard", null);

		return new EmprestimoDetalhado().executa(req, resp);
	}

}
