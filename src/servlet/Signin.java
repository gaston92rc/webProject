package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.SigninControler;
import entities.User;

/**
 * Servlet implementation class Test
 */
@WebServlet({ "/signin", "/SIGNIN", "/Signin" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ESTOY EN EL POST DE SIGNIN");
		
		SigninControler ctrl = new SigninControler();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("Usuario: "+email+"/nContraseña: "+password);
		
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		u=ctrl.getUser(u);
		
		request.getSession().setAttribute("usuario", u);
		request.getRequestDispatcher("WEB-INF/UserManagment.jsp").forward(request, response);
//		
		
	}

}
