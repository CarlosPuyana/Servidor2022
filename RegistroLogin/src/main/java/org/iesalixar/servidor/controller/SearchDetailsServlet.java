package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class SearchDetailsServlet
 */
public class SearchDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productName = request.getParameter("productName");

		DAOProductImpl dao = new DAOProductImpl();

		request.setAttribute("producto", dao.getProduct(productName));

		request.getRequestDispatcher("WEB-INF/view/vermas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productName = request.getParameter("productName");
		String productCode = request.getParameter("productCode");

		DAOProductImpl dao = new DAOProductImpl();

		request.setAttribute("producto", dao.getProduct(productName));
		
		
		Cookie cesta = new Cookie("cesta", productCode);
		response.addCookie(cesta);
		

		doGet(request, response);
		return;

	}

}
