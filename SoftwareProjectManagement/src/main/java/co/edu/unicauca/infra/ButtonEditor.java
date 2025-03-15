
package co.edu.unicauca.infra;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;


public class ButtonEditor <T extends IButtonContext> extends AbstractCellEditor implements TableCellEditor {
    
    private JButton button;
    private JTable table;
    private int row;
    private IButtonAction<T> action;
    private T context;

    public ButtonEditor(JTable table, T context, IButtonAction<T> action, String buttonText) {
        this.table = table;
        this.context = context;
        this.action = action;
        button = new JButton(buttonText);

        button.addActionListener(e -> {
            action.execute(context);
            fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }
}
