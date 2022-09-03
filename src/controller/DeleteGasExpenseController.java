package controller;

import java.awt.event.ActionEvent;
import java.util.List;

import model.Expense;
import view.DigitFilter;

public class DeleteGasExpenseController extends BaseController {

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = gasWindow.getMyList().getSelectedIndex();
		String name = gasWindow.getNameField();
		String type = gasWindow.getFrame().getTitle();

		if (index < 0) {
			gasWindow.showMessage("Нужно выбрать устройство из списка");

		} else if (index >= 0 && name.isEmpty() || gasWindow.getRunField().isEmpty()
				|| gasWindow.getGasField().isEmpty()) {

			gasWindow.showMessage("Не все поля заполнены");
			return;
		}

		if (index >= 0 && !name.isEmpty() && !gasWindow.getPriceField().isEmpty()
				&& !gasWindow.getRunField().isEmpty()
				&& !gasWindow.getGasField().isEmpty()) {
			int run = Integer.parseInt(gasWindow.getRunField());
			int price = Integer.parseInt(gasWindow.getPriceField());
			int gas = Integer.parseInt(gasWindow.getGasField());
			boolean result = database.deleteExpense(name, run);
		}

		List<Expense> newDatabase = database.searchExpenseByType(type);
		gasWindow.getMyList().setListData(newDatabase.toArray());
		gasWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
		gasWindow.getRunDoc().setDocumentFilter(new DigitFilter());
		gasWindow.getGasDoc().setDocumentFilter(new DigitFilter());

		if (database.searchExpenseByType(type).size() == 0) {
			gasWindow.showMessage("Все " + type + " удалены");
		}
		if (database.getGeneralDB().size() == 0) {
			gasWindow.showMessage("Все устройства удалены");
		}
	}
}
