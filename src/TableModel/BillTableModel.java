package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ModelApp.Object.Bill;

public class BillTableModel extends AbstractTableModel{
	private static final long serialVersionUID=1;
	protected static String[] COLUMN_NAME= {"ID Bill","Date founded","Total amount","ID Employee","ID Customer","ID Promotion","Note"}; 
	List<Bill> listBill=new ArrayList<>();
	
	public List<Bill> getBill()
	{
		return listBill;
	}
	public BillTableModel(List<Bill> Bill)
	{
		this.listBill=Bill;
		fireTableDataChanged();
	}
	@Override
	public int getRowCount() {
		return listBill.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAME.length;
	}
	@Override
	public String getColumnName(int column) {
		return COLUMN_NAME[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Bill bl=listBill.get(rowIndex);
		switch(columnIndex)
		{
		case 0:
			return bl.getIDHoaDon();
		case 1:
			return bl.getNgayLap();
		case 2:
			return bl.getTongTien();
		case 3:
			return bl.getIDNV();
		case 4:
			return bl.getIDKH();
		case 5:
			return bl.getIDKhuyenMai();
		case 6:
			return bl.getGhiChu();
		default:
			return null;
		}
	}
	

}
