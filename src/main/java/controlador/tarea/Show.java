package controlador.tarea;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Conector;
import modelo.ModeloTareas;
import modelo.Tarea;

/**
 * Servlet implementation class Show
 */
@WebServlet("/ShowTarea")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir la id
		int id = Integer.parseInt(request.getParameter("id")); 
		
		//conseguir la tarea
		ModeloTareas mt = new ModeloTareas();
		Tarea tarea = mt.get(id, Conector.getInstancia().getConexion());
		
		//enviar tarea a la vista
		request.setAttribute("tarea", tarea);
		
		//abrir vista
		request.getRequestDispatcher("tarea/show_tarea.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
