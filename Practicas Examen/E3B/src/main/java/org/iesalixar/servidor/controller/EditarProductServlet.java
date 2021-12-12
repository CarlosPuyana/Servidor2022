package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class EditarProductServlet
 */
@WebServlet("/EditarProductServlet")
public class EditarProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession();

		DAOProductImpl dao = new DAOProductImpl();

		if (!sesion.isNew()) {

			Product producto = dao.getProducts(request.getParameter("productCode"));
			

			sesion.setAttribute("product", producto);
//			
			request.getRequestDispatcher("../WEB-INF/view/admin/update.jsp").forward(request, response);

			return;
		}

		sesion.invalidate();
		response.sendRedirect(request.getContextPath() + "/");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productLine = request.getParameter("productLine");
		int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
		Double buyPrice = Double.parseDouble(request.getParameter("buyPrice"));
		
		DAOProductImpl dao = new DAOProductImpl();
		
		Product product = dao.getProducts(productCode);
		
		product.setQuantityInStock(quantityInStock);
		product.setBuyPrice(buyPrice);
		
		dao.updateProduct(product);
		
		response.sendRedirect(request.getContextPath() + "/Admin/Inicio");
		
	}

}
