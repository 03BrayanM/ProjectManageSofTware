package co.edu.unicauca.interfaces;


public interface IRepository {
    boolean save(Object entity);
    boolean update(Object entity);
    boolean delete(int id);
    
}
