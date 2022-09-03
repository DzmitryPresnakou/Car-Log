package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.datatype.DatatypeConfigurationException;
import org.jdatepicker.JDatePicker;

public class TestWindow extends JFrame {

	private JFrame frame;
	private JTextField dateField = new JTextField(12);
	private JTextField nowDateField = new JTextField(12);
	private JTextField formatedDateField = new JTextField(12);
	private Calendar date;

	public <JDatePickerImpl> TestWindow() throws DatatypeConfigurationException {
		frame = new JFrame();
		frame.setTitle("Expenses List");
		frame.setSize(370, 350);
		// по центру
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());

		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(352, 100));
		infoPanel.setLayout(new FlowLayout());

		JLabel dateLabel = new JLabel("Дата");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dateLabel.setPreferredSize(new Dimension(30, 20));
		infoPanel.add(dateLabel);

		JDatePicker datePicker = new JDatePicker();

		infoPanel.add(datePicker);
		infoPanel.add(dateField);
		infoPanel.add(nowDateField);

		dateField.setFont(new Font("Tahoma", Font.PLAIN, 11));

		nowDateField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		LocalDate localDate = LocalDate.now();
		nowDateField.setText(localDate.toString());

		infoPanel.add(formatedDateField);

		datePicker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String dateToString = datePicker.getFormattedTextField().getText();

				dateField.setText(dateToString);

				Integer year = datePicker.getModel().getYear();
				Integer month = datePicker.getModel().getMonth() + 1;
				Integer day = datePicker.getModel().getDay();
				String selectedDate = (Integer.toString(year) + "-" + Integer.toString(month) + "-"
						+ Integer.toString(day));

				formatedDateField.setFont(new Font("Tahoma", Font.PLAIN, 11));
				formatedDateField.setText(selectedDate.toString());

				System.out.println(selectedDate.substring(0, 7));
				
			}

		});

		container.add(infoPanel);

		frame.setResizable(false);
		frame.setVisible(true);

	}

	public String getDateField() {
		return dateField.getText();
	}

	public void setDateField(String dateField) {
		this.dateField.setText(dateField);
	}

	public static void main(String[] args) throws DatatypeConfigurationException {
		TestWindow testWindow = new TestWindow();

	}

}
