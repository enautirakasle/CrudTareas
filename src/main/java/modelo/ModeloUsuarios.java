package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloUsuarios {

    public ArrayList<Usuario> getTodos(Connection conexion) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return usuarios;
    }
    
    public ArrayList<Usuario> usuariosConLaTarea(int idTarea, Connection conexion) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            PreparedStatement pst = conexion.prepareStatement("SELECT usuarios.* "
            		+ "FROM `usuarios` INNER join asignaciones on usuarios.id = asignaciones.usuario_id "
            		+ "WHERE asignaciones.tarea_id = ?");
            pst.setInt(1, idTarea);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return usuarios;
    }

    public Usuario get(int id, Connection conexion) {
        try {
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM usuarios WHERE id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));

                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean delete(int id, Connection conexion) {
        try {
            PreparedStatement pst = conexion.prepareStatement("DELETE FROM usuarios WHERE id=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int update(Usuario usuario, Connection conexion) {
        try {
            PreparedStatement pst = conexion.prepareStatement("UPDATE usuarios SET nombre = ? WHERE id = ?");
            pst.setString(1, usuario.getNombre());
            pst.setInt(2, usuario.getId());

            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void insert(Usuario usuario, Connection conexion) {
        try {
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO usuarios (nombre) VALUES (?)");
            pst.setString(1, usuario.getNombre());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
