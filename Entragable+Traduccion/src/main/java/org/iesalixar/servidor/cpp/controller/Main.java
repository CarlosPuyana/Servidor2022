package org.iesalixar.servidor.cpp.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getParameter("registrar") != null && request.getParameter("registrar").equals("REGISTRARSE")) {
			
			String pass = request.getParameter("pass");
			String passCon = request.getParameter("pass2");
			String nombre = request.getParameter("nombre");
			
			
			if (pass.equals(passCon)) {
				HttpSession sesion = request.getSession();
				
				sesion.setAttribute("LOGEADO", true);
				sesion.setAttribute("nombre", nombre);
				
				response.sendRedirect(request.getContextPath() + "/Reservar");
				
				return;
			} 
			
			
			
		}
		
		response.sendRedirect(request.getContextPath());
		
		
		
		
	}

}
