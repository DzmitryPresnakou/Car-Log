package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.List;

import model.Expense;
import view.DigitFilter;

public class OpenCarWindowController extends BaseController{

	@Override
	public void actionPerformed(ActionEvent e) {

		carWindow.getFrame().setVisible(true);
		window.getFrame().setVisible(false);



	}

}
