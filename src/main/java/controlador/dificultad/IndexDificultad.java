package controlador.dificultad;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Conector;
import modelo.Dificultad;
import modelo.ModeloDificultades;

/**
 * Servlet implementation class IndexDificultad
 */
@WebServlet("/IndexDificultad")
public class IndexDificultad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexDificultad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Acceder a la BBDD y traerme todas las dificultades
	    ModeloDificultades md = new ModeloDificultades();
	    ArrayList<Dificultad> dificultades = md.getTodos(Conector.getInstancia().getConexion());
	    
	    // Set attribute de ese ArrayList
	    request.setAttribute("dificultades", dificultades);
	    
	    // Abrir la vista principal de dificultades
	    request.getRequestDispatcher("dificultad/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
