package co.edu.unicauca.main;

import co.edu.unicauca.access.Factory;
import co.edu.unicauca.interfaces.ICompanyRepository;
import co.edu.unicauca.interfaces.IRepository;
import co.edu.unicauca.domain.services.CompanyService;
import co.edu.unicauca.domain.services.ProjectService;
import co.edu.unicauca.domain.services.StudentService;
import co.edu.unicauca.view.GUILoginEmpresa;
import co.edu.unicauca.view.GUIRegisterStudent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class Main {
    
 public static void main(String[] args) {
     
     
        IRepository serviceRepository = Factory.getInstance().getRepository("company");
        //IRepository studentRepository = Factory.getInstance().getRepository("student");
        IRepository projectRepository = Factory.getInstance().getRepository("project");
        
        CompanyService servicecompany = new CompanyService(serviceRepository);
        //StudentService servicestudent = new StudentService(studentRepository);
        ProjectService serviceProyect = new ProjectService(projectRepository);
        //GUIRegisterStudent instance = new GUIRegisterStudent(servicestudent);
        
        GUILoginEmpresa instance = new GUILoginEmpresa(servicecompany,serviceProyect,"01");
        instance.setVisible(true);
}}