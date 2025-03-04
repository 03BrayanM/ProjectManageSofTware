
package co.edu.unicauca.controller;

import co.edu.unicauca.interfaces.IGestor;
import co.edu.unicauca.model.Conectionbd;
import co.edu.unicauca.model.Student;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class StudentControler  implements IGestor{

    @Override
    public boolean Registrarusuario(Object usuario) {
        Student estudiante=(Student)usuario;
        Connection conexion = Conectionbd.conectar(); // Conexión a la BD

        if (conexion == null) {
            JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
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
    

