package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloDificultades{

    public ArrayList<Dificultad> getTodos(Connection conexion) {
        ArrayList<Dificultad> dificultades = new ArrayList<>();

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dificultades");
            while (rs.next()) {
                Dificultad dificultad = new Dificultad();
                dificultad.setId(rs.getInt("id"));
                dificultad.setNombre(rs.getString("nombre"));

                dificultades.add(dificultad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dificultades;
    }

    public Dificultad get(int id, Connection conexion) {
        try {
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM dificultades WHERE id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Dificultad dificultad = new Dificultad();
                dificultad.setId(rs.getInt("id"));
                dificultad.setNombre(rs.getString("nombre"));

                return dificultad;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean delete(int id, Connection conexion) {
        try {
            PreparedStatement pst = conexion.prepareStatement("DELETE FROM dificultades WHERE id=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int update(Dificultad dificultad, Connection conexion) {
        try {
            PreparedStatement pst = conexion.prepareStatement("UPDATE dificultades SET nombre = ? WHERE id = ?");
            pst.setString(1, dificultad.getNombre());
            pst.setInt(2, dificultad.getId());

            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void insert(Dificultad dificultad, Connection conexion) {
        try {
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO dificultades (nombre) VALUES (?)");
            pst.setString(1, dificultad.getNombre());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
