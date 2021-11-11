package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.ProductLine;

/**
 * Servlet implementation class UpdateProductLine
 */
public class UpdateProductLine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductLine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productLine = request.getParameter("productLine");

		DAOProductLineImpl daoImpl = new DAOProductLineImpl();
		
		ProductLine product = daoImpl.getProductLine(productLine);
		
		request.setAttribute("producto", product);
		
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productLine = request.getParameter("productLine");
		String textDescription = request.getParameter("textDescription");
		String htmlDescription  = request.getParameter("htmlDescription");
		
		if (productLine != null && textDescription != null && htmlDescription != null) {
			
			ProductLine product = new ProductLine(productLine,textDescription,htmlDescription);
			
			DAOProductLineImpl daoImpl = new DAOProductLineImpl();
			
			daoImpl.updateProductLine(product);
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
