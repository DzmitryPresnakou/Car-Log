package controller;

import java.awt.Color;
import java.time.LocalDate;
import java.time.Month;
import org.apache.log4j.Logger;

import model.Database;
import model.Expense;
import view.CarWindow;
import view.Window;

public class FillInfoPanelOnStartController {

	private final static Logger LOGGER = Logger.getLogger(FillInfoPanelOnStartController.class);

	protected Window window;
	protected CarWindow carWindow;
	protected Database database;

	public void fillInfopanel() {

		LOGGER.info("main window has started");
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

		window.getRunAmount().setText(Integer.toString(maxRun));
		carWindow.setRunAmount(Integer.toString(maxRun));
		window.getGasAmountExpenses().setText(Integer.toString(gasExpensesPerMonth));
		window.getGasAmountLastMonthExpenses().setText(Integer.toString(gasExpensesPerLastMonth));

		window.getMonthRun().setText(Integer.toString(runPerMonth));
		window.getLastMonthRun().setText(Integer.toString(runPerLastMonth));

		window.getTotalAmountExpenses().setText(Integer.toString(allExpensesPerMonth));
		window.getTotalLastMonthAmountExpenses().setText(Integer.toString(allExpensesPerLastMonth));

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

		window.getOilReminderRun().setText(Integer.toString(oilChangeAfterRun));

		if (oilChangeAfterRun <= 9000) {
			window.getOilReminderRun().setForeground(new Color(0, 0, 255));
		} else if (oilChangeAfterRun > 9000 & oilChangeAfterRun <= 10000) {
			window.getOilReminderRun().setForeground(new Color(255, 0, 255));
		} else {
			window.getOilReminderRun().setForeground(new Color(255, 0, 0));
		}

		LOGGER.debug("infopanel has filled");
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public CarWindow getCarWindow() {
		return carWindow;
	}

	public void setCarWindow(CarWindow carWindow) {
		this.carWindow = carWindow;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

}
