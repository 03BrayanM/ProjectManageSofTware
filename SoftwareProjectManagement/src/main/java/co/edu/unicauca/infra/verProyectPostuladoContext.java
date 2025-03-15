/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.infra;

import co.edu.unicauca.domain.services.ProjectService;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author evers
 */
public class verProyectPostuladoContext implements IButtonContext {

    private JButton button;
    private JTable table;
    private int row;
    private JFrame parent;
    private IFrameEventListener listener;
    private ProjectService projectService;

    public verProyectPostuladoContext(JTable table ,JFrame parent, IFrameEventListener listener, ProjectService projectService) {
        this.table = table;
        this.row = row;
        this.parent = parent;
        this.listener = listener;
        this.projectService = projectService;
    }

    public JTable getTable() {
        return table;
    }

    public int getRow() {
        return row;
    }

    public JFrame getParent() {
        return parent;
    }

    public IFrameEventListener getListener() {
        return listener;
    }

    public ProjectService getProjectService() {
        return projectService;
    }
}
