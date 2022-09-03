package controller;

import java.awt.event.ActionEvent;
import java.util.List;

import org.apache.log4j.Logger;

import model.Expense;
import view.DigitFilter;

public class EditExpenseController extends BaseController {

//	private final static Logger LOGGER = Logger.getLogger(EditExpenseController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
//		LOGGER.info("pressed \"edit\"");
		int index = listWindow.getMyList().getSelectedIndex();
		String type = listWindow.getFrame().getTitle();
		String newName = listWindow.getNameField();

		if (index < 0) {
//			LOGGER.debug("device not selected");
			listWindow.showMessage("Нужно выбрать устройство из списка");

		} else if (index >= 0 && newName.isEmpty() || listWindow.getPriceField().isEmpty()
				|| listWindow.getRunField().isEmpty()
				|| listWindow.getChooseDate().getFormattedTextField().getText().isEmpty()) {
//			LOGGER.debug("not all fields are filled");
			listWindow.showMessage("Не все поля заполнены");
			return;

		} else if (index >= 0 && !newName.isEmpty() && !listWindow.getPriceField().isEmpty()
				&& !listWindow.getChooseDate().getFormattedTextField().getText().isEmpty()
				&& !listWindow.getRunField().isEmpty()) {
			String name = database.searchExpenseByType(type).get(index).getName();
			int price = database.searchExpenseByType(type).get(index).getPrice();
			int run = database.searchExpenseByType(type).get(index).getRun();
			int newPrice = Integer.parseInt(listWindow.getPriceField());
			int newRun = Integer.parseInt(listWindow.getRunField());

			Integer year = listWindow.getChooseDate().getModel().getYear();
			Integer month = listWindow.getChooseDate().getModel().getMonth() + 1;
			Integer day = listWindow.getChooseDate().getModel().getDay();
			String newDate = (Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day));

			if (database.searchExpenseByNameRunDatePrice(newName, newRun, newDate, newPrice)) {
//				LOGGER.debug("entered device that already exists");
				listWindow.showMessage("Устройство с такими параметрами уже есть в списке");
				return;
			}
			int dbIndex = database.findExpenseByNameAndRunAndPrice(name, run, price);
			List<Expense> editedDevices = database.editExpense(dbIndex, newName, newRun, newDate, newPrice, type);

//			LOGGER.info("device edited");
//			LOGGER.debug("edited device name = " + newName + ", price = " + newPrice + ", type = " + type);
		}

		listWindow.getPriceDoc().setDocumentFilter(null);
		listWindow.getRunDoc().setDocumentFilter(null);
		List<Expense> newDatabase = database.searchExpenseByType(type);
		listWindow.getMyList().setListData(newDatabase.toArray());
		listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());
		listWindow.getRunDoc().setDocumentFilter(new DigitFilter());
	}
}
