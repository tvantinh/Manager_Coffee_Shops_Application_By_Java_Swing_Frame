package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ModelApp.Object.Product;

public class ProductTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	protected static String[] COLUMN_NAMES = {"ID","Product name","Unit" ,"Price","describe","IDTypeProduct","Upsize",""};
	List<Product> listProduct = new ArrayList<>();
	
	
	public ProductTableModel(List<Product> products)
	{
		this.listProduct = products;
        fireTableDataChanged();
	}
	
	public List<Product> getListProduct() {
		return listProduct;
	}
	
	@Override
	public int getRowCount() {
		return listProduct.size();
	}
	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}
	@Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product pd = listProduct.get(rowIndex);
		switch (columnIndex) {
		case 0:
            return pd.getIDSanPham();
        case 1:
            return pd.getTenSanPham();
        case 2:
            return pd.getDonViTinh();
        case 3:
            return pd.getMoTa();
        case 4:
            return pd.getGiaBan();
        case 5:
            return pd.getIDLoaiSP();
        case 6:
            return pd.getUpsize();
        default:
            return null;
            }
	}
}
