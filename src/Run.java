import java.io.IOException;
import org.apache.log4j.Logger;

import controller.AddExpenseController;
import controller.AddGasExpenseController;
import controller.BackWindowController;
import controller.CloseWindowController;
import controller.DeleteExpenseController;
import controller.DeleteGasExpenseController;
import controller.EditExpenseController;
import controller.EditGasExpenseController;
import controller.InfoPanelController;
import controller.MouseControllerForWindow;
import controller.MyExpenseListSelectionListener;
import controller.MyGasExpenseListSelectionListener;
import controller.OpenNewWindowController;
import controller.ReadCarController;
import controller.ReadController;
import controller.SaveCarController;
import controller.RunApplicationController;
import controller.SaveController;
import controller.FillInfoPanelOnStartController;
import model.Database;
import model.MyCar;
import view.ListWindow;
import view.CarWindow;
import view.GasWindow;
import view.Window;

public class Run {
	
	private final static Logger LOGGER = Logger.getLogger(Run.class);

	public static void main(String[] args) throws IOException {
		
		Database generalDB = new Database();
		RunApplicationController runApplicationController = new RunApplicationController();
		runApplicationController.setDatabase(generalDB);
		runApplicationController.readDatabaseOnStart();
		
		
		Window window = new Window();
		LOGGER.info("new window created");
		ListWindow listWindow = new ListWindow();
		LOGGER.info("new listWindow created");
		GasWindow gasWindow = new GasWindow();
		LOGGER.info("new GasWindow created");
		CarWindow carWindow = new CarWindow();
		MyCar myCar = new MyCar();
		
		FillInfoPanelOnStartController fillInfoPanelOnStartController = new FillInfoPanelOnStartController();
		fillInfoPanelOnStartController.setCarWindow(carWindow);
		fillInfoPanelOnStartController.setDatabase(generalDB);
		fillInfoPanelOnStartController.setWindow(window);
		fillInfoPanelOnStartController.fillInfopanel();

		
		InfoPanelController infoPanelController = new InfoPanelController();
		infoPanelController.setCarWindow(carWindow);
		infoPanelController.setDatabase(generalDB);
		
		infoPanelController.setWindow(window);

		window.setInfoPanelController(infoPanelController);

		OpenNewWindowController openController = new OpenNewWindowController();
		BackWindowController backController = new BackWindowController();
		CloseWindowController closeController = new CloseWindowController();
		SaveCarController saveCarController = new SaveCarController();
		SaveController saveController = new SaveController();
		ReadController readController = new ReadController();
		ReadCarController readCarController = new ReadCarController();

		MouseControllerForWindow mouseControllerForWindow = new MouseControllerForWindow();
		
		MyExpenseListSelectionListener myExpenseListSelectionListener = new MyExpenseListSelectionListener();
		MyGasExpenseListSelectionListener myGasExpenseListSelectionListener = new MyGasExpenseListSelectionListener();

		AddExpenseController addExpense = new AddExpenseController();
		AddGasExpenseController addGasExpense = new AddGasExpenseController();
		DeleteExpenseController deleteExpense = new DeleteExpenseController();
		DeleteGasExpenseController deleteGasExpense = new DeleteGasExpenseController();
		EditExpenseController editExpense = new EditExpenseController();
		EditGasExpenseController editGasExpense = new EditGasExpenseController();

		window.setOpenController(openController);
		window.setReadController(readController);

		window.setMouseControllerForWindow(mouseControllerForWindow);

		
		listWindow.setDatabase(generalDB);
		listWindow.setBackWindowController(backController);
		listWindow.setCloseWindowController(closeController);
		listWindow.setAddExpense(addExpense);
		listWindow.setDeleteExpense(deleteExpense);
		listWindow.setEditExpenseController(editExpense);
		listWindow.setSaveController(saveController);
		listWindow.setMyExpenseListSelectionListener(myExpenseListSelectionListener);

		gasWindow.setDatabase(generalDB);
		gasWindow.setBackWindowController(backController);
		gasWindow.setCloseWindowController(closeController);
		gasWindow.setAddGasExpense(addGasExpense);
		gasWindow.setDeleteGasExpense(deleteGasExpense);
		gasWindow.setEditGasExpense(editGasExpense);
		gasWindow.setSaveController(saveController);
		gasWindow.setMyGasExpenseListSelectionListener(myGasExpenseListSelectionListener);

		carWindow.setBackWindowController(backController);
		carWindow.setCloseWindowController(closeController);
		carWindow.setSaveCarController(saveCarController);
		carWindow.setMyCar(myCar);
		carWindow.setReadCarController(readCarController);
		carWindow.setInfoPanelController(infoPanelController);
		
		readCarController.setMyCar(myCar);
		readCarController.setCarWindow(carWindow);

		saveCarController.setCarWindow(carWindow);
		saveCarController.setMyCar(myCar);
		saveCarController.setWindow(window);
		
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
		
		myExpenseListSelectionListener.setListWindow(listWindow);
		myExpenseListSelectionListener.setDatabase(generalDB);
		
		myGasExpenseListSelectionListener.setGasWindow(gasWindow);
		myGasExpenseListSelectionListener.setDatabase(generalDB);
		

		
		mouseControllerForWindow.setWindow(window);

	}

}
