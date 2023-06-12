package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Database implements Serializable {

	private final static Logger LOGGER = Logger.getLogger(Database.class);
	private List<Expense> generalDB = new ArrayList<>();

	public Database() {
	}

	public Database(List<Expense> generalDB) {
		this.generalDB = generalDB;
	}

	public List<Expense> getGeneralDB() {
		return generalDB;
	}

	public void setGeneralDB(List<Expense> generalDB) {
		this.generalDB = generalDB;
	}

	public void addExpense(Expense expense) {
		LOGGER.debug("method \"addExpense\" called");
		generalDB.add(expense);
	}

	public boolean deleteExpense(int index) {
		LOGGER.debug("method \"deleteExpense by index\" called");
		boolean isDeleted = false;
		generalDB.remove(index);
		isDeleted = true;
		return isDeleted;
	}

	public boolean deleteExpense(String name, int run, LocalDate date, int price, String type) {
		LOGGER.debug("method \"deleteExpense by all fields\" called");
		boolean isDeleted = false;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i) != null && generalDB.get(i).getName() != null && generalDB.get(i).getRun() != 0
					&& generalDB.get(i).getDate() != null && generalDB.get(i).getPrice() != 0
					&& generalDB.get(i).getType() != null && generalDB.get(i).getName().equals(name)
					&& generalDB.get(i).getRun() == run && generalDB.get(i).getDate().equals(date)
					&& generalDB.get(i).getPrice() == price && generalDB.get(i).getType().equals(type)) {
				generalDB.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public boolean deleteGasExpense(String name, int run, LocalDate date, int price, String type, int gas) {
		LOGGER.debug("method \"deleteGasExpense by all fields\" called");
		boolean isDeleted = false;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i) != null && generalDB.get(i).getName() != null && generalDB.get(i).getRun() != 0
					&& generalDB.get(i).getDate() != null && generalDB.get(i).getPrice() != 0
					&& generalDB.get(i).getType() != null && generalDB.get(i).getGas() != 0
					&& generalDB.get(i).getName().equals(name) && generalDB.get(i).getRun() == run
					&& generalDB.get(i).getDate().equals(date) && generalDB.get(i).getPrice() == price
					&& generalDB.get(i).getType().equals(type) && generalDB.get(i).getGas() == gas) {
				generalDB.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public Expense showExpense(int index) {
		LOGGER.debug("method \"showExpense\" called");
		return generalDB.get(index);
	}

	public Expense showExpenseByRun(int run) {
		LOGGER.debug("method \"showExpenseByRun\" called");
		Expense answer = new Expense();
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getRun() == run) {
				answer = generalDB.get(i);
			}
		}
		return answer;
	}

	public int showTheGreatestValueOfRun() {
		LOGGER.debug("method \"showTheGreatestValueOfRun\" called");
		int maxValueOfRun = 0;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i) != null && generalDB.get(i).getRun() != 0 && generalDB.get(i).getDate() != null
					&& generalDB.get(i).getRun() > maxValueOfRun) {

				maxValueOfRun = generalDB.get(i).getRun();
			}
		}
		return maxValueOfRun;
	}

	public int showTheGreatestValueOfRunByType(String type) {
		LOGGER.debug("method \"showTheGreatestValueOfRunByType\" called");
		int maxValueOfRun = 0;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i) != null && generalDB.get(i).getRun() != 0 && generalDB.get(i).getType() != null
					&& generalDB.get(i).getType().equalsIgnoreCase(type) && generalDB.get(i).getRun() > maxValueOfRun) {
				maxValueOfRun = generalDB.get(i).getRun();
			}
		}
		return maxValueOfRun;
	}

	public List<Expense> editExpense(int dbIndex, String newName, int newRun, LocalDate newDate, int newPrice,
			String type) {
		LOGGER.debug("method \"editExpense\" called");
		Expense newExpense = new Expense(newName, newRun, newDate, newPrice, type);
		generalDB.set(dbIndex, newExpense);
		return generalDB;
	}

	public List<Expense> editGasExpense(int dbIndex, String newName, int newRun, LocalDate newDate, int newPrice,
			String type, int newGas) {
		LOGGER.debug("method \"editGasExpense\" called");
		Expense newExpense = new GasExpense(newName, newRun, newDate, newPrice, type, newGas);
		generalDB.set(dbIndex, newExpense);
		return generalDB;
	}

	public List<Expense> searchExpenseByType(String type) {
		LOGGER.debug("method \"searchExpenseByType\" called");
		List<Expense> answer = new ArrayList<>();
		for (Expense expense : generalDB) {
			if (expense.getType().equals(type)) {
				answer.add(expense);
			}
		}
		return answer;
	}

	public boolean searchExpenseByNameRunDatePriceType(String name, int run, LocalDate date, int price, String type) {
		LOGGER.debug("method \"searchExpenseByNameRunDatePriceType\" called");
		boolean isFound = false;
		for (Expense expense : generalDB) {
			if (expense.getName().equals(name) && expense.getRun() == run && expense.getDate().equals(date)
					&& expense.getPrice() == price && expense.getType().equals(type)) {
				isFound = true;
			}
		}
		return isFound;
	}

	public boolean searchExpenseByNameRunDatePriceTypeGas(String name, int run, LocalDate date, int price, String type,
			int gas) {
		LOGGER.debug("method \"searchExpenseByNameRunDatePriceGas\" called");
		boolean isFound = false;
		for (Expense expense : generalDB) {
			if (expense.getName().equals(name) && expense.getRun() == run && expense.getDate().equals(date)
					&& expense.getPrice() == price && expense.getType().equals(type) && expense.getGas() == gas) {
				isFound = true;
			}
		}
		return isFound;
	}

	public boolean searchExpenseByNameAndRun(String name, int run) {
		LOGGER.debug("method \"searchExpenseByNameAndRun\" called");
		boolean isFound = false;
		for (Expense expense : generalDB) {
			if (expense.getName().equals(name) && expense.getRun() == run) {
				isFound = true;
			}
		}
		return isFound;
	}

	public int findExpenseByNameAndPrice(String name, int price) {
		LOGGER.debug("method \"findExpenseByNameAndPrice\" called");
		int index = -1;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getName().equals(name) && generalDB.get(i).getPrice() == price) {
				index = i;
			}
		}
		return index;
	}

	public int findExpenseByNameAndRun(String name, int run) {
		LOGGER.debug("method \"findExpenseByNameAndRun\" called");
		int index = -1;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getName().equals(name) && generalDB.get(i).getRun() == run) {
				index = i;
			}
		}
		return index;
	}

	public int findExpenseByNameAndRunAndPrice(String name, int run, int price) {
		LOGGER.debug("method \"findExpenseByNameAndRunAndPrice\" called");
		int index = -1;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getName().equals(name) && generalDB.get(i).getRun() == run
					&& generalDB.get(i).getPrice() == price) {
				index = i;
			}
		}
		return index;
	}

	public int findExpenseByNameAndRunAndPriceGas(String name, int run, int price, int gas) {
		LOGGER.debug("method \"findExpenseByNameAndRunAndPriceGas\" called");
		int index = -1;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getName().equals(name) && generalDB.get(i).getRun() == run
					&& generalDB.get(i).getPrice() == price && generalDB.get(i).getGas() == gas) {
				index = i;
			}
		}
		return index;
	}

	public int sumExpensesPerMonthByType(String type) {
		LOGGER.debug("method \"sumExpensesPerMonthByType\" called");
		LocalDate today = LocalDate.now();
		
		int monthNumber = today.getMonthValue();
		int year = today.getYear();
		
		int sum = 0;
		int price;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getType().equals(type)
					&& generalDB.get(i).getDate().getMonth().equals(today.getMonth())
					&& generalDB.get(i).getDate().getYear() == year) {
				price = generalDB.get(i).getPrice();
				sum += price;
			}
		}
		return sum;
	}

	public int totalRunPerMonth(Month month, int year) {
		LOGGER.debug("method \"totalRunPerMonth\" called");
		
		int monthNumber = month.getValue();
		int runPerLastMonth = 0;
		int runPerCurrentMonth = 0;
		int maxRunPerLastMonth = 0;
		int maxRunPerCurrentMonth = 0;
		int totalRun = 0;

		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getDate().getMonth().getValue() < monthNumber 
					&& generalDB.get(i).getDate().getYear() <= year) {
				runPerLastMonth = generalDB.get(i).getRun();
				if (runPerLastMonth > maxRunPerLastMonth) {
					maxRunPerLastMonth = runPerLastMonth;
				}
			}
			if (generalDB.get(i).getDate().getMonth().equals(month)
					&& generalDB.get(i).getDate().getYear()==year) {
				runPerCurrentMonth = generalDB.get(i).getRun();
				if (runPerCurrentMonth > maxRunPerCurrentMonth) {
					maxRunPerCurrentMonth = runPerCurrentMonth;
				}
			}
		}
		if (maxRunPerCurrentMonth == 0) {
			totalRun = 0;
		} else if (maxRunPerCurrentMonth > 0) {
			totalRun = maxRunPerCurrentMonth - maxRunPerLastMonth;
		}

		return totalRun;
	}

	public int sumExpensesPerLastMonthByType(String type) {
		LOGGER.debug("method \"sumExpensesPerLastMonthByType\" called");
		LocalDate today = LocalDate.now();
		Month lastMonth = today.getMonth().minus(1);
		int year = today.getYear();
		int sum = 0;
		int price;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getType().equals(type)
					&& generalDB.get(i).getDate().getMonth().equals(lastMonth)
					&& generalDB.get(i).getDate().getYear() == year) {
				price = generalDB.get(i).getPrice();
				sum += price;
			}
		}
		return sum;
	}

	public int sumAllExpensesPerMonth() {
		LOGGER.debug("method \"sumAllExpensesPerMonth\" called");
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int sum = 0;
		int price;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getDate().getMonth().equals(today.getMonth())
					&& generalDB.get(i).getDate().getYear() == year) {
				price = generalDB.get(i).getPrice();
				sum += price;
			}
		}
		return sum;
	}

	public int sumAllExpensesPerLastMonth() {
		LOGGER.debug("method \"sumAllExpensesPerLastMonth\" called");
		LocalDate today = LocalDate.now();
		Month lastMonth = today.getMonth().minus(1);
		int year = today.getYear();
		int sum = 0;
		int price;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getDate().getMonth().equals(lastMonth)
					&& generalDB.get(i).getDate().getYear() == year) {
				price = generalDB.get(i).getPrice();
				sum += price;
			}
		}
		return sum;
	}
}
