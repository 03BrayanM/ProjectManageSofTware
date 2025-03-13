package co.edu.unicauca.main;

import co.edu.unicauca.access.Factory;
import co.edu.unicauca.domain.services.CompanyService;
import co.edu.unicauca.domain.services.ProjectService;
import co.edu.unicauca.domain.services.UserService;
import co.edu.unicauca.interfaces.IFrameFactory;
import co.edu.unicauca.interfaces.IRepository;
import co.edu.unicauca.view.FrameFactory;
import co.edu.unicauca.view.GUIGestionSofwareCoordination;
import co.edu.unicauca.view.GUILogin;
import co.edu.unicauca.view.GUILoginEmpresa;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
       IRepository userRepository = Factory.getInstance().getRepository("usuario");
       UserService service = new UserService(userRepository);
       IFrameFactory frameFactory = new FrameFactory();
       GUILogin instance = new GUILogin(service, frameFactory);         
       instance.setExtendedState(JFrame.NORMAL);
       instance.setSize(450, 380); // Ajusta el tamaño a 600x400 píxeles
       instance.setLocationRelativeTo(null); // Centrar en pantalla
       instance.setVisible(true);
 }
}