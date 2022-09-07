package Tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import org.junit.Test;

import model.Database;
import model.Expense;
import model.GasExpense;

public class DatabaseTests {

	Database generalDB = new Database();

	Expense expense1 = new GasExpense("Заправка", 198200, LocalDate.of(2022, 8, 4), 50, "Заправка", 25);
	Expense expense2 = new Expense("Автомойка", 198315, LocalDate.of(2022, 8, 5), 15, "Автомойка");
	Expense expense3 = new Expense("Замена масла", 198400, LocalDate.of(2022, 8, 8), 100, "Замена масла");
	Expense expense4 = new Expense("Замена шаровой", 198515, LocalDate.of(2022, 8, 12), 60, "Расход");
	Expense expense5 = new GasExpense("Заправка", 198550, LocalDate.of(2022, 8, 13), 40, "Заправка", 15);
	Expense expense6 = new GasExpense("Заправка", 198750, LocalDate.of(2022, 8, 15), 70, "Заправка", 30);
	Expense expense7 = new Expense("Автомойка", 198900, LocalDate.of(2022, 8, 17), 10, "Автомойка");
	Expense expense8 = new Expense("Регулировка фар", 198950, LocalDate.of(2022, 8, 18), 20, "Задача");
	Expense expense9 = new GasExpense("Заправка", 199000, LocalDate.of(2022, 8, 20), 50, "Заправка", 20);
	{
		generalDB.addExpense(expense1);
		generalDB.addExpense(expense2);
		generalDB.addExpense(expense3);
		generalDB.addExpense(expense4);
		generalDB.addExpense(expense5);
		generalDB.addExpense(expense6);
		generalDB.addExpense(expense7);
		generalDB.addExpense(expense8);
		generalDB.addExpense(expense9);
	}

	@Test
	public void sumAllExpensesPerMonthTest1() {
		int index = 0;
		boolean result = generalDB.deleteExpense(index);
		assertSame(result, true);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void sumAllExpensesPerMonthTest2() {
		int index = 10;
		boolean result = generalDB.deleteExpense(index);
		assertSame(result, false);
	}

	@Test
	public void deleteExpenseTest1() {
		String name = ("Замена масла");
		int run = 199000;
		LocalDate date = LocalDate.of(2022, 8, 17);
		int price = 120;
		String type = ("Замена масла");
		boolean result = generalDB.deleteExpense(name, run, date, price, type);
		assertSame(result, false);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void showExpenseTest1() {
		int index = 10;
		Expense result = generalDB.showExpense(index);
		assertSame(result, null);
	}

	@Test
	public void showExpenseTest2() {
		int index = 5;
		Expense result = generalDB.showExpense(index);
		assertNotNull(result);
	}

	@Test
	public void showExpenseTest3() {
		generalDB.addExpense(null);
		int index = 9;
		Expense result = generalDB.showExpense(index);
		assertSame(result, null);
	}
}
