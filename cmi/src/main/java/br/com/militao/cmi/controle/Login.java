package br.com.militao.cmi.controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.ControleDeAcesso;
import br.com.militao.cmi.modelo.Usuario;

public class Login implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		Usuario user = new Usuario();
		user.setLogin(req.getParameter("login"));
		user.setSenha(req.getParameter("senha"));

		if (ControleDeAcesso.autentica(user)) {

			session.setAttribute("usuarioLogado", user);

			return "forward:/controle?logica=LoadDashboard";

		}

		session.setAttribute("erroLogin", true);
		return "redirect:index.jsp";

	}

}
