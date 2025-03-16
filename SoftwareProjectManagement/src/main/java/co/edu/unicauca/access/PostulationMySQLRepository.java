/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.domain.entities.Postulation;
import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.infra.Messages;
import co.edu.unicauca.interfaces.IProjectRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author RoLoNeGaTiVo
 */
public class PostulationMySQLRepository implements IProjectRepository {

    private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/gestion_proyectos_software";
    private static final String user = "root"; // Cambia si usas otro usuario
    private static final String password = "oracle"; // Cambia por tu contraseña

    public PostulationMySQLRepository() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(Object postular) {
        Postulation postulacion = (Postulation) postular;

        if (!conectar()) {
            Messages.showMessageDialog("Error: No se pudo conectar a la base de datos.", "Error de Conexión");
            return false;
        } else {

            String sql = "{CALL InsertarInteres(?,?,?)}"; // Llamado al procedimiento almacenado
            try (CallableStatement stmt = conn.prepareCall(sql)) {

                // Asignar parámetros al procedimiento almacenado
                stmt.setString(1, postulacion.getCodStudent());
                stmt.setInt(2, Integer.parseInt(postulacion.getCodProject())); // Asegurar conversión correcta
                stmt.setDate(3, new java.sql.Date(postulacion.getFecha().getTime()));

                // Ejecutar el procedimiento
                stmt.execute();
                return true;  // Registro exitoso

            } catch (NumberFormatException e) {
                Messages.showMessageDialog("Error de formato: El ID del proyecto no es un número válido.", "Error");
                e.printStackTrace(); // Imprimir detalles en la consola
            } catch (SQLException e) {
                Messages.showMessageDialog("Error SQL: " + e.getMessage(), "Error");
                e.printStackTrace();
            } catch (Exception e) {
                Messages.showMessageDialog("Error inesperado: " + e.getMessage(), "Error");
                e.printStackTrace();
            }

            return false;  // Hubo un error
        }
    }

    @Override
    public boolean update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public User found(Object usename) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean conectar() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean actualizarEstado(Project p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
