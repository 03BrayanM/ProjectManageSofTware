/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.services;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.IProjectObserver;
import co.edu.unicauca.interfaces.IRepository;
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
        List<Project> proyectos = (List<Project>) (Project) repository.list();
        for (IProjectObserver obs : observadores) {
            obs.actualizarProyectos(proyectos);
        }
    }

    // Método para obtener proyectos
    public List<Project> obtenerProyectos() {

        List<Object> objetos = repository.list(); // Recupera la lista como List<Object>
        List<Project> proyectos = new ArrayList<>(); // Lista para almacenar los proyectos
        for (Object obj : objetos) {               // Convertimos cada Object en Project
            if (obj instanceof Project) {              // Verifica que realmente sea un Project
                proyectos.add((Project) obj);
            }
        }
        return proyectos;
    }

    public boolean saveProject(Project project) {
        return repository.save(project);
    }
}
