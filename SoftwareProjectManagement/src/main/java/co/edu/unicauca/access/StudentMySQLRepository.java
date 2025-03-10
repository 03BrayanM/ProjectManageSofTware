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
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class StudentMySQLRepository implements IStudentRepository{


    

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(Object usuario) {
        Student estudiante = (Student) usuario;
        Connection conexion = Conectionbd.conectar(); // Conexión a la BD

        if (conexion == null) {
             Messages.showMessageDialog("Error de conexion", "Atención");
            return false;
        }

        try {
            String sql = "{CALL RegistrarEstudiante(?, ?, ?, ?, ?)}";
            CallableStatement stmt = conexion.prepareCall(sql);

            stmt.setInt(1, estudiante.getCodigo());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getCedula());
            stmt.setString(4, estudiante.getEmail());
            stmt.setString(5, estudiante.getTelefono());

            stmt.execute();
            stmt.close();
            conexion.close();

            return true;  // Registro exitoso
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar estudiante: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;  // Hubo un error
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
    
}
