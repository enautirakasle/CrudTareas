package controlador.tarea;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Conector;
import modelo.ModeloDificultades;
import modelo.ModeloTareas;
import modelo.ModeloUsuarios;
import modelo.Tarea;
import modelo.Usuario;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/EditTarea")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModeloDificultades md = new ModeloDificultades();

		// recibir la id
		int id = Integer.parseInt(request.getParameter("id"));

		// conseguir la tarea
		ModeloTareas mt = new ModeloTareas();
		Tarea tarea = mt.get(id, Conector.getInstancia().getConexion());

		ModeloUsuarios mu = new ModeloUsuarios();
		ArrayList<Usuario> usuarios = mu.getTodos(Conector.getInstancia().getConexion());
		tarea.setUsuarios(mu.usuariosConLaTarea(id, Conector.getInstancia().getConexion()));
		

		// enviar tarea a la vista
		request.setAttribute("tarea", tarea);
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("dificultades", md.getTodos(Conector.getInstancia().getConexion()));

		// abrir vista
		request.getRequestDispatcher("tarea/edit_tarea.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
