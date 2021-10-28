package org.iesalixar.servidor.cpp.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reservar
 */
@WebServlet("/Reservar")
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew() && sesion.getAttribute("LOGEADO")!= null && ((boolean) sesion.getAttribute("LOGEADO"))) {
			request.getRequestDispatcher("reservar.jsp").forward(request, response);
			
			return;
		}
		
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		  HttpSession sesion = request.getSession();

	        if (!sesion.isNew() && sesion.getAttribute("LOGEADO")!=null && ((boolean)sesion.getAttribute("LOGEADO"))) {

	            if ( request.getParameter("reservar")!=null && request.getParameter("reservar").equals("RESERVAR")) {

	                if (request.getParameter("fInicio")!=null && request.getParameter("fFin")!=null
	                        && request.getParameter("numPer")!=null) {

	                    sesion.setAttribute("fInicio", (request.getParameter("fInicio")));
	                    sesion.setAttribute("fFin", (request.getParameter("fFin")));
	                    sesion.setAttribute("numPer", (request.getParameter("numPer")));
	                    sesion.setAttribute("checkbox", request.getParameterValues("checkbox"));

	                }

	                response.sendRedirect(request.getContextPath()+"/Confirmar");
	                return;

	            } else {

	                response.sendRedirect(request.getContextPath()+"/Reservar");
	                return;

	            }

	        }


}
	
}
