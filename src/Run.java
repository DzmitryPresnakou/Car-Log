import java.io.IOException;

import controller.BackWindowController;
import controller.MyListSelectionListener;
import controller.OpenCarWindowController;
import controller.OpenNewWindowController;
import model.Database;
import view.CarWindow;
import view.ListWindow;
import view.Window;

public class Run {

	public static void main(String[] args) throws IOException {
		Window window = new Window();
		ListWindow listWindow = new ListWindow();
		CarWindow carWindow = new CarWindow();

		OpenNewWindowController openController = new OpenNewWindowController();
		OpenCarWindowController openCarWindowController = new OpenCarWindowController();
		BackWindowController backController = new BackWindowController();

		MyListSelectionListener myListSelectionListener = new MyListSelectionListener();

		window.setOpenController(openController);
		window.setOpenCarWindowController(openCarWindowController);

		Database generalDB = new Database();

		listWindow.setDatabase(generalDB);

		listWindow.setMyListSelectionListener(myListSelectionListener);
		listWindow.setBackWindowController(backController);

		carWindow.setBackWindowController(backController);

		openController.setWindow(window);
		openController.setListWindow(listWindow);
		openController.setDatabase(generalDB);

		openCarWindowController.setWindow(window);
		openCarWindowController.setCarWindow(carWindow);
		;

		backController.setListWindow(listWindow);
		backController.setWindow(window);
		backController.setCarWindow(carWindow);

		myListSelectionListener.setListWindow(listWindow);
		myListSelectionListener.setDatabase(generalDB);

	}

}
