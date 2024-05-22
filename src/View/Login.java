package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtusername;
	public JPasswordField txtpassword;
	public JButton btnlogin;
	public JButton btnclose;

	public Login()
	{
		init();
	}
	
	public void init() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 102));
		panel_1.setForeground(new Color(255, 255, 255));
		panel.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/img/logocaffe.jpg")));
		
		JLabel lblNewLabel_4 = new JLabel("Coffee Place\r\n");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Snap ITC", Font.BOLD, 30));
		
		JLabel lblNewLabel_5 = new JLabel("Copyright © Caffe place 140 Le Trong Tan");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(74)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addComponent(lblNewLabel_5)
					.addGap(34))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(0, 102, 102));
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 32));
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Passoword:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		
		btnlogin = new JButton("Login");
		btnlogin.setBackground(new Color(0, 102, 102));
		btnlogin.setForeground(new Color(255, 255, 255));
		btnlogin.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		btnclose = new JButton("Close");
		btnclose.setBackground(new Color(0, 102, 102));
		btnclose.setForeground(new Color(255, 255, 255));
		btnclose.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		txtpassword = new JPasswordField();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(27)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpassword, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(btnlogin)
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addComponent(btnclose))
						.addComponent(txtusername, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
					.addGap(69))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(128)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(86)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtusername, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(42)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnclose)
						.addComponent(btnlogin))
					.addContainerGap(148, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
