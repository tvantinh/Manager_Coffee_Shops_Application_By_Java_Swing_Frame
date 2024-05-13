package ViewHelper;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class ButtonEditor extends DefaultCellEditor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableActionEvent event;

    
    public ButtonEditor(TableActionEvent event) 
    {
    	super(new JCheckBox());
    	this.event = event;
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ActionPane action = new ActionPane();
        action.initEvent(event, row);
        return action;
    }

}