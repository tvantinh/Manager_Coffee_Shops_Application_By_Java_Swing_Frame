package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ModelApp.Object.Employee;


public class EmployeeTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	protected static String[] COLUMN_NAMES = {"Name","Date of birth","Position","Sex"};
	List<Employee> listEmployee = new ArrayList<>();
	public List<Employee> getListEmployee()
	{
		return listEmployee;
	}
	public EmployeeTableModel(List<Employee> employees)
	{
		this.listEmployee = employees;
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return listEmployee.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee em = listEmployee.get(rowIndex);
		switch(columnIndex)
		{
		case 0:
			return em.getTenNhanVien();
		case 1:
			return em.getNgaySinh();
		case 2:
			return em.getIDChucVu();
		case 3:
			return em.getGioiTinh();
		default:
			return null;
		}
	}
	@Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
	
}
