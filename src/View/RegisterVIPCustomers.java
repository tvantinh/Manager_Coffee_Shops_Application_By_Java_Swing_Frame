package View;

import javax.swing.JFrame;

import java.awt.Label;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.Font;
import javax.swing.JTextField;

import ModelApp.Object.Customer;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class RegisterVIPCustomers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField numberPhoneField;
	private JTextField AdressField;
	private JTextField emailField;
	public JButton registerbtn;
	public JButton cancelbtn;

	public JRadioButton getFemalebtn() {
		return femalebtn;
	}

	public void setFemalebtn(JRadioButton femalebtn) {
		this.femalebtn = femalebtn;
	}

	public String RanmdomIDKH() throws NoSuchAlgorithmException {
		StringBuilder str = new StringBuilder();
		str.append(nameField.getText());
		str.append(numberPhoneField.getText());
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(str.toString().getBytes());

		StringBuilder sb = new StringBuilder();
		for (byte b : hash) {
			sb.append(String.format("%02x", b));
		}
		String uniqueID = sb.toString().substring(0, 10);
		return uniqueID;
	}

	public Customer getCustomer() throws NoSuchAlgorithmException {
		if (femalebtn.isSelected())
			return new Customer(RanmdomIDKH(), nameField.getText(), "Nữ", numberPhoneField.getText(),
					AdressField.getText(), emailField.getText());
		return new Customer(RanmdomIDKH(), nameField.getText(), "Nam", numberPhoneField.getText(),
				AdressField.getText(), emailField.getText());
	}

	public JRadioButton getMalebtn() {
		return malebtn;
	}

	public void setMalebtn(JRadioButton malebtn) {
		this.malebtn = malebtn;
	}

	private JRadioButton femalebtn;
	private JRadioButton malebtn;

	public boolean check() {
		if (nameField.getText().trim().equals("") && numberPhoneField.getText().trim().equals(""))
			return false;
		return true;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getNumberPhoneField() {
		return numberPhoneField;
	}

	public void setNumberPhoneField(JTextField numberPhoneField) {
		this.numberPhoneField = numberPhoneField;
	}

	public JTextField getAdressField() {
		return AdressField;
	}

	public void setAdressField(JTextField adressField) {
		AdressField = adressField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public RegisterVIPCustomers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 294);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		Label label = new Label("Register VIP Customers");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 17));
		label.setBounds(0, 10, 434, 22);
		this.getContentPane().add(label);

		Label label_1 = new Label("Name :");
		label_1.setBounds(10, 68, 62, 22);
		this.getContentPane().add(label_1);

		Label label_2 = new Label("sex :");
		label_2.setBounds(10, 96, 38, 22);
		this.getContentPane().add(label_2);

		Label label_3 = new Label("Number Phone :");
		label_3.setBounds(10, 124, 88, 22);
		this.getContentPane().add(label_3);

		Label label_4 = new Label("Adress :");
		label_4.setBounds(10, 152, 62, 22);
		this.getContentPane().add(label_4);

		Label label_5 = new Label("Email :");
		label_5.setBounds(10, 180, 62, 22);
		this.getContentPane().add(label_5);

		nameField = new JTextField();
		nameField.setBounds(104, 70, 298, 20);
		this.getContentPane().add(nameField);
		nameField.setColumns(10);

		numberPhoneField = new JTextField();
		numberPhoneField.setBounds(104, 124, 298, 20);
		this.getContentPane().add(numberPhoneField);
		numberPhoneField.setColumns(10);

		AdressField = new JTextField();
		AdressField.setBounds(104, 152, 298, 20);
		this.getContentPane().add(AdressField);
		AdressField.setColumns(10);

		emailField = new JTextField();
		emailField.setBounds(104, 182, 298, 20);
		this.getContentPane().add(emailField);
		emailField.setColumns(10);

		ButtonGroup gr = new ButtonGroup();
		femalebtn = new JRadioButton("Female");
		femalebtn.setSelected(true);
		femalebtn.setBounds(104, 96, 73, 23);
		gr.add(femalebtn);
		this.getContentPane().add(femalebtn);

		malebtn = new JRadioButton("Male");
		malebtn.setBounds(182, 95, 109, 23);
		gr.add(malebtn);
		this.getContentPane().add(malebtn);

		registerbtn = new JButton("Register");
		registerbtn.setBounds(313, 213, 89, 23);
		this.getContentPane().add(registerbtn);

		cancelbtn = new JButton("Cancel");
		cancelbtn.setBounds(194, 213, 89, 23);
		this.getContentPane().add(cancelbtn);
	}
}
