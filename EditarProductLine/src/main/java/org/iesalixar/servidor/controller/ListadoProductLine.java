package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLine;
import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.ProductLine;

/**
 * Servlet implementation class ListadoProductLine
 */
@WebServlet("/ListadoProductLine")
public class ListadoProductLine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListadoProductLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOProductLineImpl daoImpl = new DAOProductLineImpl();

		ArrayList<ProductLine> listaProductos = (ArrayList) daoImpl.getAllProductLines();

		request.setAttribute("listaProductos", listaProductos);

		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		;

	}

}
