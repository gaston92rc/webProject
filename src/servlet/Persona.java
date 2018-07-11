package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.sendRedirect("/WebExample/ErrorPage.html");
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
			response.sendRedirect("/../ErrorPage.html");
		}

		private void consulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.getWriter().append("Consulta, requested action: ").append(request.getPathInfo()).append(" through post");
			//crear el controlador y ejecutar el getOne o getById
		}

		private void modificacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.getWriter().append("Modificación, requested action: ").append(request.getPathInfo()).append(" through post");
			//crear el controlador y ejecutar el modificar/update
		}

		private void baja(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.getWriter().append("baja, requested action: ").append(request.getPathInfo()).append(" through post");
			//crear el controlador y ejecutar el delete/remove
		}

		private void alta(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.getWriter().append("Alta, requested action: ").append(request.getPathInfo()).append(" through post");
			//crear el controlador y ejecutar el new/add
		}
	

}
