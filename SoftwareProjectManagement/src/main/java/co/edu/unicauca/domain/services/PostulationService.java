/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.services;

import co.edu.unicauca.domain.entities.Postulation;
import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.IProjectObserver;
import co.edu.unicauca.interfaces.IRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RoLoNeGaTiVo
 */
public class PostulationService {

    private IRepository repository;

    public PostulationService(IRepository repository) {
        this.repository = repository;
    }
    
     public boolean savePostulation(Postulation postulation) {
        return repository.save(postulation);
    }
}
