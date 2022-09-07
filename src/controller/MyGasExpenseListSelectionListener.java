package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;

import model.Expense;
import model.GasExpense;

public class MyGasExpenseListSelectionListener extends BaseController implements ListSelectionListener {
	private final static Logger LOGGER = Logger.getLogger(MyGasExpenseListSelectionListener.class);

	@Override
	public void valueChanged(ListSelectionEvent e) {
		LOGGER.info("MyGasExpenseListSelectionListener called");
		int index = gasWindow.getMyList().getSelectedIndex();

		if (index >= 0) {

			String type = gasWindow.getFrame().getTitle();
			List<Expense> newDatabase = database.searchExpenseByType(type);
			String name = newDatabase.get(index).getName();
			LocalDate date = newDatabase.get(index).getDate();
			int price = newDatabase.get(index).getPrice();
			int run = newDatabase.get(index).getRun();
			gasWindow.setNameField(name);
			gasWindow.setPriceField(Integer.toString(price));
			gasWindow.setRunField(Integer.toString(run));
			gasWindow.getDatePicker().getJFormattedTextField().setText(date.toString());

			if (newDatabase.get(index) instanceof GasExpense) {
				int gas = newDatabase.get(index).getGas();
				gasWindow.setGasField((Integer.toString(gas)));
				LOGGER.debug("gasExpense - name " + name + ", date: " + date + ", price = " + price + ", run = " + run
						+ ", gas = " + gas + " selected");

			} else {
				gasWindow.setNameField(null);
				gasWindow.setPriceField(null);
				gasWindow.setRunField(null);
				gasWindow.setGasField(null);
				gasWindow.getDatePicker().getJFormattedTextField().setText(null);
				LOGGER.debug("nothing selected");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
