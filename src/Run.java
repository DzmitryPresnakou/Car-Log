import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.AddExpenseController;
import controller.AddGasExpenseController;
import controller.BackWindowController;
import controller.CloseWindowController;
import controller.DeleteExpenseController;
import controller.DeleteGasExpenseController;
import controller.EditExpenseController;
import controller.EditGasExpenseController;
import controller.MyExpenseListSelectionListener;
import controller.MyGasExpenseListSelectionListener;
import controller.OpenNewWindowController;
import controller.ReadController;
import controller.SaveCarController;
import controller.SaveController;
import model.Database;
import model.Expense;
import model.GasExpense;
import model.MyCar;
import view.ListWindow;
import view.CarWindow;
import view.GasWindow;
import view.Window;

public class Run {

	public static void main(String[] args) throws IOException {

		Window window = new Window();
		ListWindow listWindow = new ListWindow();
		GasWindow gasWindow = new GasWindow();
		CarWindow carWindow = new CarWindow();
		MyCar myCar = new MyCar();

		OpenNewWindowController openController = new OpenNewWindowController();
		BackWindowController backController = new BackWindowController();
		CloseWindowController closeController = new CloseWindowController();
		SaveCarController saveCarController = new SaveCarController();
		SaveController saveController = new SaveController();
		ReadController readController = new ReadController();

		AddExpenseController addExpense = new AddExpenseController();
		AddGasExpenseController addGasExpense = new AddGasExpenseController();
		DeleteExpenseController deleteExpense = new DeleteExpenseController();
		DeleteGasExpenseController deleteGasExpense = new DeleteGasExpenseController();
		EditExpenseController editExpense = new EditExpenseController();
		EditGasExpenseController editGasExpense = new EditGasExpenseController();

		window.setOpenController(openController);
		window.setReadController(readController);

		Expense expense1 = new GasExpense("Заправка", 198200, "2022-8-11", 50, "Заправка", 25);
		Expense expense2 = new Expense("Автомойка", 198315, "2022-8-18", 10, "Автомойка");
		Expense expense3 = new Expense("Замена масла", 198400, "2022-8-22", 100, "Замена масла");
		Expense expense4 = new Expense("Замена шаровой", 198315, "2022-8-18", 60, "Расход");
		Expense expense5 = new GasExpense("Заправка", 198450, "2022-8-21", 40, "Заправка", 15);
		Expense expense6 = new GasExpense("Заправка", 198540, "2022-8-28", 70, "Заправка", 30);
		Expense expense7 = new Expense("Автомойка", 198680, "2022-8-31", 10, "Автомойка");
		Expense expense8 = new Expense("Регулировка фар", 199124, "2022-9-10", 10, "Задача");
		Expense expense9 = new GasExpense("Заправка", 199600, "2022-9-15", 50, "Заправка", 25);

		ArrayList<Expense> expenses = new ArrayList<Expense>();

		List expenseList = Arrays.asList(expense1, expense2, expense3, expense4, expense5, expense6, expense7, expense8,
				expense9);

		expenses.addAll(expenseList);

		Database generalDB = new Database(expenses);

		listWindow.setDatabase(generalDB);
		listWindow.setBackWindowController(backController);
		listWindow.setCloseWindowController(closeController);
		listWindow.setAddExpense(addExpense);
		listWindow.setDeleteExpense(deleteExpense);
		listWindow.setEditExpenseController(editExpense);
		listWindow.setSaveController(saveController);

		gasWindow.setDatabase(generalDB);
		gasWindow.setBackWindowController(backController);
		gasWindow.setCloseWindowController(closeController);
		gasWindow.setAddGasExpense(addGasExpense);
		gasWindow.setDeleteGasExpense(deleteGasExpense);
		gasWindow.setEditGasExpense(editGasExpense);
		gasWindow.setSaveController(saveController);

		carWindow.setBackWindowController(backController);
		carWindow.setCloseWindowController(closeController);
		carWindow.setSaveCarController(saveCarController);
		carWindow.setMyCar(myCar);

		saveCarController.setCarWindow(carWindow);
		saveCarController.setMyCar(myCar);

		readController.setDatabase(generalDB);
		readController.setWindow(window);

		addExpense.setDatabase(generalDB);
		addExpense.setListWindow(listWindow);

		addGasExpense.setGasWindow(gasWindow);
		addGasExpense.setDatabase(generalDB);

		deleteExpense.setDatabase(generalDB);
		deleteExpense.setListWindow(listWindow);

		deleteGasExpense.setDatabase(generalDB);
		deleteGasExpense.setGasWindow(gasWindow);

		editExpense.setDatabase(generalDB);
		editExpense.setListWindow(listWindow);

		editGasExpense.setDatabase(generalDB);
		editGasExpense.setGasWindow(gasWindow);

		saveController.setDatabase(generalDB);
		saveController.setListWindow(listWindow);
		saveController.setGasWindow(gasWindow);

		openController.setWindow(window);
		openController.setListWindow(listWindow);
		openController.setDatabase(generalDB);
		openController.setGasWindow(gasWindow);
		openController.setCarWindow(carWindow);

		backController.setListWindow(listWindow);
		backController.setCarWindow(carWindow);
		backController.setGasWindow(gasWindow);
		backController.setWindow(window);

		closeController.setCarWindow(carWindow);
		closeController.setListWindow(listWindow);
		closeController.setGasWindow(gasWindow);

	}

}
