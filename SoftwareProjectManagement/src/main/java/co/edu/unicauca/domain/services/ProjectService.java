/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.services;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.IRepository;

/**
 *
 * @author evers
 */
public class ProjectService {
    
    private IRepository repository;

    
    public ProjectService(IRepository repository) {
        this.repository = repository;
    }

    public boolean saveProject(Project project){
      return repository.save(project);
    }
    
}
