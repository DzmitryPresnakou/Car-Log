package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.Database;
import model.Expense;
import view.Window;

public class RunApplicationController {

	protected Database database;

	private final static Logger LOGGER = Logger.getLogger(RunApplicationController.class);
	public static final String FILE_NAME = "database.txt";

	public void readDatabaseOnStart() {
		List<Expense> expenses = new ArrayList<Expense>();
		File file = new File(FILE_NAME);
		if (file.exists()) {
			try {
				FileInputStream fis = null;
				fis = new FileInputStream(ReadController.FILE_NAME);
				ObjectInputStream oin = null;
				oin = new ObjectInputStream(fis);
				expenses = (List<Expense>) oin.readObject();
				oin.close();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			LOGGER.info("the file database.txt has been read");
		} else {
			LOGGER.info("the file database.txt doesn't exist");
		}
		database.setGeneralDB(expenses);

	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

}
