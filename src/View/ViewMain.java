package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import ModelApp.Object.Employee;
import ModelApp.Object.TypeProduct;
import TableModel.BillTableModel;
import TableModel.CustomerTableModel;
import TableModel.EmployeeTableModel;
import TableModel.ProductTableModel;
import TableModel.PromotionTableModel;
import TableModel.TypeInventoryTableModel;
import TableModel.TypeProductTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class ViewMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JLabel timeLabel = new JLabel();
	private Image img = new ImageIcon(ViewMain.class.getResource("/img/Logo.png")).getImage().getScaledInstance(137, 80,
			Image.SCALE_SMOOTH);
	private Image findImg = new ImageIcon(ViewMain.class.getResource("/img/loupe.png")).getImage().getScaledInstance(24,
			24, Image.SCALE_SMOOTH);
	private Image avataDemo = new ImageIcon(ViewMain.class.getResource("/img/avataDemo.jpg")).getImage()
			.getScaledInstance(68, 109, Image.SCALE_SMOOTH);
	public JTextField searchTypeProductTextField;
	public JTextField searchTypeInventoryTextField;
	public JTextField IDTypeProductTextField;
	public JTextField IDTypeInventoryTextField;
	public JTextField nameTypeProductTextField;
	public JTextField nameTypeInventoryTextField;
	public JTextField searchProductTextField;
	public JTextField searchInventoryTextField;
	public JTextField IDProductTextField;
	public JTextField IDInventoryTextField;
	public JTextField nameProductTextField;
	public JTextField nameInventoryTextField;
	public JTextField priceProductTextField;
	public JTextField priceInventoryTextField;
	public JTextField txtnd;
	public JTextField txtidbill;
	public JTextField txtgiamgia;
	public JTextField txtdate;
	public JTextField txtngaybd;
	public JTextField txttotal;
	public JTextField txtngaykt;
	public JTextField txtemp;
	public JTextField txtcus;
	public JTextField txtidpromotion;
	public JTextField txtnote;
	public JButton btnadd;
	public JButton btnupdate;
	public JButton btnxoa;
	public JTextField txttim;
	public JButton btnTim;
	public JTextField txtid;
	// khai bao cho employee
	public JTextField employeePhoneFind;
	public JTextField employeeNameFind;
	public JTextField employeeDateField1;
	public JTextField employeeNameField;
	public JTextField employeeIDField;
	public JTextField employeePhoneField;
	public JTextField employeeCCCDField;
	public JDateChooser employeeDateField;
	public JTable employeeTable;
	public JComboBox cboPositionEmployee;
	public JButton createEmployeeButton;
	public JButton btnFind;
	public JButton btnReset;
	public JButton btnDeleteEmployee;
	public JButton btnUpdateEmployee;
	public JButton btnChangePassword;
	public JButton logoutButton;
	public Employee em = new Employee();

	// KHAI BÁO CUSTOMER
	public JButton btnAddCustomer;
	public JButton btnFindCustomer;
	public JButton btnResetCustomer;
	public JTextField customerNameFind;
	public JTextField customerPhoneFind;
	public JTextField customerIDField;
	public JTextField customerNameField;
	public JTextField customerEmailField;
	public JTextField customerPhoneField;
	public JTextField customerAddressField;
	public JButton btnDeleteCustomer;
	public JButton btnUpdateCustomer;

	//
	public JLabel searchTypebtn;
	public JButton resetTypeProductbtn;
	public JButton createTypeProductbtn;
	public JButton resetProductbtn;
	public JButton updateProductChoosebtn;
	public JComboBox<String> UnitProductComboBox;
	public JComboBox<TypeProduct> typeProductComboBox;
	public JLabel searchProductbtn;

	public JPanel Type_panel;
	public JPanel Product_panel;

	public JButton updateTypeChoosebtn;
	public JButton deleteTypeProductchoosebtn;
	public JButton deleteProductChoosebtn;
	public JButton createProductbtn;

	public JLabel nameEmployeeLabel;
	public JLabel castLabel;
	public JLabel VATLabel;
	public JLabel totalLabel;
	public JButton payBillOrderButton;
	public JTable productTable = new JTable();
	public JTable typeProductTable = new JTable();
	public JTable typeInventoryTable = new JTable();
	public JTable customerTable = new JTable();
	public JTable promotionTable = new JTable();

	public JTable billTable = new JTable();

	public JTabbedPane productsTabed = new JTabbedPane(JTabbedPane.BOTTOM);
	public JTable tableOrder;
	public JPanel componentOfBillPanel;
	public DefaultTableModel OrdertableModel = new DefaultTableModel();
	public JTextField GiaUpSizeTextField;

	public ViewMain(Employee em) {

		this.em = em;
		initialize();
		setTime();
	}

	private void initialize() {
		new JFrame();
		setSize(1440, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		///// menu bar
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
		setJMenuBar(menuBar);

		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(255, 255, 255));
		northPanel.setLayout(new BorderLayout());
		JLabel logoLabel = new JLabel(new ImageIcon(img));
		logoLabel.setBackground(new Color(255, 255, 255));
		logoLabel.setForeground(new Color(0, 0, 0));
		northPanel.add(logoLabel, BorderLayout.WEST);
		getContentPane().add(northPanel, BorderLayout.NORTH);

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

		nameEmployeeLabel = new JLabel("Hello: @Name");
		nameEmployeeLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 24));
		nameEmployeeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		panel_1.add(nameEmployeeLabel);

		timeLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		timeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		panel_1.add(timeLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel newOrderPanelTab = newOrderPanelTab();
		tabbedPane.addTab("ORDER", null, newOrderPanelTab, null);
		JPanel productsPanelTab = productsPanelTab();
		tabbedPane.addTab("PRODUCTS", null, productsPanelTab, null);
		JPanel statisticPanelTab = statisticPanelTab();
		tabbedPane.addTab("STATISTIC", null, statisticPanelTab, null);
		JPanel promotionPanelTab = promotionPanelTab();
		tabbedPane.addTab("PROMOTION", null, promotionPanelTab, null);

		JPanel employeePanelTab = employeePanelTab();
		JPanel employeePanelTab1 = noneEmployeePanelTab();
		if (em.getIDChucVu().trim().equals("CV001")) {
			tabbedPane.addTab("EMPLOYEE", null, employeePanelTab, null);
		} else {
			tabbedPane.addTab("EMPLOYEE", null, employeePanelTab1, null);
		}

		JPanel customerPanelTab = customerPanelTab();
		tabbedPane.addTab("CUSTOMER", null, customerPanelTab, null);
		JPanel accountPanelTab = accountPanelTab();
		tabbedPane.addTab("ACCOUNT", null, accountPanelTab, null);

		/// menu Panel
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(192, 192, 192));
		menuPanel.setLayout(new GridLayout(0, 1));

		JLabel newOrderLabel = new JLabel("NEW ORDER");
		newOrderLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		newOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newOrderLabel.setFont(new Font("Arial", Font.BOLD, 16));
		menuPanel.add(newOrderLabel);
		JLabel productLabel = new JLabel("PRODUCTS");
		productLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		productLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(productLabel);
		JLabel statictisLabel = new JLabel("STATISTICS");
		statictisLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		statictisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statictisLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(statictisLabel);
		JLabel promotionLabel = new JLabel("PROMOTION");
		promotionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		promotionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		promotionLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(promotionLabel);
		JLabel manageLabel = new JLabel("EMPLOYEE");
		manageLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		manageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		manageLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(manageLabel);
		JLabel customerLabel = new JLabel("CUSTOMER");
		customerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(customerLabel);
		JLabel accountLabel = new JLabel("ACCOUNT");
		accountLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(accountLabel);
		logoutButton = new JButton("Log out");
		logoutButton.setIcon(new ImageIcon(ViewMain.class.getResource("/img/logout.png")));
		logoutButton.setBackground(new Color(255, 255, 255));
		logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
		logoutButton.setFont(new Font("Arial", Font.ITALIC, 20));
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuPanel.add(logoutButton);

		getContentPane().add(menuPanel, BorderLayout.WEST);
	}

	public void setTime() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);

					} catch (Exception e) {
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

	public void setComboBoxTypeProduct(List<TypeProduct> list) {

		for (TypeProduct i : list) {
			typeProductComboBox.addItem(i);
		}
	}

	// set data table default
	public void setDataTableProduct(ProductTableModel productTableModel) {
		productTable.setModel(productTableModel);
	}

	public void setDataTableBillHistory(BillTableModel billHistoryTableModel) {
		billTable.setModel(billHistoryTableModel);
	}

	public void setDataTableTypeProduct(TypeProductTableModel typeProductTableModel) {
		typeProductTable.setModel(typeProductTableModel);
	}

	public void setDataTableTypeInventory(TypeInventoryTableModel typeInventoryTableModel) {
		typeInventoryTable.setModel(typeInventoryTableModel);
	}

	public void setDataTableEmployee(EmployeeTableModel employeeTableModel) {
		employeeTable.setModel(employeeTableModel);
	}

	public void setDataTableCustomer(CustomerTableModel customerTableModel) {
		customerTable.setModel(customerTableModel);
	}

	public void setDataTablePromotion(PromotionTableModel promotionTableModel) {
		promotionTable.setModel(promotionTableModel);
	}

	public JPanel newOrderPanelTab() {

		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));

		JPanel paymentsBillPanel = new JPanel();
		orderPanel.add(paymentsBillPanel);
		paymentsBillPanel.setLayout(new BoxLayout(paymentsBillPanel, BoxLayout.X_AXIS));

		componentOfBillPanel = new JPanel();
		componentOfBillPanel.setBackground(new Color(255, 255, 255));
		componentOfBillPanel.setLayout(new GridLayout());
		componentOfBillPanel.setPreferredSize(new Dimension(700, 0));
		paymentsBillPanel.add(componentOfBillPanel);
		String[] COLUMN_NAMES = { "Item Name", "Quantity", "Size", "Note", "Cast", "Action" };
		OrdertableModel = new DefaultTableModel(null, COLUMN_NAMES);
		tableOrder = new JTable(OrdertableModel);
		tableOrder.setRowHeight(25);

		tableOrder.setSurrendersFocusOnKeystroke(true);
		tableOrder.setFillsViewportHeight(true);

		int[] columnWidths = { 35, 5, 5, 30, 10, 10 };
		int tableWidth = tableOrder.getPreferredSize().width;
		for (int i = 0; i < tableOrder.getColumnCount(); i++) {
			TableColumn column = tableOrder.getColumnModel().getColumn(i);
			int width = tableWidth * columnWidths[i] / 100;
			column.setPreferredWidth(width);
		}
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(tableOrder);
		componentOfBillPanel.add(sc);

		JPanel totalsPanel = new JPanel();
		totalsPanel.setBackground(new Color(128, 128, 128));
		paymentsBillPanel.add(totalsPanel);
		totalsPanel.setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		titlePanel.setForeground(new Color(0, 0, 0));
		titlePanel.setBackground(new Color(128, 128, 128));
		totalsPanel.add(titlePanel, BorderLayout.NORTH);

		JLabel title = new JLabel("TOTAL");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Sitka Text", Font.BOLD, 30));
		titlePanel.add(title);
		JPanel toltalPanel = new JPanel();
		toltalPanel.setBackground(new Color(62, 61, 61));
		totalsPanel.add(toltalPanel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Toltal :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));

		JLabel lblNewLabel_2 = new JLabel("Expected VAT (10%) :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));

		JLabel lblNewLabel_3 = new JLabel("vnd");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 19));

		JLabel lblNewLabel_4 = new JLabel("vnd");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 19));

		JLabel lblNewLabel_6 = new JLabel("vnd");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 19));

		castLabel = new JLabel("0");
		castLabel.setForeground(new Color(255, 255, 255));
		castLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		castLabel.setFont(new Font("Arial", Font.PLAIN, 25));

		VATLabel = new JLabel("0");
		VATLabel.setForeground(new Color(255, 255, 255));
		VATLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		VATLabel.setFont(new Font("Arial", Font.PLAIN, 25));

		totalLabel = new JLabel("0");
		totalLabel.setForeground(new Color(255, 255, 255));
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setFont(new Font("Arial", Font.PLAIN, 30));

		JSeparator separator_1 = new JSeparator();
		GroupLayout gl_toltalPanel = new GroupLayout(toltalPanel);
		gl_toltalPanel.setHorizontalGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toltalPanel.createSequentialGroup().addGap(10).addComponent(lblNewLabel).addGap(10)
						.addComponent(castLabel, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE).addGap(29)
						.addComponent(lblNewLabel_4))
				.addGroup(gl_toltalPanel.createSequentialGroup().addGap(10).addComponent(lblNewLabel_2).addGap(10)
						.addComponent(VATLabel, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE).addGap(29)
						.addComponent(lblNewLabel_6))
				.addGroup(gl_toltalPanel.createSequentialGroup().addGap(10).addComponent(separator_1,
						GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_toltalPanel.createSequentialGroup().addGap(26)
						.addComponent(totalLabel, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
						.addGap(29).addComponent(lblNewLabel_3)));
		gl_toltalPanel.setVerticalGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toltalPanel.createSequentialGroup().addGap(11)
						.addGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_toltalPanel.createSequentialGroup().addGap(1).addComponent(lblNewLabel))
								.addComponent(castLabel)
								.addGroup(gl_toltalPanel.createSequentialGroup().addGap(5).addComponent(lblNewLabel_4)))
						.addGap(23)
						.addGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_2)
								.addComponent(VATLabel)
								.addGroup(gl_toltalPanel.createSequentialGroup().addGap(4).addComponent(lblNewLabel_6)))
						.addGap(22)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(13)
						.addGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING).addComponent(totalLabel)
								.addGroup(gl_toltalPanel.createSequentialGroup().addGap(10)
										.addComponent(lblNewLabel_3)))));
		toltalPanel.setLayout(gl_toltalPanel);

		payBillOrderButton = new JButton("PAY");

		payBillOrderButton.setForeground(new Color(255, 255, 255));
		payBillOrderButton.setBackground(new Color(0, 128, 0));
		payBillOrderButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		payBillOrderButton.setBounds(125, 215, 89, 23);
		totalsPanel.add(payBillOrderButton, BorderLayout.SOUTH);

		JPanel productsPanel = new JPanel();
		productsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		productsPanel.setPreferredSize(new Dimension(0, 300));
		productsTabed.setBorder(new TitledBorder(null, "Choose your dish from the menu", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		productsPanel.add(productsTabed);
		orderPanel.add(productsPanel);

		return orderPanel;
	}

	public JPanel productsPanelTab() {
		JPanel productsPanel = new JPanel();
		productsPanel.setLayout(new BoxLayout(productsPanel, BoxLayout.Y_AXIS));

		JPanel typeProductsPanel = new JPanel();
		typeProductsPanel.setBorder(new TitledBorder(null, "type", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		productsPanel.add(typeProductsPanel);
		typeProductsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		JScrollPane TypeProductTable = new JScrollPane();
		TypeProductTable.setViewportView(typeProductTable);
		TypeProductTable.setPreferredSize(new Dimension(0, 100));
		typeProductsPanel.add(TypeProductTable);

		Type_panel = new JPanel();
		Type_panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		typeProductsPanel.add(Type_panel);
		Type_panel.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Search : ");
		lblNewLabel_16.setBounds(10, 50, 46, 14);
		Type_panel.add(lblNewLabel_16);

		searchTypeProductTextField = new JTextField();
		searchTypeProductTextField.setBounds(58, 47, 357, 20);
		Type_panel.add(searchTypeProductTextField);
		searchTypeProductTextField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Update", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(1, 72, 571, 81);
		Type_panel.add(panel_1);
		panel_1.setLayout(null);

		updateTypeChoosebtn = new JButton("update");
		updateTypeChoosebtn.setBounds(472, 43, 89, 23);
		panel_1.add(updateTypeChoosebtn);

		JLabel lblNewLabel_18 = new JLabel("ID :");
		lblNewLabel_18.setBounds(10, 22, 46, 14);
		panel_1.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Type name :");
		lblNewLabel_19.setBounds(10, 47, 67, 14);
		panel_1.add(lblNewLabel_19);

		IDTypeProductTextField = new JTextField();
		IDTypeProductTextField.setEnabled(false);
		IDTypeProductTextField.setBounds(87, 19, 381, 20);
		panel_1.add(IDTypeProductTextField);
		IDTypeProductTextField.setColumns(10);

		nameTypeProductTextField = new JTextField();
		nameTypeProductTextField.setBounds(87, 44, 381, 20);
		panel_1.add(nameTypeProductTextField);
		nameTypeProductTextField.setColumns(10);

		deleteTypeProductchoosebtn = new JButton("delete");
		deleteTypeProductchoosebtn.setBounds(472, 18, 89, 23);
		panel_1.add(deleteTypeProductchoosebtn);

		searchTypebtn = new JLabel("");
		searchTypebtn.setIcon(new ImageIcon(findImg));
		searchTypebtn.setBounds(425, 43, 32, 24);
		Type_panel.add(searchTypebtn);

		resetTypeProductbtn = new JButton("reset");
		resetTypeProductbtn.setBounds(473, 46, 89, 23);
		Type_panel.add(resetTypeProductbtn);

		createTypeProductbtn = new JButton("Create Type");
		createTypeProductbtn.setBounds(458, 11, 104, 23);
		Type_panel.add(createTypeProductbtn);

		JButton newTypebtn = new JButton("New Type");
		newTypebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDTypeProductTextField.setText("");
				nameTypeProductTextField.setText("");
			}
		});
		newTypebtn.setBounds(357, 11, 89, 23);
		Type_panel.add(newTypebtn);

		JPanel productPanel = new JPanel();
		productPanel.setBorder(new TitledBorder(null, "Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		productPanel.setBackground(new Color(255, 255, 255));
		productPanel.setPreferredSize(new Dimension(0, 300));
		productsPanel.add(productPanel);

		productPanel.setLayout(new GridLayout(0, 2, 0, 0));
		JScrollPane ProductTable = new JScrollPane();
		ProductTable.setViewportView(productTable);
		ProductTable.setPreferredSize(new Dimension(0, 150));
		productPanel.add(ProductTable);

		Product_panel = new JPanel();
		Product_panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		productPanel.add(Product_panel);
		Product_panel.setLayout(null);

		JLabel lblNewLabel_16_1 = new JLabel("Search : ");
		lblNewLabel_16_1.setBounds(9, 75, 46, 14);
		Product_panel.add(lblNewLabel_16_1);

		searchProductTextField = new JTextField();
		searchProductTextField.setColumns(10);
		searchProductTextField.setBounds(57, 72, 359, 20);
		Product_panel.add(searchProductTextField);

		searchProductbtn = new JLabel(new ImageIcon(findImg));
		searchProductbtn.setBounds(435, 71, 32, 24);
		Product_panel.add(searchProductbtn);

		resetProductbtn = new JButton("reset");
		resetProductbtn.setBounds(488, 71, 89, 23);
		Product_panel.add(resetProductbtn);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Update", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 140, 575, 200);
		Product_panel.add(panel_1_1);

		updateProductChoosebtn = new JButton("update");
		updateProductChoosebtn.setBounds(468, 168, 89, 23);
		panel_1_1.add(updateProductChoosebtn);

		JLabel lblNewLabel_18_1 = new JLabel("ID Product :");
		lblNewLabel_18_1.setBounds(10, 22, 67, 14);
		panel_1_1.add(lblNewLabel_18_1);

		JLabel lblNewLabel_19_1 = new JLabel("Name  Product :");
		lblNewLabel_19_1.setBounds(10, 47, 77, 14);
		panel_1_1.add(lblNewLabel_19_1);

		IDProductTextField = new JTextField();
		IDProductTextField.setEnabled(false);
		IDProductTextField.setColumns(10);
		IDProductTextField.setBounds(87, 19, 381, 20);
		panel_1_1.add(IDProductTextField);

		nameProductTextField = new JTextField();
		nameProductTextField.setColumns(10);
		nameProductTextField.setBounds(87, 44, 381, 20);
		panel_1_1.add(nameProductTextField);

		JLabel lblNewLabel_19_1_1 = new JLabel("Unit :");
		lblNewLabel_19_1_1.setBounds(10, 75, 67, 14);
		panel_1_1.add(lblNewLabel_19_1_1);

		priceProductTextField = new JTextField();
		priceProductTextField.setColumns(10);
		priceProductTextField.setBounds(87, 105, 381, 20);
		panel_1_1.add(priceProductTextField);

		JLabel lblNewLabel_19_1_2 = new JLabel("Price Product :");
		lblNewLabel_19_1_2.setBounds(10, 108, 77, 14);
		panel_1_1.add(lblNewLabel_19_1_2);

		JLabel lblNewLabel_19_1_3 = new JLabel("Type :");
		lblNewLabel_19_1_3.setBounds(10, 139, 67, 14);
		panel_1_1.add(lblNewLabel_19_1_3);

		UnitProductComboBox = new JComboBox<String>();
		UnitProductComboBox.setModel(new DefaultComboBoxModel(new String[] { "Ly", "Chai", "Cái", "Tô", "Cuốn" }));
		UnitProductComboBox.setBounds(87, 75, 381, 22);
		panel_1_1.add(UnitProductComboBox);

		typeProductComboBox = new JComboBox();
		typeProductComboBox.setBounds(87, 135, 381, 22);
		panel_1_1.add(typeProductComboBox);

		deleteProductChoosebtn = new JButton("delete");
		deleteProductChoosebtn.setBounds(369, 168, 89, 23);
		panel_1_1.add(deleteProductChoosebtn);

		JLabel lblNewLabel_21 = new JLabel("Up Size :");
		lblNewLabel_21.setBounds(10, 172, 46, 14);
		panel_1_1.add(lblNewLabel_21);

		GiaUpSizeTextField = new JTextField();
		GiaUpSizeTextField.setBounds(87, 169, 257, 20);
		panel_1_1.add(GiaUpSizeTextField);
		GiaUpSizeTextField.setColumns(10);

		createProductbtn = new JButton("Create Product");
		createProductbtn.setBounds(488, 23, 89, 23);
		Product_panel.add(createProductbtn);

		JButton newProduct = new JButton("New Product");
		newProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDProductTextField.setText("");
				nameProductTextField.setText("");
				priceProductTextField.setText("");
				GiaUpSizeTextField.setText("");

			}
		});
		newProduct.setBounds(374, 23, 104, 23);
		Product_panel.add(newProduct);
		return productsPanel;
	}

	public JPanel promotionPanelTab() {
		JPanel promotionPanel = new JPanel();
		promotionPanel.setLayout(new GridLayout(0, 2, 0, 0));
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "new promotion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		promotionPanel.add(panel_2);

		JLabel lblNewLabel = new JLabel("ID Promotion:");
		lblNewLabel.setBounds(42, 216, 102, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_1 = new JLabel("Content Promotion:");
		lblNewLabel_1.setBounds(42, 261, 140, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("Discount: (%)");
		lblNewLabel_2.setBounds(42, 308, 100, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("Day Start:");
		lblNewLabel_3.setBounds(42, 353, 71, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_4 = new JLabel("Day End:");
		lblNewLabel_4.setBounds(42, 398, 65, 20);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtnd = new JTextField();
		txtnd.setBounds(243, 254, 347, 27);
		txtnd.setColumns(10);

		txtgiamgia = new JTextField();
		txtgiamgia.setBounds(243, 301, 347, 27);
		txtgiamgia.setColumns(10);

		txtngaybd = new JTextField();
		txtngaybd.setBounds(243, 346, 347, 27);
		txtngaybd.setColumns(10);

		txtngaykt = new JTextField();
		txtngaykt.setBounds(243, 391, 347, 27);
		txtngaykt.setColumns(10);

		txtid = new JTextField();
		txtid.setBounds(243, 209, 347, 27);
		txtid.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(342, 83, 142, 70);
		lblNewLabel_6.setIcon(new ImageIcon(ViewMain.class.getResource("/img/logosale.png")));

		btnadd = new JButton("Add");
		btnadd.setBounds(243, 454, 89, 29);

		btnadd.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnupdate = new JButton("Update");
		btnupdate.setBounds(506, 454, 83, 29);

		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnxoa = new JButton("Delete");
		btnxoa.setBounds(400, 454, 77, 29);

		btnxoa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_6);
		panel_2.add(lblNewLabel);
		panel_2.add(lblNewLabel_1);
		panel_2.add(lblNewLabel_2);
		panel_2.add(lblNewLabel_3);
		panel_2.add(lblNewLabel_4);
		panel_2.add(btnadd);
		panel_2.add(btnxoa);
		panel_2.add(btnupdate);
		panel_2.add(txtngaykt);
		panel_2.add(txtngaybd);
		panel_2.add(txtgiamgia);
		panel_2.add(txtnd);
		panel_2.add(txtid);

		JPanel panel_3 = new JPanel();
		promotionPanel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "List promotion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_5);

		JLabel lblNewLabel_5 = new JLabel("Tìm khuyến mãi");
		lblNewLabel_5.setBounds(71, 93, 115, 20);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_5_1 = new JLabel("Trạng thái");
		lblNewLabel_5_1.setBounds(365, 93, 86, 20);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JScrollPane sc = new JScrollPane();
		sc.setBounds(52, 185, 492, 386);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(sc, popupMenu);

		sc.setViewportView(promotionTable);

		txttim = new JTextField();
		txttim.setBounds(71, 115, 179, 27);
		txttim.setColumns(10);

		btnTim = new JButton("Tìm\r\n");

		btnTim.setBounds(266, 112, 89, 29);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Đang hoạt động", "Không hoạt động" }));
		comboBox.setBounds(366, 115, 178, 27);
		panel_5.setLayout(null);
		panel_5.add(sc);
		panel_5.add(lblNewLabel_5);
		panel_5.add(txttim);
		panel_5.add(btnTim);
		panel_5.add(lblNewLabel_5_1);
		panel_5.add(comboBox);
		return promotionPanel;
	}

	public JPanel noneEmployeePanelTab() {
		JPanel Panel = new JPanel();
		Panel.setLayout(new FlowLayout());
		JLabel lblNewLabel_10 = new JLabel("Bạn không có quyền vào trang này!!!");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Panel.add(lblNewLabel_10);
		return Panel;
	}

	public JPanel statisticPanelTab() {
		JPanel statisticPanel = new JPanel();
		statisticPanel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(billTable);
		scrollPane.setBounds(52, 81, 593, 462);
		statisticPanel.add(scrollPane);

		JLabel lblNewLabel_9 = new JLabel("Sales history:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(42, 50, 95, 20);
		statisticPanel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Invoice details");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(709, 50, 101, 20);
		statisticPanel.add(lblNewLabel_10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(740, 81, 545, 462);
		statisticPanel.add(panel_2);

		JLabel lblNewLabel_20 = new JLabel("ID BiLL:");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20.setBounds(31, 35, 72, 13);
		panel_2.add(lblNewLabel_20);

		JLabel lblNewLabel_20_1 = new JLabel("Date founded:");
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20_1.setBounds(31, 85, 111, 13);
		panel_2.add(lblNewLabel_20_1);

		JLabel lblNewLabel_20_1_1 = new JLabel("Total:");
		lblNewLabel_20_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20_1_1.setBounds(31, 135, 72, 13);
		panel_2.add(lblNewLabel_20_1_1);

		JLabel lblNewLabel_20_1_2 = new JLabel("ID Employee:");
		lblNewLabel_20_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20_1_2.setBounds(31, 189, 101, 13);
		panel_2.add(lblNewLabel_20_1_2);

		JLabel lblNewLabel_20_1_3 = new JLabel("ID Customer:");
		lblNewLabel_20_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20_1_3.setBounds(31, 244, 101, 13);
		panel_2.add(lblNewLabel_20_1_3);

		txtidbill = new JTextField();
		txtidbill.setColumns(10);
		txtidbill.setBounds(142, 34, 199, 19);
		panel_2.add(txtidbill);

		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(142, 84, 199, 19);
		panel_2.add(txtdate);

		txttotal = new JTextField();
		txttotal.setColumns(10);
		txttotal.setBounds(142, 134, 199, 19);
		panel_2.add(txttotal);

		txtemp = new JTextField();
		txtemp.setColumns(10);
		txtemp.setBounds(142, 188, 199, 19);
		panel_2.add(txtemp);

		txtcus = new JTextField();
		txtcus.setColumns(10);
		txtcus.setBounds(142, 243, 199, 19);
		panel_2.add(txtcus);

		JLabel lblNewLabel_20_1_3_1 = new JLabel("ID Promotion");
		lblNewLabel_20_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20_1_3_1.setBounds(31, 296, 94, 18);
		panel_2.add(lblNewLabel_20_1_3_1);

		JLabel lblNewLabel_20_1_3_2 = new JLabel("Note:");
		lblNewLabel_20_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_20_1_3_2.setBounds(31, 343, 72, 13);
		panel_2.add(lblNewLabel_20_1_3_2);

		txtidpromotion = new JTextField();
		txtidpromotion.setColumns(10);
		txtidpromotion.setBounds(142, 295, 199, 19);
		panel_2.add(txtidpromotion);

		txtnote = new JTextField();
		txtnote.setColumns(10);
		txtnote.setBounds(142, 342, 199, 19);
		panel_2.add(txtnote);
		return statisticPanel;
	}

	public JPanel employeePanelTab() {
		JPanel employeePanel = new JPanel();
		employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.Y_AXIS));
		employeePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel findEmployee = new JPanel();
		findEmployee.setBorder(null);
		findEmployee.setPreferredSize(new Dimension(0, 400));
		employeePanel.add(findEmployee);
		findEmployee.setLayout(new BoxLayout(findEmployee, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "FIND",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		findEmployee.add(panel);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(16, 39, 45, 18);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		JLabel lblNewLabel_1 = new JLabel("Phone  number:");
		lblNewLabel_1.setBounds(16, 79, 100, 18);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		employeePhoneFind = new JTextField();
		employeePhoneFind.setBounds(126, 79, 236, 20);
		employeePhoneFind.setColumns(10);

		employeeNameFind = new JTextField();
		employeeNameFind.setBounds(126, 39, 236, 20);
		employeeNameFind.setColumns(10);

		btnFind = new JButton("Find");
		btnFind.setBounds(372, 38, 98, 23);
		btnFind.setBackground(new Color(255, 255, 255));

		btnReset = new JButton("Reset");
		btnReset.setBounds(372, 78, 98, 23);
		btnReset.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel);
		panel.add(employeePhoneFind);
		panel.add(employeeNameFind);
		panel.add(btnReset);
		panel.add(btnFind);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(220, 0));
		panel_1.setBorder(new TitledBorder(null, "UPDATE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		findEmployee.add(panel_1);
		panel_1.setLayout(null);

		btnUpdateEmployee = new JButton("Update");
		btnUpdateEmployee.setBounds(141, 168, 85, 21);
		panel_1.add(btnUpdateEmployee);

		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(88, 28, 45, 13);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(88, 82, 45, 13);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Date of birth:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(88, 124, 79, 13);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Phone number:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(378, 28, 91, 13);
		panel_1.add(lblNewLabel_5);
		JLabel lblNewLabel_6 = new JLabel("CCCD:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(378, 82, 45, 13);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Position:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_7.setBounds(378, 124, 56, 13);
		panel_1.add(lblNewLabel_7);

		employeeDateField = new JDateChooser();
		employeeDateField.setBounds(177, 120, 184, 19);
		employeeDateField.setDateFormatString("yyyy-MM-dd");
		panel_1.add(employeeDateField);

		employeeNameField = new JTextField();
		employeeNameField.setColumns(10);
		employeeNameField.setBounds(177, 78, 184, 19);
		panel_1.add(employeeNameField);

		employeeIDField = new JTextField();
		employeeIDField.setBackground(new Color(255, 255, 255));
		employeeIDField.setEditable(false);
		employeeIDField.setColumns(10);
		employeeIDField.setBounds(177, 24, 184, 19);
		panel_1.add(employeeIDField);

		employeePhoneField = new JTextField();
		employeePhoneField.setColumns(10);
		employeePhoneField.setBounds(479, 24, 173, 19);
		panel_1.add(employeePhoneField);

		employeeCCCDField = new JTextField();
		employeeCCCDField.setColumns(10);
		employeeCCCDField.setBounds(479, 78, 173, 19);
		panel_1.add(employeeCCCDField);

		JLabel lblEmployeeAvatar = new JLabel("");
		lblEmployeeAvatar.setIcon(new ImageIcon(avataDemo));
		lblEmployeeAvatar.setBounds(10, 28, 68, 109);
		panel_1.add(lblEmployeeAvatar);

		createEmployeeButton = new JButton("New employee");
		createEmployeeButton.setBounds(553, 167, 99, 23);
		panel_1.add(createEmployeeButton);
		createEmployeeButton.setBackground(new Color(255, 255, 255));

		btnDeleteEmployee = new JButton("Delete");
		btnDeleteEmployee.setBounds(10, 168, 99, 21);
		panel_1.add(btnDeleteEmployee);

		cboPositionEmployee = new JComboBox();
		cboPositionEmployee.setModel(new DefaultComboBoxModel(new String[] { "Nhân viên", "Quản lý", "" }));
		cboPositionEmployee.setBounds(479, 120, 173, 21);
		panel_1.add(cboPositionEmployee);

		JPanel employeeList = new JPanel();
		employeeList.setBorder(
				new TitledBorder(null, "List of employees", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		employeeList.setPreferredSize(new Dimension(0, 650));
		employeePanel.add(employeeList);
		employeeList.setLayout(new GridLayout(1, 0, 0, 0));
		JScrollPane scrollPane = new JScrollPane();

		// String[] COLUMN_NAMES = {"ID","Name","Date of birth","Phone
		// number","CCCD","Position"};
		// EmployeetableModel = new DefaultTableModel(null, COLUMN_NAMES);
		employeeTable = new JTable();
		scrollPane.setViewportView(employeeTable);
		employeeList.add(scrollPane);

		return employeePanel;
	}

	public JPanel customerPanelTab() {
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.Y_AXIS));
		customerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel findEmployee = new JPanel();
		findEmployee.setBorder(null);
		findEmployee.setPreferredSize(new Dimension(0, 200));
		customerPanel.add(findEmployee);
		findEmployee.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"FIND & ADD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		findEmployee.add(panel);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		JLabel lblNewLabel_1 = new JLabel("Phone  number:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		customerPhoneFind = new JTextField();
		customerPhoneFind.setColumns(10);

		customerNameFind = new JTextField();
		customerNameFind.setColumns(10);

		btnFindCustomer = new JButton("Find");
		btnFindCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnFindCustomer.setBackground(new Color(255, 255, 255));

		btnResetCustomer = new JButton("Reset");
		btnResetCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnResetCustomer.setBackground(new Color(255, 255, 255));

		btnAddCustomer = new JButton("Add");
		btnAddCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAddCustomer.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(customerPhoneFind, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnResetCustomer, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(customerNameFind, GroupLayout.PREFERRED_SIZE, 236,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnFindCustomer,
										GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
				.addComponent(btnAddCustomer, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(customerNameFind, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnFindCustomer).addComponent(btnAddCustomer)))
						.addGap(61)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(customerPhoneFind, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnResetCustomer))
						.addContainerGap(61, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "UPDATE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		findEmployee.add(panel_1);
		panel_1.setLayout(null);

		btnUpdateCustomer = new JButton("Update");
		btnUpdateCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnUpdateCustomer.setBounds(499, 115, 85, 26);
		panel_1.add(btnUpdateCustomer);

		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 28, 45, 13);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 82, 45, 13);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(10, 124, 79, 13);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Phone number:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(310, 31, 91, 13);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(310, 82, 56, 13);
		panel_1.add(lblNewLabel_6);

		customerEmailField = new JTextField();
		customerEmailField.setBounds(99, 118, 184, 19);
		panel_1.add(customerEmailField);
		customerEmailField.setColumns(10);

		customerNameField = new JTextField();
		customerNameField.setColumns(10);
		customerNameField.setBounds(99, 69, 184, 19);
		panel_1.add(customerNameField);

		customerIDField = new JTextField();
		customerIDField.setEditable(false);
		customerIDField.setColumns(10);
		customerIDField.setBounds(99, 25, 184, 19);
		panel_1.add(customerIDField);

		customerPhoneField = new JTextField();
		customerPhoneField.setColumns(10);
		customerPhoneField.setBounds(411, 28, 173, 19);
		panel_1.add(customerPhoneField);

		customerAddressField = new JTextField();
		customerAddressField.setColumns(10);
		customerAddressField.setBounds(411, 78, 173, 19);
		panel_1.add(customerAddressField);

		btnDeleteCustomer = new JButton("Delete");
		btnDeleteCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDeleteCustomer.setBounds(392, 115, 85, 26);
		panel_1.add(btnDeleteCustomer);

		JPanel employeeList = new JPanel();
		employeeList.setBorder(
				new TitledBorder(null, "List of customer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		employeeList.setPreferredSize(new Dimension(0, 650));
		customerPanel.add(employeeList);
		employeeList.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		employeeList.add(scrollPane);
		scrollPane.setViewportView(customerTable);
		return customerPanel;
	}

	public JPanel accountPanelTab() {
		JPanel accountPanel = new JPanel();
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

		JLabel nameLabel = new JLabel(em.getTenNhanVien());
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel birthdayLabel = new JLabel(em.getNgaySinh());
		birthdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel positionLabel = new JLabel(em.getIDChucVu());
		positionLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel numberPhoneLabel = new JLabel(em.getSDT());
		numberPhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		btnChangePassword = new JButton("Change password");
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_accountPanelTab = new GroupLayout(accountPanel);
		gl_accountPanelTab.setHorizontalGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_accountPanelTab.createSequentialGroup().addGroup(gl_accountPanelTab
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_accountPanelTab.createSequentialGroup().addGap(482).addComponent(lblNewLabel_13,
								GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_accountPanelTab.createSequentialGroup().addGap(402).addGroup(gl_accountPanelTab
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_accountPanelTab.createSequentialGroup()
										.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 156,
												GroupLayout.PREFERRED_SIZE)
										.addGap(54).addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 459,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_accountPanelTab.createSequentialGroup()
										.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 156,
												GroupLayout.PREFERRED_SIZE)
										.addGap(54).addComponent(birthdayLabel, GroupLayout.PREFERRED_SIZE, 459,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_accountPanelTab.createSequentialGroup()
										.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 156,
												GroupLayout.PREFERRED_SIZE)
										.addGap(54).addComponent(positionLabel, GroupLayout.PREFERRED_SIZE, 459,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_accountPanelTab.createSequentialGroup()
										.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 156,
												GroupLayout.PREFERRED_SIZE)
										.addGap(54).addComponent(numberPhoneLabel, GroupLayout.PREFERRED_SIZE, 459,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(
								gl_accountPanelTab.createSequentialGroup().addGap(736).addComponent(btnChangePassword)))
						.addContainerGap(727, Short.MAX_VALUE)));
		gl_accountPanelTab.setVerticalGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_accountPanelTab.createSequentialGroup().addGap(31)
						.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(97)
						.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_accountPanelTab.createSequentialGroup().addGap(3).addComponent(nameLabel,
										0, 0, Short.MAX_VALUE))
								.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))
						.addGap(20)
						.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_accountPanelTab.createSequentialGroup().addGap(7).addComponent(
										birthdayLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
						.addGap(22)
						.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_accountPanelTab.createSequentialGroup().addGap(3).addComponent(
										positionLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
						.addGap(20)
						.addGroup(gl_accountPanelTab.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_accountPanelTab.createSequentialGroup().addGap(3).addComponent(
										numberPhoneLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
						.addGap(78).addComponent(btnChangePassword).addGap(228)));
		accountPanel.setLayout(gl_accountPanelTab);
		return accountPanel;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
