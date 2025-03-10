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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayan
 */
public class ProjectMySQLRepository implements IProjectRepository {

    private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/ingsoftware2";
    private static final String user = "root"; // Cambia si usas otro usuario
    private static final String password = "oracle"; // Cambia por tu contraseña

    public ProjectMySQLRepository() {
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
    public boolean update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(Object entity) {
        String sql = "{CALL registrarProyecto(?, ?, ?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado
        if (!(entity instanceof Project)) {
            Messages.showMessageDialog("Error: El objeto no es de tipo Project", "Atención");
        }
        Project project = (Project) entity;
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, project.getNitEmpresa());
            stmt.setString(2, project.getDescripcion());
            stmt.setString(3, project.getNombre());
            stmt.setString(4, project.getPresupuesto());
            stmt.setString(5, project.getTiempoMaximo());
            stmt.setString(6, "HABILITADO");
            stmt.setString(7, project.getFechaEntregaEsperada());
            
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(ProjectMySQLRepository.class.getName()).log(Level.SEVERE, "Error al registrar el proyecto", e);

            Messages.showMessageDialog(
                    "Error al registrar el proyecto.",
                    "Atención"
            );
            return false;
        }

    }

}
