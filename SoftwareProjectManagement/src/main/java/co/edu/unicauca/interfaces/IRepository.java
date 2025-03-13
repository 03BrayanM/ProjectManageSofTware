package co.edu.unicauca.interfaces;

import co.edu.unicauca.domain.entities.User;
import java.util.List;


public interface IRepository {
    boolean save(Object entity);
    boolean update(Object entity);
    boolean delete(int id);
    List<Object> list();
    User found(String usename);
}
