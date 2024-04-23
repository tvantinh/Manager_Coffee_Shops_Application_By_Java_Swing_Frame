package homePage;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Home {

	private JFrame frame;

	private JLabel timeLabel = new JLabel();
	private Image img = new ImageIcon(Home.class.getResource("/img/Logo.png")).getImage().getScaledInstance(137, 80,Image.SCALE_SMOOTH);
	private Image findImg = new ImageIcon(Home.class.getResource("/img/loupe.png")).getImage().getScaledInstance(24, 24,Image.SCALE_SMOOTH);
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_2;
	private JTextField txtGi;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
		setTime();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(1440, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		JMenu homeItem = new JMenu("Home");
		menuBar.add(homeItem);
		JMenu manageItem = new JMenu("Manage");
		menuBar.add(manageItem);
		JMenu customerItem = new JMenu("Customer");
		menuBar.add(customerItem);
		JMenu reportsItem = new JMenu("Reports");
		menuBar.add(reportsItem);
		JMenu aboutItem = new JMenu("About");
		menuBar.add(aboutItem);
		frame.setJMenuBar(menuBar);
		
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(255, 255, 255));
		northPanel.setLayout(new BorderLayout());
		JLabel logoLabel = new JLabel(new ImageIcon(img));
		logoLabel.setBackground(new Color(255, 255, 255));
		logoLabel.setForeground(new Color(0, 0, 0));
		northPanel.add(logoLabel,BorderLayout.WEST);
		frame.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		northPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel nameShopLabel = new JLabel("COFFEE @NAME");
		nameShopLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD, 60));
		panel.add(nameShopLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		northPanel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel nameEmployeeLabel = new JLabel("Hello: @Name");
		nameEmployeeLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 24));
		nameEmployeeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		panel_1.add(nameEmployeeLabel);
		
		timeLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		timeLabel.setBorder(BorderFactory.createEmptyBorder(0,0,0,15));
		panel_1.add(timeLabel);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(192, 192, 192));
		menuPanel.setLayout(new GridLayout(0, 1));
		
		JLabel newOrderLabel = new JLabel("NEW ORDER");
		newOrderLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		newOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newOrderLabel.setFont(new Font("Arial", Font.BOLD, 16));
		menuPanel.add(newOrderLabel);
		JLabel productLabel = new JLabel("PRODUCTS");
		productLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(productLabel);
		JLabel inventoryLabel = new JLabel("INVENTORY");
		inventoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(inventoryLabel);
		JLabel statictisLabel = new JLabel("STATISTICS");
		statictisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statictisLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(statictisLabel);
		JLabel promotionLabel = new JLabel("PROMOTION");
		promotionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		promotionLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(promotionLabel);
		JLabel manageLabel = new JLabel("EMPLOYEE");
		manageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		manageLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(manageLabel);
		JLabel accountLabel = new JLabel("ACCOUNT");
		accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(accountLabel);
		JButton logoutButton = new JButton("Log out");
		logoutButton.setIcon(new ImageIcon(Home.class.getResource("/img/logout.png")));
		logoutButton.setBackground(new Color(255, 255, 255));
		logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
		logoutButton.setFont(new Font("Arial", Font.ITALIC, 20));
		logoutButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		menuPanel.add(logoutButton);
		
		frame.getContentPane().add(menuPanel, BorderLayout.WEST);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel newOrderPanelTab = newOrderPanelTab();
		tabbedPane.addTab("ORDER", null, newOrderPanelTab, null);
		JPanel productsPanelTab = productsPanelTab();
		tabbedPane.addTab("PRODUCTS", null, productsPanelTab, null);
		JPanel inventoryPanelTab = new JPanel();
		tabbedPane.addTab("INVENTORY", null, inventoryPanelTab, null);
		JPanel promotionPanelTab = new JPanel();
		tabbedPane.addTab("PROMOTION", null, promotionPanelTab, null);
		JPanel statisticPanelTab = new JPanel();
		tabbedPane.addTab("STATISTIC", null, statisticPanelTab, null);
		JPanel employeePanelTab = new JPanel();
		tabbedPane.addTab("EMPLOYEE", null, employeePanelTab, null);
		JPanel accountPanelTab = new JPanel();
		tabbedPane.addTab("ACCOUNT", null, accountPanelTab, null);
		
		JLabel lblNewLabel_11 = new JLabel("Name :");
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel lblNewLabel_12 = new JLabel("Birthday :");
		lblNewLabel_12.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel lblNewLabel_13 = new JLabel("ACCOUNT  INFOMATION");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_14 = new JLabel("Position :");
		lblNewLabel_14.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel lblNewLabel_15 = new JLabel("Number Phone :");
		lblNewLabel_15.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		JLabel nameLabel = new JLabel("@name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel birthdayLabel = new JLabel("01/01/2000");
		birthdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel positionLabel = new JLabel("@position");
		positionLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel numberPhoneLabel = new JLabel("0123456789");
		numberPhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Change password");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_accountPanelTab = new GroupLayout(accountPanelTab);
		gl_accountPanelTab.setHorizontalGroup(
			gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_accountPanelTab.createSequentialGroup()
					.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_accountPanelTab.createSequentialGroup()
							.addGap(482)
							.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_accountPanelTab.createSequentialGroup()
							.addGap(402)
							.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_accountPanelTab.createSequentialGroup()
									.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_accountPanelTab.createSequentialGroup()
									.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addComponent(birthdayLabel, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_accountPanelTab.createSequentialGroup()
									.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addComponent(positionLabel, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_accountPanelTab.createSequentialGroup()
									.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addComponent(numberPhoneLabel, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_accountPanelTab.createSequentialGroup()
							.addGap(736)
							.addComponent(btnNewButton)))
					.addContainerGap(727, Short.MAX_VALUE))
		);
		gl_accountPanelTab.setVerticalGroup(
			gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_accountPanelTab.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(97)
					.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_accountPanelTab.createSequentialGroup()
							.addGap(3)
							.addComponent(nameLabel, 0, 0, Short.MAX_VALUE))
						.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_accountPanelTab.createSequentialGroup()
							.addGap(7)
							.addComponent(birthdayLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_accountPanelTab.createSequentialGroup()
							.addGap(3)
							.addComponent(positionLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_accountPanelTab.createSequentialGroup()
							.addGap(3)
							.addComponent(numberPhoneLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(78)
					.addComponent(btnNewButton)
					.addGap(228))
		);
		accountPanelTab.setLayout(gl_accountPanelTab);
		
		
		
	}
	public void setTime()
	{
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while(true)
				{
					try {
						Thread.sleep(1000);
						
					}catch(Exception e){
						e.getStackTrace();
					}
					Date date = new Date();
					SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
					SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-YYYY");
					String timeFormat = tf.format(date);
					String dayFormat = df.format(date);
					timeLabel.setText(timeFormat + " - " + dayFormat); 
				}
			}
		}).start();
		
	}
	
	public JPanel newOrderPanelTab()
	{
		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
		
		JPanel paymentsBillPanel = new JPanel();
		orderPanel.add(paymentsBillPanel);
		paymentsBillPanel.setLayout(new BoxLayout(paymentsBillPanel, BoxLayout.X_AXIS));
		
		JPanel componentOfBillPanel = new JPanel();
		componentOfBillPanel.setBackground(new Color(255, 255, 255));
		componentOfBillPanel.setLayout(new GridLayout());
		componentOfBillPanel.setPreferredSize(new Dimension(900,0));
		paymentsBillPanel.add(componentOfBillPanel);
		String headerTable[] = {"Item Name","Quantity","Price", "Discount","Size","Cost"};
		
		DefaultTableModel dt = new DefaultTableModel(null ,headerTable);
		table = new JTable(dt);
		int[] columnWidths = {45,5,15,15,5,15}; 
        int tableWidth = table.getPreferredSize().width;
        for(int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int width = tableWidth * columnWidths[i] / 100;
            column.setPreferredWidth(width);
        }
		JScrollPane  sc = new JScrollPane(table);
		componentOfBillPanel.add(sc);
		
		JPanel totalsPanel = new JPanel();
		totalsPanel.setBackground(new Color(128, 128, 128));
		paymentsBillPanel.add(totalsPanel);
		totalsPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setForeground(new Color(0, 0, 0));
		titlePanel.setBackground(new Color(128, 128, 128));
		totalsPanel.add(titlePanel, BorderLayout.NORTH);
		
		JLabel title = new JLabel("TOLTAL");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Sitka Text", Font.BOLD, 30));
		titlePanel.add(title);
		JPanel toltalPanel = new JPanel();
		toltalPanel.setBackground(new Color(62, 61, 61));
		totalsPanel.add(toltalPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Toltal :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		
		JLabel lblNewLabel_1 = new JLabel("Discount :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		
		JLabel lblNewLabel_2 = new JLabel("VAT :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		
		JLabel lblNewLabel_3 = new JLabel("vnd");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 19));
		
		JLabel lblNewLabel_4 = new JLabel("vnd");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 19));
		
		JLabel lblNewLabel_5 = new JLabel("img");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 23));
		
		JLabel lblNewLabel_6 = new JLabel("vnd");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 19));
		
		JLabel lblNewLabel_7 = new JLabel("0");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 25));
		
		JLabel lblNewLabel_8 = new JLabel("0");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 25));
		
		JLabel lblNewLabel_9 = new JLabel("0");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 25));
		
		JLabel lblNewLabel_10 = new JLabel("0");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_toltalPanel = new GroupLayout(toltalPanel);
		gl_toltalPanel.setHorizontalGroup(
			gl_toltalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toltalPanel.createSequentialGroup()
					.addGroup(gl_toltalPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_toltalPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator))
						.addGroup(Alignment.LEADING, gl_toltalPanel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_toltalPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_toltalPanel.createSequentialGroup()
									.addGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1)
										.addGroup(gl_toltalPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_2)))
									.addGap(284)
									.addGroup(gl_toltalPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_7)
										.addComponent(lblNewLabel_8)
										.addComponent(lblNewLabel_9)))
								.addComponent(lblNewLabel_10))
							.addGap(29)
							.addGroup(gl_toltalPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_6))))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_toltalPanel.setVerticalGroup(
			gl_toltalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toltalPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_toltalPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_7))
					.addGap(19)
					.addGroup(gl_toltalPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_8))
					.addGap(18)
					.addGroup(gl_toltalPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_9)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_toltalPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_10))
					.addGap(33))
		);
		toltalPanel.setLayout(gl_toltalPanel);
		
		JButton payBillOrderButton = new JButton("PAY");
		payBillOrderButton.setForeground(new Color(255, 255, 255));
		payBillOrderButton.setBackground(new Color(0, 128, 0));
		payBillOrderButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		payBillOrderButton.setBounds(125, 215, 89, 23);
		totalsPanel.add(payBillOrderButton, BorderLayout.SOUTH);
		
		
		
		JTabbedPane productsPanel = new JTabbedPane(JTabbedPane.BOTTOM);
		orderPanel.add(productsPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		productsPanel.addTab("New tab", null, scrollPane, null);
		productsPanel.setPreferredSize(new Dimension(0,300));
		return orderPanel;
	}
	public JPanel productsPanelTab()
	{
		JPanel productsPanel = new JPanel();
		productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));
		
		JPanel typeProductsPanel = new JPanel();
		typeProductsPanel.setBorder(new TitledBorder(null, "type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		productsPanel.add(typeProductsPanel);
		
		table_1 = new JTable();
		String nameColumns[] = {"ID","Type name", "",""};
		DefaultTableModel dt = new DefaultTableModel(null ,nameColumns);
		typeProductsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		table_1 = new JTable(dt);
		JScrollPane  sc = new JScrollPane(table_1);
		sc.setPreferredSize(new Dimension(0, 100));
		typeProductsPanel.add(sc);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		typeProductsPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("Search : ");
		lblNewLabel_16.setBounds(10, 50, 46, 14);
		panel.add(lblNewLabel_16);
		
		textField = new JTextField();
		textField.setBounds(58, 47, 357, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Update", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(1, 72, 571, 81);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("update");
		btnNewButton_2.setBounds(472, 43, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_18 = new JLabel("ID :");
		lblNewLabel_18.setBounds(10, 22, 46, 14);
		panel_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Type name :");
		lblNewLabel_19.setBounds(10, 47, 67, 14);
		panel_1.add(lblNewLabel_19);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(87, 19, 381, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 44, 381, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(findImg));
		lblNewLabel_17.setBounds(425, 43, 32, 24);
		panel.add(lblNewLabel_17);
		
		JButton btnNewButton_1 = new JButton("reset");
		btnNewButton_1.setBounds(473, 46, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Create Type");
		btnNewButton_1_1_1_1.setBounds(473, 11, 89, 23);
		panel.add(btnNewButton_1_1_1_1);
		
		JPanel productPanel = new JPanel();
		productPanel.setBorder(new TitledBorder(null, "Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		productPanel.setBackground(new Color(255, 255, 255));
		productPanel.setPreferredSize(new Dimension(0, 300));
		productsPanel.add(productPanel);
		
		table_2 = new JTable();
		String nameProductsColumns[] = {"ID","Product name","Unit" ,"Price","describe","",""};
		DefaultTableModel dt2 = new DefaultTableModel(null ,nameProductsColumns);
		productPanel.setLayout(new GridLayout(0, 2, 0, 0));
		table_2 = new JTable(dt2);
		JScrollPane  sc2 = new JScrollPane(table_2);
		sc2.setPreferredSize(new Dimension(0, 150));
		productPanel.add(sc2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		productPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_16_1 = new JLabel("Search : ");
		lblNewLabel_16_1.setBounds(9, 75, 46, 14);
		panel_2.add(lblNewLabel_16_1);
		
		txtGi = new JTextField();
		txtGi.setColumns(10);
		txtGi.setBounds(57, 72, 359, 20);
		panel_2.add(txtGi);
		
		JLabel lblNewLabel_17_1 = new JLabel(new ImageIcon(findImg) );
		lblNewLabel_17_1.setBounds(435, 71, 32, 24);
		panel_2.add(lblNewLabel_17_1);
		
		JButton btnNewButton_1_1 = new JButton("reset");
		btnNewButton_1_1.setBounds(488, 71, 89, 23);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_16_1_1 = new JLabel("Type : ");
		lblNewLabel_16_1_1.setBounds(9, 104, 46, 14);
		panel_2.add(lblNewLabel_16_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(57, 100, 359, 22);
		panel_2.add(comboBox);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Update", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 140, 575, 200);
		panel_2.add(panel_1_1);
		
		JButton btnNewButton_2_1 = new JButton("update");
		btnNewButton_2_1.setBounds(468, 168, 89, 23);
		panel_1_1.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_18_1 = new JLabel("ID Product :");
		lblNewLabel_18_1.setBounds(10, 22, 67, 14);
		panel_1_1.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_19_1 = new JLabel("Name  Product :");
		lblNewLabel_19_1.setBounds(10, 47, 77, 14);
		panel_1_1.add(lblNewLabel_19_1);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(87, 19, 381, 20);
		panel_1_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(87, 44, 381, 20);
		panel_1_1.add(textField_4);
		
		JLabel lblNewLabel_19_1_1 = new JLabel("Unit :");
		lblNewLabel_19_1_1.setBounds(10, 75, 67, 14);
		panel_1_1.add(lblNewLabel_19_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(87, 105, 381, 20);
		panel_1_1.add(textField_6);
		
		JLabel lblNewLabel_19_1_2 = new JLabel("Price Product :");
		lblNewLabel_19_1_2.setBounds(10, 108, 77, 14);
		panel_1_1.add(lblNewLabel_19_1_2);
		
		JLabel lblNewLabel_19_1_3 = new JLabel("Type :");
		lblNewLabel_19_1_3.setBounds(10, 139, 67, 14);
		panel_1_1.add(lblNewLabel_19_1_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ly", "chai", "tui"}));
		comboBox_1.setBounds(87, 75, 381, 22);
		panel_1_1.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(87, 135, 381, 22);
		panel_1_1.add(comboBox_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Create Product");
		btnNewButton_1_1_1.setBounds(488, 23, 89, 23);
		panel_2.add(btnNewButton_1_1_1);
		return productsPanel;
	}
	public JPanel inventoryPanelTab()
	{
		JPanel inventoryPanel = new JPanel();
		return inventoryPanel;
	}
	public JPanel promotionPanelTab()
	{
		JPanel promotionPanel = new JPanel();
		return promotionPanel;
	}
	public JPanel statisticPanelTab()
	{
		JPanel statisticPanel = new JPanel();
		return statisticPanel;
	}
	public JPanel employeePanelTab()
	{
		JPanel employeePanel = new JPanel();
		return employeePanel;
	}
	public JPanel accountPanelTab()
	{
		JPanel accountPanel = new JPanel();
		return accountPanel;
	}
}
