package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import model.Expense;
import view.DigitFilter;

public class DeleteExpenseController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(DeleteExpenseController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info("pressed \"delete\"");
		int index = listWindow.getMyList().getSelectedIndex();
		String type = listWindow.getFrame().getTitle();

		if (index < 0) {
			listWindow.showMessage("Нужно выбрать расход из списка");
			LOGGER.debug("nothing selected");

		} else if (index >= 0 && listWindow.getNameField().isEmpty() || listWindow.getPriceField().isEmpty()
				|| listWindow.getRunField().isEmpty()
				|| listWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()) {

			listWindow.showMessage("Не все поля заполнены");
			LOGGER.debug("not all fields are filled");
			return;
		} else if (index >= 0 && !listWindow.getNameField().isEmpty() && !listWindow.getPriceField().isEmpty()
				&& !listWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()
				&& !listWindow.getRunField().isEmpty()) {
			String name = listWindow.getNameField();
			LocalDate date = LocalDate.parse(listWindow.getDatePicker().getJFormattedTextField().getText());
			int run = Integer.parseInt(listWindow.getRunField());
			int price = Integer.parseInt(listWindow.getPriceField());
			boolean result = database.deleteExpense(name, run, date, price, type);
			LOGGER.debug("remote expense name = " + name + ", run = " + run + ", date = " + date + ", price = " + price
					+ ", type = " + type);
		}
		listWindow.getPriceDoc().setDocumentFilter(null);
		listWindow.getRunDoc().setDocumentFilter(null);
		List<Expense> newDatabase = database.searchExpenseByType(type);
		listWindow.getMyList().setListData(newDatabase.toArray());
		listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
		listWindow.getRunDoc().setDocumentFilter(new DigitFilter());

		if (database.searchExpenseByType(type).size() == 0) {
			listWindow.showMessage("Все " + type + " удалены");
			LOGGER.debug("all expenses of type \"" + type + "\" are removed");
		}
		if (database.getGeneralDB().size() == 0) {
			listWindow.showMessage("Все расходы удалены");
			LOGGER.debug("all expenses are removed");
		}
	}
}
