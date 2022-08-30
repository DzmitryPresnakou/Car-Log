package controller;

import java.awt.event.ActionListener;

import model.Database;
import view.CarWindow;
import view.ListWindow;
import view.Window;

public abstract class BaseController implements ActionListener {

	protected Window window;
	protected ListWindow listWindow;
	protected CarWindow carWindow;
	protected Database database;

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public ListWindow getListWindow() {
		return listWindow;
	}

	public void setListWindow(ListWindow listWindow) {
		this.listWindow = listWindow;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public CarWindow getCarWindow() {
		return carWindow;
	}

	public void setCarWindow(CarWindow carWindow) {
		this.carWindow = carWindow;
	}

}
