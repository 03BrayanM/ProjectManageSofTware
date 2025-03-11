/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.entities;

/**
 *
 * @author Brayan
 */
public class Project {
    private String nitEmpresa;
    private String nombre;// titulo en la bd
    private String resumen;
    private String descripcion;
    private String objetivo;
    private String TiempoMaximo;
    private String presupuesto;
    private String FechaEntregadaEsperada;
    private String estado;
    private String nombreEmpresa;
    
    public Project(){
        
    }

    public Project( String nit, String nombre, String resumen, String descripcion, String objetivo, String tiempo, String presupuesto, String fecha, String estado, String nombreEmpresa) {
        this.nitEmpresa = nit;
        this.nombre = nombre;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.TiempoMaximo = tiempo;
        this.presupuesto = presupuesto;
        this.FechaEntregadaEsperada = fecha;
        this.estado = "Aceptado";
        this.nombreEmpresa = nombreEmpresa;
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

    public void setTiempoMaximo(String tiempo) {
        this.TiempoMaximo = tiempo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

 


    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNit(String nit) {
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
}
