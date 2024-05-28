package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ModelApp.Object.Customer;


public class CustomerTableModel extends AbstractTableModel{


	private static final long serialVersionUID = 1L;
	protected static String[] COLUMN_NAMES = {"ID","Name","Email","Phone Number", "Address"};
	List<Customer> listCustomer = new ArrayList<>();
	public List<Customer> getListCustomer()
	{
		return listCustomer;
	}
	public CustomerTableModel(List<Customer> Customer)
	{
		this.listCustomer = Customer;
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return listCustomer.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer Customer = listCustomer.get(rowIndex);
		switch(columnIndex)
		{
		case 0:
			return Customer.getIDKH();
		case 1:
			return Customer.getTenKH();
		case 2:
			return Customer.getEmail();
		case 3:
			return Customer.getSDT();
		case 4:
			return Customer.getDiaChi();
		default:
			return null;
		}
	}
	@Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
