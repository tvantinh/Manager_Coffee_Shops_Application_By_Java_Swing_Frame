package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ModelApp.Object.Inventory;



public class InventoryTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Inventory> listInventory = new ArrayList<>();
	protected static String[] COLUMN_NAMES = {"ID","Inventory name","Date IV" ,"Quanlity","Unit","describe","IDType",""};
	
	public InventoryTableModel()
	{
		
	}
	public List<Inventory> getListInventory() {
		return listInventory;
	}
	public InventoryTableModel(List<Inventory> ls)
	{
		this.listInventory = ls;
		fireTableDataChanged();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listInventory.size();
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
		Inventory IV = listInventory.get(rowIndex);
		switch(columnIndex) {
		
		 case 0: 
			 return IV.getIDNguyenLieu();
		 case 1:
			 return IV.getTenNguyenLieu();
		 case 2:
			 return IV.getDate();
		 case 3:
			 return IV.getSoLuong();
		 case 4:
			 return IV.getDonVi();
		 case 5:
			 return IV.getGiaNhap();
		 case 6:
			 return IV.getIDLoai();
			default:
				return null;
		}
	}

}
