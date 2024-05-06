package Model;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Object.TypeProduct;

public class TypeProductTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String[] COLUMN_NAMES = {"ID","Name type","",""};
	List<TypeProduct> listTypeProduct = new ArrayList<>();
	public TypeProductTableModel()
	{
		
	}
	
	
	public void setData(List<TypeProduct> list)
	{
		listTypeProduct = list;
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listTypeProduct.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		TypeProduct tpd = listTypeProduct.get(rowIndex);
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
