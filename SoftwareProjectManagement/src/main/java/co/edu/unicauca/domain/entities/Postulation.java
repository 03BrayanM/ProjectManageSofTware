/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.entities;

/**
 *
 * @author RoLoNeGaTiVo
 */
public class Postulation {
    private int codStudent;
    private String codProject;
    private String fecha; 
    
    public Postulation(int codStudent_,String codProject_,String fecha_){
    this.codStudent= codStudent_;
    this.codProject=codProject_;
    this.fecha=fecha_; 
    }



    /**
     * @return the codStudent
     */
    public int getCodStudent() {
        return codStudent;
    }

    /**
     * @param codStudent the codStudent to set
     */
    public void setCodStudent(int codStudent) {
        this.codStudent = codStudent;
    }

    /**
     * @return the codProject
     */
    public String getCodProject() {
        return codProject;
    }

    /**
     * @param codProject the codProject to set
     */
    public void setCodProject(String codProject) {
        this.codProject = codProject;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
