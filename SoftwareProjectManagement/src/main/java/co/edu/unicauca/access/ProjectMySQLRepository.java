/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.interfaces.IProjectRepository;
import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.infra.CalcularFecha;
import co.edu.unicauca.infra.Messages;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Brayan
 */
public class ProjectMySQLRepository implements IProjectRepository {

    private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/gestion_proyectos_software";
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
        String sql = "{CALL registrarProyecto(?, ?, ?, ?, ?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado
        if (!(entity instanceof Project)) {
            Messages.showMessageDialog("Error: El objeto no es de tipo Project", "Atención");
        }
        Project project = (Project) entity;
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, project.getNitEmpresa());
            stmt.setString(2, project.getDescripcion());
            stmt.setString(3, project.getNombre());
            stmt.setString(4, project.getPresupuesto());
            stmt.setString(5, project.getObjetivo());
            stmt.setString(6, project.getResumen());
            stmt.setString(7, project.getTiempoMaximo());         
            stmt.setString(8,"RECIBIDO");
            stmt.setString(9, project.getFechaEntregadaEsperada());
          

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

    @Override
    public List<Object> list() {
        
        List<Project> listaproyectos = new ArrayList<>();
        Connection conexion = Conectionbd.conectar();
           if (conexion == null) {
           Messages.showMessageDialog("No se pudo conectar a la base de datos", "Atención");               

            return null; // Devuelve null si la conexión falla
           }
           try{
               // Llamada al procedimiento almacenado
            String sql = "{CALL ListarProyectosPostulados()}";
            CallableStatement stmt = conexion.prepareCall(sql);
            // Ejecutamos el procedimiento y obtenemos los resultados
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Project proyecto= new Project();
                proyecto.setId(rs.getString("idProject"));
                proyecto.setNombre(rs.getString("titulo"));
                proyecto.setNombreEmpresa(rs.getString("empresa"));
                proyecto.setTiempoMaximo(rs.getString("tiempoEst"));
                proyecto.setEstado(rs.getString("estado"));
                proyecto.setFechaEntregadaEsperada(rs.getString("fechaEntregaEsperada"));
                
                

                listaproyectos.add(proyecto);
            }
            rs.close();
            stmt.close();
            conexion.close();
            
            return (List<Object>)(List<?>)listaproyectos;
            
           }catch(SQLException e) {
             Messages.showMessageDialog("Error al listar empresas:", "Error de Consulta");  
          

            return null; // Devuelve null en caso de error 
        }
    }
    

    @Override
    public Object buscarElemento(Object entity) {
        Project  proyecto= null;
        String sql="{CALL BuscarProyectoPorNombre(?) }";
        
        try(Connection conexion=Conectionbd.conectar();
            CallableStatement stmt= conexion.prepareCall(sql)){
            
            stmt.setString(1,(String) entity);
            ResultSet rs=stmt.executeQuery();
            
            if(rs.next()){
                proyecto= new Project();
                proyecto.setNombre(rs.getString("titulo"));
                proyecto.setNombreEmpresa(rs.getString("empresa"));
                proyecto.setFechaEntregadaEsperada(rs.getString("fechaEntregaEsperada"));
                proyecto.setTiempoMaximo(rs.getString("tiempoEst"));
                proyecto.setPresupuesto(rs.getString("presupuesto"));
                proyecto.setEstado(rs.getString("estado"));
                proyecto.setObjetivo(rs.getString("objetivo"));
                proyecto.setResumen(rs.getString("resumen"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return proyecto;
    }


    @Override
    public User found(String usename) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


   
    @Override
    public Project getProject(String id) {
    Connection conexion = Conectionbd.conectar();
    if (conexion == null) {
        JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        return null; // Retorna null si no hay conexión
    }

    Project proyecto = null;
    String sql = "{CALL ObtenerProyecto(?)}"; // Nombre del procedimiento almacenado

    try (CallableStatement stmt = conexion.prepareCall(sql)) {
        stmt.setString(1, id); // Asignamos el ID del proyecto

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                proyecto = new Project();
                proyecto.setId(rs.getString("idProject"));
                proyecto.setNombre(rs.getString("titulo"));
                proyecto.setNombreEmpresa(rs.getString("empresa"));
                proyecto.setTiempoMaximo(rs.getString("tiempoEst"));
                proyecto.setEstado(rs.getString("estado"));
                proyecto.setFechaEntregadaEsperada(rs.getString("fechaEntregaEsperada"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setObjetivo(rs.getString("objetivo"));
                proyecto.setResumen(rs.getString("resumen"));
                proyecto.setPresupuesto(rs.getString("presupuesto"));
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(ProjectMySQLRepository.class.getName()).log(Level.SEVERE, "Error al obtener el proyecto", e);
        JOptionPane.showMessageDialog(null, "Error al obtener el proyecto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            conexion.close();
        } catch (SQLException e) {
            Logger.getLogger(ProjectMySQLRepository.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", e);
        }
    }
    return proyecto;
}


}
