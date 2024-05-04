package Main;

import javax.swing.SwingUtilities;

import Controller.Controller;
import Model.ProductTableModel;
import View.ViewMain;

public class main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProductTableModel model = new ProductTableModel();
                ViewMain view = new ViewMain();
                Controller controller = new Controller(view,model);
                controller.refreshData();
                view.setVisible(true);
            }
        });
	}
}
