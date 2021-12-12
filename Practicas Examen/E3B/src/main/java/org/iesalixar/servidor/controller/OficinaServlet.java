package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOOficinaImpl;

/**
 * Servlet implementation class OficinaServlet
 */
@WebServlet("/OficinaServlet")
public class OficinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OficinaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession();

		if (!sesion.isNew()) {
			request.getRequestDispatcher("WEB-INF/view/oficinas.jsp").forward(request, response);

			return;
		}

		sesion.invalidate();

		response.sendRedirect(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession sesion = request.getSession();

		String oficinas = request.getParameter("oficinas");
		
		if (oficinas != null) {
			
			DAOOficinaImpl dao = new DAOOficinaImpl();
			
			sesion.setAttribute("oficinas", dao.getOficina(oficinas));
			
			doGet(request, response);
			
			return;
		}
		
		doGet(request, response);
		
		
	}

}
