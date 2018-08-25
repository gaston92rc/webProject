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
 * Servlet implementation class ABMC
 */
@WebServlet({ "/persona/*", "/Persona/*", "/PERSONA/*" })
public class Persona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Persona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.sendRedirect("/WebExample/ErrorPage.html");
		response.setStatus(404);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		switch (request.getPathInfo()) {
			case "/alta":
				this.alta(request,response);
				break;
				
			case "/baja":
				this.baja(request,response);
				break;
				
			case "/modificacion":
				this.modificacion(request,response);
				break;
				
			case "/consulta":
				this.consulta(request,response);
				break;

			default:
				this.error(request,response);
				break;
			}
		}

		private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setStatus(404);
			response.sendRedirect("/WebContent/ErrorPage.html");
		}

		private void consulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
			//crear el controlador y ejecutar el getOne o getById
			String username = (String) request.getAttribute("username");
			System.out.println("USERNAME: "+username);
			SigninControler ctrl = new SigninControler();
			User u = ctrl.getUserByUsername(username);
			if(u != null){
				response.getWriter().append(u.getUsuario()+" - "+u.getEmail());
			}else{
				response.getWriter().append("Usuario incorrecto");
			}
			
		}

		private void modificacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.getWriter().append("Modificación, requested action: ").append(request.getPathInfo()).append(" through post");
			//crear el controlador y ejecutar el modificar/update
		}

		private void baja(HttpServletRequest request, HttpServletResponse response) throws IOException {
//			response.getWriter().append("baja, requested action: ").append(request.getPathInfo()).append(" through post");
			//crear el controlador y ejecutar el delete/remove
			String email = (String) request.getAttribute("email");
			String username = (String) request.getAttribute("username");
			String password = (String) request.getAttribute("password");
			System.out.println(email+" - "+username+" - "+password);
			User u = new User(username,email,password);
			SigninControler ctrl = new SigninControler();
			if(ctrl.deleteUser(u)){
				response.getWriter().append("Usuario Eliminado");
			}else{
				response.getWriter().append("Usuario no encontrado");
			}
		}

		private void alta(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.getWriter().append("Alta, requested action: ").append(request.getPathInfo()).append(" through post");
			//crear el controlador y ejecutar el new/add
		}
	

}
