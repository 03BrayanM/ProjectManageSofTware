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
        if (conn== null) {
            Messages.showMessageDialog("Error de conexión", "Atención");
            return false;
        }

        try {
            String sql = "{CALL InsertarInteres(?,?,?)}";
            CallableStatement stmt = conn.prepareCall(sql);

            // Corrección: Se debe usar setInt para los campos de tipo INT
            stmt.setString(1, postulacion.getCodStudent());
            stmt.setInt(2, Integer.valueOf(postulacion.getCodProject()));
            stmt.setDate(3, new java.sql.Date(postulacion.getFecha().getTime()));

            stmt.execute();
            stmt.close();            
            return true;  // Registro exitoso
        } catch (SQLException e) {
            Messages.showMessageDialog("Error al registrar la Postulacion:", "Error");            
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
    public Project getProject(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object buscarElemento(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User found(String usename) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
