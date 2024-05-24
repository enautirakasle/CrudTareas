package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    private static Conector instancia;
    private Connection conexion;

    // Constructor privado para evitar la instanciación externa
    private Conector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD, Config.USERNAME, Config.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método público y estático para obtener la instancia única
    public static Conector getInstancia() {
        if (instancia == null) {
            synchronized (Conector.class) {
                if (instancia == null) {
                    instancia = new Conector();
                }
            }
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
