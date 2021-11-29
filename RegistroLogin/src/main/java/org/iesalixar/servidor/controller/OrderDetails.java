package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOrdersIMpl;
import org.iesalixar.servidor.model.Orders;

/**
 * Servlet implementation class OrderDetails
 */
@WebServlet("/OrderDetails")
public class OrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderNumber = request.getParameter("orderNumber");
		
		DAOOrdersIMpl dao = new DAOOrdersIMpl();
		
		System.out.println(orderNumber);
		
		if (orderNumber != null) {
			Orders order = dao.getOrder(Integer.parseInt(orderNumber));
			
			System.out.println(Integer.parseInt(orderNumber));
			
			System.out.println(order);
			
			request.setAttribute("detallesPedido", order);
		}
		request.getRequestDispatcher("../WEB-INF/view/admin/details.jsp").forward(request, response);
	}

}
