package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOPaymentImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Payment;

/**
 * Servlet implementation class AddPaymentServlet
 */
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtengo los datos de todos los clientes para pasarlo a la vista y
		// mostrarlos en el select como opciones
		DAOCustomerImpl daoImpl = new DAOCustomerImpl();
		ArrayList<Customer> customers = daoImpl.getAllCustomers();
		
		//Lo añado a la petición que se le pasa a la vista
		request.setAttribute("customers", customers);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/addpayment.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerNumber = request.getParameter("customerNumber");
		String checkNumber = request.getParameter("checkNumber");
		String date = request.getParameter("paymentDate");
		String amount = request.getParameter("amount");
		
		
		if (customerNumber != null && checkNumber != null && date != null && amount != null) {
						
			Payment pago = new Payment(Integer.parseInt(customerNumber), checkNumber, date, Double.parseDouble(amount));
			
			DAOPaymentImpl daoPaymentImpl = new DAOPaymentImpl();
			
			daoPaymentImpl.insertPayment(pago);
			
			
		}
		
		response.sendRedirect(request.getContextPath() + "/Admin/");
		
		
	}

}
