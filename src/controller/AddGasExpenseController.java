package controller;

import java.awt.event.ActionEvent;
import java.util.List;

import model.Expense;
import model.GasExpense;
import view.DigitFilter;

public class AddGasExpenseController extends BaseController {

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = gasWindow.getNameField();
		String type = gasWindow.getFrame().getTitle();

		if (name.isEmpty() || gasWindow.getPriceField().isEmpty() || gasWindow.getRunField().isEmpty()
				|| gasWindow.getChooseDate().getFormattedTextField().getText().isEmpty()
				|| gasWindow.getGasField().isEmpty()) {
			gasWindow.showMessage("Не все поля заполнены");
			return;
		}
		
		int run = Integer.parseInt(gasWindow.getRunField());
		Integer year = gasWindow.getChooseDate().getModel().getYear();
		Integer month = gasWindow.getChooseDate().getModel().getMonth() + 1;
		Integer day = gasWindow.getChooseDate().getModel().getDay();

		String date = (Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day));
		int price = Integer.parseInt(gasWindow.getPriceField());
		int gas = Integer.parseInt(gasWindow.getGasField());

		if (database.searchExpenseByNameRunDatePrice(name, run, date, price)) {
			gasWindow.showMessage("Устройство с такими параметрами уже есть в списке");
			return;
		}

		if (type.equalsIgnoreCase("Заправка")) {

			Expense newExpense = new GasExpense(name, run, date, price, type, gas);
			database.addExpense(newExpense);

//		gasWindow.getMyList().setListData(database.searchExpenseByType(type));

//			gasWindow.getPriceDoc().setDocumentFilter(null);
			List<Expense> newDatabase = database.searchExpenseByType(type);
			gasWindow.getMyList().setListData(newDatabase.toArray());
//			gasWindow.getPriceDoc().setDocumentFilter(new DigitFilter());

		}

	}

}
