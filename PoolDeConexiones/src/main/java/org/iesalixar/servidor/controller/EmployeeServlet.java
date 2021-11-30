package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAOEmployeeImpl dao = new DAOEmployeeImpl();
		
		ArrayList<Employee> listaEmpleados = (ArrayList) dao.getAllEmployeesFromOffice(request.getParameter("codigo"));
		
		request.setAttribute("employees", listaEmpleados);
		
	
		request.getRequestDispatcher("WEB-INF/view/employees.jsp").forward(request, response);
		
	}


}
