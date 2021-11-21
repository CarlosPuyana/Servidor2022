package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class SearchProductServlet
 */
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// HttpSession sesion = request.getSession();

		request.getRequestDispatcher("WEB-INF/view/search.jsp").forward(request, response);

//		String productName = (String) sesion.getAttribute("get");
//
//		System.out.println("Si " + productName);

	}

	/**	
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productName = request.getParameter("search");

		if (productName != null) {
			DAOProductImpl dao = new DAOProductImpl();

			ArrayList<Product> product = dao.getProduct(productName);

			HttpSession sesion = request.getSession();
			sesion.setAttribute("producto", product);

			sesion.setAttribute("buscar", product.size());

			doGet(request, response);
		}

	}

}
