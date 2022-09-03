package controller;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Expense;
import model.GasExpense;

public class MyGasExpenseListSelectionListener extends BaseController implements ListSelectionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = gasWindow.getMyList().getSelectedIndex();
		System.out.println(index);
		String type = gasWindow.getFrame().getTitle();
		System.out.println(type);

		if (index >= 0) {

			List<Expense> newDatabase = database.searchExpenseByType(type);

			System.out.println(index);
			System.out.println(newDatabase.toString());

			String name = newDatabase.get(index).getName();
			int run = newDatabase.get(index).getRun();
			String date = newDatabase.get(index).getDate();
			int price = newDatabase.get(index).getPrice();

			gasWindow.setNameField(name);
			gasWindow.setRunField(Integer.toString(run));
			gasWindow.setPriceField(Integer.toString(price));

		} else {
			gasWindow.setNameField(null);
			gasWindow.setRunField(null);
			gasWindow.setPriceField(null);

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}
