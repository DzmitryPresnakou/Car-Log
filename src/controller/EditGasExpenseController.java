package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;
import org.apache.log4j.Logger;

import model.Expense;
import view.DigitFilter;

public class EditGasExpenseController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(EditGasExpenseController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info("pressed \"edit\"");
		int index = gasWindow.getMyList().getSelectedIndex();
		String type = gasWindow.getFrame().getTitle();

		if (index < 0) {
			LOGGER.debug("expense not selected");
			gasWindow.showMessage("Нужно выбрать расход из списка");

		} else if (index >= 0 && gasWindow.getNameField().isEmpty() || gasWindow.getPriceField().isEmpty()
				|| gasWindow.getRunField().isEmpty()
				|| gasWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()
				|| gasWindow.getGasField().isEmpty()) {
			LOGGER.debug("not all fields are filled");
			listWindow.showMessage("Не все поля заполнены");
			return;

		} else if (index >= 0 && !gasWindow.getNameField().isEmpty() && !gasWindow.getPriceField().isEmpty()
				&& !gasWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()
				&& !gasWindow.getRunField().isEmpty() && !gasWindow.getGasField().isEmpty()) {
			String newName = gasWindow.getNameField();
			String name = database.searchExpenseByType(type).get(index).getName();
			int price = database.searchExpenseByType(type).get(index).getPrice();
			int run = database.searchExpenseByType(type).get(index).getRun();
			int gas = database.searchExpenseByType(type).get(index).getGas();
			int newPrice = Integer.parseInt(gasWindow.getPriceField());
			int newRun = Integer.parseInt(gasWindow.getRunField());
			int newGas = Integer.parseInt(gasWindow.getGasField());
			LocalDate newDate = LocalDate.parse(gasWindow.getDatePicker().getJFormattedTextField().getText());

			if (database.searchExpenseByNameRunDatePriceTypeGas(newName, newRun, newDate, newPrice, type, newGas)) {
				LOGGER.debug("entered expense that already exists");
				gasWindow.showMessage("Расход с такими параметрами уже есть в списке");
				return;
			}
			int dbIndex = database.findExpenseByNameAndRunAndPriceGas(name, run, price, gas);
			List<Expense> editedGasExpenses = database.editGasExpense(dbIndex, newName, newRun, newDate, newPrice, type,
					newGas);

			LOGGER.info("expense edited");
			LOGGER.info("expense edited");
			LOGGER.debug("edited expense name = " + newName + ", run = " + newRun + "Date: " + newDate + ", price = "
					+ newPrice + ", type = " + type + ", gas = " + newGas);
		}

		gasWindow.getPriceDoc().setDocumentFilter(null);
		gasWindow.getRunDoc().setDocumentFilter(null);
		gasWindow.getGasDoc().setDocumentFilter(null);
		List<Expense> newDatabase = database.searchExpenseByType(type);
		gasWindow.getMyList().setListData(newDatabase.toArray());
		gasWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
		gasWindow.getRunDoc().setDocumentFilter(new DigitFilter());
		gasWindow.getGasDoc().setDocumentFilter(new DigitFilter());
	}
}
