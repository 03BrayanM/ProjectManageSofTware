package co.edu.unicauca.access;


public interface IRepository {
    boolean save(Object entity);
    boolean update(Object entity);
    boolean delete(int id);
    
}
