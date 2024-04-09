package controlador.tarea;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloTareas;
import modelo.Tarea;

/**
 * Servlet implementation class index
 */
@WebServlet("/IndexTarea")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//acceder a la BBDD y traerme todos los usuarios
		ModeloTareas mt = new ModeloTareas();
		ArrayList<Tarea> tareas = mt.getTodos();
		
		
		//set atribute de eese arraylist
		request.setAttribute("tareas", tareas);
		
		//abir la vista principal
		request.getRequestDispatcher("tarea/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
