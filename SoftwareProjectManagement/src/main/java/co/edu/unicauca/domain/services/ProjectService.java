/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.services;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.IProjectObserver;
import co.edu.unicauca.interfaces.IProjectRepository;
import co.edu.unicauca.interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yisus
 */
public class ProjectService {
    private IProjectRepository repository;
    private final List<IProjectObserver> observadores = new ArrayList<>();
    

    public ProjectService(IRepository repository) {
        this.repository = (IProjectRepository)repository;
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
        List<Object> objects = repository.list();
        List<Project> projects = new ArrayList<>();
        for (Object obj : objects) {
            if (obj instanceof Project) {
                projects.add((Project) obj); 
            }
        }
        // Devuelves la lista de Project como List<Object>
        return new ArrayList<>(projects);
    }
    public Project consultarProyecto(String id){
        return this.repository.getProject(id);
    }
    public boolean saveProject(Project project){
      return repository.save(project);
    }
}
