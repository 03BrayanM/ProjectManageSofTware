package co.edu.unicauca.main;

import co.edu.unicauca.access.Factory;
import co.edu.unicauca.interfaces.ICompanyRepository;
import co.edu.unicauca.interfaces.IRepository;
import co.edu.unicauca.domain.services.CompanyService;
import co.edu.unicauca.domain.services.StudentService;
import co.edu.unicauca.view.GUIRegisterStudent;
import javax.swing.JFrame;
public class Main {
    
 public static void main(String[] args) {
     
     
     
     
      //  IRepository serviceRepository = Factory.getInstance().getRepository("company");
        IRepository studentRepository = Factory.getInstance().getRepository("student");

     //   CompanyService servicecompany = new CompanyService(serviceRepository);
        StudentService servicestudent = new StudentService(studentRepository);
        
        GUIRegisterStudent instance = new GUIRegisterStudent(servicestudent);
        instance.setExtendedState(JFrame.MAXIMIZED_BOTH);
        instance.setVisible(true);
}}