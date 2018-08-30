package br.com.militao.cmi.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomeDaClasse = req.getParameter("logica");

		try {
			Class<?> classe = Class.forName("br.com.militao.cmi.controle." + nomeDaClasse);

			Logica logica = (Logica) classe.newInstance();

			String urldestino = logica.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(urldestino);

			dispatcher.forward(req, resp);

		} catch (Exception e) {
			throw new ServletException("Encontrou erro " + e);
		}
	}

}
