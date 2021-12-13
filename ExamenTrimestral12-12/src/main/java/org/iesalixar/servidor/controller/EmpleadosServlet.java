package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOEmployeesImpl;
import org.iesalixar.servidor.dao.DAOOfficesImpl;
import org.iesalixar.servidor.model.Employees;

/**
 * Servlet implementation class EmpleadosServlet
 */
@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEmployeesImpl daoImpl = new DAOEmployeesImpl();
		DAOOfficesImpl dao = new DAOOfficesImpl();
		
		request.setAttribute("offices", dao.getAllOficinas());

		ArrayList<Employees> listaEmployees = (ArrayList) daoImpl.getAllEmployees();

		request.setAttribute("employee", listaEmployees);
		
		request.getRequestDispatcher("../WEB-INF/view/admin/mostrarEmpleados.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
