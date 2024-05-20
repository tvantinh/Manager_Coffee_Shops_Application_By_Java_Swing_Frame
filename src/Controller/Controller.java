package Controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ModelApp.Model.CustomerDAO;
import ModelApp.Model.EmployeeDAO;
import ModelApp.Model.InventoryDAO;
import ModelApp.Model.ProductDAO;
import ModelApp.Model.PromotionDAO;
import ModelApp.Model.TypeInventoryDAO;
import ModelApp.Model.TypeProductDAO;
import ModelApp.Object.Customer;
import ModelApp.Object.Employee;
import ModelApp.Object.Inventory;
import ModelApp.Object.Order;
import ModelApp.Object.Product;
import ModelApp.Object.Promotion;
import ModelApp.Object.TypeInventory;
import ModelApp.Object.TypeProduct;
import TableModel.CustomerTableModel;
import TableModel.EmployeeTableModel;
import TableModel.InventoryTableModel;
import TableModel.ProductTableModel;
import TableModel.PromotionTableModel;
import TableModel.TypeInventoryTableModel;
import TableModel.TypeProductTableModel;
import View.BillToPay;
import View.ChoosePromotion;
import View.CreateOrder;
import View.EditOrder;
import View.ViewMain;
import ViewHelper.ActionPane;
import ViewHelper.ActionPaneRenderer;
import ViewHelper.ButtonEditor;
import ViewHelper.TableActionEvent;

public class Controller {

	// models
	CustomerDAO customerDAO = new CustomerDAO();
	EmployeeDAO emoloyeeDAO = new EmployeeDAO();
	ProductDAO productDAO = new ProductDAO();
	TypeProductDAO typeProductDAO = new TypeProductDAO();
	InventoryDAO inventoryDAO = new InventoryDAO();
	PromotionDAO promotionDAO = new PromotionDAO();
	TypeInventoryDAO typeInventoryDAO = new TypeInventoryDAO();
	private List<Order> listOrder = new ArrayList<>();
	Promotion promotion = new Promotion();
	ViewMain view;

