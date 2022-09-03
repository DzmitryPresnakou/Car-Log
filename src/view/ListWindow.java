package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.PlainDocument;

import org.jdatepicker.JDatePicker;
import controller.AddExpenseController;
import controller.BackWindowController;
import controller.CloseWindowController;
import controller.DeleteExpenseController;
import controller.EditExpenseController;
import controller.SaveController;
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
	private PlainDocument priceDoc;

	private SaveController saveController;
	private AddExpenseController addExpense;
	private DeleteExpenseController deleteExpense;
	private EditExpenseController editExpense;
	private BackWindowController backWindowController;
	private CloseWindowController closeWindowController;

	private JTextField nameField = new JTextField(34);
	private JTextField runField = new JTextField(6);
	private JTextField dateField = new JTextField(8);

	private JTextField priceField = new JTextField(3);
	private JButton addButton = new JButton("Добавить");
	private JButton editButton = new JButton("Править");
	private JButton deleteButton = new JButton("Удалить");
	private JButton backButton = new JButton("Назад");
	private JButton dateButton = new JButton("...");
	private JDatePicker chooseDate = new JDatePicker();

	public ListWindow() {

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

		myList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = myList.getSelectedIndex();
				if (index >= 0) {
					String type = frame.getTitle();
					List<Expense> newDatabase = database.searchExpenseByType(type);
					String name = newDatabase.get(index).getName();
					String date = newDatabase.get(index).getDate();
					int price = newDatabase.get(index).getPrice();
					int run = newDatabase.get(index).getRun();
					nameField.setText(name);
					priceField.setText(Integer.toString(price));
					runField.setText(Integer.toString(run));
					chooseDate.getFormattedTextField().setText(date);
				} else {
					nameField.setText(null);
					priceField.setText(null);
					runField.setText(null);
					chooseDate.getFormattedTextField().setText(null);
				}
			}
		});

		runDoc = (PlainDocument) runField.getDocument();
		priceDoc = (PlainDocument) priceField.getDocument();

		runDoc.setDocumentFilter(new DigitFilter());
		priceDoc.setDocumentFilter(new DigitFilter());

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

		container.add(namePanel);

		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(360, 32));
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

		chooseDate.getFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		chooseDate.setPreferredSize(new Dimension(111, 20));

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
		return priceDoc;
	}

	public void setDateDoc(PlainDocument dateDoc) {
		this.priceDoc = dateDoc;
	}

	public PlainDocument getPriceDoc() {
		return priceDoc;
	}

	public void setPriceDoc(PlainDocument priceDoc) {
		this.priceDoc = priceDoc;
	}

	public SaveController getSaveController() {
		return saveController;
	}

	public void setSaveController(SaveController saveController) {
		this.saveController = saveController;
		addButton.addActionListener(saveController);
		deleteButton.addActionListener(saveController);
		editButton.addActionListener(saveController);
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

	public AddExpenseController getAddExpense() {
		return addExpense;
	}

	public void setAddExpense(AddExpenseController addExpense) {
		this.addExpense = addExpense;
		addButton.addActionListener(addExpense);
	}

	public DeleteExpenseController getDeleteExpense() {
		return deleteExpense;
	}

	public void setDeleteExpense(DeleteExpenseController deleteExpense) {
		this.deleteExpense = deleteExpense;
		deleteButton.addActionListener(deleteExpense);
	}

	public EditExpenseController getEditExpenseController() {
		return editExpense;
	}

	public void setEditExpenseController(EditExpenseController editExpense) {
		this.editExpense = editExpense;
		editButton.addActionListener(editExpense);
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

	public JDatePicker getChooseDate() {
		return chooseDate;
	}

	public void setChooseDate(JDatePicker chooseDate) {
		this.chooseDate = chooseDate;
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
