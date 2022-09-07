package controller;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import model.MyCar;

public class SaveCarController extends BaseController {

	private final static Logger LOGGER = Logger.getLogger(SaveCarController.class);
	public static final String FILE_NAME = "car.txt";

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info("the file car.txt has been saved");
		if (carWindow.getNameField().isEmpty() || carWindow.getIdField().isEmpty() || carWindow.getMadeField().isEmpty()
				|| carWindow.getTankField().isEmpty() || carWindow.getRunField().isEmpty()) {
			carWindow.showMessage("Не все поля заполнены");
			return;
		} else {
			String name = carWindow.getNameField();
			String id = carWindow.getIdField();
			int made = Integer.parseInt(carWindow.getMadeField());
			int tank = Integer.parseInt(carWindow.getTankField());
			int run = Integer.parseInt(carWindow.getRunField());
			MyCar myCar = new MyCar(name, id, made, tank, run);
			carWindow.showMessage("Автомобиль " + name + " сохранен");
			carWindow.getFrame().setVisible(false);
			window.getFrame().setVisible(true);

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
				oos.writeObject(myCar);
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
}
