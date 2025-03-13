/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.interfaces.ICoordinatorRepository;
import co.edu.unicauca.domain.entities.Coordination;
import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.infra.CalcularFecha;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class CoordinatorMySQLRepository implements ICoordinatorRepository{

   

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Object> list() {
       CalcularFecha calcular = new CalcularFecha();
        List<Project> listaproyectos = new ArrayList<>();
       Connection conexion = Conectionbd.conectar();
           if (conexion == null) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            return null; // Devuelve null si la conexión falla
           }
           try{
               // Llamada al procedimiento almacenado
            String sql = "{CALL sp_ListarProyectosPostulados()}";
            CallableStatement stmt = conexion.prepareCall(sql);
            // Ejecutamos el procedimiento y obtenemos los resultados
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Project proyecto= new Project();
                proyecto.setNombre(rs.getString("titulo"));
                proyecto.setNombreEmpresa(rs.getString("nombre"));
                proyecto.setTiempoMaximo(rs.getString("tiempoEst"));
                proyecto.setEstado(rs.getString("estado"));
                proyecto.setFechaEntregadaEsperada(rs.getString("fechaEntregaEsperada"));
            
                
                listaproyectos.add(proyecto);
            }
            rs.close();
            stmt.close();
            conexion.close();
            
            return (List<Object>)(Project)listaproyectos;
            
           }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar empresas: " + e.getMessage(), "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            return null;
           }
    }

   
    
}
