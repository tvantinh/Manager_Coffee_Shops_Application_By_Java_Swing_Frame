package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;

import Model.ProductTableModel;
import Object.Product;
import View.ViewMain;

public class Controller implements PropertyChangeListener{

	ViewMain App;
	ProductTableModel Model ;
	public Controller(ViewMain App, ProductTableModel Model)
	{
		this.App = App;
		this.Model = Model;
	}
	public void refreshData()
	{

		List<Product> data = Model.getListProduct();
		
		App.setDataTableProduct(data);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
