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
    
    private String nombre;
    private String resumen;
    private String descripcion;
    private String objetivo;
    private String tiempoMaximo;
    private String presupuesto;
    private String fechaEntregaEsperada;

    public Project(String nombre, String resumen, String descripcion, String objetivo,
            String tiempoMaximo, String presupuesto, String fechaEntregaEsperada,String nitEmpresa) {
        this.nombre = nombre;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.tiempoMaximo = tiempoMaximo;
        this.presupuesto = presupuesto;
        this.fechaEntregaEsperada = fechaEntregaEsperada;
        this.nitEmpresa= nitEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
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
        return tiempoMaximo;
    }

    public void setTiempoMaximo(String tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getFechaEntregaEsperada() {
        return fechaEntregaEsperada;
    }

    public void setFechaEntregaEsperada(String fechaEntregaEsperada) {
        this.fechaEntregaEsperada = fechaEntregaEsperada;
    }

}
