import java.io.IOException;

import controller.BackWindowController;
import controller.MyListSelectionListener;
import controller.OpenNewWindowController;
import model.Database;
import view.ListWindow;
import view.Window;

public class Run {

	public static void main(String[] args) throws IOException {
		Window window = new Window();
		ListWindow listWindow = new ListWindow();

		OpenNewWindowController openController = new OpenNewWindowController();
		BackWindowController backController = new BackWindowController();

		MyListSelectionListener myListSelectionListener = new MyListSelectionListener();

		window.setOpenController(openController);

		Database generalDB = new Database();

		listWindow.setDatabase(generalDB);

		listWindow.setMyListSelectionListener(myListSelectionListener);
		listWindow.setBackWindowController(backController);

		openController.setWindow(window);
		openController.setListWindow(listWindow);
		openController.setDatabase(generalDB);

		backController.setListWindow(listWindow);
		backController.setWindow(window);

		myListSelectionListener.setListWindow(listWindow);
		myListSelectionListener.setDatabase(generalDB);

	}

}
