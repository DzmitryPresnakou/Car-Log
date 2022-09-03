package controller;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

public class SaveController extends BaseController {

//	private final static Logger LOGGER = Logger.getLogger(SaveController.class);
	public static final String FILE_NAME = "database.txt";

	@Override
	public void actionPerformed(ActionEvent e) {

		// сначала создаем байтовый поток
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(FILE_NAME);
			// потом создаем объектный поток на основе байтового потока
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(fos);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {

				oos.writeObject(database.getGeneralDB());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				oos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
//		LOGGER.info("the file database.txt has been saved");
	}
}
