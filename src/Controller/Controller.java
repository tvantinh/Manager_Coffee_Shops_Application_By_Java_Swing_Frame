package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;

import Model.Model;
import Object.Inventory;
import Object.Order;
import Object.Product;
import Object.TypeProduct;
import View.EditOrder;
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
