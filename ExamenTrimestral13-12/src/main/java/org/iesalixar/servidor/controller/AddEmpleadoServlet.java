package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOEmployees;
import org.iesalixar.servidor.dao.DAOEmployeesImpl;
import org.iesalixar.servidor.dao.DAOOfficesImpl;
import org.iesalixar.servidor.model.Employees;
import org.iesalixar.servidor.model.Offices;

/**
 * Servlet implementation class AddEmpleadoServlet
 */
@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(AddEmpleadoServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOOfficesImpl dao = new DAOOfficesImpl();
		DAOEmployeesImpl daoEm = new DAOEmployeesImpl();
		
		
		request.setAttribute("offices", dao.getAllOficinas());

		request.getRequestDispatcher("../WEB-INF/view/admin/addEmpleado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeNumber = Integer.parseInt(request.getParameter("employeeNumber"));
		String lastName = (String) request.getParameter("lastName");
		String firstName = (String) request.getParameter("firstName");
		String extension = (String) request.getParameter("extension");
		String puesto = (String) request.getParameter("puesto");
		String oficina = (String) request.getParameter("oficina");
		int jefe = Integer.parseInt( request.getParameter("jefe"));
		
		DAOEmployeesImpl dao = new DAOEmployeesImpl();
		DAOOfficesImpl daoOf = new DAOOfficesImpl();
		
		Offices oficinas = new Offices();
		oficinas = daoOf.getOffice(oficina);
		
		Employees empleado = new Employees();
		
		empleado.setEmployeeNumber(employeeNumber);
		empleado.setLastName(lastName);
		empleado.setFirstName(firstName);
		empleado.setExtension(extension);
		empleado.setJobTitle(puesto);
		empleado.setOfficeCode(oficinas.getOfficeCode());
		empleado.setReportsTo(jefe);
		
		
		dao.insertEmployee(empleado);
		

		logger.log(Level.INFO, "Empleado " + empleado.getFirstName() + " añadido");
		
		response.sendRedirect(request.getContextPath() + "/Admin/Empleados");
		
		
	}

}
