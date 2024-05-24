package controlador.tarea;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Conector;
import modelo.ModeloDificultades;
import modelo.ModeloUsuarios;

/**
 * Servlet implementation class Create
 */
@WebServlet("/CreateTarea")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloDificultades md = new ModeloDificultades();
		ModeloUsuarios mu = new ModeloUsuarios();

		request.setAttribute("msg", request.getParameter("msg"));
		
		request.setAttribute("dificultades", md.getTodos(Conector.getInstancia().getConexion()));
		request.setAttribute("usuarios", mu.getTodos(Conector.getInstancia().getConexion()));
		
		request.getRequestDispatcher("tarea/create_tarea.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
