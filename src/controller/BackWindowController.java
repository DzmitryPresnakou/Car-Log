package controller;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

public class BackWindowController extends BaseController {
	
	private final static Logger LOGGER = Logger.getLogger(BackWindowController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info("pressed \"return\"");
		gasWindow.getFrame().setVisible(false);
		listWindow.getFrame().setVisible(false);
		carWindow.getFrame().setVisible(false);
		window.getFrame().setVisible(true);
	}
}
