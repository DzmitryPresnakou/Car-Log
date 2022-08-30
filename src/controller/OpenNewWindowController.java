package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.List;

import model.Expense;
import view.DigitFilter;

public class OpenNewWindowController extends BaseController {

	@Override
	public void actionPerformed(ActionEvent e) {
		String type = ((Component) e.getSource()).getName();
		String expenseName = ((Component) e.getSource()).getName();
		listWindow.getFrame().setVisible(true);
		window.getFrame().setVisible(false);
		listWindow.getFrame().setTitle(type);
		listWindow.setNameField(expenseName);
		listWindow.getPriceDoc().setDocumentFilter(null);
		List<Expense> newDatabase = database.searchExpenseByType(type);
		listWindow.getMyList().setListData(newDatabase.toArray());
		listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());

	}

}
