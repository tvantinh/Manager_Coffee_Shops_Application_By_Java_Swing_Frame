package Controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

import ModelApp.Model.BillDAO;
import ModelApp.Model.CustomerDAO;
import ModelApp.Model.EmployeeDAO;
import ModelApp.Model.OrderDAO;
import ModelApp.Model.ProductDAO;
import ModelApp.Model.PromotionDAO;
import ModelApp.Model.TypeInventoryDAO;
import ModelApp.Model.TypeProductDAO;
import ModelApp.Object.Bill;
import ModelApp.Object.Customer;
import ModelApp.Object.DateConvert;
import ModelApp.Object.Employee;
import ModelApp.Object.Order;
import ModelApp.Object.Product;
import ModelApp.Object.Promotion;
import ModelApp.Object.TypeInventory;
import ModelApp.Object.TypeProduct;
import TableModel.BillTableModel;
import TableModel.CustomerTableModel;
import TableModel.EmployeeTableModel;
import TableModel.ProductTableModel;
import TableModel.PromotionTableModel;
import TableModel.TypeInventoryTableModel;
import TableModel.TypeProductTableModel;
import View.BillToPay;
import View.ChangePassword;
import View.ChoosePromotion;
import View.CreateCustomer;
import View.CreateEmployee;
import View.CreateOrder;
import View.EditOrder;
import View.RegisterVIPCustomers;
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
	PromotionDAO promotionDAO = new PromotionDAO();
	TypeInventoryDAO typeInventoryDAO = new TypeInventoryDAO();
	OrderDAO orderDAO = new OrderDAO();
	BillDAO billDAO = new BillDAO();
	private List<Order> listOrder = new ArrayList<>();
	private String destination;
	ViewMain view;
	Employee employeeLogin;

	public Controller(ViewMain view, Employee em) {
		this.view = view;
		this.employeeLogin = em;
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
		setDataTablePromotion();
		setDataTableTypeInventory();
		setDataTableTypeProduct();
		setDataTableBillHistory();
		clickBillTable();
		loadPanelOrder();
		initActionButtonPay();
		initActionEmployee();
		ProductPanel();
		clickTablePromotion();
		addPromotion();
		updatePromotion();
		deletePromotion();
		searchPromotion();
		initActionCustomer();
	}

	public void clickBillTable() {
		view.billTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = view.billTable.getSelectedRow();
				if (r < 0) {
					return;
				}
				view.txtidbill.setText(view.billTable.getValueAt(r, 0).toString());
				view.txtdate.setText(view.billTable.getValueAt(r, 1).toString());
				view.txttotal.setText(view.billTable.getValueAt(r, 2).toString());
				view.txtemp.setText(view.billTable.getValueAt(r, 3).toString());
				view.txtcus.setText(view.billTable.getValueAt(r, 4).toString());
				view.txtidpromotion.setText(view.billTable.getValueAt(r, 5).toString());
				if (view.billTable.getValueAt(r, 6).toString() != null) {
					view.txtnote.setText(view.billTable.getValueAt(r, 6).toString());
				}

			}
		});
	}

	public void ProductPanel() {
		view.searchTypebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (view.searchTypeProductTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(view.Type_panel, "vui lòng nhập trường tìm kiếm!!!");
				} else {
					List<TypeProduct> list = typeProductDAO.searchTypeList(view.searchTypeProductTextField.getText());
					TypeProductTableModel typeProductTableModel = new TypeProductTableModel(list);
					typeProductTableModel.fireTableDataChanged();
					view.setDataTableTypeProduct(typeProductTableModel);
				}
			}
		});
		view.resetTypeProductbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setDataTableTypeProduct();
					view.searchTypeProductTextField.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		view.searchProductbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (view.searchProductTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(view.Product_panel, "vui lòng nhập trường tìm kiếm!!!");
				} else {
					List<Product> list = productDAO.searchProductList(view.searchProductTextField.getText());
					ProductTableModel ProductTableModel = new ProductTableModel(list);
					ProductTableModel.fireTableDataChanged();
					view.setDataTableProduct(ProductTableModel);
				}
			}
		});
		view.resetProductbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setDataTableProduct();
					view.searchProductTextField.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		view.typeProductTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = view.typeProductTable.getSelectedRow();
				view.IDTypeProductTextField.setText(view.typeProductTable.getValueAt(r, 0).toString());
				view.nameTypeProductTextField.setText(view.typeProductTable.getValueAt(r, 1).toString());
			}
		});

		view.productTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = view.productTable.getSelectedRow();
				view.IDProductTextField.setText(view.productTable.getValueAt(r, 0).toString());
				view.nameProductTextField.setText(view.productTable.getValueAt(r, 1).toString());
				selectProductTypeByUnit(view.UnitProductComboBox, view.productTable.getValueAt(r, 2).toString().trim());
				view.priceProductTextField.setText(view.productTable.getValueAt(r, 3).toString());
				selectProductTypeById(view.typeProductComboBox, view.productTable.getValueAt(r, 5).toString().trim());
				view.GiaUpSizeTextField.setText(view.productTable.getValueAt(r, 6).toString());
			}
		});
		view.updateTypeChoosebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.IDTypeProductTextField.getText().toString().equals(""))
					JOptionPane.showMessageDialog(view.Type_panel, "vui lòng chọn loại sản phẩm!!!");
				else {
					try {
						typeProductDAO.updateType(view.IDTypeProductTextField.getText().toString(),
								view.nameTypeProductTextField.getText().toString());
						setDataTableTypeProduct();
						JOptionPane.showMessageDialog(view.Type_panel, "cập nhật thành công!!!");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		view.deleteTypeProductchoosebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (view.IDProductTextField.getText().toString().equals(""))
					JOptionPane.showMessageDialog(view.Type_panel, "vui lòng chọn loại sản phẩm!!!");
				else {

					try {
						typeProductDAO.deleteType(view.IDTypeProductTextField.getText().toString());
						setDataTableTypeProduct();
						JOptionPane.showMessageDialog(view.Type_panel, "xóa thành công!!!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		view.updateProductChoosebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.IDProductTextField.getText().toString().equals(""))
					JOptionPane.showMessageDialog(view.Type_panel, "vui lòng chọn loại sản phẩm!!!");
				else {
					try {
						productDAO.updateProduct(view.IDProductTextField.getText().toString(),
								view.nameProductTextField.getText().toString(),
								view.UnitProductComboBox.getSelectedItem().toString(),
								Integer.valueOf(view.priceProductTextField.getText()),
								selectProductTypeByName(view.typeProductComboBox,
										view.typeProductComboBox.getSelectedItem().toString()),
								Integer.valueOf(view.GiaUpSizeTextField.getText()));
						setDataTableProduct();
						JOptionPane.showMessageDialog(view.Type_panel, "cập nhật thành công!!!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		view.deleteProductChoosebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (view.IDProductTextField.getText().toString().equals(""))
					JOptionPane.showMessageDialog(view.Product_panel, "vui lòng chọn loại sản phẩm!!!");
				else {

					try {
						productDAO.deleteProduct(view.IDProductTextField.getText().toString());
						setDataTableProduct();
						JOptionPane.showMessageDialog(view.Product_panel, "xóa thành công!!!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		addTypeProduct();
		addProduct();
	}
	public void addTypeProduct() {
		view.createTypeProductbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	        	try {

		            String IDLoaiSP = "LSP00"+(typeProductDAO.getData().size()+1);
		            String TenLoaiSP = view.nameTypeProductTextField.getText().trim();
		            TypeProductDAO.insertTypetProduct(IDLoaiSP, TenLoaiSP);
		            JOptionPane.showMessageDialog(view,"Upadate sucess!");
		            setDataTableTypeProduct();
		            
	        	}catch(Exception e1) {
	        		e1.printStackTrace();
	        	}
			}
		});
	}
	public void addProduct() {
		view.createProductbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String IDSanPham = "SP0"+(productDAO.getData().size()+1);
		            String TenSP = view.nameProductTextField.getText().trim();
		            String DonViTinh =view.UnitProductComboBox.getSelectedItem().toString();
		            int GiaBan = Integer.valueOf(view.priceProductTextField.getText());
		            String IDLoaiSP=selectProductTypeByName(view.typeProductComboBox, view.typeProductComboBox.getSelectedItem().toString());
					int GiaUpSize = Integer.valueOf(view.GiaUpSizeTextField.getText());
		            ProductDAO.insertProduct(IDSanPham, TenSP, DonViTinh, GiaBan, IDLoaiSP,GiaUpSize);
					JOptionPane.showMessageDialog(view,"Save sucess!");
					setDataTableProduct();
				}catch(Exception e2) {
					e2.printStackTrace();
				}

			}
		});
	}

	public String selectProductTypeByName(JComboBox<TypeProduct> comboBox, String name) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			TypeProduct type = comboBox.getItemAt(i);
			if (type.getTenLoai().trim().equals(name)) {
				return type.getIDLoaiSP();
			}
		}
		return null;
	}

	public void selectProductTypeById(JComboBox<TypeProduct> comboBox, String id) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			TypeProduct type = comboBox.getItemAt(i);
			if (type.getIDLoaiSP().trim().equals(id)) {
				comboBox.setSelectedItem(type);
				break;
			}
		}
	}

	public void selectProductTypeByUnit(JComboBox<String> comboBox, String id) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (comboBox.getItemAt(i).equals(id)) {
				comboBox.setSelectedItem(comboBox.getItemAt(i));
				break;
			}
		}
	}

	public void updateTotalToBill(BillToPay BP, Promotion p, int castTotal) {
		BP.discountLabel.setText(p.getNoiDung());
		BP.percentOfPromotion.setText(p.getGiaGiam() + " %");

		int discountTotal = (int) (castTotal * (p.getGiaGiam() * 0.01));
		int vat = (int) ((castTotal - discountTotal) * 0.1);
		int total = castTotal - discountTotal + vat;
		BP.totalLabel.setText(String.valueOf(total));
		System.out.println(vat + "  , " + discountTotal + " , " + total);
	}

	public void initActionButtonPay() {
		view.nameEmployeeLabel.setText("Hello: " + employeeLogin.getTenNhanVien());
		view.payBillOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listOrder.size() > 0) {
					BillToPay BP;
					try {

						BP = new BillToPay(employeeLogin, listOrder, view.totalLabel.getText());
						String IDHoaDon = RanmdomIDHoaDon(employeeLogin, BP.customer, BP.promotion);
						BP.billNumberLabel.setText(IDHoaDon);
						BP.setVisible(true);
						BP.cashComboBox.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BP.update(Integer.valueOf(BP.cashComboBox.getSelectedItem().toString()),
										Integer.valueOf(BP.totalLabel.getText()));
							}
						});
						BP.choosePromotion.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (listOrder.size() > 0) {
									try {
										ChoosePromotion cp = new ChoosePromotion(promotionDAO.getData());
										cp.addWindowListener(new WindowAdapter() {
											public void windowClosed(WindowEvent e) {

												if (cp.State == true) {
													if (cp.getPromotionChoosed().getIDKhuyenMai().trim()
															.equals("KMVIP"))
														if (BP.customer.getIDKH().equals("KH0VL"))
															JOptionPane.showMessageDialog(view.componentOfBillPanel,
																	"vui lòng nhập số điện thoại khách hàng!!!");
														else {
															BP.setPromotion(cp.getPromotionChoosed());
															updateTotalToBill(BP, BP.promotion,
																	Integer.parseInt(view.totalLabel.getText()));
														}
													else {
														BP.setPromotion(cp.getPromotionChoosed());
														updateTotalToBill(BP, BP.promotion,
																Integer.parseInt(view.totalLabel.getText()));
													}
												}

											}
										});
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} else {
									JOptionPane.showMessageDialog(view.componentOfBillPanel,
											"vui lòng chọn sản phẩm!!!");
								}

							}
						});
						BP.getCustomer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (BP.numberPhoneField.getText().trim().equals("")) {
									JOptionPane.showMessageDialog(BP, "vui lòng nhập số điện thoại khách hàng!!!");
								} else {
									String numberPhone = BP.numberPhoneField.getText().trim();
									try {
										Customer customer = customerDAO.SelectCustomerToPhone(numberPhone);
										if (customer == null) {
											BP.useVIPbtn.setEnabled(false);
											BP.nameCustomerLabel.setText("<<None>>");
											JOptionPane.showMessageDialog(BP,
													"Không có khách hàng với SDT vừa nhập vui lòng nhập lại(nếu chưa có xin hãy đăng kí khách hàng mới)!!!");
										} else {
											BP.setCustomer(customer);
											BP.nameCustomerLabel.setText(customer.getTenKH());
											BP.useVIPbtn.setEnabled(true);
										}

									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						});
						BP.registerCustomer.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								RegisterVIPCustomers RG = new RegisterVIPCustomers();
								RG.setVisible(true);
								RG.registerbtn.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										if (RG.check()) {
											try {
												if (CustomerDAO.checkIDKH(RG.RanmdomIDKH())) {
													JOptionPane.showMessageDialog(RG, "Khách hàng đã tồn tại!!!");
												} else {
													CustomerDAO.insertCustomer(RG.getCustomer());
													JOptionPane.showMessageDialog(RG, "Thêm khách hàng thành công!!!");
													RG.dispose();
												}
											} catch (HeadlessException | NoSuchAlgorithmException | SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										} else {
											JOptionPane.showMessageDialog(RG, "vui lòng nhập đủ các trường!!!");
										}

									}
								});
								RG.cancelbtn.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										int result = JOptionPane.showConfirmDialog(RG.cancelbtn, "Do you want to exit?",
												"Confirmation", JOptionPane.OK_CANCEL_OPTION);
										if (result == JOptionPane.OK_OPTION) {
											RG.dispose();
										}
									}
								});
							}
						});
						BP.useVIPbtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BP.promotion = new Promotion("KMVIP", "Khuyến mãi khách vip", 20, null, null);

								updateTotalToBill(BP, BP.promotion, Integer.parseInt(view.totalLabel.getText()));
							}
						});
						BP.cancelbtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int result = JOptionPane.showConfirmDialog(BP.cancelbtn, "Do you want to exit?",
										"Confirmation", JOptionPane.OK_CANCEL_OPTION);
								if (result == JOptionPane.OK_OPTION) {
									BP.dispose();
								}
							}
						});
						BP.Paybtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {

									Timestamp time = new Timestamp(System.currentTimeMillis());
									System.out.println(BP.promotion.toString());
									orderDAO.insert(employeeLogin, IDHoaDon, time, BP.getTotal(), BP.customer,
											BP.getPromotion(), BP.getNote(), listOrder);
									JOptionPane.showMessageDialog(view.componentOfBillPanel,
											"Thanh toán thành công!!!");
									BP.dispose();
								} catch (Exception ev) {
									ev.printStackTrace();
								}
							}
						});
						BP.addWindowListener(new WindowAdapter() {
							public void windowClosed(WindowEvent e) {
								resetItemOrder();
							}
						});
					} catch (SQLException | NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(view.componentOfBillPanel, "vui lòng chọn sản phẩm!!!");
				}

			}
		});

	}

	public void resetItemOrder() {
		listOrder.clear();
		view.OrdertableModel.setRowCount(0);
	}

	public void setDataTableBillHistory() throws SQLException {

		List<Bill> listProduct = billDAO.getData();
		BillTableModel BillHistoryTableModel = new BillTableModel(listProduct);
		BillHistoryTableModel.fireTableDataChanged();
		view.setDataTableBillHistory(BillHistoryTableModel);

	}

	public void setDataTableProduct() throws SQLException {

		List<Product> listProduct = productDAO.getData();
		ProductTableModel productTableModel = new ProductTableModel(listProduct);
		productTableModel.fireTableDataChanged();
		view.setDataTableProduct(productTableModel);

	}

	public void setDataTableTypeProduct() throws SQLException {
		List<TypeProduct> listTypeProduct = typeProductDAO.getData();
		view.setComboBoxTypeProduct(listTypeProduct);
		TypeProductTableModel typeProductTableModel = new TypeProductTableModel(listTypeProduct);
		typeProductTableModel.fireTableDataChanged();
		view.setDataTableTypeProduct(typeProductTableModel);
	}


	public void setDataTableTypeInventory() throws SQLException {
		List<TypeInventory> listTypeInventory = typeInventoryDAO.getData();
		TypeInventoryTableModel typeInventoryTableModel = new TypeInventoryTableModel(listTypeInventory);
		typeInventoryTableModel.fireTableDataChanged();
		view.setDataTableTypeInventory(typeInventoryTableModel);
	}

	public void setDataTableEmployee() throws SQLException {
		List<Employee> listEmployee = emoloyeeDAO.getData();
		EmployeeTableModel employeeTableModel = new EmployeeTableModel(listEmployee);
		employeeTableModel.fireTableDataChanged();
		view.setDataTableEmployee(employeeTableModel);
	}

	public void setDataTableCustomer() throws SQLException {
		List<Customer> listCustomer = customerDAO.getData();
		CustomerTableModel customerTableModel = new CustomerTableModel(listCustomer);
		customerTableModel.fireTableDataChanged();
		view.setDataTableCustomer(customerTableModel);
	}

	public void setDataTablePromotion() throws SQLException {
		List<Promotion> listPromotion = promotionDAO.getData();
		PromotionTableModel promotionTableModel = new PromotionTableModel(listPromotion);
		promotionTableModel.fireTableDataChanged();
		view.setDataTablePromotion(promotionTableModel);
	}

	public int getinfoCast(List<Order> list) {
		int cast = 0;
		for (var i : list) {
			cast += i.getGiaBan();
		}
		return cast;
	}

	public void updatetotal() {
		int ic = getinfoCast(listOrder);
		view.castLabel.setText(String.valueOf(ic));
		int vat = (int) (ic * 0.1);
		view.VATLabel.setText(String.valueOf(vat));
		view.totalLabel.setText(String.valueOf(ic));
	}

	public void ActionPanel(JTable table, int column) {
		// create 2 button action and listener click component
		TableActionEvent event = new TableActionEvent() {
			@Override
			public void onEdit(int row) {
				EditOrder edv = new EditOrder(listOrder.get(row));

				edv.cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(edv.cancelButton, "Do you want to exit?",
								"Confirmation", JOptionPane.OK_CANCEL_OPTION);
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
						edv.updateQlty(edv.upButton.getLabel(), edv.orderedit);
					}
				});

				edv.downButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						edv.updateQlty(edv.downButton.getLabel(), edv.orderedit);
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

	public String IDStringConvert(Employee e, Customer c, Promotion p) {
		StringBuilder str = new StringBuilder();
		str.append(e.getIDNhanVien());
		str.append(c.getIDKH());
		Date date = new Date();
		SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
		str.append(tf.format(date));
		str.append(p.getIDKhuyenMai());
		String t = str.toString();
		return t;
	}

	public String RanmdomIDHoaDon(Employee e, Customer c, Promotion p) throws NoSuchAlgorithmException {
		String input = IDStringConvert(e, c, p);
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(input.getBytes());

		StringBuilder sb = new StringBuilder();
		for (byte b : hash) {
			sb.append(String.format("%02x", b));
		}

		String uniqueID = sb.toString().substring(0, 10);
		return uniqueID;
	}

	public int checkProductinListOrder(Order order) {

		for (var i : listOrder) {
			if (i.getIDSanPham() == order.getIDSanPham() && i.getSize().equals(order.getSize())) {

				return listOrder.lastIndexOf(i);
			}
		}
		return -1;
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
			if (row >= 0) {
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
				int i = od.getSoLuong();
				int cost = i * od.getGiaBan();
				od.setGiaBan(cost);
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

	@SuppressWarnings("deprecation")
	public DateConvert dateConvert(JDateChooser dataChooser) {
		return new DateConvert(dataChooser.getDate().getDate(), dataChooser.getDate().getMonth() + 1,
				dataChooser.getDate().getYear() + 1900);
	}

	public void initActionEmployee()
	{
		view.createEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateEmployee ce = new CreateEmployee(null);
				ce.setVisible(true);
				ce.btnCancelEmployee.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(ce.btnCancelEmployee, "Do you want to exit?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
						if (result == JOptionPane.OK_OPTION) {
							ce.State = false;
							ce.dispose();
						}
						
					}
				});
				
				//nút thêm nhân viên
				ce.btnSaveEmployee.addActionListener(new ActionListener() {
					
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						if(checkInfo(ce) == false)
						{
							JOptionPane.showMessageDialog(ce.addEmployee, "Please enter complete information!");
						}
						else
						{												
							String selectedDate = (String) (ce.dateChooser.getDate().toString());
							DateConvert dc = dateConvert(ce.dateChooser);
							String selectedDate1 = (String) (ce.dateChooser1.getDate().toString());
							DateConvert dc1 = dateConvert(ce.dateChooser1);
						    String selectedOption = "";
						    if(ce.rdoMale.isSelected())
						    {
						    	selectedOption = ce.rdoMale.getText();
						    }
						    else
						    {
						    	selectedOption = ce.rdoFemale.getText();
						    }
						    String position = "";
						    if(ce.cboPosition.getSelectedItem() == "Nhân viên")
						    {
						    	position = "CV002";
						    }
						    else
						    {
						    	position = "CV001";
						    }
							try {
								EmployeeDAO.insertEmployee1(ce.IDField.getText(), ce.nameField.getText(), dc.toString(), ce.CCCDField.getText(), ce.phoneField.getText(), 
										selectedOption.toString(), destination, position.toString(), 
										dc1.toString(), ce.employeeUsernameField.getText(), ce.employeePasswordField.getText());
								JOptionPane.showMessageDialog(ce.addEmployee, "Save success!");
								ce.dispose();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							try {
								setDataTableEmployee();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				});
				//nút load hình đại diện
				ce.btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    JFileChooser fc = new JFileChooser();
					    int result = fc.showOpenDialog(null);

					    if (result != JFileChooser.APPROVE_OPTION) {
					        JOptionPane.showMessageDialog(null, "Không có tệp nào được chọn.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					        return;
					    }

					    // Lấy đường dẫn tệp
					    File selectedFile = fc.getSelectedFile();
					    String path = selectedFile.getAbsolutePath();
					    String fileName = selectedFile.getName();  // Lấy tên tệp gốc

					    String existingFolderPath = "src/img";
					    File folder = new File(existingFolderPath);
					    if (!folder.exists()) {
					        boolean success = folder.mkdir();
					        if (!success) {
					            JOptionPane.showMessageDialog(null, "Không thể tạo thư mục: img", "Lỗi", JOptionPane.ERROR_MESSAGE);
					            return;
					        }
					    }

					    // Lấy đường dẫn đích cho ảnh mới với tên tệp gốc
					    String destination = folder.getAbsolutePath() + File.separator + fileName;

					    try (
					        // Sao chép tệp từ nguồn đến đích
					        FileChannel source = new FileInputStream(path).getChannel();
					        FileChannel dest = new FileOutputStream(destination).getChannel()
					    ) {
					        dest.transferFrom(source, 0, source.size());
					        System.out.println("Sao chép tệp thành công.");
					    } catch (IOException e1) {
					        e1.printStackTrace();
					        JOptionPane.showMessageDialog(null, "Lỗi khi sao chép tệp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
					        return;
					    }
					    Image img = new ImageIcon(destination).getImage().getScaledInstance(215, 309, Image.SCALE_SMOOTH);
					    ce.lblAvatar.setIcon(new ImageIcon(img));
					}
				});
			}
		});
		
	
		
		view.btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.employeeNameFind.setText(" ");
				view.employeePhoneFind.setText(" ");
				try {
					setDataTableEmployee();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				view.employeeNameFind.setEnabled(true);
				view.employeePhoneFind.setEnabled(true);
			}
		});
	
		view.employeeNameFind.getDocument().addDocumentListener(new DocumentListener() {
            private void updatePhoneTextField() {
                if (view.employeeNameFind.getText().isEmpty()) {
                    view.employeePhoneFind.setEnabled(true); // Enable phoneTextField if nameTextField is empty
                } else {
                	view.employeePhoneFind.setEnabled(false);// Disable phoneTextField if nameTextField has text
                	view.btnFind.addActionListener(new ActionListener() {
            			
            			@Override
            			public void actionPerformed(ActionEvent e) {
            				String name = view.employeeNameFind.getText();
            	            List<Employee> employees = null;
            	            try {
            					employees = EmployeeDAO.findEmployee(name);
            					EmployeeTableModel model = new EmployeeTableModel(employees);
            					view.employeeTable.setModel(model);
            				} catch (Exception e2) {
            					e2.printStackTrace();
            				}
            				
            			}
            		});
                }
            }

			@Override
			public void insertUpdate(DocumentEvent e) {
				updatePhoneTextField();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updatePhoneTextField();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updatePhoneTextField();
				
			}
        });
    
		view.employeePhoneFind.getDocument().addDocumentListener(new DocumentListener() {
            private void updateNameTextField() {
                if (view.employeePhoneFind.getText().isEmpty()) {
                    view.employeeNameFind.setEnabled(true);
                } else {
                	view.employeeNameFind.setEnabled(false); 
                	view.btnFind.addActionListener(new ActionListener() {           			
            			@Override
            			public void actionPerformed(ActionEvent e) {
            				String phoneNum = view.employeePhoneFind.getText();
            	            List<Employee> employees = null;
            	            try {
            					employees = EmployeeDAO.findEmployeeByPhoneNum(phoneNum);
            					EmployeeTableModel model = new EmployeeTableModel(employees);
            					view.employeeTable.setModel(model);
            				} catch (Exception e2) {
            					e2.printStackTrace();
            				}
            				
            			}
            		});
                }
            }

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateNameTextField();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateNameTextField();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateNameTextField();
				
			}
        });
		
		view.employeeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = view.employeeTable.getSelectedRow();
				String d = view.employeeTable.getValueAt(r, 2).toString();
				java.util.Date date2;
				try {
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d);
					view.employeeDateField.setDate(date2);
					if(r<0)
					{
						return;
					}
					view.employeeIDField.setText(view.employeeTable.getValueAt(r, 0).toString());
					view.employeeNameField.setText(view.employeeTable.getValueAt(r, 1).toString());
					view.employeeDateField.setDate(date2);
				    view.employeePhoneField.setText(view.employeeTable.getValueAt(r, 3).toString());
					view.employeeCCCDField.setText(view.employeeTable.getValueAt(r, 4).toString());	
					String id = view.employeeIDField.getText();
					if(view.employeeTable.getValueAt(r, 5).toString() == "CV001")
					{
						view.cboPositionEmployee.getModel().setSelectedItem("Quản lý");
					}
					else if (view.employeeTable.getValueAt(r, 5).toString() == "CV002")
					{
						view.cboPositionEmployee.getModel().setSelectedItem("Nhân viên");
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		view.btnUpdateEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					DateConvert dc = dateConvert(view.employeeDateField);
				    String position = "";
				    if(view.cboPositionEmployee.getSelectedItem() == "Nhân viên")
				    {
				    	position = "CV002";
				    }
				    else
				    {
				    	position = "CV001";
				    }
				    String ID = view.employeeIDField.getText().trim(); 
				    String name = view.employeeNameField.getText().trim();
				    String ngaySinh = dc.toString().trim();
				    String CCCD = view.employeeCCCDField.getText().trim();
				    String phoneNum = view.employeePhoneField.getText().trim();
					EmployeeDAO.updateEmployee(ID,name,ngaySinh,CCCD, phoneNum, position);
					setDataTableEmployee();
					JOptionPane.showMessageDialog(view.employeePanelTab(), "Update success!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		
		view.btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp = new ChangePassword();
				cp.setVisible(true);
				cp.btnSave.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					    if (areFieldsEmpty(cp)) {
					        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ các trường.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					        return;
					    }

					    if (!isPasswordMatching(cp)) {
					        JOptionPane.showMessageDialog(null, "Mật khẩu mới và mật khẩu xác nhận không khớp.", "Thông báo", JOptionPane.ERROR_MESSAGE);
					        return;
					    }


					    try {
					        EmployeeDAO.changePassword(employeeLogin.getTaiKhoan(), cp.XacNhanMKField.getText());
					        emoloyeeDAO.getData();
					        JOptionPane.showMessageDialog(view.employeePanelTab(), "Đổi mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					    } catch (Exception e1) {
					        e1.printStackTrace();
					        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình đổi mật khẩu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
					    }
					}
				});
			}
		});
		
		view.btnDeleteEmployee.addActionListener(new ActionListener() {					
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = view.employeeIDField.getText().trim();
				System.out.println(id);
		        try {
		            EmployeeDAO.deleteEmployee(id);				            				            
		            setDataTableEmployee();
		            JOptionPane.showMessageDialog(view.employeePanelTab(), "Employee deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		            
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(view.employeePanelTab(), "Error deleting employee.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
	}
	public boolean isPasswordMatching(ChangePassword cp) {
	    return cp.MKCuField.getText().equals(cp.XacNhanMKField.getText());
	}

	public boolean areFieldsEmpty(ChangePassword cp) {
	    return cp.MKCuField.getText().isEmpty() || cp.XacNhanMKField.getText().isEmpty();
	}

	public boolean checkInfo(CreateEmployee ce) {
		if ( ce.nameField.getText().trim().isEmpty()
				|| ce.dateChooser.getDate() == null || ce.CCCDField.getText().trim().isEmpty()
				|| ce.phoneField.getText().trim().isEmpty() || ce.bg.isSelected(null)
				|| ce.dateChooser1.getDate() == null) {
			return false;
		} else {
			return true;
		}
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

							Order od = new Order(ip.getIDSanPham(), ip.getTenSanPham(), 1, "M", "", ip.getGiaBan(),
									ip.getUpsize());
							CreateOrder createOrder = new CreateOrder(od);
							createOrder.okeButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									createOrder.State = true;
									createOrder.dispose();
								}
							});
							createOrder.cancelButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									int result = JOptionPane.showConfirmDialog(createOrder.cancelButton,
											"Do you want to exit?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
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
									createOrder.updateQlty(createOrder.downButton.getLabel());
								}
							});
							createOrder.sizeM.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent e) {
									if (createOrder.sizeM.isSelected()) {
										int giaban = createOrder.newOrder.getGiaBan();
										int giaup = createOrder.newOrder.getGiaUpsize();
										createOrder.newOrder.setGiaBan(giaban - giaup);
										createOrder.updatePrice();
									}
								}
							});
							createOrder.sizeL.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent e) {
									if (createOrder.sizeL.isSelected()) {
										int giaban = createOrder.newOrder.getGiaBan();
										int giaup = createOrder.newOrder.getGiaUpsize();
										createOrder.newOrder.setGiaBan(giaban + giaup);
										createOrder.updatePrice();
									}
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

	public void clickTablePromotion() {
		view.promotionTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = view.promotionTable.getSelectedRow();
				if (r < 0) {
					return;
				}
				view.txtid.setText(view.promotionTable.getValueAt(r, 0).toString());
				view.txtnd.setText(view.promotionTable.getValueAt(r, 1).toString());
				view.txtgiamgia.setText(view.promotionTable.getValueAt(r, 2).toString());
				view.txtngaybd.setText(view.promotionTable.getValueAt(r, 3).toString());
				view.txtngaykt.setText(view.promotionTable.getValueAt(r, 4).toString());
			}
		});
	}

	public void addPromotion() {
		view.btnadd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String IDKhuyenMai = view.txtid.getText().trim();
					String noiDung = view.txtnd.getText().trim();
					int giamGia = Integer.parseInt(view.txtgiamgia.getText().trim());
					String ngayBD = view.txtngaybd.getText().trim();
					String ngayKT = view.txtngaykt.getText().trim();

					PromotionDAO.insertPromotion(IDKhuyenMai, noiDung, giamGia, ngayBD, ngayKT);
					JOptionPane.showMessageDialog(view, "Save sucess!");
					setDataTablePromotion();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}

	public void updatePromotion() {
		view.btnupdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String IDKhuyenMai = view.txtid.getText().trim();
					String noiDung = view.txtnd.getText().trim();
					int giamGia = Integer.parseInt(view.txtgiamgia.getText().trim());
					String ngayBD = view.txtngaybd.getText().trim();
					String ngayKT = view.txtngaykt.getText().trim();

					PromotionDAO.updatePromotion(IDKhuyenMai, noiDung, giamGia, ngayBD, ngayKT);
					JOptionPane.showMessageDialog(view, "Upadate sucess!");
					setDataTablePromotion();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}

	public void deletePromotion() {
		view.btnxoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = view.promotionTable.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(view, "Please select the promotion to delete.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					String proDeleteId = view.promotionTable.getValueAt(selectedRow, 0).toString();
					PromotionDAO.deletePromotion(proDeleteId);
					JOptionPane.showMessageDialog(view, "Promotion has been successfully removed.");
					setDataTablePromotion();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
	}

	public void searchPromotion() {
		view.btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idkm = view.txttim.getText();
				List<Promotion> promotion = null;
				try {
					promotion = PromotionDAO.findPromotion(idkm, idkm);
					PromotionTableModel model = new PromotionTableModel(promotion);
					view.promotionTable.setModel(model);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	//CUSTOMER ACTION
		public void initActionCustomer()
		{
			view.btnAddCustomer.addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {	
					CreateCustomer cr = new CreateCustomer();
					cr.setVisible(true);	
					
					cr.btnCancel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							int result = JOptionPane.showConfirmDialog(cr.btnCancel, "Do you want to exit?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
							if (result == JOptionPane.OK_OPTION) {
								cr.State = false;
								cr.dispose();
							}
							
						}
					});
					
					cr.btnSave.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(checkInfoCustomer(cr) == false)
							{
								JOptionPane.showMessageDialog(cr.panel, "Please enter complete information!");
							}
							else
							{
								String id = cr.idField.getName();
								String name = cr.nameField.getText();
								String sex = "";
								if(cr.rdoMale.isSelected())
								{
									sex = cr.rdoMale.getText();
								}
								else
								{
									sex = cr.rdoFemale.getText();
								}
								String phoneNum = cr.phoneNumField.getText();
								String address = cr.addressField.getText();
								String email = cr.emailField.getText();
								try {
									CustomerDAO.insertCustomer(id, name, sex, phoneNum, address, email);
									JOptionPane.showMessageDialog(cr.panel, "Insert success!");
									cr.dispose();
									setDataTableCustomer();
								} catch (Exception e2) {
									e2.printStackTrace();
								}
							}
						}
					});
				}
			});
			
			view.btnResetCustomer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					List<Customer> customers = null;
					view.customerNameFind.setText(" ");
					view.customerPhoneFind.setText(" ");
					try {
						customers = customerDAO.getData();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					CustomerTableModel model = new CustomerTableModel(customers);
					view.customerTable.setModel(model);
					view.customerNameFind.setEnabled(true);
					view.customerPhoneFind.setEnabled(true);
					
				}
			});
			
			view.customerNameFind.getDocument().addDocumentListener(new DocumentListener() {
	            private void updatePhoneTextField() {
	                if (view.customerNameFind.getText().isEmpty()) {
	                    view.customerPhoneFind.setEnabled(true); // Enable phoneTextField if nameTextField is empty
	                } else {
	                	view.customerPhoneFind.setEnabled(false);// Disable phoneTextField if nameTextField has text
	                	view.btnFindCustomer.addActionListener(new ActionListener() {
	            			
	            			@Override
	            			public void actionPerformed(ActionEvent e) {
	            				String name = view.customerNameFind.getText();
	            	            List<Customer> customers = null;
	            	            try {
	            	            	customers = CustomerDAO.findCustomer(name);
	            					CustomerTableModel model = new CustomerTableModel(customers);
	            					view.customerTable.setModel(model);
	            				} catch (Exception e2) {
	            					e2.printStackTrace();
	            				}
	            				
	            			}
	            		});
	                }
	            }

				@Override
				public void insertUpdate(DocumentEvent e) {
					updatePhoneTextField();
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					updatePhoneTextField();
					
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					updatePhoneTextField();
					
				}
	        });
	    
			view.customerPhoneFind.getDocument().addDocumentListener(new DocumentListener() {
	            private void updateNameTextField() {
	                if (view.customerPhoneFind.getText().isEmpty()) {
	                    view.customerNameFind.setEnabled(true);
	                } else {
	                	view.customerNameFind.setEnabled(false); 
	                	view.btnFindCustomer.addActionListener(new ActionListener() {
	            			
	            			@Override
	            			public void actionPerformed(ActionEvent e) {
	            				String phoneNum = view.customerPhoneFind.getText();
	            	            List<Customer> customers = null;
	            	            try {
	            	            	customers = CustomerDAO.findCustomerByPhoneNum(phoneNum);
	            					CustomerTableModel model = new CustomerTableModel(customers);
	            					view.customerTable.setModel(model);
	            				} catch (Exception e2) {
	            					e2.printStackTrace();
	            				}
	            				
	            			}
	            		});
	                }
	            }

				@Override
				public void insertUpdate(DocumentEvent e) {
					updateNameTextField();
					
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					updateNameTextField();
					
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					updateNameTextField();
					
				}
	        });
		
			view.customerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int r = view.customerTable.getSelectedRow();
					if(r<0)
					{
						return;
					}
					view.customerIDField.setText(view.customerTable.getValueAt(r, 0).toString());
					view.customerNameField.setText(view.customerTable.getValueAt(r, 1).toString());
					view.customerEmailField.setText(view.customerTable.getValueAt(r, 2).toString());	
					view.customerPhoneField.setText(view.customerTable.getValueAt(r, 3).toString());
					view.customerAddressField.setText(view.customerTable.getValueAt(r, 4).toString());
					
					
				}
			});
		
			view.btnUpdateCustomer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					    String ID = view.customerIDField.getText().trim(); 
					    String name = view.customerNameField.getText().trim();
					    String email = view.customerEmailField.getText().trim();
					    String phoneNum = view.customerPhoneField.getText().trim();
					    String address = view.customerAddressField.getText().trim();
						try {
							CustomerDAO.updateCustomer(ID,name,email,phoneNum,address);
							JOptionPane.showMessageDialog(view.employeePanelTab(), "Update success!");
							setDataTableCustomer();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				}
			});
			
			view.btnDeleteCustomer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String id = view.customerIDField.getText().trim();
			        if (id == null || id.isEmpty()) {
			            JOptionPane.showMessageDialog(view.customerPanelTab(), "No customer selected.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        int response = JOptionPane.showConfirmDialog(view.employeePanelTab(), "Delete this customer?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        if (response == JOptionPane.NO_OPTION) {
			            return;
			        }

			        try {
			            CustomerDAO.deleteCustomer(id);				            				            
			            setDataTableCustomer();
			            JOptionPane.showMessageDialog(view.employeePanelTab(), "Customer deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
			        } catch (SQLException e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(view.employeePanelTab(), "Error deleting customer.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
					
				}
			});
		}
		
		public boolean checkInfoCustomer(CreateCustomer cr)
		{
			if(cr.nameField.getText().trim() == null || cr.bg.isSelected(null) || cr.phoneNumField.getText().trim() == null || cr.emailField.getText().trim() == null || cr.addressField.getText().trim() == null)
			{
				return false;
			}
			else{
				return true;
			}
		}
}
