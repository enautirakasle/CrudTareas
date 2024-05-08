package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloAsignaciones extends Conector {

    public ArrayList<Asignacion> getTodos() {
        ArrayList<Asignacion> asignaciones = new ArrayList<>();

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM asignaciones");
            while (rs.next()) {
                Asignacion asignacion = new Asignacion();
                asignacion.setTareaId(rs.getInt("tarea_id"));
                asignacion.setUsuarioId(rs.getInt("usuario_id"));

                asignaciones.add(asignacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return asignaciones;
    }

    public Asignacion get(int tareaId, int usuarioId) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM asignaciones WHERE tarea_id=? AND usuario_id=?");
            pst.setInt(1, tareaId);
            pst.setInt(2, usuarioId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Asignacion asignacion = new Asignacion();
                asignacion.setTareaId(rs.getInt("tarea_id"));
                asignacion.setUsuarioId(rs.getInt("usuario_id"));

                return asignacion;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean delete(int tareaId, int usuarioId) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM asignaciones WHERE tarea_id=? AND usuario_id=?");
            pst.setInt(1, tareaId);
            pst.setInt(2, usuarioId);
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(int tareaId) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM asignaciones WHERE tarea_id=?");
            pst.setInt(1, tareaId);
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    

    public void insert(Asignacion asignacion) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO asignaciones (tarea_id, usuario_id) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, asignacion.getTareaId());
            pst.setInt(2, asignacion.getUsuarioId());
            pst.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
