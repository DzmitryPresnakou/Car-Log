package controller;

import java.awt.event.ActionEvent;
import java.util.List;

import model.Expense;
import view.DigitFilter;

public class EditGasExpenseController extends BaseController{

//	private final static Logger LOGGER = Logger.getLogger(EditExpenseController.class);

	@Override
	public void actionPerformed(ActionEvent e) {
//		LOGGER.info("pressed \"edit\"");
		int index = gasWindow.getMyList().getSelectedIndex();
		String type = gasWindow.getFrame().getTitle();
		String newName = gasWindow.getNameField();

		if (index < 0) {
//			LOGGER.debug("device not selected");
			gasWindow.showMessage("Нужно выбрать устройство из списка");

		} else if (index >= 0 && newName.isEmpty() || gasWindow.getPriceField().isEmpty()
				|| gasWindow.getRunField().isEmpty()
				|| gasWindow.getChooseDate().getFormattedTextField().getText().isEmpty()
				|| gasWindow.getGasField().isEmpty()) {
//			LOGGER.debug("not all fields are filled");
			listWindow.showMessage("Не все поля заполнены");
			return;

		} else if (index >= 0 && !newName.isEmpty() && !gasWindow.getPriceField().isEmpty()
				&& !gasWindow.getChooseDate().getFormattedTextField().getText().isEmpty()
				&& !gasWindow.getRunField().isEmpty() && !gasWindow.getGasField().isEmpty()) {
			String name = database.searchExpenseByType(type).get(index).getName();
			int price = database.searchExpenseByType(type).get(index).getPrice();
			int run = database.searchExpenseByType(type).get(index).getRun();
			int gas = database.searchExpenseByType(type).get(index).getGas();
			int newPrice = Integer.parseInt(gasWindow.getPriceField());
			int newRun = Integer.parseInt(gasWindow.getRunField());
			int newGas = Integer.parseInt(gasWindow.getGasField());

			Integer year = gasWindow.getChooseDate().getModel().getYear();
			Integer month = gasWindow.getChooseDate().getModel().getMonth() + 1;
			Integer day = gasWindow.getChooseDate().getModel().getDay();
			String newDate = (Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day));

			if (database.searchExpenseByNameRunDatePriceGas(newName, newRun, newDate, newPrice, newGas)) {
//				LOGGER.debug("entered device that already exists");
				gasWindow.showMessage("Устройство с такими параметрами уже есть в списке");
				return;
			}
			int dbIndex = database.findExpenseByNameAndRunAndPriceGas(name, run, price, gas);
			List<Expense> editedDevices = database.editGasExpense(dbIndex, newName, newRun, newDate, newPrice, type, newGas);

//			LOGGER.info("device edited");
//			LOGGER.debug("edited device name = " + newName + ", price = " + newPrice + ", type = " + type);
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