	public Controller(ViewMain view) {
		this.view = view;
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialize() throws SQLException {
		setDataTableProduct();
		setDataTableCustomer();
		setDataTableEmployee();
		setDataTableInventory();
		setDataTablePromotion();
		setDataTableTypeInventory();
		setDataTableTypeProduct();
		loadPanelOrder();
		initActionButtonPay();
	}

	public void initActionButtonPay()
	{
		view.choosePromotion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ChoosePromotion cp = new ChoosePromotion(promotionDAO.getData());
					cp.addWindowListener(new WindowAdapter() {
						public void windowClosed(WindowEvent e) {

							if (cp.State == true) {
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
		
		view.payBillOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if (listOrder.size() > 0) {
					BillToPay BP;
					try {
						BP = new BillToPay(employee, promotion, listOrder, view.castLabel.getText(),view.totalLabel.getText());
						BP.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					JOptionPane.showMessageDialog(view.componentOfBillPanel, "vui lòng chọn sản phẩm!!!");
				}*/

			}
		});
	}
	public void setDataTableProduct() throws SQLException {
		List<Product> listProduct = productDAO.getData();
		ProductTableModel productTableModel = new ProductTableModel(listProduct);
		view.setDataTableProduct(productTableModel);
	}

	public void setDataTableTypeProduct() throws SQLException {
		List<TypeProduct> listTypeProduct = typeProductDAO.getData();
		TypeProductTableModel typeProductTableModel = new TypeProductTableModel(listTypeProduct);
		view.setDataTableTypeProduct(typeProductTableModel);
	}

	public void setDataTableInventory() throws SQLException {
		List<Inventory> listInventory = inventoryDAO.getData();
		InventoryTableModel inventoryTableModel = new InventoryTableModel(listInventory);
		view.setDataTableInventory(inventoryTableModel);
	}

	public void setDataTableTypeInventory() throws SQLException {
		List<TypeInventory> listTypeInventory = typeInventoryDAO.getData();
		TypeInventoryTableModel typeInventoryTableModel = new TypeInventoryTableModel(listTypeInventory);
		view.setDataTableTypeInventory(typeInventoryTableModel);
	}

	public void setDataTableEmployee() throws SQLException {
		List<Employee> listEmployee = emoloyeeDAO.getData();
		EmployeeTableModel employeeTableModel = new EmployeeTableModel(listEmployee);
		view.setDataTableEmployee(employeeTableModel);
	}

	public void setDataTableCustomer() throws SQLException {
		List<Customer> listCustomer = customerDAO.getData();
		CustomerTableModel customerTableModel = new CustomerTableModel(listCustomer);
		view.setDataTableCustomer(customerTableModel);
	}

	public void setDataTablePromotion() throws SQLException {
		List<Promotion> listPromotion = promotionDAO.getData();
		PromotionTableModel promotionTableModel = new PromotionTableModel(listPromotion);
		view.setDataTablePromotion(promotionTableModel);
	}

	public int checkProductinListOrder(Order order) {

		for (var i : listOrder) {
			if (i.getIDSanPham() == order.getIDSanPham()) {

				return listOrder.lastIndexOf(i);
			}
		}
		return -1;
	}
	
	public int getinfoCast(List<Order> list) {
		int cast = 0;
		for (var i : list) {
			cast += i.getGiaBan();
		}
		return cast;
	}

	public int getCastPromotion(Promotion p, List<Order> list) {
		int cast = 0;
		cast = (int) ((p.getGiaGiam() * 0.01) * getinfoCast(list));
		return cast;
	}

	public void updatetotal() {
		int ic = getinfoCast(listOrder);
		int ip = getCastPromotion(promotion, listOrder);
		view.castLabel.setText(String.valueOf(ic));
		view.discountLabel.setText(String.valueOf(ip));
		int vat = (int) ((ic - ip) * 0.1);
		int total = ic - ip + vat;
		System.out.println(ic + ", " + ip + ", " + total);
		view.VATLabel.setText(String.valueOf(vat));
		view.totalLabel.setText(String.valueOf(total));
	}
	
	public void ActionPanel(JTable table, int column) {
		// create 2 button action and listener click component
		TableActionEvent event = new TableActionEvent() {
			@Override
			public void onEdit(int row) {
				EditOrder edv = new EditOrder(listOrder.get(row));
				
				edv.cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(edv.cancelButton, "Do you want to exit?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
						if (result == JOptionPane.OK_OPTION) {
							edv.State = false;
							edv.dispose();
						}
					}
				});
				
				edv.okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						edv.State = true;
						edv.dispose();
					}
				});
				
				
				edv.upButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						edv.updateQlty(edv.upButton.getLabel(),edv.orderedit);
					}
				});
				
				edv.downButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						edv.updateQlty(edv.downButton.getLabel(),edv.orderedit);
					}
				});
				
				edv.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						Order editedOrder = edv.getOrder();
						if (edv.State == true) {
							addProductToOrder(editedOrder, true);
							updatetotal();
						}
					}
				});
			}

			@Override
			public void onDelete(int row) {
				System.out.println("cot + " + row);
				listOrder.remove(row);
				view.OrdertableModel.removeRow(row);
				updatetotal();

				for (var il : listOrder) {
					System.out.println(il.toString());
				}
			}
		};
		table.getColumnModel().getColumn(column).setCellRenderer(new ActionPaneRenderer());// show action Pane
		table.getColumnModel().getColumn(column).setCellEditor(new ButtonEditor(event));
	}
	
	public void addProductToOrder(Order od, boolean flag) {
		// flag is true == update
		// flag is false == new order
		int row = checkProductinListOrder(od); // get row product in list(true is >= 0) and (false = -1)
		if (flag == true) {
			listOrder.set(row, od);
			int cost = od.getSoLuong() * od.getGiaBan();
			listOrder.get(row).setGiaBan(cost);
			view.tableOrder.setValueAt(listOrder.get(row).getTenSanPham(), row, 0);
			view.tableOrder.setValueAt(listOrder.get(row).getSoLuong(), row, 1);
			view.tableOrder.setValueAt(listOrder.get(row).getSize(), row, 2);
			view.tableOrder.setValueAt(listOrder.get(row).getGhichu(), row, 3);
			view.tableOrder.setValueAt(listOrder.get(row).getGiaBan(), row, 4);

		} else {
			if (row >= 0 && listOrder.get(row).getSize().equals(od.getSize())) {
				// product is already in the list
				int i = listOrder.get(row).getSoLuong();
				i++;
				int cost = i * od.getGiaBan();
				listOrder.get(row).setSoLuong(i);
				listOrder.get(row).setGiaBan(cost);
				view.tableOrder.setValueAt(listOrder.get(row).getTenSanPham(), row, 0);
				view.tableOrder.setValueAt(listOrder.get(row).getSoLuong(), row, 1);
				view.tableOrder.setValueAt(listOrder.get(row).getSize(), row, 2);
				view.tableOrder.setValueAt(listOrder.get(row).getGhichu(), row, 3);
				view.tableOrder.setValueAt(listOrder.get(row).getGiaBan(), row, 4);
			} else {
				// The product is not in the list
				listOrder.add(od);
				Vector<Object> dataRow = new Vector<>();
				dataRow.add(od.getTenSanPham());
				dataRow.add(od.getSoLuong());
				dataRow.add(od.getSize());
				dataRow.add(od.getGhichu());
				dataRow.add(od.getGiaBan());
				ActionPane Pane = new ActionPane();
				dataRow.add(Pane);
				view.OrdertableModel.addRow(dataRow);
				ActionPanel(view.tableOrder, 5);
			}

		}

		for (var il : listOrder) {
			System.out.println(il.toString());
		}
		System.out.println("ket thuc");
		view.tableOrder.setModel(view.OrdertableModel);
	}
	
	public void loadPanelOrder() throws SQLException {
		List<TypeProduct> listType = typeProductDAO.getData();
		List<Product> listProduct = productDAO.getData();
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
							createOrder.okeButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									createOrder.State = true;
									createOrder.dispose();
								}
							});
							createOrder.cancelButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									int result = JOptionPane.showConfirmDialog(createOrder.cancelButton, "Do you want to exit?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
									if (result == JOptionPane.OK_OPTION) {
										createOrder.State = false;
										createOrder.dispose();
									}
								}
							});
							createOrder.upButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									createOrder.updateQlty(createOrder.upButton.getLabel());
								}
							});
							createOrder.downButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									createOrder.updateQlty(createOrder.upButton.getLabel());
								}
							});
							createOrder.addWindowListener(new WindowAdapter() {
								public void windowClosed(WindowEvent e) {
									Order newOrder = createOrder.getOrder();
									if (createOrder.State == true) {
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
			view.productsTabed.addTab(i.getTenLoai(), null, scrollPane, null);
		}
	}
}
