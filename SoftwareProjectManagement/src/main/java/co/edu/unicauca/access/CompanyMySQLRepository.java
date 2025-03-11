/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.access;

import co.edu.unicauca.interfaces.ICompanyRepository;
import co.edu.unicauca.domain.entities.Company;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class CompanyMySQLRepository implements ICompanyRepository {

    @Override
   public boolean save(Object usuario) {
    Company empresa = (Company) usuario;
    Connection conexion = Conectionbd.conectar(); // Llamamos a la conexión existente

    if (conexion == null) {
        JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    try {
        // Llamada al procedimiento almacenado con 9 parámetros
        String sql = "{CALL sp_registrar_empresa(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement stmt = conexion.prepareCall(sql);

        // Pasamos los 9 parámetros correctamente
        stmt.setInt(1, empresa.getNit());
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
        conexion.close();

        return true; // Registro exitoso
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar la empresa: " + e.getMessage(), "Error de Registro", JOptionPane.ERROR_MESSAGE);
        return false; // Fallo en el registro
    }
}


    public boolean update(Company entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
