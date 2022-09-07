package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import model.Expense;
import model.GasExpense;
import view.DigitFilter;

public class AddGasExpenseController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(AddGasExpenseController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info("pressed \"add\"");
		String type = gasWindow.getFrame().getTitle();

		if (gasWindow.getNameField().isEmpty() || gasWindow.getPriceField().isEmpty()
				|| gasWindow.getRunField().isEmpty()
				|| gasWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()
				|| gasWindow.getGasField().isEmpty()) {
			gasWindow.showMessage("Не все поля заполнены");
			LOGGER.debug("nothing entered");
			return;
		} else {
			String name = gasWindow.getNameField();
			LocalDate date = LocalDate.parse(gasWindow.getDatePicker().getJFormattedTextField().getText());
			int run = Integer.parseInt(gasWindow.getRunField());
			int price = Integer.parseInt(gasWindow.getPriceField());
			int gas = Integer.parseInt(gasWindow.getGasField());

			if (database.searchExpenseByNameRunDatePriceTypeGas(name, run, date, price, type, gas)) {
				gasWindow.showMessage("Расход с такими параметрами уже есть в списке");
				LOGGER.debug("the entered gasExpense already exists");
				return;
			} else {
				Expense newExpense = new GasExpense(name, run, date, price, type, gas);
				database.addExpense(newExpense);
				LOGGER.info("new gasExpense added");
				LOGGER.debug("name entered = " + name + ", run entered = " + run + ", date entered = " + date
						+ ", price entered = " + price + ", type entered = " + type + ", gas entered = " + gas);

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
	}
}
