package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.CustomersDAO;
import org.iesalixar.servidor.dao.CustomersDAOImpl;

/**
 * Servlet implementation class OrdersCustomersServlet
 */
@WebServlet("/OrdersCustomersServlet")
public class OrdersCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdersCustomersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));

		CustomersDAO dao = new CustomersDAOImpl();

		request.setAttribute("orders", dao.getOrders(customerNumber));

		request.getRequestDispatcher("/WEB-INF/view/orders.jsp").forward(request, response);
	}


}
