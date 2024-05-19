package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
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

import Object.Customer;
import Object.Employee;
import Object.Inventory;
import Object.Order;
import Object.Product;
import Object.Promotion;
import Object.TypeInventory;
import Object.TypeProduct;
import TableModel.CustomerTableModel;
import TableModel.EmployeeTableModel;
import TableModel.InventoryTableModel;
import TableModel.ProductTableModel;
import TableModel.PromotionTableModel;
import TableModel.TypeInventoryTableModel;
import TableModel.TypeProductTableModel;
import ViewHelper.ActionPane;
import ViewHelper.ActionPaneRenderer;
import ViewHelper.ButtonEditor;
import ViewHelper.TableActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;

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
	private Image avataDemo =new ImageIcon(ViewMain.class.getResource("/img/avataDemo.jpg")).getImage().getScaledInstance(68,
			109, Image.SCALE_SMOOTH);
	private JTextField searchTypeProductTextField;
	private JTextField searchTypeInventoryTextField;
	private JTextField IDTypeProductTextField;
	private JTextField IDTypeInventoryTextField;
	private JTextField nameTypeProductTextField;
	private JTextField nameTypeInventoryTextField;
	private JTextField searchProductTextField;
	private JTextField searchInventoryTextField;
	private JTextField IDProductTextField;
	private JTextField IDInventoryTextField;
	private JTextField nameProductTextField;
	private JTextField nameInventoryTextField;
	private JTextField priceProductTextField;
	private JTextField priceInventoryTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	Promotion promotion = new Promotion();
	private JLabel castLabel;
	private JLabel discountLabel;
	private JLabel VATLabel;
	private JLabel totalLabel;
	private JTable productTable;
	private JTable typeProductTable;
	private JTable inventoryTable;
	private JTable typeInventoryTable;
	private JTable employeeTable;
	private JTable customerTable;
	private JTable promotionTable;
	
	private ProductTableModel tableModel = new ProductTableModel();
	private TypeProductTableModel typeProductTableModel = new TypeProductTableModel();
	private InventoryTableModel inventoryTableModel = new InventoryTableModel();
	private TypeInventoryTableModel typeInventoryTableModel = new TypeInventoryTableModel();
	private EmployeeTableModel employeeTableModel = new EmployeeTableModel();
	private CustomerTableModel customerTableModel = new CustomerTableModel();
	private PromotionTableModel promotionTableModel = new PromotionTableModel();
	private JTabbedPane productsTabed = new JTabbedPane(JTabbedPane.BOTTOM);
	private List<Order> listOrder = new ArrayList<>();
	private JTable tableOrder;

	private DefaultTableModel model = new DefaultTableModel();
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Create the application.
	 */
	public ViewMain() {

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

		JLabel nameEmployeeLabel = new JLabel("Hello: @Name");
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
		JPanel inventoryPanelTab = inventoryPanelTab();
		tabbedPane.addTab("INVENTORY", null, inventoryPanelTab, null);
		JPanel statisticPanelTab = new JPanel();
		tabbedPane.addTab("STATISTIC", null, statisticPanelTab, null);
		JPanel promotionPanelTab = promotionPanelTab();
		tabbedPane.addTab("PROMOTION", null, promotionPanelTab, null);
		JPanel employeePanelTab = employeePanelTab();
		tabbedPane.addTab("EMPLOYEE", null, employeePanelTab, null);
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
		JLabel inventoryLabel = new JLabel("INVENTORY");
		inventoryLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		inventoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(inventoryLabel);
		JLabel statictisLabel = new JLabel("STATISTICS");
		statictisLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		statictisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statictisLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(statictisLabel);
		JLabel promotionLabel = new JLabel("PROMOTION");
		promotionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		promotionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		promotionLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(promotionLabel);
		JLabel manageLabel = new JLabel("EMPLOYEE");
		manageLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		manageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		manageLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(manageLabel);
		JLabel customerLabel = new JLabel("CUSTOMER");
		customerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(customerLabel);
		JLabel accountLabel = new JLabel("ACCOUNT");
		accountLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(7);
			}
		});
		accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountLabel.setFont(new Font("Arial", Font.BOLD, 17));
		menuPanel.add(accountLabel);
		JButton logoutButton = new JButton("Log out");
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

	// set data table default
	public void setDataTableProduct(List<Product> tb) {
		tableModel.setData(tb);
	}

	public void setDataTableTypeProduct(List<TypeProduct> tb) {
		typeProductTableModel.setData(tb);
	}

	public void setDataTableInventory(List<Inventory> tb) {
		inventoryTableModel.setData(tb);
	}

	public void setDataTableTypeInventory(List<TypeInventory> tb) {
		typeInventoryTableModel.setData(tb);
	}
	public void setDataTableEmployee(List<Employee> tb) {
		employeeTableModel.setData(tb);
	}
	public void setDataTableCustomer(List<Customer> tb) {
		customerTableModel.setData(tb);
	}
	public void setDataTablePromotion(List<Promotion> tb) {
		promotionTableModel.setData(tb);
	}
	// load data list Product in Panel
	public void loadPanelOrder(List<TypeProduct> listType, List<Product> listProduct) {
		for (var i : listType) {
			JPanel panel = new JPanel();// Tạo một panel mới để chứa các nút
			panel.setLayout(new FlowLayout());
			int flag = 0;
			for (var ip : listProduct) {
				if (ip.getIDLoaiSP().equals(i.getIDLoaiSP())) {
					JButton btn = new JButton(ip.getTenSanPham());
					btn.setMargin(new Insets(10, 10, 10, 10));
					btn.setPreferredSize(new Dimension(150, 50));
					btn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							Order od = new Order(ip.getIDSanPham(), ip.getTenSanPham(), 1, "M", "", ip.getGiaBan());
							CreateOrder createOrder = new CreateOrder(od);
							createOrder.addWindowListener(new WindowAdapter() {
								public void windowClosed(WindowEvent e) {
									Order newOrder = createOrder.getOrder();
									if(createOrder.State == true)
									{
										addProductToOrder(newOrder, false);
										updatetotal();
									}
									
								}
							});

						}
					});
					panel.add(btn); // Thêm nút vào panel
					flag = 1;
				}
			}

			if (flag == 0) {
				JLabel lblNewLabel = new JLabel("You need more product for this category!!!");
				lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
				panel.add(lblNewLabel); // Thêm label vào panel nếu không có sản phẩm
			}

			JScrollPane scrollPane = new JScrollPane(panel); // Đặt panel vào JScrollPane
			productsTabed.addTab(i.getTenLoai(), null, scrollPane, null);
		}
	}

	
	public void addProductToOrder(Order od, boolean flag) {
		//flag is true == update
		//flag is false == new order
		int row = checkProductinListOrder(od); //get row product in list(true is >= 0) and (false = -1)
		if (flag == true) {
			listOrder.set(row, od);
			int cost = od.getSoLuong() * od.getGiaBan();
			listOrder.get(row).setGiaBan(cost);
			tableOrder.setValueAt(listOrder.get(row).getTenSanPham(), row, 0);
			tableOrder.setValueAt(listOrder.get(row).getSoLuong(), row, 1);
			tableOrder.setValueAt(listOrder.get(row).getSize(), row, 2);
			tableOrder.setValueAt(listOrder.get(row).getGhichu(), row, 3);
			tableOrder.setValueAt(listOrder.get(row).getGiaBan(), row, 4);
			
		} else {
			if (row >= 0 && listOrder.get(row).getSize().equals(od.getSize())) {
				//product is already in the list
				int i = listOrder.get(row).getSoLuong();
				i++;
				int cost = i * od.getGiaBan();
				listOrder.get(row).setSoLuong(i);
				listOrder.get(row).setGiaBan(cost);
				tableOrder.setValueAt(listOrder.get(row).getTenSanPham(), row, 0);
				tableOrder.setValueAt(listOrder.get(row).getSoLuong(), row, 1);
				tableOrder.setValueAt(listOrder.get(row).getSize(), row, 2);
				tableOrder.setValueAt(listOrder.get(row).getGhichu(), row, 3);
				tableOrder.setValueAt(listOrder.get(row).getGiaBan(), row, 4);
			} else {
				//The product is not in the list
				listOrder.add(od);
				Vector<Object> dataRow = new Vector<>();
				dataRow.add(od.getTenSanPham());
				dataRow.add(od.getSoLuong());
				dataRow.add(od.getSize());
				dataRow.add(od.getGhichu());
				dataRow.add(od.getGiaBan());
				ActionPane Pane = new ActionPane();
				dataRow.add(Pane);				
				model.addRow(dataRow);
				ActionPanel(tableOrder,5);
			}
			
			
		}
		
		for (var il : listOrder) {
			System.out.println(il.toString());
		}
		System.out.println("ket thuc");
		tableOrder.setModel(model);
	}

	
	public void ActionPanel(JTable table, int column)
	{
		// create 2 button action  and listener click component
		TableActionEvent event = new TableActionEvent() {
			@Override
			public void onEdit(int row) {
				EditOrder edv = new EditOrder(listOrder.get(row));
				edv.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						Order editedOrder = edv.getOrder();
						if(edv.State == true)
						{
							addProductToOrder(editedOrder, true);
							updatetotal();
						}
					}
				});
			}

			@Override
			public void onDelete(int row) {
				System.out.println("cot + " +row);
				listOrder.remove(row);
				model.removeRow(row);
				updatetotal();
				
				for (var il : listOrder) {
					System.out.println(il.toString());
				}
			}
		};
		table.getColumnModel().getColumn(column).setCellRenderer(new ActionPaneRenderer());// show action Pane
		table.getColumnModel().getColumn(column).setCellEditor(new ButtonEditor(event));
	}
	
	
	
	public int getinfoCast(List<Order> list)
	{
		int cast = 0;
		for(var i : list)
		{
			cast += i.getGiaBan();
		}
		return cast;
	}
	public int getCastPromotion(Promotion p, List<Order> list)
	{
		int cast = 0;
		cast = (int)((p.getGiaGiam()*0.01) * getinfoCast(list));
		return cast;
	}

	
	
	public void updatetotal()
	{
		int ic = getinfoCast(listOrder);
		int ip = getCastPromotion(promotion,listOrder);
		castLabel.setText(String.valueOf(ic));
		discountLabel.setText(String.valueOf(ip));
		int vat = (int) ((ic-ip) * 0.1);
		int total = ic-ip + vat;
		System.out.println(ic +", "+ ip +", "+ total);
		VATLabel.setText(String.valueOf(vat));
		totalLabel.setText(String.valueOf(total));
	}
	public int checkProductinListOrder(Order order) {

		for (var i : listOrder) {
			if (i.getIDSanPham() == order.getIDSanPham()) {

				return listOrder.lastIndexOf(i);
			}
		}
		return -1;
	}

	public JPanel newOrderPanelTab() {
		
		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));

		JPanel paymentsBillPanel = new JPanel();
		orderPanel.add(paymentsBillPanel);
		paymentsBillPanel.setLayout(new BoxLayout(paymentsBillPanel, BoxLayout.X_AXIS));

		JPanel componentOfBillPanel = new JPanel();
		componentOfBillPanel.setBackground(new Color(255, 255, 255));
		componentOfBillPanel.setLayout(new GridLayout());
		componentOfBillPanel.setPreferredSize(new Dimension(900, 0));
		paymentsBillPanel.add(componentOfBillPanel);
		String[] COLUMN_NAMES = { "Item Name", "Quantity", "Size", "Note", "Cast", "Action" };
		model = new DefaultTableModel(null, COLUMN_NAMES);
		tableOrder = new JTable(model);
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

		JLabel lblNewLabel_2 = new JLabel("VAT (10%) :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));

		JLabel lblNewLabel_3 = new JLabel("vnd");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 19));

		JLabel lblNewLabel_4 = new JLabel("vnd");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 19));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ChoosePromotion cp = new ChoosePromotion();
					cp.addWindowListener(new WindowAdapter() {
						public void windowClosed(WindowEvent e) {
							
							if(cp.State == true)
							{
								Promotion p = cp.getPromotionChoosed();
								promotion = p;
								updatetotal();
							}
							
						}
					});
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(ViewMain.class.getResource("/img/subscription-alt.png")));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 23));

		JLabel lblNewLabel_6 = new JLabel("vnd");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 19));

		castLabel = new JLabel("0");
		castLabel.setForeground(new Color(255, 255, 255));
		castLabel.setHorizontalAlignment(SwingConstants.LEFT);
		castLabel.setFont(new Font("Arial", Font.PLAIN, 25));

		discountLabel = new JLabel("0");
		discountLabel.setForeground(new Color(255, 255, 255));
		discountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		discountLabel.setFont(new Font("Arial", Font.PLAIN, 25));

		VATLabel = new JLabel("0");
		VATLabel.setForeground(new Color(255, 255, 255));
		VATLabel.setHorizontalAlignment(SwingConstants.LEFT);
		VATLabel.setFont(new Font("Arial", Font.PLAIN, 25));

		totalLabel = new JLabel("0");
		totalLabel.setForeground(new Color(255, 255, 255));
		totalLabel.setHorizontalAlignment(SwingConstants.LEFT);
		totalLabel.setFont(new Font("Arial", Font.PLAIN, 30));

		JSeparator separator = new JSeparator();
		GroupLayout gl_toltalPanel = new GroupLayout(toltalPanel);
		gl_toltalPanel.setHorizontalGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_toltalPanel
				.createSequentialGroup()
				.addGroup(gl_toltalPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING,
								gl_toltalPanel.createSequentialGroup().addContainerGap().addComponent(separator))
						.addGroup(Alignment.LEADING, gl_toltalPanel.createSequentialGroup().addGap(10)
								.addGroup(gl_toltalPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_toltalPanel.createSequentialGroup()
												.addGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel).addComponent(lblNewLabel_1)
														.addGroup(gl_toltalPanel.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblNewLabel_2)))
												.addGap(284)
												.addGroup(gl_toltalPanel.createParallelGroup(Alignment.TRAILING)
														.addComponent(castLabel).addComponent(discountLabel)
														.addComponent(VATLabel)))
										.addComponent(totalLabel))
								.addGap(29)
								.addGroup(gl_toltalPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_4).addComponent(lblNewLabel_5)
										.addComponent(lblNewLabel_3).addComponent(lblNewLabel_6))))
				.addContainerGap(12, Short.MAX_VALUE)));
		gl_toltalPanel.setVerticalGroup(gl_toltalPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_toltalPanel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_toltalPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4).addComponent(castLabel))
				.addGap(19)
				.addGroup(gl_toltalPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_1).addComponent(discountLabel))
				.addGap(18)
				.addGroup(gl_toltalPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(VATLabel).addComponent(lblNewLabel_6))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE).addGap(40)
				.addGroup(gl_toltalPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
						.addComponent(totalLabel))
				.addGap(33)));
		toltalPanel.setLayout(gl_toltalPanel);

		JButton payBillOrderButton = new JButton("PAY");
		payBillOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println();
				
				
				
			}
		});
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

		typeProductTable = new JTable(typeProductTableModel);
		JScrollPane TypeProductTable = new JScrollPane();
		TypeProductTable.setViewportView(typeProductTable);
		TypeProductTable.setPreferredSize(new Dimension(0, 100));
		typeProductsPanel.add(TypeProductTable);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		typeProductsPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Search : ");
		lblNewLabel_16.setBounds(10, 50, 46, 14);
		panel.add(lblNewLabel_16);

		searchTypeProductTextField = new JTextField();
		searchTypeProductTextField.setBounds(58, 47, 357, 20);
		panel.add(searchTypeProductTextField);
		searchTypeProductTextField.setColumns(10);

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

		IDTypeProductTextField = new JTextField();
		IDTypeProductTextField.setEnabled(false);
		IDTypeProductTextField.setBounds(87, 19, 381, 20);
		panel_1.add(IDTypeProductTextField);
		IDTypeProductTextField.setColumns(10);

		nameTypeProductTextField = new JTextField();
		nameTypeProductTextField.setBounds(87, 44, 381, 20);
		panel_1.add(nameTypeProductTextField);
		nameTypeProductTextField.setColumns(10);

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

		productPanel.setLayout(new GridLayout(0, 2, 0, 0));
		JScrollPane ProductTable = new JScrollPane();
		productTable = new JTable(tableModel);
		ProductTable.setViewportView(productTable);
		ProductTable.setPreferredSize(new Dimension(0, 150));
		productPanel.add(ProductTable);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		productPanel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_16_1 = new JLabel("Search : ");
		lblNewLabel_16_1.setBounds(9, 75, 46, 14);
		panel_2.add(lblNewLabel_16_1);

		searchProductTextField = new JTextField();
		searchProductTextField.setColumns(10);
		searchProductTextField.setBounds(57, 72, 359, 20);
		panel_2.add(searchProductTextField);

		JLabel lblNewLabel_17_1 = new JLabel(new ImageIcon(findImg));
		lblNewLabel_17_1.setBounds(435, 71, 32, 24);
		panel_2.add(lblNewLabel_17_1);

		JButton btnNewButton_1_1 = new JButton("reset");
		btnNewButton_1_1.setBounds(488, 71, 89, 23);
		panel_2.add(btnNewButton_1_1);

		JLabel lblNewLabel_16_1_1 = new JLabel("Type : ");
		lblNewLabel_16_1_1.setBounds(9, 104, 46, 14);
		panel_2.add(lblNewLabel_16_1_1);

		JComboBox searchTypeProductComboBox = new JComboBox();
		searchTypeProductComboBox.setBounds(57, 100, 359, 22);
		panel_2.add(searchTypeProductComboBox);

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

		JComboBox UnitProductTextField = new JComboBox();
		UnitProductTextField.setModel(new DefaultComboBoxModel(new String[] { "ly", "chai", "tui" }));
		UnitProductTextField.setBounds(87, 75, 381, 22);
		panel_1_1.add(UnitProductTextField);

		JComboBox typeProductComboBox = new JComboBox();
		typeProductComboBox.setBounds(87, 135, 381, 22);
		panel_1_1.add(typeProductComboBox);

		JButton btnNewButton_1_1_1 = new JButton("Create Product");
		btnNewButton_1_1_1.setBounds(488, 23, 89, 23);
		panel_2.add(btnNewButton_1_1_1);
		return productsPanel;
	}

	public JPanel inventoryPanelTab() {
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));

		JPanel typeInventoryPanel = new JPanel();
		typeInventoryPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"type Inventory", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inventoryPanel.add(typeInventoryPanel);
		typeInventoryPanel.setLayout(new GridLayout(0, 2, 0, 0));

		typeInventoryTable = new JTable(typeInventoryTableModel);
		JScrollPane sc = new JScrollPane();
		sc.setViewportView(typeInventoryTable);

		sc.setPreferredSize(new Dimension(0, 100));
		typeInventoryPanel.add(sc);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		typeInventoryPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Search : ");
		lblNewLabel_16.setBounds(10, 50, 46, 14);
		panel.add(lblNewLabel_16);

		searchTypeInventoryTextField = new JTextField();
		searchTypeInventoryTextField.setBounds(58, 47, 357, 20);
		panel.add(searchTypeInventoryTextField);
		searchTypeInventoryTextField.setColumns(10);

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

		IDTypeInventoryTextField = new JTextField();
		IDTypeInventoryTextField.setEnabled(false);
		IDTypeInventoryTextField.setBounds(87, 19, 381, 20);
		panel_1.add(IDTypeInventoryTextField);
		IDTypeInventoryTextField.setColumns(10);

		nameTypeInventoryTextField = new JTextField();
		nameTypeInventoryTextField.setBounds(87, 44, 381, 20);
		panel_1.add(nameTypeInventoryTextField);
		nameTypeInventoryTextField.setColumns(10);

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

		JPanel InventoryPanel = new JPanel();
		InventoryPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Inventory",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		InventoryPanel.setBackground(new Color(255, 255, 255));
		InventoryPanel.setPreferredSize(new Dimension(0, 300));
		inventoryPanel.add(InventoryPanel);

		InventoryPanel.setLayout(new GridLayout(0, 2, 0, 0));
		inventoryTable = new JTable(inventoryTableModel);
		JScrollPane sc2 = new JScrollPane();
		sc2.setViewportView(inventoryTable);
		sc2.setPreferredSize(new Dimension(0, 150));
		InventoryPanel.add(sc2);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Action",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		InventoryPanel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_16_1 = new JLabel("Search : ");
		lblNewLabel_16_1.setBounds(9, 75, 46, 14);
		panel_2.add(lblNewLabel_16_1);

		searchInventoryTextField = new JTextField();
		searchInventoryTextField.setColumns(10);
		searchInventoryTextField.setBounds(57, 72, 359, 20);
		panel_2.add(searchInventoryTextField);

		JLabel lblNewLabel_17_1 = new JLabel(new ImageIcon(findImg));
		lblNewLabel_17_1.setBounds(435, 71, 32, 24);
		panel_2.add(lblNewLabel_17_1);

		JButton btnNewButton_1_1 = new JButton("reset");
		btnNewButton_1_1.setBounds(488, 71, 89, 23);
		panel_2.add(btnNewButton_1_1);

		JLabel lblNewLabel_16_1_1 = new JLabel("Type : ");
		lblNewLabel_16_1_1.setBounds(9, 104, 46, 14);
		panel_2.add(lblNewLabel_16_1_1);

		JComboBox searchTypeInventoryComboBox = new JComboBox();
		searchTypeInventoryComboBox.setBounds(57, 100, 359, 22);
		panel_2.add(searchTypeInventoryComboBox);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Update", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 140, 575, 200);
		panel_2.add(panel_1_1);

		JButton btnNewButton_2_1 = new JButton("update");
		btnNewButton_2_1.setBounds(468, 168, 89, 23);
		panel_1_1.add(btnNewButton_2_1);

		JLabel lblNewLabel_18_1 = new JLabel("ID Inventory :");
		lblNewLabel_18_1.setBounds(10, 22, 77, 14);
		panel_1_1.add(lblNewLabel_18_1);

		JLabel lblNewLabel_19_1 = new JLabel("Name  Inventory :");
		lblNewLabel_19_1.setBounds(10, 47, 77, 14);
		panel_1_1.add(lblNewLabel_19_1);

		IDInventoryTextField = new JTextField();
		IDInventoryTextField.setEnabled(false);
		IDInventoryTextField.setColumns(10);
		IDInventoryTextField.setBounds(87, 19, 381, 20);
		panel_1_1.add(IDInventoryTextField);

		nameInventoryTextField = new JTextField();
		nameInventoryTextField.setColumns(10);
		nameInventoryTextField.setBounds(87, 44, 381, 20);
		panel_1_1.add(nameInventoryTextField);

		JLabel lblNewLabel_19_1_1 = new JLabel("Unit :");
		lblNewLabel_19_1_1.setBounds(10, 75, 67, 14);
		panel_1_1.add(lblNewLabel_19_1_1);

		priceInventoryTextField = new JTextField();
		priceInventoryTextField.setColumns(10);
		priceInventoryTextField.setBounds(87, 105, 381, 20);
		panel_1_1.add(priceInventoryTextField);

		JLabel lblNewLabel_19_1_2 = new JLabel("Price Inventory :");
		lblNewLabel_19_1_2.setBounds(10, 108, 77, 14);
		panel_1_1.add(lblNewLabel_19_1_2);

		JLabel lblNewLabel_19_1_3 = new JLabel("Type :");
		lblNewLabel_19_1_3.setBounds(10, 139, 67, 14);
		panel_1_1.add(lblNewLabel_19_1_3);

		JComboBox UnitInventoryTextField = new JComboBox();
		UnitInventoryTextField.setModel(new DefaultComboBoxModel(new String[] { "ly", "chai", "tui" }));
		UnitInventoryTextField.setBounds(87, 75, 381, 22);
		panel_1_1.add(UnitInventoryTextField);

		JComboBox typeInventoryComboBox = new JComboBox();
		typeInventoryComboBox.setBounds(87, 135, 381, 22);
		panel_1_1.add(typeInventoryComboBox);

		JButton btnNewButton_1_1_1 = new JButton("Create Product");
		btnNewButton_1_1_1.setBounds(488, 23, 89, 23);
		panel_2.add(btnNewButton_1_1_1);
		return inventoryPanel;
	}

	public JPanel promotionPanelTab() {
		JPanel promotionPanel = new JPanel();
		promotionPanel.setLayout(new GridLayout(0, 2, 0, 0));
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "new promotion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		promotionPanel.add(panel_2);

		JLabel lblNewLabel = new JLabel("Mã khuyến mãi:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_1 = new JLabel("Nội dung:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("Giá giảm:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("Ngày bắt đầu:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_4 = new JLabel("Ngày kết thúc:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ViewMain.class.getResource("/img/logosale.png")));

		JButton btnNewButton_1_1_2 = new JButton("Thêm\r\n");
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnNewButton_1_1_3 = new JButton("Cập nhật");
		btnNewButton_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addGap(94)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2).addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
						.addGap(61)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false).addComponent(textField_3)
								.addComponent(textField_2).addComponent(textField_1).addComponent(textField)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
						.addGroup(gl_panel_2.createSequentialGroup().addGap(147).addComponent(btnNewButton,
								GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(413, Short.MAX_VALUE))
				.addGroup(
						gl_panel_2.createSequentialGroup().addContainerGap(497, Short.MAX_VALUE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 142,
										GroupLayout.PREFERRED_SIZE)
								.addGap(260))
				.addGroup(gl_panel_2.createSequentialGroup().addGap(285)
						.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnNewButton_1_1_3).addContainerGap(412, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(65).addComponent(lblNewLabel_6).addGap(57)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(20)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_2)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_4)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(36)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1_1_2, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_1_3, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE))
						.addGap(246)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		promotionPanel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "List promotion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_5);

		JLabel lblNewLabel_5 = new JLabel("Tìm khuyến mãi");
		lblNewLabel_5.setBounds(52, 30, 115, 20);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_5_1 = new JLabel("Trạng thái");
		lblNewLabel_5_1.setBounds(361, 30, 86, 20);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JScrollPane sc = new JScrollPane();
		sc.setBounds(52, 90, 487, 180);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(sc, popupMenu);
		promotionTable = new JTable(promotionTableModel);
		sc.setViewportView(promotionTable);

		textField_5 = new JTextField();
		textField_5.setBounds(52, 52, 179, 27);
		textField_5.setColumns(10);

		JButton btnNewButton_1_1_1 = new JButton("Tìm\r\n");
		btnNewButton_1_1_1.setBounds(241, 49, 89, 29);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đang hoạt động", "Không hoạt động"}));
		comboBox.setBounds(361, 52, 178, 27);
		panel_5.setLayout(null);
		panel_5.add(sc);
		panel_5.add(lblNewLabel_5);
		panel_5.add(textField_5);
		panel_5.add(btnNewButton_1_1_1);
		panel_5.add(lblNewLabel_5_1);
		panel_5.add(comboBox);

		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Update", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(26, 39, 575, 200);
		panel_3.add(panel_1_1);
		
		JButton btnNewButton_2_1 = new JButton("update");
		btnNewButton_2_1.setBounds(473, 214, 89, 23);
		panel_1_1.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_18_1 = new JLabel("ID Promotion :");
		lblNewLabel_18_1.setBounds(33, 62, 77, 14);
		panel_1_1.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_19_1 = new JLabel("Content  Promotion :");
		lblNewLabel_19_1.setBounds(33, 93, 106, 14);
		panel_1_1.add(lblNewLabel_19_1);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		textField_11.setBounds(191, 59, 371, 20);
		panel_1_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(191, 90, 371, 20);
		panel_1_1.add(textField_12);
		
		JLabel lblNewLabel_19_1_1 = new JLabel("Discount : (%)");
		lblNewLabel_19_1_1.setBounds(33, 124, 77, 14);
		panel_1_1.add(lblNewLabel_19_1_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(191, 152, 371, 20);
		panel_1_1.add(textField_13);
		
		JLabel lblNewLabel_19_1_2 = new JLabel("Day Start :");
		lblNewLabel_19_1_2.setBounds(33, 155, 77, 14);
		panel_1_1.add(lblNewLabel_19_1_2);
		
		JLabel lblNewLabel_19_1_3 = new JLabel("Day End :");
		lblNewLabel_19_1_3.setBounds(33, 186, 67, 14);
		panel_1_1.add(lblNewLabel_19_1_3);
		
		JButton btnNewButton_2_1_1 = new JButton("delete");
		btnNewButton_2_1_1.setBounds(361, 214, 89, 23);
		panel_1_1.add(btnNewButton_2_1_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(191, 121, 371, 20);
		panel_1_1.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(191, 183, 371, 20);
		panel_1_1.add(textField_15);
		return promotionPanel;
	}

	public JPanel statisticPanelTab() {
		JPanel statisticPanel = new JPanel();
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
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"FIND", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		findEmployee.add(panel);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(16, 39, 45, 18);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		JLabel lblNewLabel_1 = new JLabel("Phone  number:");
		lblNewLabel_1.setBounds(16, 79, 100, 18);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		textField_3 = new JTextField();
		textField_3.setBounds(126, 79, 236, 20);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(126, 39, 236, 20);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Find");
		btnNewButton.setBounds(372, 38, 98, 23);
		btnNewButton.setBackground(new Color(255, 255, 255));

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(372, 78, 98, 23);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel);
		panel.add(textField_3);
		panel.add(textField_4);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(220, 0));
		panel_1.setBorder(new TitledBorder(null, "UPDATE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		findEmployee.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(567, 168, 85, 21);
		panel_1.add(btnNewButton_3);

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

		textField_5 = new JTextField();
		textField_5.setBounds(177, 120, 184, 19);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(177, 78, 184, 19);
		panel_1.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(177, 24, 184, 19);
		panel_1.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(479, 24, 173, 19);
		panel_1.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(479, 78, 173, 19);
		panel_1.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(479, 120, 173, 19);
		panel_1.add(textField_10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(avataDemo));
		lblNewLabel_8.setBounds(10, 28, 68, 109);
		panel_1.add(lblNewLabel_8);
		
				JButton btnNewButton_2 = new JButton("Add");
				btnNewButton_2.setBounds(12, 167, 66, 23);
				panel_1.add(btnNewButton_2);
				btnNewButton_2.setBackground(new Color(255, 255, 255));

		JPanel employeeList = new JPanel();
		employeeList.setBorder(
				new TitledBorder(null, "List of employees", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		employeeList.setPreferredSize(new Dimension(0, 650));
		employeePanel.add(employeeList);
		employeeList.setLayout(new GridLayout(1, 0, 0, 0));
		
		employeeTable = new JTable(employeeTableModel);
		JScrollPane scrollPane = new JScrollPane();
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

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Find");
		btnNewButton.setBackground(new Color(255, 255, 255));

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBackground(new Color(255, 255, 255));

		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_1,
										GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton,
										GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE).addGap(8)
				.addContainerGap(329, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton).addComponent(btnNewButton_2)))
						.addGap(61)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1))
						.addContainerGap(48, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "UPDATE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		findEmployee.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(499, 115, 85, 26);
		panel_1.add(btnNewButton_3);

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

		textField_5 = new JTextField();
		textField_5.setBounds(99, 118, 184, 19);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(99, 69, 184, 19);
		panel_1.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(99, 25, 184, 19);
		panel_1.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(411, 28, 173, 19);
		panel_1.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(411, 78, 173, 19);
		panel_1.add(textField_9);

		JPanel employeeList = new JPanel();
		employeeList.setBorder(
				new TitledBorder(null, "List of customer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		employeeList.setPreferredSize(new Dimension(0, 650));
		customerPanel.add(employeeList);
		employeeList.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		employeeList.add(scrollPane);

		customerTable = new JTable(customerTableModel);
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
						.addGroup(gl_accountPanelTab.createSequentialGroup().addGap(736).addComponent(btnNewButton)))
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
						.addGap(78).addComponent(btnNewButton).addGap(228)));
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
