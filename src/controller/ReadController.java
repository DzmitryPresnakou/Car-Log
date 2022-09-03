package controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.Expense;

public class ReadController extends BaseController {

//	private final static Logger LOGGER = Logger.getLogger(ReadController.class);
	public static final String FILE_NAME = "database.txt";

	@Override
	public void actionPerformed(ActionEvent e) {
	
		List<Expense> expenses = new ArrayList<Expense>();

		File file = new File(FILE_NAME);

		if (file.exists()) {

			FileInputStream fis = null;
			try {
				fis = new FileInputStream(ReadController.FILE_NAME);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			ObjectInputStream oin = null;
			try {
				oin = new ObjectInputStream(fis);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				expenses = (List<Expense>) oin.readObject();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				oin.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

//			LOGGER.info("the file database.txt has been read");
		} else {
//			LOGGER.info("the file database.txt doesn't exist");
		}
		database.setGeneralDB(expenses);
	}
}
