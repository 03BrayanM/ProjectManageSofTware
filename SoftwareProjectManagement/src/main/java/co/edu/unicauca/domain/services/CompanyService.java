package co.edu.unicauca.domain.services;


import co.edu.unicauca.domain.entities.Company;
import co.edu.unicauca.access.Conectionbd;
import co.edu.unicauca.domain.entities.Student;
import co.edu.unicauca.infra.Messages;
import co.edu.unicauca.interfaces.IRepository;
import javax.swing.JOptionPane; // Importar para mostrar mensajes en la GUI
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(validarcampos( company.getNombre(), company.getEmail(), company.getNombrecontaccto(), company.getApellido(), company.getCargo(), company.getTelefono(), company.getSector())){
      return repository.save(company);
    }else
            return false;
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

   private boolean validarcampos( String nombre, String email, String nombrecontacto, String apellido, String cargo, String telefono, String sector){
        // Validar que el nombre y apellido no contengan números
        if (contieneNumeros(nombre)) {
            Messages.showMessageDialog("El campo Nombre no puede contener números.", "Atención");
            return false;
        }
          if (contieneNumeros(sector)) {
            Messages.showMessageDialog("El campo Sector no puede contener números.", "Atención");
            return false;
        }
            if (contieneNumeros(cargo)) {
            Messages.showMessageDialog("El campo Nombre no puede contener números.", "Atención");
            return false;
        }
        if (contieneNumeros(nombrecontacto)) {
            Messages.showMessageDialog("El campo Nombre de contacto no puede contener números.", "Atención");
            return false;
        }
        if (contieneNumeros(apellido)) {
            Messages.showMessageDialog("El campo Apellido no puede contener números.", "Atención");
            return false;
        }

        // Validar que el email tenga un formato válido
        if (!validarEmail(email)) {
            Messages.showMessageDialog("El campo Email no tiene un formato válido.", "Atención");
            return false;
        }

        // Validar que el teléfono solo contenga números
        if (esNumero(telefono)) {
            Messages.showMessageDialog("El campo Teléfono solo puede contener números.", "Atención");
            return false;
        }
         
        return true;
   }
    private static boolean contieneNumeros(String texto) {
        return texto.matches(".*\\d.*");
    }

    private  boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private  boolean esNumero(String texto) {
        return texto.matches("\\d+");
    }

    
}
