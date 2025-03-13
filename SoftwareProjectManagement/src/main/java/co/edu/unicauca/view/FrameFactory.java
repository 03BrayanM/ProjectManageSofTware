/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.view;

import co.edu.unicauca.access.Factory;
import co.edu.unicauca.domain.entities.User;
import co.edu.unicauca.domain.services.CompanyService;
import co.edu.unicauca.domain.services.ProjectService;
import co.edu.unicauca.domain.services.StudentService;
import co.edu.unicauca.interfaces.ICompanyRepository;
import co.edu.unicauca.interfaces.IFrameFactory;
import co.edu.unicauca.interfaces.IRepository;
import javax.swing.JFrame;

/**
 *
 * @author Brayan
 */
public class FrameFactory implements IFrameFactory {

    @Override
    public JFrame createFrame(User user) {

        switch (user.getRol()) {
            case "ESTUDIANTE":
                IRepository repository1 = Factory.getInstance().getRepository("student");
                StudentService service = new StudentService(repository1);
                return new GUIGestionSottwareStudent(service,user);
            case "COORDINADOR":
                IRepository repository2 = Factory.getInstance().getRepository("project");
                ProjectService projectService = new ProjectService(repository2);
                return new GUIGestionSofwareCoordination(projectService, user);
            case "EMPRESA":
                IRepository repository3 = Factory.getInstance().getRepository("company");
                IRepository repository4 = Factory.getInstance().getRepository("project");
                CompanyService companyService = new CompanyService(repository3);
                ProjectService projectService1 = new ProjectService(repository4);
                return new GUILoginEmpresa(companyService, projectService1, user);
           
            // Agrega otros roles según necesites
            default:
                return null;
        }

    }

}
