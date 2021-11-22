package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DAOProductImpl dao = new DAOProductImpl();

		Cookie[] cookies = request.getCookies();
		ArrayList<Product> listaCesta = new ArrayList<Product>();

		for (Cookie c : cookies) {

			if (c.getName().equals("cesta")) {
				
				//Product producto = dao.getProducts(c.getValue());
				
				listaCesta.add(dao.getProducts(c.getValue()));
						
			}
		}
		
		request.setAttribute("cesta", listaCesta);

		request.getRequestDispatcher("WEB-INF/view/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String current_passw = request.getParameter("currentPswd");
		String new_passw = request.getParameter("newPswd");
		String confirm_passw = request.getParameter("confirmPswd");

		DAOUsuarioImpl dao = new DAOUsuarioImpl();

		Usuario usuario = dao.getUsuario(user);

		if (new_passw.equals(confirm_passw)) {

			if (PasswordHashGenerator.checkPassword(current_passw, usuario.getPassword())) {

				new_passw = PasswordHashGenerator.hashPassword(new_passw);

				usuario.setPassword(new_passw);

				dao.updateContrasena(usuario);

			}
		} else {

			request.setAttribute("diferentes", "Las contraseñas no son iguales");

			System.out.println("Las contraseñas no son iguales");

		}

		doGet(request, response);

	}

}
