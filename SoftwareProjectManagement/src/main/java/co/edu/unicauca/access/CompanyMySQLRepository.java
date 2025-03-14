/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.interfaces.ICompanyRepository;
import co.edu.unicauca.domain.entities.Company;
import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.infra.Messages;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class CompanyMySQLRepository implements ICompanyRepository {

    private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/gestion_proyectos_software";
    private static final String user = "root"; // Cambia si usas otro usuario
    private static final String password = "oracle"; // Cambia por tu contraseña

    public CompanyMySQLRepository() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(Object usuario) {
        Company empresa = (Company) usuario;

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            // Llamada al procedimiento almacenado con 9 parámetros
            String sql = "{CALL sp_registrar_empresa(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt = conn.prepareCall(sql);

            // Pasamos los 9 parámetros correctamente
            stmt.setString(1, empresa.getNit());
            stmt.setString(2, empresa.getNombre());
            stmt.setString(3, empresa.getEmail());
            stmt.setString(4, empresa.getTelefono());
            stmt.setString(5, empresa.getNombrecontaccto());
            stmt.setString(6, empresa.getApellido());
            stmt.setString(7, empresa.getSector());
            stmt.setString(8, empresa.getCargo());
            stmt.setString(9, empresa.getEstado()); // Corregido el índice

            // Ejecutamos el procedimiento
            stmt.execute();

            // Cerramos recursos
            stmt.close();
            conn.close();

            return true; // Registro exitoso
        } catch (SQLException e) {
            Messages.showMessageDialog("Error al registrar la empresa", "Atención");
            return false; // Fallo en el registro
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
    public List<Object> list() {
        List<Company> listaEmpresas = new ArrayList<>();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            return null; // Devuelve null si la conexión falla
        }

        try {
            // Llamada al procedimiento almacenado
            String sql = "{CALL sp_listar_empresas()}";
            CallableStatement stmt = conn.prepareCall(sql);

            // Ejecutamos el procedimiento y obtenemos los resultados
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Company empresa = new Company();
                empresa.setNit(rs.getString("nit"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setEmail(rs.getString("email"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setNombrecontaccto(rs.getString("nombrecontacto"));
                empresa.setApellido(rs.getString("apellido"));
                empresa.setSector(rs.getString("sector"));

                listaEmpresas.add(empresa);
            }

            // Cerramos recursos
            rs.close();
            stmt.close();
            conn.close();

            return new ArrayList(listaEmpresas); // Devuelve la lista con las empresas
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar empresas: " + e.getMessage(), "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            return null; // Devuelve null en caso de error
        }
    }

    @Override

    public User found(String usename) {
      return null;
    }

    public Object buscarElemento(Object entity) {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Company getCompanyWithUser(String username) {
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            return null; // Retorna null si no hay conexión
        }

        Company company = null;
        String sql = "{CALL ObtenerCompanyConUser(?)}"; // Nombre del procedimiento almacenado

        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, username); // Asignamos el ID del proyecto

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    company = new Company();
                    company.setNit(rs.getString("nit"));
                    company.setNombre(rs.getString("nombre"));
                    company.setSector(rs.getString("sector"));
                    company.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(CompanyMySQLRepository.class.getName()).log(Level.SEVERE, "Error al obtener el proyecto", e);
            JOptionPane.showMessageDialog(null, "Error al obtener el proyecto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                Logger.getLogger(ProjectMySQLRepository.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", e);
            }
        }
        return company;
    }

}
