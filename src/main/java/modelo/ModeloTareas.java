package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloTareas{

	public ArrayList<Tarea> getTodos(Connection conexion) {
		ModeloDificultades md = new ModeloDificultades();
		ArrayList<Tarea> tareas = new ArrayList<>();

		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM tareas");
			while (rs.next()) {
				Tarea tarea = new Tarea();
				tarea.setId(rs.getInt("id"));
				tarea.setTitulo(rs.getString("titulo"));
				tarea.setDescripcion(rs.getString("descripcion"));
				tarea.setDificultad(md.get(rs.getInt("dificultad_id"), conexion));

				tareas.add(tarea);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return tareas;
	}

	public Tarea get(int id, Connection conexion) {
		ModeloDificultades md = new ModeloDificultades();

		try {
			PreparedStatement pst = conexion.prepareStatement("SELECT * FROM tareas WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Tarea tarea = new Tarea();
				tarea.setId(rs.getInt("id"));
				tarea.setTitulo(rs.getString("titulo"));
				tarea.setDescripcion(rs.getString("descripcion"));
				tarea.setDificultad(md.get(rs.getInt("dificultad_id"), conexion));

				// Si necesitas más campos aquí, agrégalos como lo hiciste en Alimento

				return tarea;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public boolean delete(int id, Connection conexion) {
		try {
			PreparedStatement pst = conexion.prepareStatement("DELETE FROM tareas WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int update(Tarea tarea, Connection conexion) {
		try {
			PreparedStatement pst = conexion
					.prepareStatement("UPDATE tareas SET titulo = ?, descripcion = ?, dificultad_id = ? WHERE id = ?");
			pst.setString(1, tarea.getTitulo());
			pst.setString(2, tarea.getDescripcion());
			pst.setInt(3, tarea.getDificultad().getId());
			pst.setInt(4, tarea.getId());

			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int insert(Tarea tarea, Connection conexion) {
		try {
			PreparedStatement pst = conexion
					.prepareStatement("INSERT INTO tareas (titulo, descripcion, dificultad_id) VALUES (?, ?, ?)");
			pst.setString(1, tarea.getTitulo());
			pst.setString(2, tarea.getDescripcion());
			pst.setInt(3, tarea.getDificultad().getId());
			pst.executeUpdate();
			
			return obtenerUltimoIdInsertado(conexion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int obtenerUltimoIdInsertado(Connection conexion) {
	    try {
	    	Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID() as last_id");
	        if (rs.next()) {
	            return rs.getInt("last_id");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1; // Si no se pudo obtener el ID, retorna un valor negativo
	}


}
