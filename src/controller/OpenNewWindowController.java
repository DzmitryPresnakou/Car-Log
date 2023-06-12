package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Cursor;

import javax.swing.event.MouseInputListener;

import org.apache.log4j.Logger;

import model.Expense;
import view.DigitFilter;

public class OpenNewWindowController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(OpenNewWindowController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		String type = ((Component) e.getSource()).getName();

		if (type.equalsIgnoreCase("Машина")) {
			carWindow.getFrame().setVisible(true);
			LOGGER.info("window " + "\"" + type + "\" open");
			window.getFrame().setVisible(false);
			carWindow.getMadeDoc().setDocumentFilter(null);
			carWindow.getRunDoc().setDocumentFilter(null);
			carWindow.getTankDoc().setDocumentFilter(null);
			carWindow.getMadeDoc().setDocumentFilter(new DigitFilter());
			carWindow.getRunDoc().setDocumentFilter(new DigitFilter());
			carWindow.getTankDoc().setDocumentFilter(new DigitFilter());

		} else if (type.equalsIgnoreCase("Заправка")) {
			gasWindow.getFrame().setVisible(true);
			LOGGER.info("window " + "\"" + type + "\" open");
			window.getFrame().setVisible(false);
			gasWindow.getFrame().setTitle(type);
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
			LOGGER.info("window " + "\"" + type + "\" open");
			window.getFrame().setVisible(false);
			listWindow.getFrame().setTitle(type);
			listWindow.getPriceDoc().setDocumentFilter(null);
			listWindow.getRunDoc().setDocumentFilter(null);

			List<Expense> newDatabase = database.searchExpenseByType(type);
			listWindow.getMyList().setListData(newDatabase.toArray());
			listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
			listWindow.getRunDoc().setDocumentFilter(new DigitFilter());
		}
	}

}
