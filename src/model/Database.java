package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database implements Serializable {

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
		generalDB.add(expense);
	}

	public boolean deleteExpense(int index) {
		boolean isDeleted = false;
		generalDB.remove(index);
		isDeleted = true;
		return isDeleted;
	}

	public boolean deleteExpense(String name, int run) {
		boolean isDeleted = false;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i) != null && generalDB.get(i).getName() != null && generalDB.get(i).getRun() != 0
					&& generalDB.get(i).getName().equals(name) && generalDB.get(i).getRun() == run) {
				generalDB.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public Expense showExpense(int index) {
		return generalDB.get(index);
	}

	public List<Expense> editExpense(int dbIndex, String newName, int newRun, String newDate, int newPrice,
			String type) {
		Expense newExpense = new Expense(newName, newRun, newDate, newPrice, type);
		generalDB.set(dbIndex, newExpense);
		return generalDB;
	}
	
	public List<Expense> editGasExpense(int dbIndex, String newName, int newRun, String newDate, int newPrice,
			String type, int newGas) {
		Expense newExpense = new GasExpense(newName, newRun, newDate, newPrice, type,  newGas);
		generalDB.set(dbIndex, newExpense);
		return generalDB;
	}

	public List<Expense> searchExpenseByType(String type) {
		List<Expense> answer = new ArrayList<>();
		for (Expense expense : generalDB) {
			if (expense.getType().equals(type)) {
				answer.add(expense);
			}
		}
		return answer;
	}

	public boolean searchExpenseByNameAndPrice(String name, int price) {
		boolean isFound = false;
		for (Expense expense : generalDB) {
			if (expense.getName().equals(name) && expense.getPrice() == price) {
				isFound = true;
			}
		}
		return isFound;
	}

	public boolean searchExpenseByNameRunDatePrice(String name, int run, String date, int price) {
		boolean isFound = false;
		for (Expense expense : generalDB) {
			if (expense.getName().equals(name) && expense.getRun() == run && expense.getDate().equals(date)
					&& expense.getPrice() == price) {
				isFound = true;
			}
		}
		return isFound;
	}

	public boolean searchExpenseByNameRunDatePriceGas(String name, int run, String date, int price, int gas) {
		boolean isFound = false;
		for (Expense expense : generalDB) {
			if (expense.getName().equals(name) && expense.getRun() == run && expense.getDate().equals(date)
					&& expense.getPrice() == price && expense.getGas() == gas) {
				isFound = true;
			}
		}
		return isFound;
	}

	public boolean searchExpenseByNameAndRun(String name, int run) {
		boolean isFound = false;
		for (Expense expense : generalDB) {
			if (expense.getName().equals(name) && expense.getRun() == run) {
				isFound = true;
			}
		}
		return isFound;
	}

	public int findExpenseByNameAndPrice(String name, int price) {
		int index = -1;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getName().equals(name) && generalDB.get(i).getPrice() == price) {
				index = i;
			}
		}
		return index;
	}

	public int findExpenseByNameAndRun(String name, int run) {
		int index = -1;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getName().equals(name) && generalDB.get(i).getRun() == run) {
				index = i;
			}
		}
		return index;
	}

	public int findExpenseByNameAndRunAndPrice(String name, int run, int price) {
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
		int index = -1;
		for (int i = 0; i < generalDB.size(); i++) {
			if (generalDB.get(i).getName().equals(name) && generalDB.get(i).getRun() == run
					&& generalDB.get(i).getPrice() == price && generalDB.get(i).getGas() == gas) {
				index = i;
			}
		}
		return index;
	}

}
