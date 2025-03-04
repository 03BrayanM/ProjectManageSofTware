package co.edu.unicauca.controller;

import co.edu.unicauca.model.Company;
import co.edu.unicauca.model.Student;
import java.util.HashMap;
import java.util.Map;
import co.edu.unicauca.interfaces.IGestor;

public class Controler {

    private static Controler instance;
    private Map<String, IGestor> dictionary;

    public Controler() {
        dictionary = new HashMap<>();
        dictionary.put("estudiante", new StudentControler());
        dictionary.put("empresa", new CompanyControler());
    }

    public static Controler getInstance() {

        if (instance == null) {
            instance = new Controler();
        }
        return instance;

    }

    public IGestor getTipoUsuario(String usuario) {

        IGestor result = null;

        if (dictionary.containsKey(usuario)) {
            result = dictionary.get(usuario);
        }

        return result;

    }

}
