
package co.edu.unicauca.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectionbd {
    // Datos de conexión
    private static final String url = "jdbc:mysql://localhost:3306/gestion_proyectos_software";
    private static final String user = "root"; // Cambia si usas otro usuario
    private static final String password = "oracle"; // Cambia por tu contraseña

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
        
    }
}
