package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ModelApp.Object.Order;


public class OrderTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	protected static String[] COLUMN_NAMES = {"Item Name","Quantity","Size","Note","Cast"};
	private List<Order> listOrder = new ArrayList<>();
	
	public OrderTableModel(List<Order> order)
	{
		this.listOrder = order;
        fireTableDataChanged();
	}
	public List<Order> getListProduct() {
		return listOrder;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listOrder.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMN_NAMES.length;
	}

	@Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Order pd = listOrder.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			return pd.getTenSanPham();
		case 1:
			return pd.getSoLuong();
		case 2:
			return pd.getSize();
		case 3:
			return pd.getGhichu();
		case 4:
			return pd.getGiaBan();
		default:
			return null;
		}
		
	}

}
