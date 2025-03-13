/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.interfaces.IRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class UserMySQLRepository implements IRepository  {

    @Override
    public boolean save(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public User found(String username) {
               Connection conexion = Conectionbd.conectar(); // Llamamos a la conexión existente

        if (conexion == null) {
             JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        User usuario = null;

        try {
            // Llamada al procedimiento almacenado
            String sql = "{CALL sp_obtener_usuario(?)}";
            CallableStatement stmt = conexion.prepareCall(sql);
            stmt.setString(1, username); // Establecemos el parámetro userName

            // Ejecutamos el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Si hay resultados, creamos un objeto Usuario
            if (rs.next()) {
                usuario = new User();
                usuario.setUsuario(rs.getString("userName"));
                usuario.setContrasenia(rs.getString("pass"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
            }

            // Cerramos los recursos
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento almacenado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return usuario;
    
    }

    
}
