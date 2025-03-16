/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.infra.Messages;
import co.edu.unicauca.interfaces.IRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class UserMySQLRepository implements IRepository {

    private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/gestion_proyectos_software";
    private static final String user = "root"; // Cambia si usas otro usuario
    private static final String password = "oracle"; // Cambia por tu contraseña

    public UserMySQLRepository() {
        conectar();
    }

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
    public User found(Object username) {
        
        User usuario = null;

        if(!conectar()){
            Messages.showMessageDialog("Error: No se pudo conectar a la base de datos.", "Error de Conexión");
            return null;
        }else{
        try {
            // Llamada al procedimiento almacenado
            String sql = "{CALL sp_obtener_usuario(?)}";
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, (String)username); // Establecemos el parámetro userName

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
            Messages.showMessageDialog("Error al ejecutar el procedimiento almacenado:", "Error");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Messages.showMessageDialog("Error al cerrar la conexión:", "Error de Conexión");
            }
        }}
        return usuario;
    }
    
    private boolean conectar(){
        try {
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
       
    }
}
