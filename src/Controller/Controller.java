package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;

import Model.Model;
import Object.Customer;
import Object.Employee;
import Object.Inventory;
import Object.Product;
import Object.Promotion;
import Object.TypeInventory;
import Object.TypeProduct;
import View.ViewMain;

public class Controller implements PropertyChangeListener{

	ViewMain App;
	Model Model;
	public Controller(ViewMain App, Model Model)
	{
		this.App = App;
		this.Model = Model;
	}
	public void refeshdata()
	{
		try {
			List<Product> listProduct = Model.getDataProduct();
			App.setDataTableProduct(listProduct);
			
			///liên quan đến type product
			List<TypeProduct> listTypeProduct = Model.getDataTypeProduct();
			App.setDataTableTypeProduct(listTypeProduct);
			//=>hiển thị các loại tương ứng trong new order
			App.loadPanelOrder(listTypeProduct, listProduct);
			
			
			
			
			List<Inventory> listInventory = Model.getDataInventory();
			App.setDataTableInventory(listInventory);
			List<TypeInventory> listTypeInventory = Model.getDataTypeInventory();
			App.setDataTableTypeInventory(listTypeInventory);
			List<Employee> listEmployee = Model.getDataEmployee();
			App.setDataTableEmployee(listEmployee);
			List<Customer> listCustomer = Model.getDataCustomer();
			App.setDataTableCustomer(listCustomer);
			List<Promotion> listPromotion = Model.getDataPromotion();
			App.setDataTablePromotion(listPromotion);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
