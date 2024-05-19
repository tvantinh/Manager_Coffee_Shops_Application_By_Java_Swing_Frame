package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Choice;
import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Object.Employee;
import Object.Order;
import Object.Promotion;

import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BillToPay extends JFrame{
	/**
	 * Create the application.
	 */
	public BillToPay(Employee employee, Promotion promotion,List<Order> listOrder,String netTotal,String total) {
		initialize(employee,promotion,listOrder,netTotal,total);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Employee employee, Promotion promotion,List<Order> listOrder,String netTotal,String total) {
		this.setBounds(100, 100, 450, 549);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("COFFEE @NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(110, 44, 199, 25);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("140 Le Trong Tan, Quan Tan Phu");
		lblNewLabel.setBounds(132, 80, 165, 14);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("hotline: 0339123456");
		lblNewLabel_2.setBounds(162, 96, 105, 14);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("time: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(34, 137, 46, 14);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Serv:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(34, 162, 46, 14);
		this.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Code Bill:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(34, 187, 60, 14);
		this.getContentPane().add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 216, 335, 2);
		this.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(35, 124, 337, 2);
		this.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_6 = new JLabel("Net total:");
		lblNewLabel_6.setBounds(34, 296, 46, 14);
		this.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Total:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(34, 325, 46, 14);
		this.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cash:");
		lblNewLabel_8.setBounds(34, 361, 46, 14);
		this.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Change:");
		lblNewLabel_9.setBounds(34, 386, 46, 14);
		this.getContentPane().add(lblNewLabel_9);
		
		Label changeLabel = new Label();
		changeLabel.setAlignment(Label.RIGHT);
		changeLabel.setBounds(87, 386, 282, 14);
		this.getContentPane().add(changeLabel);
		
		Label netTotalLabel = new Label(netTotal);
		netTotalLabel.setAlignment(Label.RIGHT);
		netTotalLabel.setBounds(86, 296, 282, 14);
		this.getContentPane().add(netTotalLabel);
		
		JLabel totalLabel = new JLabel(total);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		totalLabel.setBounds(86, 316, 279, 33);
		this.getContentPane().add(totalLabel);
		
		JLabel lblNewLabel_11 = new JLabel("Note:");
		lblNewLabel_11.setBounds(34, 233, 37, 14);
		this.getContentPane().add(lblNewLabel_11);
		
		JTextArea noteText = new JTextArea();
		noteText.setBounds(86, 229, 283, 39);
		this.getContentPane().add(noteText);
		
		Date date = new Date();
		SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
		SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-YYYY");
		String timeFormat = tf.format(date);
		String dayFormat = df.format(date);
		
		Label timeLabel = new Label(timeFormat + " - " + dayFormat);
		timeLabel.setAlignment(Label.RIGHT);
		timeLabel.setBounds(83, 137, 286, 14);
		this.getContentPane().add(timeLabel);
		
		Label servLabel = new Label(employee.getTenNhanVien());
		servLabel.setAlignment(Label.RIGHT);
		servLabel.setBounds(83, 162, 286, 14);
		this.getContentPane().add(servLabel);
		
		Label codeBillLabel = new Label("New label");
		codeBillLabel.setAlignment(Label.RIGHT);
		codeBillLabel.setBounds(93, 187, 276, 14);
		this.getContentPane().add(codeBillLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(34, 411, 335, 2);
		this.getContentPane().add(separator_2);
		
		Label label_5 = new Label("Note*: Invoice is only valid during the day!!!");
		label_5.setBounds(34, 419, 211, 14);
		this.getContentPane().add(label_5);
		
		Label label_6 = new Label("Any problems please contact: 0339123456");
		label_6.setBounds(34, 435, 213, 14);
		this.getContentPane().add(label_6);
		
		Label label_7 = new Label("Thanks You. Please visit us agin.");
		label_7.setBounds(114, 456, 166, 15);
		this.getContentPane().add(label_7);
		
		Button Paybtn = new Button("Pay");
		Paybtn.setBounds(299, 480, 70, 22);
		this.getContentPane().add(Paybtn);
		
		Button cancelbtn = new Button("cancel");
		cancelbtn.setBounds(202, 481, 70, 22);
		this.getContentPane().add(cancelbtn);
		
		JComboBox cashCombobBox = new JComboBox();
		cashCombobBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Không cần xử lý khi combobox nhận focus
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Kiểm tra xem người dùng có nhập dữ liệu vào combobox không khi mất focus
                String text = cashCombobBox.getEditor().getItem().toString();
                if (text.isEmpty()) {
                    JOptionPane.showInputDialog("Combobox không được để trống!");
                } else {
                    if(cashCombobBox.getSelectedItem().toString().matches("[0-9]+"))
                    {
                    	JOptionPane.showInputDialog("Combobox không được để trống!");
                    }
                }
            }
        });
		cashCombobBox.setModel(new DefaultComboBoxModel(new String[] {"10000", "20000", "50000", "100000", "200000", "500000"}));
		cashCombobBox.setEditable(true);
		cashCombobBox.setBounds(86, 358, 283, 22);
		this.getContentPane().add(cashCombobBox);
		
		Label labele = new Label("discount: ");
		labele.setBounds(32, 274, 46, 16);
		this.getContentPane().add(labele);
		
		Label discountLabel = new Label(promotion.getNoiDung());
		discountLabel.setAlignment(Label.RIGHT);
		discountLabel.setBounds(87, 276, 282, 14);
		this.getContentPane().add(discountLabel);
	}
}
