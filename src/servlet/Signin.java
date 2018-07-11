package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Time;

import business.SigninControler;
import entities.User;
import helpers.LoginHelper;

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
//		 TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SigninControler ctrl = new SigninControler();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User();
		u.setUsuario(LoginHelper.getUserByEmail(email));
		u.setEmail(email);
		u.setPassword(password);
		System.out.println("El usuario: "+u.getUsuario()+" esta intentando loguearse");
		u=ctrl.getUser(u);
		
		request.getSession().setAttribute("usuario", u);
		if(u!=null){
			System.out.println("El usuario: "+u.getUsuario()+" fue logueado");
			request.getRequestDispatcher("WEB-INF/UserManagment.jsp").forward(request, response);
		}else{
			System.out.println("Usuario Invalido");
		}
		
		
		
	}

}
