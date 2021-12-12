package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		DAOUsuarioImpl daoUsuarioImpl = new DAOUsuarioImpl();
		
		if (firstName!=null && lastName!=null && usuario!=null && email!=null 
			&& password!=null && password2!=null && (password.equals(password2))) {
			
			if (daoUsuarioImpl.getUsuario(usuario)!=null) {
				
				request.setAttribute("errorUsuario", "Usuario ya existente");
				doGet(request, response);
				
			} else {
				
				password = PasswordHashGenerator.hashPassword(password);
				
				Usuario user = new Usuario(usuario, email, password, "usuario", firstName, lastName);
				
				daoUsuarioImpl.registerUsuario(user);
			}
			
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
