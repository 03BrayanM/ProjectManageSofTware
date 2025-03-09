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
    private int id;
    private String nit;
    private int codcor;
    private String nombre;// titulo en la bd
    private String resumen;
    private String descripcion;
    private String objetivo;
    private int tiempo;
    private int presupuesto;
    private String fecha;
    private String estado;
    private String nombreEmpresa;
    
    public Project(){
        
    }

    public Project(int id, String nit, int codcor, String nombre, String resumen, String descripcion, String objetivo, int tiempo, int presupuesto, String fecha, String estado, String nombreEmpresa) {
        this.id = id;
        this.nit = nit;
        this.codcor = codcor;
        this.nombre = nombre;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.tiempo = tiempo;
        this.presupuesto = presupuesto;
        this.fecha = fecha;
        this.estado = estado;
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


    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

 
    public int getId() {
        return id;
    }

 
    public void setId(int id) {
        this.id = id;
    }


    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getCodcor() {
        return codcor;
    }

    public void setCodcor(int codcor) {
        this.codcor = codcor;
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
