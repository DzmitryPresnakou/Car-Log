package controller;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

public class SaveCarToFileController extends BaseController {
	private final static Logger LOGGER = Logger.getLogger(SaveCarToFileController.class);
	public static final String FILE_NAME = "car.txt";

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
			oos.writeObject(getMyCar());
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		LOGGER.info("the file car.txt has been saved");
	}
}
