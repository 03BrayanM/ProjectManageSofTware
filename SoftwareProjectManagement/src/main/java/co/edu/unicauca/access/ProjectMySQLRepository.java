/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.interfaces.IProjectRepository;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            stmt.setString(8, "RECIBIDO");
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
        if (!conectar()) {
            Messages.showMessageDialog("No se pudo conectar a la base de datos", "Atención");

            return null; // Devuelve null si la conexión falla

        }
        try {
            // Llamada al procedimiento almacenado
            String sql = "{CALL ListarProyectosPostulados()}";
            CallableStatement stmt = conn.prepareCall(sql);
            // Ejecutamos el procedimiento y obtenemos los resultados
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Project proyecto = new Project();
                proyecto.setId(rs.getString("idProject"));
                proyecto.setNombre(rs.getString("titulo"));
                proyecto.setNombreEmpresa(rs.getString("empresa"));
                proyecto.setTiempoMaximo(rs.getString("tiempoEst"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setObjetivo(rs.getString("objetivo"));
                proyecto.setPresupuesto(rs.getString("presupuesto"));
                proyecto.setResumen(rs.getString("resumen"));
                String estadoBD = rs.getString("estado"); // Obtiene el estado como String
                ProjectState estado = obtenerEstadoDesdeBD(estadoBD); // Convierte el estado a un objeto
                proyecto.setEstado(estado); // Asigna el estado al proyecto
                proyecto.setFechaEntregadaEsperada(rs.getString("fechaEntregaEsperada"));

                listaproyectos.add(proyecto);
            }
            rs.close();
            stmt.close();
            return (List<Object>) (List<?>) listaproyectos;

        } catch (SQLException e) {
            Messages.showMessageDialog("Error al listar proyectos:", "Error de Consulta");
            return null; // Devuelve null en caso de error 
        }
    }

    private ProjectState obtenerEstadoDesdeBD(String estadoBD) {
        switch (estadoBD) {
            case "ACEPTADO":
                return new AceptadoState();
            case "EJECUCION":
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

    private boolean conectar() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarEstado(Project p) {
        if (conn == null) {
            Messages.showMessageDialog("No se pudo conectar a la base de datos", "Atención");
            return false;
        }

        String sql = "{CALL ActualizarEstadoProyecto(?, ?)}"; // Procedimiento almacenado

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, p.getNombre().trim());
            stmt.setString(2, p.getEstadoString());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            Messages.showMessageDialog("Error SQL: " + e.getMessage(), "Error");
            //Messages.showMessageDialog("\"Error al obtener el proyectooooo:", "Error");
            return false;
        }
    }


    @Override
    public List<Object> getProjectsNit(String nit) {
        List<Project> listaProyectos = new ArrayList<>();

        if (!conectar()) {
            Messages.showMessageDialog("No se pudo conectar a la base de datos", "Atención");
            return null; // Devuelve una lista vacía en lugar de null
        }

        // Consulta SQL para el procedimiento almacenado
        String sql = "{CALL ListarProyectosPostulados(?)}";

        try (CallableStatement stmt = conn.prepareCall(sql)) { // Try-with-resources para evitar fugas de memoria
            stmt.setString(1, nit);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Project proyecto = new Project();
                    proyecto.setId(rs.getString("idProject"));
                    proyecto.setNombre(rs.getString("titulo"));
                    proyecto.setNombreEmpresa(rs.getString("empresa"));
                    proyecto.setTiempoMaximo(rs.getString("tiempoEst"));
                    proyecto.setDescripcion(rs.getString("descripcion"));
                    proyecto.setObjetivo(rs.getString("objetivo"));
                    proyecto.setPresupuesto(rs.getString("presupuesto"));

                    // Obtener y asignar el estado del proyecto
                    String estadoBD = rs.getString("estado");
                    ProjectState estado = obtenerEstadoDesdeBD(estadoBD);
                    proyecto.setEstado(estado);

                    proyecto.setFechaEntregadaEsperada(rs.getString("fechaEntregaEsperada"));

                    listaProyectos.add(proyecto);
                }
            }
        } catch (SQLException e) {
            Messages.showMessageDialog("Error al listar proyectos: " + e.getMessage(), "Error de Consulta");
            return null; // Retorna una lista vacía en caso de error
        }

        return new ArrayList<>(listaProyectos); // Devuelve la lista con los proyectos encontrados
    }

    @Override
    public Project found(Object idProject){
        Project proyecto = null;
        String sql = "{CALL ObtenerProyecto(?) }";
        if (!conectar()) {
            Messages.showMessageDialog("Error: No se pudo conectar a la base de datos.", "Error de Conexión");
            return null;
        } else {
            try (CallableStatement stmt = conn.prepareCall(sql)) {

                stmt.setString(1, (String) idProject);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    proyecto = new Project();
                    proyecto.setNombre(rs.getString("titulo"));
                    proyecto.setNombreEmpresa(rs.getString("empresa"));
                    proyecto.setFechaEntregadaEsperada(rs.getString("fechaEntregaEsperada"));
                    proyecto.setTiempoMaximo(rs.getString("tiempoEst"));
                    proyecto.setPresupuesto(rs.getString("presupuesto"));
                    String estadoBD = rs.getString("estado"); // Obtiene el estado como String
                    ProjectState estado = obtenerEstadoDesdeBD(estadoBD); // Convierte el estado a un objeto
                    proyecto.setEstado(estado); // Asigna el estado al proyecto
                    proyecto.setObjetivo(rs.getString("objetivo"));
                    proyecto.setResumen(rs.getString("resumen"));
                    proyecto.setDescripcion(rs.getString("descripcion"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return proyecto;
    }

}
