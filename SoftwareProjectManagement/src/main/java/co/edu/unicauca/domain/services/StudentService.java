package co.edu.unicauca.domain.services;


import co.edu.unicauca.interfaces.IRepository;
import co.edu.unicauca.domain.entities.Student;


/**
 *
 * @author Brayan
 */
public class StudentService {

    private IRepository repository;

    
    public StudentService(IRepository repository) {
        this.repository = repository;
    }

    public boolean registreStudent(Student student){
      return repository.save(student);
    }
    
    
}
