/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.interfaces;

import co.edu.unicauca.domain.entities.Project;
import java.util.List;

public interface IProjectRepository extends IRepository{

    List<Object> getProjectsNit(String nit);
    boolean actualizarEstado(Project p);

}
