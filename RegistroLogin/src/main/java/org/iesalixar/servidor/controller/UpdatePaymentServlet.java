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
 * Servlet implementation class UpdatePaymentServlet
 */
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo todo los clientes porque los pasaré para mostrarlos en un select
		
		//Obtengo también el pago correspondiente a los datos del enlace
		String customerNumber = request.getParameter("cn");
		String checkNumber = request.getParameter("checkn");
		
		if (customerNumber!=null && checkNumber!=null) {
			
			DAOPaymentImpl daoPaymentImpl = new DAOPaymentImpl();
			DAOCustomerImpl daoCustomerImpl = new DAOCustomerImpl();
			
			//Obtengo el Payment cuyos datos pasaré a la vista
			Payment payment = daoPaymentImpl.getPayment(Integer.parseInt(customerNumber), checkNumber); 
			
			//Obtengo todos los clientes para mostrar los nombre en la vista de edición
			ArrayList<Customer> customers = daoCustomerImpl.getAllCustomers();
			
			//Pasamos la información a la vista
			request.setAttribute("pago", payment);
			request.setAttribute("customers", customers);
			
			
			request.getRequestDispatcher("/WEB-INF/view/admin/updatepayment.jsp").forward(request, response);
		} else {
			response.sendRedirect("/Admin/");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		String checkNumber = request.getParameter("checkn");
		String date = request.getParameter("paymentDate");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		
		if (customerNumber != 0 && checkNumber != null && date != null && amount != 0.0) {
			
			
			
			Payment pago = new Payment(customerNumber, checkNumber, date, amount);
			
			DAOPaymentImpl daoPaymentImpl = new DAOPaymentImpl();
			DAOCustomerImpl daoCustomerImpl = new DAOCustomerImpl();
			
			daoPaymentImpl.updatePayment(pago);
			
		}
		
		response.sendRedirect(request.getContextPath() + "/Admin/");
		
	}

}
