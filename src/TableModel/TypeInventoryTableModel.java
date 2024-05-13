package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Object.TypeInventory;


public class TypeInventoryTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	protected static String[] COLUMN_NAMES = {"ID","Name type",""};
	List<TypeInventory> listTypeInventory = new ArrayList<>();
	public TypeInventoryTableModel()
	{
		
	}
	
	
	public void setData(List<TypeInventory> list)
	{
		listTypeInventory = list;
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listTypeInventory.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		TypeInventory tpd = listTypeInventory.get(rowIndex);
		switch(columnIndex)
		{
			case 0:
				return tpd.getIDLoaiSP();
			case 1:
				return tpd.getTenLoai();
			default:
				return null;
		}
	}

	@Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
