package controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class CloseWindowController extends BaseController implements WindowListener {

	private final static Logger LOGGER = Logger.getLogger(CloseWindowController.class);

	@Override
	public void windowClosing(WindowEvent e) {
		LOGGER.info("window closing");
		Object[] options = { "Да", "Нет!" };
		int n = JOptionPane.showOptionDialog(e.getWindow(), "Закрыть окно?", "Подтверждение", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n == 0) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

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
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
