package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import org.jdatepicker.JDatePicker;

import controller.BackWindowController;
import controller.MyListSelectionListener;
import model.Database;
import model.Expense;
import java.awt.Font;

public class ListWindow extends JFrame {
	private JFrame frame;
	private Database database;
	private JList<?> myList;
	private JScrollPane myScrollpane;
	private DefaultListModel<?> listModel;

	private PlainDocument runDoc;
	private PlainDocument dateDoc;
	private PlainDocument priceDoc;

//	private SaveController saveController;
//	private AddComputerDevice addDevice;
//	private DeleteComputerDevice deleteDevice;
//	private EditComputerDevice editDevice;
	private BackWindowController backWindowController;
	private MyListSelectionListener myListSelectionListener;

	private JTextField nameField = new JTextField(34);
	private JTextField runField = new JTextField(6);
	private JTextField dateField = new JTextField(10);
	private JTextField priceField = new JTextField(4);
	private JTextField intervalField = new JTextField(7);
	private JButton addButton = new JButton("Добавить");
	private JButton editButton = new JButton("Править");
	private JButton deleteButton = new JButton("Удалить");
	private JButton backButton = new JButton("Назад");
	private JCheckBox checkInterval = new JCheckBox();
	private JLabel periodically = new JLabel("Периодично");
	private JLabel interval = new JLabel("Интервал");

	public ListWindow() {

		frame = new JFrame();
		frame.setTitle("Expenses List");
		frame.setSize(370, 373);
		// по центру
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		myList = new JList();
		myScrollpane = new JScrollPane(myList);
		myScrollpane.setPreferredSize(new Dimension(345, 205));
		myList.setLayoutOrientation(JList.VERTICAL);
		listModel = new DefaultListModel();

		runDoc = (PlainDocument) runField.getDocument();
		dateDoc = (PlainDocument) dateField.getDocument();
		priceDoc = (PlainDocument) priceField.getDocument();

		runDoc.setDocumentFilter(new DigitFilter());
		dateDoc.setDocumentFilter(new DigitFilter());
		priceDoc.setDocumentFilter(new DigitFilter());

		container.add(myScrollpane);

		JPanel namePanel = new JPanel();
		namePanel.setPreferredSize(new Dimension(352, 25));
		namePanel.setLayout(new FlowLayout());

		JLabel nameLabel = new JLabel("Действие");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nameLabel.setPreferredSize(new Dimension(54, 20));
		namePanel.add(nameLabel);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		namePanel.add(nameField);

		container.add(namePanel);

		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(352, 25));
		infoPanel.setLayout(new FlowLayout());

		JLabel runLabel = new JLabel("Пробег");
		runLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		runLabel.setPreferredSize(new Dimension(40, 20));
		infoPanel.add(runLabel);
		runField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		runField.setText("7777777");
		infoPanel.add(runField);

		JLabel kmLabel = new JLabel("км");
		kmLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		kmLabel.setPreferredSize(new Dimension(15, 20));
		infoPanel.add(kmLabel);

		JLabel dateLabel = new JLabel("Дата");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dateLabel.setPreferredSize(new Dimension(30, 20));
		infoPanel.add(dateLabel);

		JDatePicker chooseDate = new JDatePicker();
		chooseDate.getFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		chooseDate.setPreferredSize(new Dimension(104, 20));
		infoPanel.add(chooseDate);

		JLabel priceLabel = new JLabel("Цена");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		priceLabel.setPreferredSize(new Dimension(30, 20));
		infoPanel.add(priceLabel);
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		infoPanel.add(priceField);

		JLabel bynLabel = new JLabel("р");
		bynLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bynLabel.setPreferredSize(new Dimension(10, 20));
		infoPanel.add(bynLabel);

