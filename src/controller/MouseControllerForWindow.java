package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class MouseControllerForWindow extends BaseController implements MouseInputListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		window.getCarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		window.getGasButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		window.getExpensesButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		window.getTasksButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		window.getOilButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		window.getCarwashButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
