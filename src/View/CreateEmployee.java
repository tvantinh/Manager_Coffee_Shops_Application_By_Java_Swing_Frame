package View;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;


import ModelApp.Model.DBConnect;
import ModelApp.Model.EmployeeDAO;
import ModelApp.Object.Employee;
import TableModel.EmployeeTableModel;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;



public class CreateEmployee extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField phoneField;
	public JTextField CCCDField;
	public JTextField dob;
	public JTextField nameField;
	public JTextField IDField;
	public JTextField textField_5;
	public ButtonGroup bg;
	public boolean State = false;
	public JDateChooser dateChooser;
	public JDateChooser dateChooser1;
	public JComboBox cboPosition;	
	public JButton btnCancelEmployee;
	public JPanel addEmployee = new JPanel();
	public JPanel avatar = new JPanel();
	public JLabel lblAvatar;
	public JButton btnNewButton;
	public JPanel information;
	public JRadioButton rdoMale;
	public JRadioButton rdoFemale;
	public JButton btnSaveEmployee;
	JLabel lblNewLabel;
	JLabel lblNewLabel_10;
	
	static List<ModelApp.Object.Employee> listEmployee = new ArrayList<>();
	EmployeeDAO employeeTableModel = new EmployeeDAO();
	public JTextField employeeUsernameField;
	public JPasswordField employeePasswordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEmployee frame = new CreateEmployee(listEmployee);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 * @param list 
	 */
	public CreateEmployee(List<ModelApp.Object.Employee> list) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		contentPane.add(addEmployee);
		addEmployee.setLayout(new BoxLayout(addEmployee, BoxLayout.X_AXIS));
		addEmployee.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		addEmployee.add(avatar);
		avatar.setLayout(null);
		
		
		lblAvatar = new JLabel("");
		lblAvatar.setBounds(41, 49, 215, 309);
		avatar.add(lblAvatar);
		
		btnNewButton = new JButton("Upload Image");

		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(94, 387, 120, 47);
		avatar.add(btnNewButton);
		
		information = new JPanel();
		information.setPreferredSize(new Dimension(150, 0));
		addEmployee.add(information);
		information.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee's Information");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 10, 204, 26);
		information.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 59, 45, 13);
		information.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 99, 56, 13);
		information.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of birth:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 138, 99, 13);
		information.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CCCD:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 179, 64, 13);
		information.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone number:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 219, 120, 13);
		information.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sex:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(10, 262, 105, 13);
		information.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Positon:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(10, 305, 99, 13);
		information.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Starting date:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(10, 351, 120, 13);
		information.add(lblNewLabel_9);
		
		phoneField = new JTextField();
		phoneField.setBounds(129, 218, 314, 19);
		information.add(phoneField);
		phoneField.setColumns(10);
		
		CCCDField = new JTextField();
		CCCDField.setColumns(10);
		CCCDField.setBounds(129, 178, 314, 19);
		information.add(CCCDField);
		
		
		dateChooser =  new JDateChooser();
		dateChooser.setBounds(129, 137, 314, 19);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		information.add(dateChooser);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(129, 98, 314, 19);
		information.add(nameField);
		
		IDField = new JTextField();
		IDField.setColumns(10);
		IDField.setBounds(129, 58, 314, 19);
		information.add(IDField);
		
		rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdoMale.setBounds(129, 260, 103, 21);
		information.add(rdoMale);
		
		rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdoFemale.setBounds(246, 260, 103, 21);
		information.add(rdoFemale);
		
		bg = new ButtonGroup();
		bg.add(rdoMale);
		bg.add(rdoFemale);
		
		cboPosition = new JComboBox();
		cboPosition.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên", "Quản lý"}));
		cboPosition.setBounds(129, 303, 314, 21);
		information.add(cboPosition);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		

		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(129, 350, 314, 19);
		dateChooser1.setDateFormatString("yyyy-MM-dd");
		information.add(dateChooser1);
		
		btnSaveEmployee = new JButton("Save");
		btnSaveEmployee.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSaveEmployee.setBounds(252, 496, 84, 40);
		information.add(btnSaveEmployee);	
		
		btnCancelEmployee = new JButton("Cancel");
		btnCancelEmployee.setVisible(true);
		btnCancelEmployee.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancelEmployee.setBounds(359, 496, 84, 40);
		information.add(btnCancelEmployee);
		
		 lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 401, 99, 13);
		information.add(lblNewLabel);
		
		employeeUsernameField = new JTextField();
		employeeUsernameField.setBounds(129, 400, 314, 19);
		information.add(employeeUsernameField);
		employeeUsernameField.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Password:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(10, 459, 99, 13);
		information.add(lblNewLabel_10);
		
		employeePasswordField = new JPasswordField();
		employeePasswordField.setBounds(129, 458, 314, 19);
		information.add(employeePasswordField);
	}
	
	public boolean checkInfo()
	{
		if(IDField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty() || dateChooser.getDate()==null || CCCDField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty() || bg.isSelected(null) || dateChooser1.getDate()==null)
		{
			return false;
		}
		else{
			return true;
		}
	}
}
