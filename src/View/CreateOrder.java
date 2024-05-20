package View;


import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

import ModelApp.Object.Order;

import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateOrder extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField quanlityOrder;
	public boolean State;
	private JRadioButton sizeM;
	private Order newOrder;
	private JTextArea noteText;
	private JLabel castLable;
	private JRadioButton sizeL;
	public JButton okeButton;
	public JButton cancelButton;
	public Button upButton;
	public Button downButton;
	/**
	 * Create the application.
	 */
	public CreateOrder(Order order) {
		newOrder = order;
		initialize();
	}

	public Order getOrder()
	{
		Order od = new Order();
		od.setIDSanPham(newOrder.getIDSanPham());
		od.setTenSanPham(newOrder.getTenSanPham());
		od.setGiaBan(newOrder.getGiaBan());
		od.setSoLuong(Integer.parseInt(quanlityOrder.getText()));
		od.setGhichu(noteText.getText());
		od.setSize((sizeM.isSelected() == true ? "M":"L"));
		return od;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void updateQlty(String str)
	{
		int sl = Integer.parseInt(quanlityOrder.getText());
		if(str.equals("+") )
		{
			sl++;
		}else if(str.equals("-") && sl != 0 )
		{
			sl--;
		}
		
		quanlityOrder.setText(String.valueOf(sl));
		int cost = newOrder.getGiaBan() * Integer.parseInt(quanlityOrder.getText());
		castLable.setText(String.valueOf(cost));
	}
	private void initialize() {
		this.setTitle("New Order");
		this.setBounds(100, 100, 503, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));

		this.setVisible(true);
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Product's name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JLabel productName = new JLabel(newOrder.getTenSanPham());
		productName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		panel.add(productName);
		
		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("note: thêm đủ thông tin yêu cầu");
		panel_1.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Quanlity :");
		lblNewLabel_3.setBounds(10, 25, 82, 23);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblNewLabel_4 = new JLabel("Size : ");
		lblNewLabel_4.setBounds(10, 67, 46, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblNewLabel_5 = new JLabel("note :");
		lblNewLabel_5.setBounds(10, 107, 46, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		noteText = new JTextArea();
		noteText.setBounds(100, 107, 377, 76);
		
		okeButton = new JButton("Ok");
		okeButton.setBounds(388, 186, 89, 23);
		cancelButton = new JButton("cancel");
		cancelButton.setBounds(275, 186, 89, 23);
		
		quanlityOrder = new JTextField("1");
		quanlityOrder.setBounds(100, 28, 329, 20);
		quanlityOrder.setColumns(10);
		
		sizeM = new JRadioButton("M");
		sizeM.setSelected(true);
		sizeM.setBounds(101, 65, 39, 23);
		sizeL = new JRadioButton("L");
		sizeL.setBounds(142, 65, 39, 23);
		ButtonGroup G = new ButtonGroup();
		G.add(sizeM);
		G.add(sizeL);
		JLabel lblNewLabel_6 = new JLabel("( chọn size nước )");
		lblNewLabel_6.setBounds(181, 69, 103, 14);
		
		upButton = new Button("+");
		upButton.setBounds(435, 25, 20, 20);
		
		downButton = new Button("-");
		downButton.setBounds(457, 25, 20, 20);
		
		JLabel lblNewLabel_7 = new JLabel("Cast: ");
		lblNewLabel_7.setBounds(294, 67, 46, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		castLable = new JLabel(String.valueOf(newOrder.getGiaBan()));
		castLable.setBounds(347, 69, 46, 14);
		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_3);
		panel_2.add(lblNewLabel_4);
		panel_2.add(lblNewLabel_5);
		panel_2.add(noteText);
		panel_2.add(okeButton);
		panel_2.add(cancelButton);
		panel_2.add(quanlityOrder);
		panel_2.add(sizeM);
		panel_2.add(sizeL);
		panel_2.add(lblNewLabel_6);
		panel_2.add(upButton);
		panel_2.add(downButton);
		panel_2.add(lblNewLabel_7);
		panel_2.add(castLable);
	}

}
