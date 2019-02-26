package br.com.militao.cmi.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.militao.cmi.modelo.ControleDeAcesso;
import br.com.militao.cmi.modelo.Usuario;



public class AutenticarUsuario implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Usuario user = new Usuario();
		user.setLogin(req.getParameter("login"));
		user.setSenha(req.getParameter("senha"));
	
		
		if(ControleDeAcesso.autentica(user)) {	
			req.setAttribute("usuarioLogado", user);
			return new LoadDashboard().executa(req, resp);
		}else {		
			return "index.jsp";
		}
	}

}
