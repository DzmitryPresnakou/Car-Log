package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.Expense;

public class ReadController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(ReadController.class);
	public static final String FILE_NAME = "database.txt";

	@Override
	public void actionPerformed(ActionEvent e) {

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
}
