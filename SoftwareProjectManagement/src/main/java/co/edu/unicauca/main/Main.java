package co.edu.unicauca.main;
import co.edu.unicauca.view.GUILogin;
import javax.swing.JFrame;

public class Main {
<<<<<<< HEAD
    
 public static void main(String[] args) {
     
     
        IRepository serviceRepository = Factory.getInstance().getRepository("company");
        //IRepository studentRepository = Factory.getInstance().getRepository("student");
        IRepository projectRepository = Factory.getInstance().getRepository("project");
        
        CompanyService servicecompany = new CompanyService(serviceRepository);
        //StudentService servicestudent = new StudentService(studentRepository);
        ProjectService serviceProyect = new ProjectService(projectRepository);
        //GUIRegisterStudent instance = new GUIRegisterStudent(servicestudent);
        
        GUILoginEmpresa instance = new GUILoginEmpresa(servicecompany,serviceProyect,"123456789");
