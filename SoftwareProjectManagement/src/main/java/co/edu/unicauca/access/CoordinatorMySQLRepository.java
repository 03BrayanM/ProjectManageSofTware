/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.interfaces.ICoordinatorRepository;
import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.domain.states.AceptadoState;
import co.edu.unicauca.domain.states.EnEjecucionState;
import co.edu.unicauca.domain.states.RechazadoState;
import co.edu.unicauca.domain.states.RecibidoState;
import co.edu.unicauca.domain.states.CerradoState;
import co.edu.unicauca.infra.Messages;
import co.edu.unicauca.interfaces.ProjectState;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Brayan
 */
public class CoordinatorMySQLRepository implements ICoordinatorRepository {
    private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/gestion_proyectos_software";
    private static final String user = "root"; // Cambia si usas otro usuario
    private static final String password = "oracle"; // Cambia por tu contraseña

    public CoordinatorMySQLRepository() {
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
    public boolean save(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Object> list() {

        List<Project> listaproyectos = new ArrayList<>();

         if(!conectar()){
            Messages.showMessageDialog("Error: No se pudo conectar a la base de datos.", "Error de Conexión");
            return null;
        }else{
        try {
            // Llamada al procedimiento almacenado
            String sql = "{CALL sp_ListarProyectosPostulados()}";
            CallableStatement stmt = conn.prepareCall(sql);
            // Ejecutamos el procedimiento y obtenemos los resultados
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Project proyecto = new Project();
                proyecto.setNombre(rs.getString("titulo"));
                proyecto.setNombreEmpresa(rs.getString("nombre"));
                proyecto.setTiempoMaximo(rs.getString("tiempoEst"));
                String estadoBD = rs.getString("estado"); // Obtiene el estado como String
                ProjectState estado = obtenerEstadoDesdeBD(estadoBD); // Convierte el estado a un objeto
                proyecto.setEstado(estado);
                proyecto.setFechaEntregadaEsperada(rs.getString("fechaEntregaEsperada"));

                listaproyectos.add(proyecto);
            }
            rs.close();
            stmt.close();

            return (List<Object>) (Project) listaproyectos;

        } catch (SQLException e) {
            Messages.showMessageDialog("Error al listar empresas:", "Error de Consulta");

            return null;
        }}
    }

    @Override
    public User found(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object buscarElemento(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private ProjectState obtenerEstadoDesdeBD(String estadoBD) {
        switch (estadoBD.trim().toUpperCase()) {
            case "ACEPTADO":
                return new AceptadoState();
            case "EN EJECUCION":
                return new EnEjecucionState();
            case "RECHAZADO":
                return (ProjectState) new RechazadoState();
            case "RECIBIDO":
                return new RecibidoState();
            case "CERRADO":
                return new CerradoState();
            default:
                throw new IllegalArgumentException("Estado no reconocido: " + estadoBD);
        }
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
