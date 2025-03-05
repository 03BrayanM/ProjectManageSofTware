package co.edu.unicauca.access;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private static Factory instance;
    private Map<String, IRepository> dictionary;

    private Factory() {
        dictionary = new HashMap<>();
        dictionary.put("company", new CompanyMySQLRepository());
        dictionary.put("student", new StudentMySQLRepository());
        
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public IRepository getRepository(String repository) {
        IRepository repo = dictionary.get(repository.toLowerCase());
        if (repo == null) {
            throw new IllegalArgumentException("No se encontró el repositorio: " + repository);
        }
        return repo;
    }
}
