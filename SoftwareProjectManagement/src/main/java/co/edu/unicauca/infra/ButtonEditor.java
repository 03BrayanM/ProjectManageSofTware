
package co.edu.unicauca.infra;
import co.edu.unicauca.domain.entities.Project;
import co.edu.unicauca.domain.services.ProjectService;
import co.edu.unicauca.view.GUIInfoProject;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JButton button;
    private JTable table;
    private int row;
    private JFrame parent; 
    private IFrameEventListener listener; 
    private ProjectService projectService;
    public ButtonEditor(JTable table,JFrame parent, IFrameEventListener listener,ProjectService projectService) {
        this.table = table;
        this.projectService=projectService;
        button = new JButton("Ver"); 
        this.parent = parent;
        this.listener = listener;
        // Nueva acción al hacer clic en el botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIInfoProject instance = new GUIInfoProject(parent, listener,(String)table.getValueAt(row, 5),projectService);
                instance.setVisible(true);     
                fireEditingStopped(); // Terminar edición del botón
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return "Ver";
    }

}
