package org.iesalixar.servidor.bd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.CustomersDAO;
import org.iesalixar.servidor.dao.CustomersDAOImpl;

/**
 * Servlet implementation class CustomersServlet
 */
@WebServlet("/CustomersServlet")
public class CustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomersDAO dao = new CustomersDAOImpl();

		request.setAttribute("customers", dao.getAllCustomers());

		request.getRequestDispatcher("/WEB-INF/view/customers.jsp").forward(request, response);

	}

}