		container.add(infoPanel);
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 11));

		container.add(addButton);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		container.add(deleteButton);
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		container.add(editButton);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		container.add(backButton);

		JPanel intervalPanel = new JPanel();
		intervalPanel.setPreferredSize(new Dimension(400, 25));
		intervalPanel.setLayout(new FlowLayout());
		periodically.setFont(new Font("Tahoma", Font.PLAIN, 11));

		intervalPanel.add(periodically);
		intervalPanel.add(checkInterval);
		interval.setFont(new Font("Tahoma", Font.PLAIN, 11));
		intervalPanel.add(interval);
		intervalField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		intervalPanel.add(intervalField);

		JLabel intKmLabel = new JLabel("км");
		intKmLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		intervalPanel.add(intKmLabel);

		container.add(intervalPanel);

		frame.setResizable(false);
		frame.setVisible(false);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public JList getMyList() {
		return myList;
	}

	public void setMyList(JList<?> myList) {
		this.myList = myList;
	}

	public JScrollPane getMyScrollpane() {
		return myScrollpane;
	}

	public void setMyScrollpane(JScrollPane myScrollpane) {
		this.myScrollpane = myScrollpane;
	}

	public DefaultListModel<?> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<?> listModel) {
		this.listModel = listModel;
	}

	public PlainDocument getRunDoc() {
		return runDoc;
	}

	public void setRunDoc(PlainDocument runDoc) {
		this.runDoc = runDoc;
	}

	public PlainDocument getDateDoc() {
		return dateDoc;
	}

	public void setDateDoc(PlainDocument dateDoc) {
		this.dateDoc = dateDoc;
	}

	public PlainDocument getPriceDoc() {
		return priceDoc;
	}

	public void setPriceDoc(PlainDocument priceDoc) {
		this.priceDoc = priceDoc;
	}

	public MyListSelectionListener getMyListSelectionListener() {
		return myListSelectionListener;
	}

	public void setMyListSelectionListener(MyListSelectionListener myListSelectionListener) {
		this.myListSelectionListener = myListSelectionListener;
	}

	public BackWindowController getBackWindowController() {
		return backWindowController;
	}

	public void setBackWindowController(BackWindowController backWindowController) {
		this.backWindowController = backWindowController;
		backButton.addActionListener(backWindowController);
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField.setText(nameField);
	}

	public JTextField getRunField() {
		return runField;
	}

	public void setRunField(String runField) {
		this.runField.setText(runField);
	}

	public JTextField getDateField() {
		return dateField;
	}

	public void setDateField(String date) {
		this.dateField.setText(date);
	}

	public JTextField getPriceField() {
		return priceField;
	}

	public void setPriceField(String priceField) {
		this.priceField.setText(priceField);
	}

	public JTextField getIntervalField() {
		return intervalField;
	}

	public void setIntervalField(String intervalField) {
		this.intervalField.setText(intervalField);
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getEditButton() {
		return editButton;
	}

	public void setEditButton(JButton editButton) {
		this.editButton = editButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JCheckBox getCheckInterval() {
		return checkInterval;
	}

	public void setCheckInterval(JCheckBox checkInterval) {
		this.checkInterval = checkInterval;
	}

	public JLabel getPeriodically() {
		return periodically;
	}

	public void setPeriodically(JLabel periodically) {
		this.periodically = periodically;
	}

	public JLabel getInterval() {
		return interval;
	}

	public void setInterval(JLabel interval) {
		this.interval = interval;
	}

	public void showMessage(String text) {
		JOptionPane.showMessageDialog(null, text);
	}

	public void showExpenses(ArrayList<Expense> expenses) {
		if (expenses.size() == 0) {
			showMessage("Расход не найден");
			return;
		}
		StringBuilder result = new StringBuilder();
		boolean isExists = false;
		for (Expense expense : expenses) {
			if (expense != null) {
				isExists = true;
				result.append(expense).append("\n");
			}
		}
		if (isExists) {
			showMessage(result.toString());
		} else {
			showMessage("Нет устройств");
		}
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public void setRunField(JTextField runField) {
		this.runField = runField;
	}

	public void setDateField(JTextField dateField) {
		this.dateField = dateField;
	}

	public void setPriceField(JTextField priceField) {
		this.priceField = priceField;
	}

	public void setIntervalField(JTextField intervalField) {
		this.intervalField = intervalField;
	}

}
