/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.states;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.ProjectState;

/**
 *
 * @author Yisus
 */
public class CerradoState implements ProjectState{

    @Override
    public ProjectState avanzarEstado(Project proyecto) {
        return proyecto.getEstado();
    }

    @Override
    public ProjectState NoAvanzaEstado(Project proyecto) {
        return proyecto.getEstado();
    }

    @Override
    public String getEstado() {
        return "CERRADO";
    }

  
  
}
