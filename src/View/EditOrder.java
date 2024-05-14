package View;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JTextField;

import Object.Order;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class EditOrder extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField quanlityTextField;
	public boolean State;
	private Label costItem;
	private Order ordersucces;
	private JComboBox comboBox;
	private TextArea noteText;
	private Order orderedit;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public EditOrder(Order order) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditOrder.class.getResource("/img/Logo.png")));
		getContentPane().setBackground(new Color(255, 128, 128));
		orderedit = order;
		initialize(order);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void updateQlty(String str,Order order)
	{
		int sl = Integer.parseInt(quanlityTextField.getText());
		if(str.equals("+") )
		{
			sl++;
		}else if(str.equals("-") && sl != 0 )
		{
			sl--;
		}
		
		quanlityTextField.setText(String.valueOf(sl));
		int cost = order.getGiaBan() * Integer.parseInt(quanlityTextField.getText());
		costItem.setText(String.valueOf(cost));
	}
	public Order getOrder()
	{
		ordersucces = new Order();
		ordersucces.setIDSanPham(orderedit.getIDSanPham());
		ordersucces.setTenSanPham(orderedit.getTenSanPham());
		ordersucces.setGiaBan(orderedit.getGiaBan());
		ordersucces.setSoLuong(Integer.parseInt(quanlityTextField.getText()));
		ordersucces.setGhichu(noteText.getText());
		ordersucces.setSize(comboBox.getSelectedItem().toString());
		return ordersucces;
	}
	private void initialize(Order order) {
		this.setBounds(100, 100, 716, 340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setTitle("Edit Item");
		this.setVisible(true);
		JLabel lblNewLabel = new JLabel("UPDATE ITEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(263, 11, 153, 22);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 55, 46, 20);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quanlity :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(250, 55, 82, 20);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("size :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(449, 55, 46, 20);
		this.getContentPane().add(lblNewLabel_3);
		
		noteText = new TextArea();
		noteText.setBounds(63, 103, 613, 160);
		this.getContentPane().add(noteText);
		
		Button cancelButton = new Button("cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(cancelButton, "Do you want to exit?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					State = false;
					dispose();
				}
			}
		});
		cancelButton.setBounds(495, 269, 70, 22);
		this.getContentPane().add(cancelButton);
		
		Button okButton = new Button("ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State = true;
				dispose();
			}
		});
		okButton.setBounds(606, 269, 70, 22);
		this.getContentPane().add(okButton);
		
		Label label = new Label("Note :");
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(10, 103, 46, 20);
		this.getContentPane().add(label);
		
		Label nameItemLabel = new Label(order.getTenSanPham());
		nameItemLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		nameItemLabel.setBounds(55, 55, 191, 20);
		this.getContentPane().add(nameItemLabel);
		
		Label label_2 = new Label("Cost :");
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(542, 55, 46, 20);
		this.getContentPane().add(label_2);
		
		quanlityTextField = new JTextField();
		quanlityTextField.setFont(new Font("Tahoma", Font.ITALIC, 14));
		quanlityTextField.setText(""+order.getSoLuong());
		quanlityTextField.setBounds(330, 55, 46, 20);
		this.getContentPane().add(quanlityTextField);
		quanlityTextField.setColumns(10);
		
		Button upButton = new Button("+");
		upButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateQlty(upButton.getLabel(),order);
			}
		});
		upButton.setBounds(382, 55, 20, 20);
		this.getContentPane().add(upButton);
		
		Button downButton = new Button("-");
		downButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateQlty(downButton.getLabel(),order);
			}
		});
		downButton.setBounds(408, 55, 20, 20);
		this.getContentPane().add(downButton);
		
		costItem = new Label(String.valueOf(order.getGiaBan()));
		costItem.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		costItem.setBounds(589, 55, 62, 20);
		this.getContentPane().add(costItem);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "L"}));
		comboBox.setBounds(495, 56, 41, 20);
		this.getContentPane().add(comboBox);
	}
	
	
}
