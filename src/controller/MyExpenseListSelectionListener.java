package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;

import model.Expense;

public class MyExpenseListSelectionListener extends BaseController implements ListSelectionListener {
	private final static Logger LOGGER = Logger.getLogger(MyExpenseListSelectionListener.class);

	@Override
	public void valueChanged(ListSelectionEvent e) {
		LOGGER.info("MyExpenseListSelectionListener called");
		int index = listWindow.getMyList().getSelectedIndex();

		if (index >= 0) {
			String type = listWindow.getFrame().getTitle();
			List<Expense> newDatabase = database.searchExpenseByType(type);
			String name = newDatabase.get(index).getName();
			LocalDate date = newDatabase.get(index).getDate();
			int price = newDatabase.get(index).getPrice();
			int run = newDatabase.get(index).getRun();
			listWindow.setNameField(name);
			listWindow.setRunField(Integer.toString(run));
			listWindow.setPriceField(Integer.toString(price));
			listWindow.getDatePicker().getJFormattedTextField().setText(date.toString());
			LOGGER.debug("expense - name " + name + ", date: " + date + ", price = " + price + ", run = " + run
					+ " selected");

		} else {
			listWindow.setNameField(null);
			listWindow.setRunField(null);
			listWindow.setPriceField(null);
			listWindow.getDatePicker().getJFormattedTextField().setText(null);
			LOGGER.debug("nothing selected");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
