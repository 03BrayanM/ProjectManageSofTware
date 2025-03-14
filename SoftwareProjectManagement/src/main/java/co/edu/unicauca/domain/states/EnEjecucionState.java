/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.states;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.ProjectState;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Yisus
 */
public class EnEjecucionState implements ProjectState {

    @Override
    public List<String> obtenerOpcionesEstado() {
        return Collections.singletonList("CERRADO");
    }

    @Override
    public ProjectState cambiarEstado(String nuevoEstado) {
        if("CERRADO".equals(nuevoEstado)){
        return  new CerradoState();
    }
        return this;
    }
    @Override  
     public String toString() {
        return "En ejecucion";
    }
}
