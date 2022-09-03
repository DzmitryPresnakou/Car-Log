package controller;

import java.awt.event.ActionEvent;

public class BackWindowController extends BaseController {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		gasWindow.getFrame().setVisible(false);
		listWindow.getFrame().setVisible(false);
		carWindow.getFrame().setVisible(false);
		window.getFrame().setVisible(true);
	}
}
