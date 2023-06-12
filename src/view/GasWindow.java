package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import controller.AddGasExpenseController;
import controller.BackWindowController;
import controller.CloseWindowController;
import controller.DeleteGasExpenseController;
import controller.EditGasExpenseController;
import controller.MyGasExpenseListSelectionListener;
import controller.SaveController;
import model.Database;
import model.Expense;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class GasWindow extends ListWindow {
	private JFrame frame;
	private Database database;
	private JList<?> myList;
	private JScrollPane myScrollpane;
	private DefaultListModel<?> listModel;

	private PlainDocument runDoc;
	private PlainDocument priceDoc;
	private PlainDocument gasDoc;

	private SaveController saveController;
	private AddGasExpenseController addGasExpense;
	private DeleteGasExpenseController deleteGasExpense;
	private EditGasExpenseController editGasExpense;
	private BackWindowController backWindowController;
	private CloseWindowController closeWindowController;
	private MyGasExpenseListSelectionListener myGasExpenseListSelectionListener;

	private JTextField nameField = new JTextField(28);
	private JTextField runField = new JTextField(6);
	private JTextField dateField = new JTextField(10);
	private JTextField gasField = new JTextField(3);

	private JTextField priceField = new JTextField(4);
	private JButton addButton = new JButton("Добавить");
	private JButton editButton = new JButton("Править");
	private JButton deleteButton = new JButton("Удалить");
	private JButton backButton = new JButton("Назад");
	private JDatePickerImpl datePicker;
	private SpringLayout springLayout;

	public GasWindow() {

		frame = new JFrame();
		frame.setTitle("Expenses List");
		frame.setSize(380, 350);
		// по центру
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		myList = new JList();
		myScrollpane = new JScrollPane(myList);
		myScrollpane.setPreferredSize(new Dimension(350, 205));
		myList.setLayoutOrientation(JList.VERTICAL);
		listModel = new DefaultListModel();

		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.day", "Day");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
 		JDatePanelImpl panel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(panel, new DateLabelFormatter());

		springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.WEST, datePicker.getJFormattedTextField(), 0, SpringLayout.WEST, datePicker);
		datePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.CENTER);
		datePicker.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		datePicker.setPreferredSize(new Dimension(110, 20));

		runDoc = (PlainDocument) runField.getDocument();
		priceDoc = (PlainDocument) priceField.getDocument();
		gasDoc = (PlainDocument) gasField.getDocument();
		runDoc.setDocumentFilter(new DigitFilter());
		priceDoc.setDocumentFilter(new DigitFilter());
		gasDoc.setDocumentFilter(new DigitFilter());
		container.add(myScrollpane);

		JPanel namePanel = new JPanel();
		namePanel.setPreferredSize(new Dimension(360, 25));
		namePanel.setLayout(new FlowLayout());

		JLabel nameLabel = new JLabel("Действие");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nameLabel.setPreferredSize(new Dimension(54, 20));
		namePanel.add(nameLabel);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		namePanel.add(nameField);
		gasField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		gasField.setHorizontalAlignment(JLabel.RIGHT);
		namePanel.add(gasField);
		JLabel volumeLabel = new JLabel("л");
		volumeLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		volumeLabel.setPreferredSize(new Dimension(10, 20));
		namePanel.add(volumeLabel);
		container.add(namePanel);

		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(360, 25));
		infoPanel.setLayout(new FlowLayout());

		JLabel runLabel = new JLabel("Пробег");
		runLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		runLabel.setPreferredSize(new Dimension(36, 20));
		infoPanel.add(runLabel);
		runField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		runField.setHorizontalAlignment(JLabel.RIGHT);
		infoPanel.add(runField);

		JLabel kmLabel = new JLabel("км");
		kmLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		kmLabel.setPreferredSize(new Dimension(14, 20));
		infoPanel.add(kmLabel);

		JLabel dateLabel = new JLabel("Дата");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dateLabel.setPreferredSize(new Dimension(28, 20));
		infoPanel.add(dateLabel);
		infoPanel.add(datePicker);

		JLabel priceLabel = new JLabel("Цена");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		priceLabel.setPreferredSize(new Dimension(28, 20));
		infoPanel.add(priceLabel);
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		priceField.setHorizontalAlignment(JLabel.RIGHT);
		infoPanel.add(priceField);

		JLabel bynLabel = new JLabel("р");
		bynLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bynLabel.setPreferredSize(new Dimension(8, 20));
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

	public PlainDocument getRunDoc() {
		return runDoc;
	}

	public void setRunDoc(PlainDocument runDoc) {
		this.runDoc = runDoc;
	}

	public PlainDocument getPriceDoc() {
		return priceDoc;
	}

	public void setPriceDoc(PlainDocument priceDoc) {
		this.priceDoc = priceDoc;
	}

	public PlainDocument getGasDoc() {
		return gasDoc;
	}

	public void setGasDoc(PlainDocument gasDoc) {
		this.gasDoc = gasDoc;
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

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}

	public MyGasExpenseListSelectionListener getMyGasExpenseListSelectionListener() {
		return myGasExpenseListSelectionListener;
	}

	public void setMyGasExpenseListSelectionListener(
			MyGasExpenseListSelectionListener myGasExpenseListSelectionListener) {
		this.myGasExpenseListSelectionListener = myGasExpenseListSelectionListener;
		myList.addListSelectionListener(myGasExpenseListSelectionListener);
	}

	public SaveController getSaveController() {
		return saveController;
	}

	public void setSaveController(SaveController saveController) {
		this.saveController = saveController;
		addButton.addActionListener(saveController);
		deleteButton.addActionListener(saveController);
		editButton.addActionListener(saveController);
		backButton.addActionListener(saveController);
	}

	public BackWindowController getBackWindowController() {
		return backWindowController;
	}

	public void setBackWindowController(BackWindowController backWindowController) {
		this.backWindowController = backWindowController;
		backButton.addActionListener(backWindowController);
	}

	public CloseWindowController getCloseWindowController() {
		return closeWindowController;
	}

	public void setCloseWindowController(CloseWindowController closeWindowController) {
		this.closeWindowController = closeWindowController;
		frame.addWindowListener(closeWindowController);
	}

	public AddGasExpenseController getAddGasExpense() {
		return addGasExpense;
	}

	public void setAddGasExpense(AddGasExpenseController addGasExpense) {
		this.addGasExpense = addGasExpense;
		addButton.addActionListener(addGasExpense);
	}

	public DeleteGasExpenseController getDeleteGasExpense() {
		return deleteGasExpense;
	}

	public void setDeleteGasExpense(DeleteGasExpenseController deleteGasExpense) {
		this.deleteGasExpense = deleteGasExpense;
		deleteButton.addActionListener(deleteGasExpense);
	}

	public EditGasExpenseController getEditGasExpense() {
		return editGasExpense;
	}

	public void setEditGasExpense(EditGasExpenseController editGasExpense) {
		this.editGasExpense = editGasExpense;
		editButton.addActionListener(editGasExpense);
	}

	public String getNameField() {
		return nameField.getText();
	}

	public void setNameField(String nameField) {
		this.nameField.setText(nameField);
	}

	public String getRunField() {
		return runField.getText();
	}

	public void setRunField(String runField) {
		this.runField.setText(runField);
	}

	public String getDateField() {
		return dateField.getText();
	}

	public void setDateField(String date) {
		this.dateField.setText(date);
	}

	public String getPriceField() {
		return priceField.getText();
	}

	public void setPriceField(String priceField) {
		this.priceField.setText(priceField);
	}

	public String getGasField() {
		return gasField.getText();
	}

	public void setGasField(String gastField) {
		this.gasField.setText(gastField);
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
			showMessage("Нет расходов");
		}
	}

}
