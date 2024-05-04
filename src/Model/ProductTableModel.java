package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Object.Product;
public class ProductTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String[] COLUMN_NAMES = {"ID","Product name","Unit" ,"Price","describe","",""};
	List<Product> listProduct = new ArrayList<>();
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	//List<TypeProduct> listTypeProduct = new ArrayList<>();
	DBConnect db = new DBConnect();
	public ProductTableModel()
	{
		try {
			getDataProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getDataProduct() throws SQLException
	{
		String getListProduct = "select * from ThucDon";
		ResultSet rs = db.query(getListProduct);
		
		while(rs.next())
		{
			Product pd = new Product();
			pd.setIDSanPham(rs.getString(1));
			pd.setTenSanPham(rs.getString(2));
			pd.setDonViTinh(rs.getString(3));
			pd.setMoTa(rs.getString(4));
			pd.setGiaBan(rs.getInt(5));
			pd.setIDLoaiSP(rs.getString(6));
			listProduct.add(pd);
		}
	}
	public void setdata(List<Product> products)
	{
		this.listProduct = products;
        fireTableDataChanged();
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
        default:
            return null;
            }
	}
		@Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }
	
	
	
	
}
