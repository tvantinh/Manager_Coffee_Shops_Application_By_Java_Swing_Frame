package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Controller.Controller;
import ModelApp.Model.EmployeeDAO;
import ModelApp.Object.Employee;
import View.Login;
import View.ViewMain;

public class main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				EmployeeDAO employeeDAO = new EmployeeDAO();
				
				Login login = new Login();
				login.setVisible(true);
				login.btnlogin.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {					
						Employee em = new Employee();
						String tk = login.txtusername.getText();
						String mk = String.valueOf(login.txtpassword.getPassword());
							try {
								em = employeeDAO.login(tk, mk);
								if(em == null)
								{
									JOptionPane.showMessageDialog(login, "tài khoản mật khẩu không chính xác!!!");
								}else {
									ViewMain view = new ViewMain(em);
									try {
										new Controller(view,em);
									} catch (Exception ev) {
										// TODO Auto-generated catch block
										ev.printStackTrace();
									}
									view.setVisible(true);
									login.dispose();
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

					}
				});
			}
		});
	}

}
