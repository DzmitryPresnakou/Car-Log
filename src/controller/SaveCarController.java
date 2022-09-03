package controller;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import model.MyCar;

public class SaveCarController extends BaseController {

//	private final static Logger LOGGER = Logger.getLogger(SaveController.class);
	public static final String FILE_NAME = "car.txt";

	@Override
	public void actionPerformed(ActionEvent e) {

		String name = carWindow.getNameField();
		String id = carWindow.getIdField();
		String made = carWindow.getMadeField();
		int tank = Integer.parseInt(carWindow.getTankField());
		int run = Integer.parseInt(carWindow.getRunField());

		if (name.isEmpty() || id.isEmpty() || carWindow.getMadeField().isEmpty() || carWindow.getTankField().isEmpty()
				|| carWindow.getRunField().isEmpty()) {
			carWindow.showMessage("Не все поля заполнены");
			return;
		}
		if (myCar.getName() != null && myCar.getId() != null && myCar.getMade() != null && myCar.getMade() != null
				&& myCar.getTank() != 0 && myCar.getRun() != 0) {
			carWindow.showMessage("Автомобиль уже был сохранен");
			return;
		}

		MyCar myCar = new MyCar(name, id, made, tank, run);

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

				oos.writeObject(myCar);
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
//		LOGGER.info("the file car.txt has been saved");

	}

}
