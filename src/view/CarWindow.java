package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;
import controller.BackWindowController;
import controller.CloseWindowController;
import controller.SaveCarController;
import model.MyCar;

public class CarWindow extends JFrame {

	private JFrame frame;
	private BackWindowController backWindowController;
	private CloseWindowController closeWindowController;
	private SaveCarController saveCarController;

	private PlainDocument runDoc;
	private PlainDocument tankDoc;
	private PlainDocument madeDoc;
	private MyCar myCar;

	private JTextField nameField = new JTextField(10);
	private JTextField idField = new JTextField(10);
	private JTextField madeField = new JTextField(10);
	private JTextField tankField = new JTextField(3);
	private JTextField runField = new JTextField(8);

	private JButton saveButton = new JButton("Сохранить");
	private JButton backButton = new JButton("Назад");

	public CarWindow() {
		frame = new JFrame();
		frame.setTitle("Info");
		frame.setSize(210, 225);
		// по центру
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());

		JPanel namePanel = new JPanel();
		namePanel.setPreferredSize(new Dimension(180, 25));
		namePanel.setLayout(new FlowLayout());

		JLabel nameLabel = new JLabel("Марка");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nameLabel.setPreferredSize(new Dimension(82, 20));
		namePanel.add(nameLabel);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		namePanel.add(nameField);

		container.add(namePanel);

		JPanel idPanel = new JPanel();
		idPanel.setPreferredSize(new Dimension(180, 25));
		idPanel.setLayout(new FlowLayout());

		JLabel idLabel = new JLabel("Гос №");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idLabel.setPreferredSize(new Dimension(82, 20));
		idPanel.add(idLabel);
		idField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idPanel.add(idField);

		container.add(idPanel);

		JPanel madePanel = new JPanel();
		madePanel.setPreferredSize(new Dimension(180, 25));
		madePanel.setLayout(new FlowLayout());

		JLabel madeLabel = new JLabel("Год выпуска");
		madeLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		madeLabel.setPreferredSize(new Dimension(82, 20));

		madePanel.add(madeLabel);
		madeField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		madePanel.add(madeField);

		container.add(madePanel);

		JPanel tankPanel = new JPanel();
		tankPanel.setPreferredSize(new Dimension(180, 25));
		tankPanel.setLayout(new FlowLayout());

		JLabel tankLabel = new JLabel("Топливный бак");
		tankLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tankLabel.setPreferredSize(new Dimension(118, 20));
		tankPanel.add(tankLabel);
		tankField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tankPanel.add(tankField);

		JLabel volumeLabel = new JLabel("л");
		volumeLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		volumeLabel.setPreferredSize(new Dimension(15, 20));
		tankPanel.add(volumeLabel);

		container.add(tankPanel);

		JPanel runPanel = new JPanel();
		runPanel.setPreferredSize(new Dimension(180, 25));
		runPanel.setLayout(new FlowLayout());

		JLabel runLabel = new JLabel("Пробег");
		runLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		runLabel.setPreferredSize(new Dimension(78, 20));
		runPanel.add(runLabel);
		runField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		runPanel.add(runField);

		JLabel kilometerLabel = new JLabel("км");
		kilometerLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		kilometerLabel.setPreferredSize(new Dimension(15, 20));
		runPanel.add(kilometerLabel);
		container.add(runPanel);
		
		runDoc = (PlainDocument) runField.getDocument();
		tankDoc = (PlainDocument) tankField.getDocument();
		madeDoc = (PlainDocument) madeField.getDocument();

		runDoc.setDocumentFilter(new DigitFilter());
		tankDoc.setDocumentFilter(new DigitFilter());
		madeDoc.setDocumentFilter(new DigitFilter());

		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		container.add(saveButton);
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

		
	public SaveCarController getSaveCarController() {
		return saveCarController;
	}

	public void setSaveCarController(SaveCarController saveCarController) {
		this.saveCarController = saveCarController;
		saveButton.addActionListener(saveCarController);
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public void setMadeField(JTextField madeField) {
		this.madeField = madeField;
	}

	public void setTankField(JTextField tankField) {
		this.tankField = tankField;
	}

	public void setRunField(JTextField runField) {
		this.runField = runField;
	}

	public PlainDocument getRunDoc() {
		return runDoc;
	}

	public void setRunDoc(PlainDocument runDoc) {
		this.runDoc = runDoc;
	}

	public PlainDocument getTankDoc() {
		return tankDoc;
	}

	public void setTankDoc(PlainDocument tankDoc) {
		this.tankDoc = tankDoc;
	}

	public String getNameField() {
		return nameField.getText();
	}

	public void setNameField(String nameField) {
		this.nameField.setText(nameField);
	}

	public String getIdField() {
		return idField.getText();
	}

	public void setIdField(String idField) {
		this.idField.setText(idField);
	}

	public String getMadeField() {
		return madeField.getText();
	}

	public void setMadeField(String madeField) {
		this.madeField.setText(madeField);
	}

	public String getTankField() {
		return tankField.getText();
	}

	public void setTankField(String tankField) {
		this.tankField.setText(tankField);
	}

	public String getRunField() {
		return runField.getText();
	}

	public void setRunField(String runField) {
		this.runField.setText(runField);
	}

	public JButton getEditButton() {
		return saveButton;
	}

	public void setEditButton(JButton editButton) {
		this.saveButton = editButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
		
	public MyCar getMyCar() {
		return myCar;
	}

	public void setMyCar(MyCar myCar) {
		this.myCar = myCar;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public void showMessage(String text) {
		JOptionPane.showMessageDialog(null, text);
	}

}
