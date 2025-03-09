/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.services;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.IProjectObserver;
import co.edu.unicauca.interfaces.IRepository;
import co.edu.unicauca.access.ProyectMySQLRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yisus
 */
public class ProjectService {
    private IRepository repository;
    private final List<IProjectObserver> observadores = new ArrayList<>();
    

    public ProjectService(IRepository repository) {
        this.repository = repository;
    }
     // Método para agregar observadores
    public void agregarObservador(IProjectObserver observador) {
        observadores.add(observador);
    }

    // Método para notificar a los observadores
    private void notificarObservadores() {
        List<Project> proyectos = (List<Project>)(Project)repository.list();
        for (IProjectObserver obs : observadores) {
            obs.actualizarProyectos(proyectos);
        }
    }

    // Método para obtener proyectos
    public List<Project> obtenerProyectos() {
        return (List<Project>)(Project)repository.list();
    }
}
