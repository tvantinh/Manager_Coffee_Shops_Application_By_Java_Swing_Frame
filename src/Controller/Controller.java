package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;

import Model.Model;
import Object.Product;
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
			List<TypeProduct> listTypeProduct = Model.getDataTypeProduct();
			App.setDataTableTypeProduct(listTypeProduct);
			App.setDataTableProduct(listProduct);
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
