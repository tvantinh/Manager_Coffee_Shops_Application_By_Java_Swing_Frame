package Controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import ModelApp.Model.BillDAO;
import ModelApp.Model.CustomerDAO;
import ModelApp.Model.EmployeeDAO;
import ModelApp.Model.InventoryDAO;
import ModelApp.Model.OrderDAO;
import ModelApp.Model.ProductDAO;
import ModelApp.Model.PromotionDAO;
import ModelApp.Model.TypeInventoryDAO;
import ModelApp.Model.TypeProductDAO;
import ModelApp.Object.Bill;
import ModelApp.Object.Customer;
import ModelApp.Object.DateConvert;
import ModelApp.Object.Employee;
import ModelApp.Object.Inventory;
import ModelApp.Object.Order;
import ModelApp.Object.Product;
import ModelApp.Object.Promotion;
import ModelApp.Object.TypeInventory;
import ModelApp.Object.TypeProduct;
import TableModel.BillTableModel;
import TableModel.CustomerTableModel;
import TableModel.EmployeeTableModel;
import TableModel.InventoryTableModel;
import TableModel.ProductTableModel;
import TableModel.PromotionTableModel;
import TableModel.TypeInventoryTableModel;
import TableModel.TypeProductTableModel;
import View.BillToPay;
import View.ChangePassword;
import View.ChoosePromotion;
import View.CreateEmployee;
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
		setDataTableInventory();
		setDataTablePromotion();
		setDataTableTypeInventory();
		setDataTableTypeProduct();
		setDataTableBillHistory();
		clickBillTable();
		loadPanelOrder();
		initActionButtonPay();
		initActionEmployee();
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
				if(view.billTable.getValueAt(r, 6).toString()!=null) {
					view.txtnote.setText(view.billTable.getValueAt(r, 6).toString());
				}
				
			}
		});
	}
	
	public void updateTotalToBill(BillToPay BP, Promotion p, int castTotal) {
		BP.discountLabel.setText(p.getNoiDung());
		BP.percentOfPromotion.setText(p.getGiaGiam() + " %");

		int discountTotal = (int) (castTotal * (p.getGiaGiam() * 0.01));
		int vat = (int) ((castTotal - discountTotal) * 0.1);// mac dinh 10% vat
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
													BP.setPromotion(cp.getPromotionChoosed());
													updateTotalToBill(BP, BP.promotion,
															Integer.parseInt(view.totalLabel.getText()));

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
						BP.useVIPbtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BP.promotion = new Promotion("KMKHACHVIP", "Khuyến mãi khách vip", 20, null, null);
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
									String IDHoaDon = RanmdomIDHoaDon(employeeLogin,BP.customer,BP.promotion);
									Date date = new Date();
									SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-YYYY");
									String dayFormat = df.format(date);
									orderDAO.insert(employeeLogin, IDHoaDon, dayFormat, Integer.valueOf(BP.totalLabel.getText()) , BP.customer, BP.promotion, BP.noteText.getText(), listOrder);
									JOptionPane.showMessageDialog(view.componentOfBillPanel, "Thanh toán thành công!!!");
									BP.dispose();
								}
								catch (Exception ev)
								{
									ev.printStackTrace();
								}
							}
						});
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(view.componentOfBillPanel, "vui lòng chọn sản phẩm!!!");
				}

			}
		});

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
		TypeProductTableModel typeProductTableModel = new TypeProductTableModel(listTypeProduct);
		typeProductTableModel.fireTableDataChanged();
		view.setDataTableTypeProduct(typeProductTableModel);
	}

	public void setDataTableInventory() throws SQLException {
		List<Inventory> listInventory = inventoryDAO.getData();
		InventoryTableModel inventoryTableModel = new InventoryTableModel(listInventory);
		inventoryTableModel.fireTableDataChanged();
		view.setDataTableInventory(inventoryTableModel);
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

	public String IDStringConvert(Employee e, Customer c,Promotion p)
	{
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
	public String RanmdomIDHoaDon(Employee e, Customer c,Promotion p) throws NoSuchAlgorithmException
	{
		String input = IDStringConvert(e,c,p);
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
	public DateConvert dateConvert(JDateChooser dataChooser)
	{
		return new DateConvert(dataChooser.getDate().getDate(), dataChooser.getDate().getMonth()+1, dataChooser.getDate().getYear()+1900);
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
							//Employee em = new Employee(ce.IDField.getText(), ce.nameField.getText(), ce.dateChooser.getDateFormatString(), ce.CCCDField.getText(), ce.phoneField.getText(), ce.bg.getSelection().toString(), ce.lblAvatar.getText(), ce.cboPosition.getSelectedItem().toString(), ce.dateChooser1.getDateFormatString(), ce.employeeUsernameField.getText(), ce.employeePasswordField.getSelectedText());
							
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
										selectedOption.toString(), destination.toString(), position.toString(), 
										dc1.toString(), ce.employeeUsernameField.getText(), ce.employeePasswordField.getText());
								emoloyeeDAO.getData();
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
						// Create a file chooser
				        JFileChooser fc = new JFileChooser();
				        int result = fc.showOpenDialog(null);

				        // Make sure that a file was chosen, else exit
				        if (result != JFileChooser.APPROVE_OPTION) {
				            System.exit(0);
				        }

				        // Get file path
				        String path = fc.getSelectedFile().getAbsolutePath();

				        String existingFolderPath = "src/img";
				        File folder = new File(existingFolderPath);
				        if (!folder.exists()) {
				            boolean success = folder.mkdir();
				            if (!success) {
				                System.err.println("Failed to create directory: images");
				                System.exit(1);
				            }
				        }

				        // Get the destination path for the new image (image.jpg will be the new name)
				        destination = folder.getAbsolutePath() + File.separator + "image.jpg";

				        try {
				            // Copy file from source to destination
				            FileChannel source = new FileInputStream(path).getChannel();
				            FileChannel dest = new FileOutputStream(destination).getChannel();
				            dest.transferFrom(source, 0, source.size());

				            // Close the channels
				            source.close();
				            dest.close();
				            System.out.println("File copied successfully.");
				        } catch (IOException e1) {
				            e1.printStackTrace();
				        }
				        Image img = new ImageIcon(destination).getImage().getScaledInstance(215, 309,Image.SCALE_SMOOTH);
				        ce.lblAvatar.setIcon(new ImageIcon(img));
					}
				});
				
				view.btnReset.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						view.employeeNameFind.setText("");
						view.employeePhoneFind.setText("");
					}
				});
				
				view.btnFind.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String tenNhanVien = view.employeeNameField.getText();
						String sdt = view.employeePhoneField.getText();
						
						System.out.println(tenNhanVien+ sdt); 
						
					}
				});
			}
		});
		
		view.btnUpdateEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
				try {
					EmployeeDAO.updateEmployee(view.employeeIDField.getText(), view.employeeNameField.getText(), dc.toString(), view.employeeCCCDField.getText(), view.employeePhoneField.getText(), position.toString());
					emoloyeeDAO.getData();
					JOptionPane.showMessageDialog(view.employeePanelTab(), "Update success!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
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
		
		view.btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp = new ChangePassword();
				cp.setVisible(true);
				cp.btnSave.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(checkPassword(cp) == false)
						{
							JOptionPane.showMessageDialog(cp.panel, "Please enter complete information!");
						}
						else
						{
							try {
								EmployeeDAO.changePassword("abc", cp.XacNhanMKField.getText());
								emoloyeeDAO.getData();
								JOptionPane.showMessageDialog(view.employeePanelTab(), "Update success!");
							}catch (Exception e1) {
								// TODO: handle exception
								e1.printStackTrace();
							}
						}
					}
				});
			}
		});
	}
	
	public boolean checkPassword(ChangePassword cp)
	{
		if(cp.MKHienTaiField.getText().isEmpty() || cp.MKCuField.getText().isEmpty() || cp.XacNhanMKField.getText().isEmpty())
		{
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean checkInfo(CreateEmployee ce)
	{
		if(ce.IDField.getText().trim().isEmpty() || ce.nameField.getText().trim().isEmpty() || ce.dateChooser.getDate()==null || ce.CCCDField.getText().trim().isEmpty() || ce.phoneField.getText().trim().isEmpty() || ce.bg.isSelected(null) || ce.dateChooser1.getDate()==null)
		{
			return false;
		}
		else{
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
}
