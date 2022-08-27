package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Expense;

public class MyListSelectionListener extends BaseController implements ListSelectionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = listWindow.getMyList().getSelectedIndex();
		if (index >= 0) {
			String type = listWindow.getFrame().getTitle();

			List<Expense> newDatabase = database.searchExpenseByType(type);

			String name = newDatabase.get(index).getName();
			int run = newDatabase.get(index).getRun();
			LocalDate date = newDatabase.get(index).getDate();
			int price = newDatabase.get(index).getPrice();

			listWindow.setNameField(name);
			listWindow.setRunField(Integer.toString(run));
			listWindow.setDateField(date.toString());
			listWindow.setPriceField(Integer.toString(price));

		} else {
			listWindow.setNameField(null);
			listWindow.setPriceField(null);

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}
