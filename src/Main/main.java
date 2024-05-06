package Main;

import javax.swing.SwingUtilities;

import Controller.Controller;
import Model.Model;
import View.ViewMain;

public class main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Model model = new Model();
                ViewMain view = new ViewMain();
                Controller controller = new Controller(view,model);
                controller.refeshdata();
                view.setVisible(true);
            }
        });
	}
}
