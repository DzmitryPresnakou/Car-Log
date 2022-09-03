package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import model.Expense;
import view.DigitFilter;

public class DeleteExpenseController extends BaseController {

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = listWindow.getMyList().getSelectedIndex();
		String name = listWindow.getNameField();
		String type = listWindow.getFrame().getTitle();

		if (index < 0) {
			listWindow.showMessage("Нужно выбрать устройство из списка");

		} else if (index >= 0 && name.isEmpty() || listWindow.getPriceField().isEmpty()
				|| listWindow.getRunField().isEmpty()) {

			listWindow.showMessage("Не все поля заполнены");
			return;
		}

		if (index >= 0 && !name.isEmpty() && !listWindow.getPriceField().isEmpty()
				&& !listWindow.getRunField().isEmpty()) {
			int run = Integer.parseInt(listWindow.getRunField());
			int price = Integer.parseInt(listWindow.getPriceField());
			boolean result = database.deleteExpense(name, run);
		}

		List<Expense> newDatabase = database.searchExpenseByType(type);
		listWindow.getMyList().setListData(newDatabase.toArray());
		listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
		listWindow.getRunDoc().setDocumentFilter(new DigitFilter());

		if (database.searchExpenseByType(type).size() == 0) {
			listWindow.showMessage("Все " + type + " удалены");
		}
		if (database.getGeneralDB().size() == 0) {
			listWindow.showMessage("Все устройства удалены");
		}
	}
}
