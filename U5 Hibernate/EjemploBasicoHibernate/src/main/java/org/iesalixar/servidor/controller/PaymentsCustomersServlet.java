package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.PaymentsDAO;
import org.iesalixar.servidor.dao.PaymentsDAOImpl;

/**
 * Servlet implementation class PaymentsCustomersServlet
 */
@WebServlet("/PaymentsCustomersServlet")
public class PaymentsCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentsCustomersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PaymentsDAO dao = new PaymentsDAOImpl();

		request.setAttribute("payments", dao.getAllPayments());

		request.getRequestDispatcher("/WEB-INF/view/payments.jsp").forward(request, response);
	}

}
