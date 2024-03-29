package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.Month;

import org.apache.log4j.Logger;

import model.Expense;

public class InfoPanelController extends BaseController implements WindowListener {
	private final static Logger LOGGER = Logger.getLogger(InfoPanelController.class);

	@Override
	public void windowActivated(WindowEvent e) {
		LOGGER.info("main window activated");
		LocalDate today = LocalDate.now();
		Month nowMonth = today.getMonth();
		int year = today.getYear();
		Month lastMonth = today.getMonth().minus(1);
		int maxRun = database.showTheGreatestValueOfRun();
		Expense newExpense = new Expense();
		newExpense = database.showExpenseByRun(maxRun);
		maxRun = newExpense.getRun();
		String gasType = new String("Заправка");
		String oilType = new String("Замена масла");
		String taskType = new String("Задача");
		int oilChangeAfterRun = 0;
		int gasExpensesPerMonth = database.sumExpensesPerMonthByType(gasType);
		int gasExpensesPerLastMonth = database.sumExpensesPerLastMonthByType(gasType);
		int taskExpensesPerMonth = database.sumExpensesPerMonthByType(taskType);
		int taskExpensesPerLastMonth = database.sumExpensesPerLastMonthByType(taskType);
		int allExpensesPerMonth = database.sumAllExpensesPerMonth() - taskExpensesPerMonth;
		int allExpensesPerLastMonth = database.sumAllExpensesPerLastMonth() - taskExpensesPerLastMonth;

		int runPerMonth = database.totalRunPerMonth(nowMonth, year);
		int runPerLastMonth = database.totalRunPerMonth(lastMonth, year);

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
		window.getGasAmountLastMonthExpenses().setText(Integer.toString(gasExpensesPerLastMonth));

		window.getMonthRun().setText(Integer.toString(runPerMonth));
		window.getLastMonthRun().setText(Integer.toString(runPerLastMonth));

		window.getTotalAmountExpenses().setText(Integer.toString(allExpensesPerMonth));
		window.getTotalLastMonthAmountExpenses().setText(Integer.toString(allExpensesPerLastMonth));

		window.getOilReminderRun().setText(Integer.toString(oilChangeAfterRun));
		if (oilChangeAfterRun <= 9000) {
			window.getOilReminderRun().setForeground(new Color(0, 0, 255));
		} else if (oilChangeAfterRun > 9000 & oilChangeAfterRun <= 10000) {
			window.getOilReminderRun().setForeground(new Color(255, 0, 255));
		} else {
			window.getOilReminderRun().setForeground(new Color(255, 0, 0));
		}

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
