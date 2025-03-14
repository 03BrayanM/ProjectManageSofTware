package co.edu.unicauca.domain.services;

import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.interfaces.IRepository;
import co.edu.unicauca.domain.entities.Student;
import co.edu.unicauca.interfaces.IProjectObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class StudentService {

    private IRepository repository;
    private final List<IProjectObserver> observadores = new ArrayList<>();

    public StudentService(IRepository repository) {
        this.repository = repository;
    }

    public void agregarObservador(IProjectObserver observador) {
        observadores.add(observador);
    }

    public List<Project> obtenerProyectos() {
        return (List<Project>) (Project) repository.list();
    }

    public boolean registreStudent(Student student) {
        return repository.save(student);
    }

    public Student obtenerEstudiante(String username) {
        return (Student) repository.found(username);
    }

}
