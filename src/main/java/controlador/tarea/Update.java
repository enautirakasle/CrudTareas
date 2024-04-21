package controlador.tarea;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Dificultad;
import modelo.ModeloTareas;
import modelo.Tarea;

/**
 * Servlet implementation class Update
 */
@WebServlet("/UpdateTarea")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		//recibir los tatos de la tarea
		int id = Integer.parseInt(request.getParameter("id")); 
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		int dificultad_id = Integer.parseInt(request.getParameter("dificultad"));

		
		//almacenar la tarea en BBDD
		Tarea tarea = new Tarea();
		tarea.setId(id);
		tarea.setTitulo(titulo);
		tarea.setDescripcion(descripcion);
		Dificultad dificultad = new Dificultad();
		dificultad.setId(dificultad_id);
		tarea.setDificultad(dificultad);
		
		ModeloTareas mt = new ModeloTareas();
		mt.update(tarea);
				
		//abrir lo que quiera, en mi caso inicio
		//como ya tengo un controlador que abra el inicio redirijo a ese controlador
		response.sendRedirect("IndexTarea");
	}

}
