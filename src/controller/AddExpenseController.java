package controller;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.JFormattedTextField;

import org.jdatepicker.constraints.DateSelectionConstraint;

import model.Expense;
import model.GasExpense;
import view.DigitFilter;

public class AddExpenseController extends BaseController {

	@Override
	public void actionPerformed(ActionEvent e) {

		String name = listWindow.getNameField();
		String type = listWindow.getFrame().getTitle();

		if (name.isEmpty() || listWindow.getPriceField().isEmpty() || listWindow.getRunField().isEmpty()
				|| listWindow.getChooseDate().getFormattedTextField().getText().isEmpty()) {
			listWindow.showMessage("Не все поля заполнены");
			return;
		}

		int run = Integer.parseInt(listWindow.getRunField());
		Integer year = listWindow.getChooseDate().getModel().getYear();
		Integer month = listWindow.getChooseDate().getModel().getMonth() + 1;
		Integer day = listWindow.getChooseDate().getModel().getDay();
		String date = (Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day));
		int price = Integer.parseInt(listWindow.getPriceField());

		if (database.searchExpenseByNameRunDatePrice(name, run, date, price)) {
			listWindow.showMessage("Устройство с такими параметрами уже есть в списке");
			return;
		}

		if (type.equalsIgnoreCase("Расход") || type.equalsIgnoreCase("Задача") || type.equalsIgnoreCase("Замена масла")
				|| type.equalsIgnoreCase("Автомойка")) {

			Expense newExpense = new Expense(name, run, date, price, type);
			database.addExpense(newExpense);

//			listWindow.getMyList().setListData(database.searchExpenseByType(type));

			listWindow.getPriceDoc().setDocumentFilter(null);
			List<Expense> newDatabase = database.searchExpenseByType(type);
			listWindow.getMyList().setListData(newDatabase.toArray());
			listWindow.getPriceDoc().setDocumentFilter(new DigitFilter());

		}

	}

}
