package controller;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Expense;

public class MyExpenseListSelectionListener extends BaseController implements ListSelectionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = listWindow.getMyList().getSelectedIndex();
		String type = listWindow.getFrame().getTitle();
		System.out.println(index);
		
		if (index >= 0) {


			List<Expense> newDatabase = database.searchExpenseByType(type);
			
			System.out.println(index);
			System.out.println(newDatabase.toString());

			String name = newDatabase.get(index).getName();
			int run = newDatabase.get(index).getRun();
			String date = newDatabase.get(index).getDate();
			int price = newDatabase.get(index).getPrice();

			listWindow.setNameField(name);
			listWindow.setRunField(Integer.toString(run));
			listWindow.setPriceField(Integer.toString(price));

		} else {
			listWindow.setNameField(null);
			listWindow.setRunField(null);
			listWindow.setPriceField(null);

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}
