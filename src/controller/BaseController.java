package controller;

import java.awt.event.ActionListener;

import model.Database;
import model.MyCar;
import view.CarWindow;
import view.GasWindow;
import view.ListWindow;
import view.Window;

public abstract class BaseController implements ActionListener {

	protected Window window;
	protected ListWindow listWindow;
	protected GasWindow gasWindow;
	protected CarWindow carWindow;
	protected Database database;
	protected MyCar myCar;

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

	public GasWindow getGasWindow() {
		return gasWindow;
	}

	public void setGasWindow(GasWindow gasWindow) {
		this.gasWindow = gasWindow;
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

	public MyCar getMyCar() {
		return myCar;
	}

	public void setMyCar(MyCar myCar) {
		this.myCar = myCar;
	}
	
	

}
