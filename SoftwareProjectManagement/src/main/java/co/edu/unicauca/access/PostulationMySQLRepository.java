/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.domain.entities.Postulation;
import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.infra.Messages;
import co.edu.unicauca.interfaces.IPostulationRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author RoLoNeGaTiVo
 */
public class PostulationMySQLRepository implements IPostulationRepository {

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

    public Object found(Object usename) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    public Postulation found(Object post) {

        Postulation pos = new Postulation();
        
        if (!(post instanceof Postulation)) {
            Messages.showMessageDialog("Error: El objeto no es una Psotulacion", "Atención");
        }

        Postulation postulacion = (Postulation) post;

        if (!conectar()) {
            Messages.showMessageDialog("Error: No se pudo conectar a la base de datos.", "Error de Conexión");
            return null;
        } else {
            try {
                // Llamada al procedimiento almacenado
                String sql = "{CALL BuscarInteres(?, ?)}";
                CallableStatement stmt = conn.prepareCall(sql);
                stmt.setString(1, (String) postulacion.getCodStudent());
                stmt.setInt(2, (int) Integer.parseInt(postulacion.getCodProject()));
                // Ejecutamos el procedimiento almacenado
                ResultSet rs = stmt.executeQuery();

                // Si hay resultados, creamos un objeto Usuario
                if (rs.next()) {
                    pos.setCodProject(rs.getString("idProject"));
                    pos.setCodStudent(rs.getString("codEst"));
                    pos.setFecha(rs.getTimestamp("fecha"));
                }

                // Cerramos los recursos
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                Messages.showMessageDialog("Error al ejecutar el procedimiento almacenado:", "Error");
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    Messages.showMessageDialog("Error al cerrar la conexión:", "Error de Conexión");
                }
            }
        }

        if (pos != null) {
            return pos;
        } else {
            return new Postulation(null, null, null);
        }
    }

}
