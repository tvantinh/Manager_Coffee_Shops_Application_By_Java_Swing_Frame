package ViewHelper;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActionPane extends JPanel{

	JButton delete;
	JButton edit;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionPane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(null);
		
		delete = new JButton("");
		
		delete.setIcon(new ImageIcon(ActionPane.class.getResource("/img/trash.png")));
		delete.setBounds(0, 0, 49, 25);
		this.add(delete);
		
		edit = new JButton("");
		edit.setIcon(new ImageIcon(ActionPane.class.getResource("/img/file-edit.png")));
		edit.setBounds(47, 0, 49, 25);
		this.add(edit);
		
	}
	public void initEvent(TableActionEvent event, int row)
	{
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				event.onDelete(row);
			}
		});
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				event.onEdit(row);
			}
		});
	}
}
