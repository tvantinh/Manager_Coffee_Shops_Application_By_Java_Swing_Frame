package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnCancel;
	public JButton btnSave;
	public JPanel panel;
	public JPasswordField MKHienTaiField;
	public JPasswordField MKCuField;
	public JPasswordField XacNhanMKField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		 panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change password");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(211, 21, 248, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập mật khẩu mới:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_1.setBounds(62, 175, 178, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập mật khẩu hiện tại:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_1_1.setBounds(62, 116, 178, 20);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nhập lại mật khẩu mới:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel_1_2.setBounds(62, 234, 178, 20);
		panel.add(lblNewLabel_1_2);
		
		 btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBounds(493, 297, 85, 33);
		panel.add(btnCancel);
		
		 btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSave.setBounds(383, 297, 85, 33);
		panel.add(btnSave);
		
		MKHienTaiField = new JPasswordField();
		MKHienTaiField.setBounds(250, 119, 328, 19);
		panel.add(MKHienTaiField);
		
		MKCuField = new JPasswordField();
		MKCuField.setBounds(250, 176, 328, 19);
		panel.add(MKCuField);
		
		XacNhanMKField = new JPasswordField();
		XacNhanMKField.setBounds(250, 237, 328, 19);
		panel.add(XacNhanMKField);
	}
}
