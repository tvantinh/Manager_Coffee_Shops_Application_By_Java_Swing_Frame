package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CreateCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel panel;
	private JPanel contentPane;
	public JTextField phoneNumField;
	public JTextField nameField;
	public JTextField idField;
	public JTextField addressField;
	public JTextField emailField;
	public ButtonGroup bg;
	public JButton btnCancel;
	public JButton btnSave;
	public JRadioButton rdoMale;
	public JRadioButton rdoFemale;
	public boolean State = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCustomer frame = new CreateCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer's Information");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(213, 10, 236, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(77, 75, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(77, 131, 71, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sex:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(77, 183, 45, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone number:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(77, 235, 126, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(77, 295, 71, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6.setBounds(77, 356, 71, 13);
		panel.add(lblNewLabel_6);
		
		phoneNumField = new JTextField();
		phoneNumField.setBounds(213, 234, 307, 19);
		panel.add(phoneNumField);
		phoneNumField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(213, 130, 307, 19);
		panel.add(nameField);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(213, 74, 307, 19);
		panel.add(idField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(213, 294, 307, 19);
		panel.add(addressField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(213, 355, 307, 19);
		panel.add(emailField);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBounds(419, 403, 101, 30);
		panel.add(btnCancel);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(302, 403, 101, 30);
		panel.add(btnSave);
		
		rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdoMale.setBounds(217, 181, 103, 21);
		panel.add(rdoMale);
		
		rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdoFemale.setBounds(346, 181, 103, 21);
		panel.add(rdoFemale);
		
		bg = new ButtonGroup();
		bg.add(rdoMale);
		bg.add(rdoFemale);
	}
}
