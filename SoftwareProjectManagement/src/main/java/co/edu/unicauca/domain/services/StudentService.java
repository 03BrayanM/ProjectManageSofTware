package co.edu.unicauca.domain.services;

import co.edu.unicauca.interfaces.IGestor;
import co.edu.unicauca.access.Conectionbd;
import co.edu.unicauca.access.IRepository;
import co.edu.unicauca.domain.entities.Student;
import co.edu.unicauca.infra.Messages;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class StudentService {

    private IRepository repository;

    public StudentService(IRepository repository) {
        this.repository = repository;
    }

    public boolean RegistrarStudent(Object usuario) {
        Student estudiante = (Student) usuario;
        Connection conexion = Conectionbd.conectar(); // Conexión a la BD

        if (conexion == null) {
             Messages.showMessageDialog("Error de conexion", "Atención");
            return false;
        }

        try {
            String sql = "{CALL sp_registrar_estudiante(?, ?, ?, ?, ?)}";
            CallableStatement stmt = conexion.prepareCall(sql);

            stmt.setInt(1, estudiante.getCodigo());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getCedula());
            stmt.setString(4, estudiante.getEmail());
            stmt.setString(5, estudiante.getTelefono());

            stmt.execute();
            stmt.close();
            conexion.close();

            return true;  // Registro exitoso
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar estudiante: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;  // Hubo un error
        }
    }
}
