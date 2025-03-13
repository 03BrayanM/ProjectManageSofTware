package co.edu.unicauca.main;

import co.edu.unicauca.access.Factory;
import co.edu.unicauca.domain.services.CompanyService;
import co.edu.unicauca.domain.services.ProjectService;
import co.edu.unicauca.domain.services.StudentService;
import co.edu.unicauca.interfaces.IRepository;
import co.edu.unicauca.view.GUIGestionSottwareStudent;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        IRepository projectRepository = Factory.getInstance().getRepository("project");
        ProjectService serviceProyect = new ProjectService(projectRepository);
        GUIGestionSottwareStudent instance = new GUIGestionSottwareStudent(serviceProyect);
        instance.setExtendedState(JFrame.NORMAL);
        instance.setVisible(true);
    }
}
/*public static void main(String[] args) {
     
     
        //IRepository serviceRepository = Factory.getInstance().getRepository("company");
        IRepository studentRepository = Factory.getInstance().getRepository("student");
        //IRepository projectRepository = Factory.getInstance().getRepository("project");
        
        //CompanyService servicecompany = new CompanyService(serviceRepository);
        StudentService servicestudent = new StudentService(studentRepository);
        //ProjectService serviceProyect = new ProjectService(projectRepository);
        //GUIRegisterStudent instance = new GUIRegisterStudent(servicestudent);
        GUIGestionSottwareStudent instance = new GUIGestionSottwareStudent(servicestudent);
        instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
        instance.setVisible(true);
 }*/

