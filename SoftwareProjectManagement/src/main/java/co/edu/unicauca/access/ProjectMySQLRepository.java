/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.interfaces.IProjectRepository;
import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.infra.Messages;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Brayan
 */
public class ProjectMySQLRepository implements IProjectRepository {

    private Connection conn;
    
    public ProjectMySQLRepository() {
        try {
            // Ruta de la base de datos (ajústala según la ubicación real de tu archivo)
            String url = "jdbc:mysql://localhost:3306/ingsoftware2";
            this.conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(Object entity) {
       String sql = "{CALL registrarProyecto(?, ?, ?, ?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado
    if(!(entity instanceof Project)){
         Messages.showMessageDialog("Error: El objeto no es de tipo Project", "Atención");
    }
    Project project= (Project) entity;  
    try (CallableStatement stmt = conn.prepareCall(sql)) {
        stmt.setString(1, project.getNitEmpresa());
        stmt.setString(2, project.getNombre());
        stmt.setString(3, project.getResumen());
        stmt.setString(4, project.getDescripcion());
        stmt.setString(5, project.getObjetivo());
        stmt.setString(6, project.getTiempoMaximo());
        stmt.setString(7, project.getPresupuesto());
        stmt.setString(8, project.getFechaEntregaEsperada());
        stmt.setString(9, project.getFechaEntregaEsperada());

        
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0; // Retorna true si el procedimiento se ejecutó correctamente

    } catch (SQLException e) {
        e.printStackTrace();
        Messages.showMessageDialog("Error al registrar el proyecto", "Atención");
        return false;
    } 
    }

 

}
