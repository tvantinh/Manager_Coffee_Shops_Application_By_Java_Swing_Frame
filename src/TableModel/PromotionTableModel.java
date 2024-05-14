package TableModel;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Object.Promotion;

public class PromotionTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	protected static String [] COLUMN_NAMES= {"IDKhuyenMai","Noi dung","Giam gia","Ngay BD","Ngay KT"};
	List <Promotion> listPromotion=new ArrayList<>();
	public List<Promotion> getListPromotion()
	{
		return listPromotion;
	}
	public void setListPromotion(List<Promotion> listPromotion) {
		this.listPromotion = listPromotion;
	}
	public void setData(List<Promotion> promotion)
	{
		this.listPromotion = promotion;
        fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listPromotion.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Promotion pd = listPromotion.get(rowIndex);
		switch (columnIndex) {
		case 0:
            return pd.getIDKhuyenMai(); 
        case 1:
            return pd.getNoiDung();
        case 2:
            return pd.getGiaGiam();
        case 3:
            return pd.getNgayBD();
        case 4:
            return pd.getNgayKT();
        default:
            return null;
            }
	}
	@Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
