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
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
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

public class Home {

	private JFrame frame;

	private JLabel timeLabel = new JLabel();
	private Image img = new ImageIcon(Home.class.getResource("/img/Logo.png")).getImage().getScaledInstance(137, 80,Image.SCALE_SMOOTH);
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
		
		timeLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
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
		
		JPanel newOrderPanelTab = new JPanel();
		tabbedPane.addTab("ORDER", null, newOrderPanelTab, null);
		JPanel productsPanelTab = new JPanel();
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
					SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-mm-yyyy");
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
		return orderPanel;
	}
	public JPanel productsPanelTab()
	{
		JPanel productsPanel = new JPanel();
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
