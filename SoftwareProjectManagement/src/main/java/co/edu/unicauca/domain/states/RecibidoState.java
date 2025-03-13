/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.states;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.ProjectState;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Yisus
 */
public class RecibidoState implements ProjectState{

    @Override
    public List<String> obtenerOpcionesEstado() {
        return Arrays.asList("ACEPTADO", "RECHAZADO");
    }

    @Override
    public ProjectState cambiarEstado(String nuevoEstado) {
        switch (nuevoEstado) {
            case "ACEPTADO":
                return new EnEjecucionState();  
            case "RECHAZADO":
                return (ProjectState) new RechazadoState();
            default:
                return this; // No cambia si la opción no es válida
        }
    }
     @Override  
     public String toString() {
        return "Recibido";
    }
}
