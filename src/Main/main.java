package Main;

import javax.swing.SwingUtilities;

import Controller.Controller;
import View.ViewMain;

public class main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewMain view = new ViewMain();
                try {
					new Controller(view);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                view.setVisible(true);
            }
        });
	}
}
