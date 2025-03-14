/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.domain.services;

import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.interfaces.IRepository;
import javax.swing.JOptionPane;

/**
 *
 * @author Brayan
 */
public class UserService {

    private IRepository userRepository;

    public UserService(IRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) {
        User user = (User)userRepository.found(username);        
        if (user == null) {
          
            return null;
        }
        if(verifyPassword(password, user.getContrasenia())) {
            return user;
        } else {
            return null;
            
        }
    }

    private boolean verifyPassword(String rawPassword, String Passwordbd) {
        // Lógica para comparar hash
        return rawPassword.equals(Passwordbd);
    }
}
