package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Label;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ModelApp.Object.Customer;
import ModelApp.Object.Employee;
import ModelApp.Object.Order;
import ModelApp.Object.Promotion;

import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class BillToPay extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * Create the application.
	 */
	private JLabel changeLabel = new JLabel();
	public JTextField numberPhoneField;
	public JButton useVIPbtn;
	public JComboBox<String> cashComboBox;
	public JButton getCustomer;
	public JLabel nameCustomerLabel;
	public JButton choosePromotion;
	public JLabel percentOfPromotion;
	public Label discountLabel;
	public JButton cancelbtn;
	public JButton Paybtn;
	public JLabel totalLabel;
	public Label timeLabel;
	public JTextArea noteText;
	public Label billNumberLabel;
	public Promotion promotion = new Promotion("KM000","",1,"","");
	public Customer customer = new Customer("KH0VL","","","","","");
	public JButton registerCustomer;
	public BillToPay(Employee employee,List<Order> listOrder,String netTotal) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BillToPay.class.getResource("/img/Logo.png")));
		initialize(employee,listOrder,netTotal);
		
	}

	public int getTotal()
	{
		return Integer.valueOf(totalLabel.getText());
		
	}
	public Promotion getPromotion()
	{
		return promotion;
		
	}
	public void setPromotion(Promotion p)
	{
		promotion = p;
	}
	public void setCustomer(Customer c)
	{
		customer = c;
	}
	public void update(int i1, int i2) {
		int pay = i1 - i2;
		changeLabel.setText(String.valueOf(pay));
	}
	public void setNote(String p)
	{
		noteText.append(p);
	}
	public String getNote()
	{
		return noteText.getText();
		
	}
	private void initialize(Employee employee,List<Order> listOrder,String netTotal) {
		this.setBounds(100, 100, 450, 660);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setTitle("BILL TO PAY");
		JLabel lblNewLabel_1 = new JLabel("COFFEE @NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(105, 11, 199, 25);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("140 Le Trong Tan, Quan Tan Phu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(113, 40, 187, 14);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("hotline: 0339123456");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(143, 56, 118, 14);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("time: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(34, 89, 46, 14);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Serv:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(34, 114, 46, 14);
		this.getContentPane().add(lblNewLabel_4);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 169, 335, 2);
		this.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 75, 337, 2);
		this.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_6 = new JLabel("Net total:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(34, 373, 82, 14);
		this.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Total:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(34, 428, 46, 14);
		this.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cash:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(34, 466, 46, 14);
		this.getContentPane().add(lblNewLabel_8);
		
		
		cashComboBox = new JComboBox<>();
		
		cashComboBox.setModel(new DefaultComboBoxModel(new String[] {"10000", "20000", "50000", "100000", "200000", "500000"}));
		cashComboBox.setEditable(true);
		cashComboBox.setBounds(86, 463, 283, 22);
		this.getContentPane().add(cashComboBox);
		
		JLabel lblNewLabel_9 = new JLabel("Change:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(34, 489, 46, 14);
		this.getContentPane().add(lblNewLabel_9);
		
		
		
		changeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		changeLabel.setBounds(87, 489, 282, 14);
		this.getContentPane().add(changeLabel);
		
		Label netTotalLabel = new Label(netTotal);
		netTotalLabel.setAlignment(Label.RIGHT);
		netTotalLabel.setBounds(122, 373, 246, 14);
		this.getContentPane().add(netTotalLabel);
		
		totalLabel = new JLabel(netTotal);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		totalLabel.setBounds(140, 419, 225, 33);
		this.getContentPane().add(totalLabel);
		
		JLabel lblNewLabel_11 = new JLabel("Note:");
		lblNewLabel_11.setBounds(34, 182, 37, 14);
		this.getContentPane().add(lblNewLabel_11);
		
		noteText = new JTextArea();
		noteText.setBounds(86, 179, 283, 72);
		this.getContentPane().add(noteText);
		
		Date date = new Date();
		SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
		SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-YYYY");
		String timeFormat = tf.format(date);
		String dayFormat = df.format(date);
		
		timeLabel = new Label(timeFormat + " - " + dayFormat);
		timeLabel.setAlignment(Label.RIGHT);
		timeLabel.setBounds(83, 89, 286, 14);
		this.getContentPane().add(timeLabel);
		
		Label servLabel = new Label(employee.getTenNhanVien());
		servLabel.setAlignment(Label.RIGHT);
		servLabel.setBounds(83, 114, 286, 14);
		this.getContentPane().add(servLabel);
		
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(34, 509, 335, 2);
		this.getContentPane().add(separator_2);
		
		Label label_5 = new Label("Note*: Invoice is only valid during the day!!!");
		label_5.setAlignment(Label.CENTER);
		label_5.setBounds(34, 517, 335, 14);
		this.getContentPane().add(label_5);
		
		Label label_6 = new Label("Any problems please contact: 0339123456");
		label_6.setAlignment(Label.CENTER);
		label_6.setBounds(34, 533, 335, 14);
		this.getContentPane().add(label_6);
		
		Label label_7 = new Label("Thanks You. Please visit us agin.");
		label_7.setAlignment(Label.CENTER);
		label_7.setBounds(34, 554, 335, 15);
		this.getContentPane().add(label_7);
		
		Paybtn = new JButton("Pay");
		Paybtn.setBounds(336, 578, 70, 22);
		this.getContentPane().add(Paybtn);
		
		cancelbtn = new JButton("cancel");
		cancelbtn.setBounds(239, 579, 70, 22);
		this.getContentPane().add(cancelbtn);
		
		
		
		Label labele = new Label("Discount: ");
		labele.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		labele.setBounds(34, 393, 60, 16);
		this.getContentPane().add(labele);
		
		discountLabel = new Label("<none>");
		discountLabel.setBounds(107, 395, 148, 14);
		this.getContentPane().add(discountLabel);
		
		JLabel lblNewLabel_10 = new JLabel("Number phone:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(34, 274, 100, 14);
		getContentPane().add(lblNewLabel_10);
		
		numberPhoneField = new JTextField();
		numberPhoneField.setBounds(144, 274, 148, 21);
		getContentPane().add(numberPhoneField);
		numberPhoneField.setColumns(10);
		
		getCustomer = new JButton("Chọn");
		getCustomer.setBounds(302, 274, 67, 21);
		getContentPane().add(getCustomer);
		
		JLabel lblNewLabel_12 = new JLabel("Customers name:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setBounds(34, 312, 116, 14);
		getContentPane().add(lblNewLabel_12);
		
		nameCustomerLabel = new JLabel("...");
		nameCustomerLabel.setBounds(140, 312, 140, 14);
		getContentPane().add(nameCustomerLabel);
		
		registerCustomer = new JButton("Register");
		registerCustomer.setBounds(278, 308, 91, 23);
		getContentPane().add(registerCustomer);
		
		useVIPbtn = new JButton("Use VIP privileges");
		useVIPbtn.setEnabled(false);
		useVIPbtn.setBounds(239, 342, 130, 25);
		getContentPane().add(useVIPbtn);
		
		Label label = new Label("(*) If you use VIP privileges, the ");
		label.setBounds(32, 342, 209, 14);
		getContentPane().add(label);
		
		Label label_1 = new Label("previous promotion will be deleted");
		label_1.setBounds(42, 357, 199, 14);
		getContentPane().add(label_1);
		
		choosePromotion = new JButton("Chọn");
		choosePromotion.setBounds(310, 393, 60, 21);
		getContentPane().add(choosePromotion);
		
		percentOfPromotion = new JLabel("");
		percentOfPromotion.setBounds(258, 394, 46, 14);
		getContentPane().add(percentOfPromotion);
		
		JLabel lblNewLabel_13 = new JLabel("(Including VAT 10%)");
		lblNewLabel_13.setBounds(34, 447, 116, 14);
		getContentPane().add(lblNewLabel_13);
		
		Label label_2 = new Label("Bill Number :");
		label_2.setBounds(32, 141, 62, 14);
		getContentPane().add(label_2);
		
		billNumberLabel = new Label("");
		billNumberLabel.setAlignment(Label.RIGHT);
		billNumberLabel.setBounds(105, 142, 264, 14);
		getContentPane().add(billNumberLabel);
	}
}