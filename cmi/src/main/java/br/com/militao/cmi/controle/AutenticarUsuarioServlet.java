package br.com.militao.cmi.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.militao.cmi.modelo.ControleDeAcesso;
import br.com.militao.cmi.modelo.Usuario;

@WebServlet(urlPatterns = "/acesso")
public class AutenticarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher;
		HttpSession session = req.getSession();

		Usuario user = new Usuario();
		user.setLogin(req.getParameter("login"));
		user.setSenha(req.getParameter("senha"));

		if (ControleDeAcesso.autentica(user)) {

			session.setAttribute("usuarioLogado", user);

			dispatcher = req.getRequestDispatcher("/controle?logica=LoadDashboard");
			dispatcher.forward(req, resp);

		} else {
			System.out.println("erro ao logar");
			session.setAttribute("erroLogin", true); 
			resp.sendRedirect("index.jsp");
		}
	}

}
