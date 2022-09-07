package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import model.Expense;
import view.DigitFilter;

public class EditExpenseController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(EditExpenseController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info("pressed \"edit\"");
		int index = listWindow.getMyList().getSelectedIndex();
		String type = listWindow.getFrame().getTitle();

		if (index < 0) {
			LOGGER.debug("expense not selected");
			listWindow.showMessage("Нужно выбрать расход из списка");

		} else if (index >= 0 && listWindow.getNameField().isEmpty() || listWindow.getPriceField().isEmpty()
				|| listWindow.getRunField().isEmpty()
				|| listWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()) {
			LOGGER.debug("not all fields are filled");
			listWindow.showMessage("Не все поля заполнены");
			return;

		} else if (index >= 0 && !listWindow.getNameField().isEmpty() && !listWindow.getPriceField().isEmpty()
				&& !listWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()
				&& !listWindow.getRunField().isEmpty()) {
			String newName = listWindow.getNameField();
			LocalDate newDate = LocalDate.parse(listWindow.getDatePicker().getJFormattedTextField().getText());
			String name = database.searchExpenseByType(type).get(index).getName();
			int price = database.searchExpenseByType(type).get(index).getPrice();
			int run = database.searchExpenseByType(type).get(index).getRun();
			int newPrice = Integer.parseInt(listWindow.getPriceField());
			int newRun = Integer.parseInt(listWindow.getRunField());

			if (database.searchExpenseByNameRunDatePriceType(newName, newRun, newDate, newPrice, type)) {
				LOGGER.debug("the entered expense already exists");
				listWindow.showMessage("Расход с такими параметрами уже есть в списке");
				return;
			}
			int dbIndex = database.findExpenseByNameAndRunAndPrice(name, run, price);
			List<Expense> editedExpenses = database.editExpense(dbIndex, newName, newRun, newDate, newPrice, type);

			LOGGER.info("expense edited");
			LOGGER.debug("edited expense name = " + newName + ", run = " + newRun + "Date: " + newDate + ", price = "
					+ newPrice + ", type = " + type);
		}

		listWindow.getPriceDoc().setDocumentFilter(null);
		listWindow.getRunDoc().setDocumentFilter(null);
		List<Expense> newDatabase = database.searchExpenseByType(type);
		listWindow.getMyList().setListData(newDatabase.toArray());
		listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
		listWindow.getRunDoc().setDocumentFilter(new DigitFilter());
	}
}
