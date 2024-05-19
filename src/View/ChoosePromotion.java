package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Model;
import Object.Promotion;
import TableModel.PromotionTableModel;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoosePromotion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Model model = new Model();
	private PromotionTableModel modelTabel = new PromotionTableModel();
	private Promotion promotionChoose = new Promotion();
	private JLabel titleLablePromotion;
	public boolean State = false;
	public void setDataTablePromotion(List<Promotion> tb) {
		modelTabel.setData(tb);
	}
	public Promotion getPromotionChoosed()
	{
		return promotionChoose;
	}
	public ChoosePromotion() throws SQLException {
		List<Promotion> tb = model.getDataPromotion();
		setDataTablePromotion(tb);
		init();
		this.setVisible(true);
	}
	public void init() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChoosePromotion.class.getResource("/img/logosale.png")));
		setTitle("Choose Promotion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable(modelTabel);
		JScrollPane sc = new JScrollPane();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				promotionChoose = new Promotion(table.getValueAt(r, 0).toString(),table.getValueAt(r, 1).toString(),Integer.parseInt(table.getValueAt(r, 2).toString()),table.getValueAt(r, 3).toString(),table.getValueAt(r, 4).toString());
				titleLablePromotion.setText(promotionChoose.getNoiDung());
			}
		});
		sc.setViewportView(table);
		sc.setBounds(10, 45, 414, 135);
		contentPane.add(sc);
		
		JButton Choosebtn = new JButton("Choose");
		Choosebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State = true;
				dispose();
			}
		});
		Choosebtn.setBounds(335, 227, 89, 23);
		contentPane.add(Choosebtn);
		
		JButton cancelbtn = new JButton("Cancel");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(cancelbtn, "Do you want to exit?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					State = false;
					dispose();
				}
			}
		});
		cancelbtn.setBounds(236, 227, 89, 23);
		contentPane.add(cancelbtn);
		
		JLabel lblNewLabel = new JLabel("Promotion: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 191, 98, 14);
		contentPane.add(lblNewLabel);
		
		titleLablePromotion = new JLabel("");
		titleLablePromotion.setBounds(100, 191, 324, 14);
		contentPane.add(titleLablePromotion);
		
		JLabel lblNewLabel_2 = new JLabel("Choose Promotion ");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 11, 200, 23);
		contentPane.add(lblNewLabel_2);
	}
}
