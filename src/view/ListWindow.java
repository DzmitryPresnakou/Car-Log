package view;

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

import controller.BackWindowController;
import controller.MyListSelectionListener;
import model.Database;
import model.Expense;

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

	private JTextField nameField = new JTextField(39);
	private JTextField runField = new JTextField(7);
	private JTextField dateField = new JTextField(10);
	private JTextField priceField = new JTextField(6);
	private JTextField intervalField = new JTextField(7);
	private JButton addButton = new JButton("Добавить");
	private JButton editButton = new JButton("Править");
	private JButton deleteButton = new JButton("Удалить");
	private JButton backButton = new JButton("Главное меню");
	private JCheckBox checkInterval = new JCheckBox();
	private JLabel periodically = new JLabel("Периодично");
	private JLabel interval = new JLabel("Интервал");

	public ListWindow() {

		frame = new JFrame();
		frame.setTitle("Expenses List");
		frame.setSize(455, 400);
		// по центру
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		myList = new JList();
		myScrollpane = new JScrollPane(myList);
		myScrollpane.setPreferredSize(new Dimension(430, 205));
		myList.setLayoutOrientation(JList.VERTICAL);
		listModel = new DefaultListModel();

		runDoc = (PlainDocument) runField.getDocument();
		dateDoc = (PlainDocument) dateField.getDocument();
		priceDoc = (PlainDocument) priceField.getDocument();

		runDoc.setDocumentFilter(new DigitFilter());
		dateDoc.setDocumentFilter(new DigitFilter());
		priceDoc.setDocumentFilter(new DigitFilter());

		container.add(myScrollpane);

		JLabel nameLabel = new JLabel("Наименование");
		container.add(nameLabel);
		container.add(nameField);

		JLabel runLabel = new JLabel("Пробег");
		container.add(runLabel);
		container.add(runField);

		JLabel kmLabel = new JLabel("км, ");
		container.add(kmLabel);

		JLabel dateLabel = new JLabel("Дата");
		container.add(dateLabel);
		container.add(dateField);

		JLabel priceLabel = new JLabel("Цена");
		container.add(priceLabel);
		container.add(priceField);

		JLabel bynLabel = new JLabel("р");
		container.add(bynLabel);

		container.add(addButton);
		container.add(deleteButton);
		container.add(editButton);
		container.add(backButton);

		JPanel intervalPanel = new JPanel();
		intervalPanel.setPreferredSize(new Dimension(400, 25));
		intervalPanel.setLayout(new FlowLayout());

		intervalPanel.add(periodically);
		intervalPanel.add(checkInterval);
		intervalPanel.add(interval);
		intervalPanel.add(intervalField);

		JLabel intKmLabel = new JLabel("км");
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

}
