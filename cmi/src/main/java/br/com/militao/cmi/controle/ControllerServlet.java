package br.com.militao.cmi.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controle")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomeDaClasse = req.getParameter("logica");

		String urlDestino = null;

		try {
			Class<?> classe = Class.forName("br.com.militao.cmi.controle." + nomeDaClasse);

			Logica logica = (Logica) classe.newInstance();

			urlDestino = logica.executa(req, resp);

		} catch (Exception e) {
			throw new ServletException("Encontrou erro " + e);
		}

		String[] param = urlDestino.split(":");

		if (param[0].equals("forward")) {

			RequestDispatcher dispatcher = req.getRequestDispatcher(param[1]);
			dispatcher.forward(req, resp);

		} else {

			resp.sendRedirect(param[1]);

		}
	}
}
