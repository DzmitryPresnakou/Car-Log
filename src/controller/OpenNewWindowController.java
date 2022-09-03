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

		if (type.equalsIgnoreCase("Машина")) {
			carWindow.getFrame().setVisible(true);
			window.getFrame().setVisible(false);

		} else if (type.equalsIgnoreCase("Заправка")) {
			gasWindow.getFrame().setVisible(true);
			window.getFrame().setVisible(false);
			gasWindow.getFrame().setTitle(type);
			gasWindow.setNameField(type);
			gasWindow.getPriceDoc().setDocumentFilter(null);
			gasWindow.getRunDoc().setDocumentFilter(null);
			gasWindow.getGasDoc().setDocumentFilter(null);
			List<Expense> newDatabase = database.searchExpenseByType(type);
			gasWindow.getMyList().setListData(newDatabase.toArray());
			gasWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
			gasWindow.getRunDoc().setDocumentFilter(new DigitFilter());
			gasWindow.getGasDoc().setDocumentFilter(new DigitFilter());

		} else {
			listWindow.getFrame().setVisible(true);
			window.getFrame().setVisible(false);
			listWindow.getFrame().setTitle(type);
			listWindow.setNameField(type);
			listWindow.getPriceDoc().setDocumentFilter(null);
			listWindow.getRunDoc().setDocumentFilter(null);
			
			List<Expense> newDatabase = database.searchExpenseByType(type);
			listWindow.getMyList().setListData(newDatabase.toArray());
			listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
			listWindow.getRunDoc().setDocumentFilter(new DigitFilter());
		}
	}
}
