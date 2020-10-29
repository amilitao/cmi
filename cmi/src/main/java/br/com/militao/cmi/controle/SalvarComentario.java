package br.com.militao.cmi.controle;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.com.militao.cmi.modelo.Emprestimo;
import br.com.militao.cmi.modelo.HistoricoEmprestimo;
import br.com.militao.cmi.modelo.Usuario;
import br.com.militao.cmi.modelo.dao.HistoricoEmprestimoDao;

public class SalvarComentario implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		
		int id_emprestimo = Integer.parseInt(req.getParameter("id_emprestimo"));
		
		HistoricoEmprestimoDao histEmpDao = new HistoricoEmprestimoDao();
		HistoricoEmprestimo historico = new HistoricoEmprestimo();
		Usuario user = new Usuario();
		
		historico.setEmprestimo(new Emprestimo(id_emprestimo));  
		historico.setOcorrencia(req.getParameter("comentario"));
		historico.setDt_ocorrencia(LocalDateTime.now());
			

		user = (Usuario)session.getAttribute("usuarioLogado");
	
		historico.setUsuario(user);
		
		histEmpDao.insert(historico);		

		return "redirect:controle?logica=EmprestimoDetalhado&id_emprestimo=" + id_emprestimo;		
	
	}

}
