package controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;

import org.apache.log4j.Logger;

import model.Expense;

public class InfoPanelController extends BaseController implements WindowListener {
	private final static Logger LOGGER = Logger.getLogger(InfoPanelController.class);

	@Override
	public void windowActivated(WindowEvent e) {
		LOGGER.info("main window activated");
		int maxRun = database.showTheGreatestValueOfRun();
		Expense newExpense = new Expense();
		newExpense = database.showExpenseByRun(maxRun);
		maxRun = newExpense.getRun();
		String gasType = new String("Заправка");
		String oilType = new String("Замена масла");
		String taskType = new String("Задача");
		int oilChangeAfterRun = 0;
		int gasExpensesPerMonth = database.sumExpensesPerMonthByType(gasType);
		int taskExpensesPerMonth = database.sumExpensesPerMonthByType(taskType);
		int allExpensesPerMonth = database.sumAllExpensesPerMonth() - taskExpensesPerMonth;
		int oilChangeLastRun = database.showTheGreatestValueOfRunByType(oilType);
		if (oilChangeLastRun > 0) {
			oilChangeAfterRun = maxRun - oilChangeLastRun;
		}
		if (newExpense.getDate() != null) {

			LocalDate date = newExpense.getDate();

			window.getDate().setText(date.toString());

		} else {
			window.getDate().setText(null);
		}
		window.getRunAmount().setText(Integer.toString(maxRun));
		carWindow.setRunAmount(Integer.toString(maxRun));
		window.getGasAmountExpenses().setText(Integer.toString(gasExpensesPerMonth));
		window.getTotalAmountExpenses().setText(Integer.toString(allExpensesPerMonth));
		window.getOilReminderRun().setText(Integer.toString(oilChangeAfterRun));

		LOGGER.debug("infopanel is filled");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
