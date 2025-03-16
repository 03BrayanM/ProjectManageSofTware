package co.edu.unicauca.domain.entities;

import co.edu.unicauca.domain.states.RecibidoState;
import co.edu.unicauca.interfaces.ProjectState;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class Project {

    private String id;    
    private String nitEmpresa;
    private String nombre;
    private String resumen;
    private String descripcion;
    private String objetivo;
    private String TiempoMaximo;
    private String presupuesto;
    private String FechaEntregadaEsperada;
    private ProjectState estado;
    private String nombreEmpresa;

    public Project() {
        this.estado = new RecibidoState(); // Estado inicial del proyecto
    }
    
    public Project(String nombre, String resumen, String descripcion, String objetivo, String tiempo, String presupuesto, String fecha, String ide, String nitEmpresa_) {
        this.id = ide;
        this.nitEmpresa = nitEmpresa_;
        this.nombre = nombre;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.TiempoMaximo = tiempo;
        this.presupuesto = presupuesto;
        this.FechaEntregadaEsperada = fecha;
        this.estado = new RecibidoState(); // Estado inicial
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Project(Project pro) {
        setId(pro.getId());
        setNitEmpresa(pro.getNitEmpresa());
        setNombre(pro.getNombre());
        setDescripcion(pro.getDescripcion());
        setObjetivo(pro.getObjetivo());
        setTiempoMaximo(pro.getTiempoMaximo());
        setFechaEntregadaEsperada(pro.getFechaEntregadaEsperada());
        setEstado(pro.getEstado());
        setNombreEmpresa(pro.getNombreEmpresa());
        
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getResumen() {
        return resumen;
    }
    
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getObjetivo() {
        return objetivo;
    }
    
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    public String getTiempoMaximo() {
        return TiempoMaximo;
    }
    
    public void setTiempoMaximo(String TiempoMaximo) {
        this.TiempoMaximo = TiempoMaximo;
    }
    
    public String getPresupuesto() {
        return presupuesto;
    }
    
    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    public String getFechaEntregadaEsperada() {
        return FechaEntregadaEsperada;
    }
    
    public void setFechaEntregadaEsperada(String fecha) {
        this.FechaEntregadaEsperada = fecha;
    }
    
    public ProjectState getEstado() {
        return estado;
    }
    
    public void setEstado(ProjectState estado) {
        this.estado = estado;
    }
    
    public String getNitEmpresa() {
        return nitEmpresa;
    }
    
    public void setNitEmpresa(String nit) {
        this.nitEmpresa = nit;
    }

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = this.estado.cambiarEstado(nuevoEstado);
    }

    public List<String> obtenerOpcionesEstado() {
        return this.estado.obtenerOpcionesEstado();
    }

    public String getEstadoActual() {
        return estado.toString(); // Devuelve el nombre del estado actual
    }
}
