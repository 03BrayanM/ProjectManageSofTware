package co.edu.unicauca.domain.services;


import co.edu.unicauca.domain.entities.Company;
import co.edu.unicauca.access.Conectionbd;
import co.edu.unicauca.domain.entities.Student;
import co.edu.unicauca.interfaces.IRepository;
import javax.swing.JOptionPane; // Importar para mostrar mensajes en la GUI
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class CompanyService  {

    private IRepository repository;
    

    public CompanyService(IRepository repository) {
        this.repository = repository;
    }
    public boolean registreCompany(Company company){
      return repository.save(company);
    }

    public List<Company> listarEmpresas() {
        List<Company> listaEmpresas = new ArrayList<>();
        Connection conexion = Conectionbd.conectar();

        if (conexion == null) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            return null; // Devuelve null si la conexión falla
        }

        try {
            // Llamada al procedimiento almacenado
            String sql = "{CALL sp_listar_empresas()}";
            CallableStatement stmt = conexion.prepareCall(sql);

            // Ejecutamos el procedimiento y obtenemos los resultados
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Company empresa = new Company();
                empresa.setNit(rs.getInt("nit"));
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
            conexion.close();

            return listaEmpresas; // Devuelve la lista con las empresas
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar empresas: " + e.getMessage(), "Error de Consulta", JOptionPane.ERROR_MESSAGE);
            return null; // Devuelve null en caso de error
        }
    }

   


    
}
