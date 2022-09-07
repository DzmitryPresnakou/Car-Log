package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import model.Expense;
import view.DigitFilter;

public class AddExpenseController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(AddExpenseController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info("pressed \"add\"");
		String type = listWindow.getFrame().getTitle();

		if (listWindow.getNameField().isEmpty() || listWindow.getPriceField().isEmpty()
				|| listWindow.getRunField().isEmpty()
				|| listWindow.getDatePicker().getJFormattedTextField().getText().isEmpty()) {
			listWindow.showMessage("Не все поля заполнены");
			LOGGER.debug("nothing entered");
			return;
		} else {
			String name = listWindow.getNameField();
			LocalDate date = LocalDate.parse(listWindow.getDatePicker().getJFormattedTextField().getText());
			int run = Integer.parseInt(listWindow.getRunField());
			int price = Integer.parseInt(listWindow.getPriceField());

			if (database.searchExpenseByNameRunDatePriceType(name, run, date, price, type)) {
				listWindow.showMessage("Расход с такими параметрами уже есть в списке");
				LOGGER.debug("the entered expense already exists");
				return;
			} else {
				database.addExpense(new Expense(name, run, date, price, type));
				LOGGER.info("new expense added");
				LOGGER.debug("name entered = " + name + ", run entered = " + run + ", date entered = " + date
						+ ", price entered = " + price + ", type entered = " + type);

				listWindow.getPriceDoc().setDocumentFilter(null);
				listWindow.getRunDoc().setDocumentFilter(null);
				List<Expense> newDatabase = database.searchExpenseByType(type);
				listWindow.getMyList().setListData(newDatabase.toArray());
				listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
			}
		}
	}
}
