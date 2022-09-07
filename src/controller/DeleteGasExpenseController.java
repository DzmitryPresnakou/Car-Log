package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import model.Expense;
import view.DigitFilter;

public class DeleteGasExpenseController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(DeleteGasExpenseController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info("pressed \"delete\"");
		int index = gasWindow.getMyList().getSelectedIndex();
		String type = gasWindow.getFrame().getTitle();

		if (index < 0) {
			gasWindow.showMessage("Нужно выбрать расход из списка");
			LOGGER.debug("nothing selected");

		} else if (index >= 0 && gasWindow.getNameField().isEmpty() || gasWindow.getPriceField().isEmpty()
				|| gasWindow.getRunField().isEmpty()
				|| gasWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()
				|| gasWindow.getGasField().isEmpty()) {

			gasWindow.showMessage("Не все поля заполнены");
			LOGGER.debug("not all fields are filled");
			return;
		} else if (index >= 0 && !gasWindow.getNameField().isEmpty() && !gasWindow.getPriceField().isEmpty()
				&& !gasWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()
				&& !gasWindow.getRunField().isEmpty() && !gasWindow.getGasField().isEmpty()) {
			String name = gasWindow.getNameField();
			LocalDate date = LocalDate.parse(gasWindow.getDatePicker().getJFormattedTextField().getText());
			int run = Integer.parseInt(gasWindow.getRunField());
			int price = Integer.parseInt(gasWindow.getPriceField());
			int gas = Integer.parseInt(gasWindow.getGasField());
			boolean result = database.deleteGasExpense(name, run, date, price, type, gas);
			LOGGER.debug("remote gasExpense name = " + name + ", run = " + run + ", date = " + date + ", price = "
					+ price + ", type = " + type + ", gas = " + gas);
		}
		gasWindow.getPriceDoc().setDocumentFilter(null);
		gasWindow.getRunDoc().setDocumentFilter(null);
		gasWindow.getGasDoc().setDocumentFilter(null);
		List<Expense> newDatabase = database.searchExpenseByType(type);
		gasWindow.getMyList().setListData(newDatabase.toArray());
		gasWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
		gasWindow.getRunDoc().setDocumentFilter(new DigitFilter());
		gasWindow.getGasDoc().setDocumentFilter(new DigitFilter());

		if (database.searchExpenseByType(type).size() == 0) {
			gasWindow.showMessage("Все " + type + " удалены");
			LOGGER.debug("all gasExpense of type \"" + type + "\" are removed");
		}
		if (database.getGeneralDB().size() == 0) {
			gasWindow.showMessage("Все расходы удалены");
			LOGGER.debug("all gasExpense are removed");
		}
	}
}
