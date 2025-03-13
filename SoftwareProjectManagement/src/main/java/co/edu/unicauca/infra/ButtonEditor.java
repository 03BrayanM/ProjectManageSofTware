
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
                GUIInfoProject instance = new GUIInfoProject(parent, listener,(String)table.getValueAt(row, 0),projectService);
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

    // Método para mostrar los detalles del proyecto en una ventana nueva
    private void mostrarDetalles(String titulo, String empresa, String fechaEntrega, String estado) {
        JFrame frame = new JFrame("Detalles del Proyecto");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        
        panel.add(new JLabel("Título: " + titulo));
        panel.add(new JLabel("Empresa: " + empresa));
        panel.add(new JLabel("Fecha de Entrega: " + fechaEntrega));
        panel.add(new JLabel("Estado: " + estado));

        frame.add(panel);
        frame.setVisible(true);
    }
}
