package controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.apache.log4j.Logger;

import model.MyCar;

public class ReadCarController extends BaseController implements WindowListener {

	private final static Logger LOGGER = Logger.getLogger(ReadCarController.class);
	public static final String FILE_NAME = "car.txt";
	private MyCar newCar;

	@Override
	public void windowActivated(WindowEvent e) {

		File file = new File(FILE_NAME);

		if (file.exists()) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(ReadCarController.FILE_NAME);
				ObjectInputStream oin = null;
				oin = new ObjectInputStream(fis);

				newCar = (MyCar) oin.readObject();
				fis.close();
				oin.close();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			LOGGER.info("the file car.txt has been read");
		} else {
			LOGGER.info("the file car.txt doesn't exist");
		}
		MyCar myCar = newCar;
		String name = myCar.getName();
		String id = myCar.getId();
		int made = myCar.getMade();
		int tank = myCar.getTank();
		int run = myCar.getRun();

		carWindow.setNameField(name);
		carWindow.setIdField(id);
		carWindow.setMadeField(Integer.toString(made));
		carWindow.setTankField(Integer.toString(tank));
		carWindow.setRunField(Integer.toString(run));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
