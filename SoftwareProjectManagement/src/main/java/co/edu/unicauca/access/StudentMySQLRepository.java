/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.interfaces.IStudentRepository;
import co.edu.unicauca.domain.entities.Student;
import co.edu.unicauca.infra.Messages;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class StudentMySQLRepository implements IStudentRepository {

    private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/gestion_proyectos_software";
    private static final String user = "root"; // Cambia si usas otro usuario
    private static final String password = "oracle"; // Cambia por tu contraseña

    public StudentMySQLRepository() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(Object usuario) {
        Student estudiante = (Student) usuario;
        if (!conectar()) {
            Messages.showMessageDialog("Error: No se pudo conectar a la base de datos.", "Error de Conexión");
            return false;
        } else {
            try {
                String sql = "{CALL sp_registrar_estudiante(?, ?, ?, ?, ?, ?)}";
                CallableStatement stmt = conn.prepareCall(sql);

                stmt.setString(1, estudiante.getCodigo());
                stmt.setString(2, estudiante.getNombre());
                stmt.setString(3, estudiante.getCedula());
                stmt.setString(4, estudiante.getEmail());
                stmt.setString(5, estudiante.getTelefono());
                stmt.setString(6, "HABILITADO"); // Estado predeterminado

                stmt.execute();
                stmt.close();
                conn.close();

                return true;  // Registro exitoso
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al registrar estudiante: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;  // Hubo un error
            }
        }
    }

    @Override
    public boolean update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object found(Object nombre) {

        Student estudiante = new Student();
        if (!conectar()) {
            Messages.showMessageDialog("Error: No se pudo conectar a la base de datos.", "Error de Conexión");
            return null;

        } else {
            try {
                // Llamada al procedimiento almacenado
                String sql = "{CALL BuscarEstudiante(?)}";
                CallableStatement stmt = conn.prepareCall(sql);

                stmt.setString(1, (String) nombre);

                // Ejecutamos el procedimiento y obtenemos los resultados
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    estudiante.setNombre(rs.getString("userName"));
                    estudiante.setCodigo(rs.getString("codEst"));
                    estudiante.setCedula(rs.getString("cedula"));
                    estudiante.setTelefono(rs.getString("telefono"));
                } else {
                    Messages.showMessageDialog("No se encontro el estudiante", "Error");
                }
                rs.close();
                stmt.close();
                return estudiante;

            } catch (SQLException e) {
                Logger.getLogger(ProjectMySQLRepository.class.getName()).log(Level.SEVERE, "Error al obtener el estudiante", e);
                JOptionPane.showMessageDialog(null, "Error al obtener el estudiante: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return estudiante;
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
}
