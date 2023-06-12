package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.InfoPanelController;
import controller.MouseControllerForWindow;
import controller.OpenNewWindowController;
import controller.ReadController;
import java.awt.Font;
import java.awt.event.WindowListener;

import javax.swing.SwingConstants;

public class Window extends JFrame {

	private OpenNewWindowController openController;
	private ReadController readController;
	private InfoPanelController infoPanelController;
	private MouseControllerForWindow mouseControllerForWindow;

	private JButton gasButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("gas.jpg"))));
	private JButton expensesButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("expenses.jpg"))));
	private JButton tasksButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("tasks.jpg"))));
	private JButton oilButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("oil.jpg"))));
	private JButton carwashButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("carwash.jpg"))));
	private JButton carButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("car.jpg"))));
	private JFrame frame;
	private JLabel run;
	private JLabel gasExpenses;
	private JLabel gasLastMonthExpenses;
	private JLabel oil;
	private JLabel runAmount;
	private JLabel date;
	private JLabel gasAmountExpenses;
	private JLabel gasAmountLastMonthExpenses;
	private JLabel gasExpensesMoney;
	private JLabel gasLastMonthExpensesMoney;
	private JLabel monthRun;
	private JLabel monthRunValue;
	private JLabel lastMonthRun;
	private JLabel lastMonthRunValue;
	private JLabel oilReminderRun;
	private JLabel oilReminderValue;
	private JLabel carLabel;
	private JLabel totalExpenses;
	private JLabel totalLastMonthExpenses;
	private JLabel totalAmountExpenses;
	private JLabel totalLastMonthAmountExpenses;
	private JLabel totalExpensesMoney;
	private JLabel totalLastMonthExpensesMoney;

	public Window() throws IOException {

		frame = new JFrame("Car log");
		frame.setResizable(false);
		frame.setSize(370, 580);
		// по центру
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		JPanel gasPanel = new JPanel();
		gasPanel.setPreferredSize(new Dimension(110, 140));
		gasPanel.setLayout(new FlowLayout());
		gasButton.setBorderPainted(false);
		gasButton.setFocusPainted(false);
		gasButton.setContentAreaFilled(false);
		gasButton.setName("Заправка");
		JLabel gasLabel = new JLabel("Заправка");
		gasPanel.add(gasButton);
		gasPanel.add(gasLabel);
		container.add(gasPanel);

		JPanel expensesPanel = new JPanel();
		expensesPanel.setPreferredSize(new Dimension(110, 140));
		expensesPanel.setLayout(new FlowLayout());
		expensesButton.setBorderPainted(false);
		expensesButton.setFocusPainted(true);
		expensesButton.setContentAreaFilled(false);
		expensesButton.setName("Расход");
		JLabel expensesLabel = new JLabel("Расход");
		expensesPanel.add(expensesButton);
		expensesPanel.add(expensesLabel);
		container.add(expensesPanel);

		JPanel tasksPanel = new JPanel();
		tasksPanel.setPreferredSize(new Dimension(110, 140));
		tasksPanel.setLayout(new FlowLayout());
		tasksButton.setBorderPainted(false);
		tasksButton.setFocusPainted(true);
		tasksButton.setContentAreaFilled(false);
		tasksButton.setName("Задача");
		JLabel tasksLabel = new JLabel("Задача");
		tasksPanel.add(tasksButton);
		tasksPanel.add(tasksLabel);
		container.add(tasksPanel);

		JPanel oilPanel = new JPanel();
		oilPanel.setPreferredSize(new Dimension(110, 140));
		oilPanel.setLayout(new FlowLayout());
		oilButton.setBorderPainted(false);
		oilButton.setFocusPainted(true);
		oilButton.setContentAreaFilled(false);
		oilButton.setName("Замена масла");
		JLabel oilLabel = new JLabel("Замена масла");
		oilPanel.add(oilButton);
		oilPanel.add(oilLabel);
		container.add(oilPanel);

		JPanel carwashPanel = new JPanel();
		carwashPanel.setPreferredSize(new Dimension(110, 140));
		carwashPanel.setLayout(new FlowLayout());
		carwashButton.setBorderPainted(false);
		carwashButton.setFocusPainted(true);
		carwashButton.setContentAreaFilled(false);
		carwashButton.setName("Автомойка");
		JLabel carwashLabel = new JLabel("Автомойка");
		carwashPanel.add(carwashButton);
		carwashPanel.add(carwashLabel);
		container.add(carwashPanel);

		JPanel carPanel = new JPanel();
		carPanel.setPreferredSize(new Dimension(110, 140));
		carPanel.setLayout(new FlowLayout());
		carButton.setBorderPainted(false);
		carButton.setFocusPainted(true);
		carButton.setContentAreaFilled(false);
		carButton.setName("Машина");
		JLabel carLabel = new JLabel("Машина");
		carPanel.add(carButton);
		carPanel.add(carLabel);
		container.add(carPanel);

		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(330, 240));
		infoPanel.setBackground(new Color(225, 225, 225));
		infoPanel.setLayout(new FlowLayout());

		container.add(infoPanel, BorderLayout.SOUTH);

		JPanel runAmountPanel = new JPanel();
		runAmountPanel.setPreferredSize(new Dimension(325, 24));
		runAmountPanel.setBackground(new Color(225, 225, 225));
		runAmountPanel.setLayout(new FlowLayout());

		runAmount = new JLabel();
		runAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		runAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		runAmount.setForeground(new Color(0, 0, 255));
		runAmount.setPreferredSize(new Dimension(80, 20));
		runAmountPanel.add(runAmount);

		run = new JLabel("км пробег на дату");
		run.setHorizontalAlignment(SwingConstants.CENTER);
		run.setPreferredSize(new Dimension(120, 20));
		runAmountPanel.add(run);

		date = new JLabel();
		date.setHorizontalAlignment(SwingConstants.LEFT);
		date.setFont(new Font("Tahoma", Font.BOLD, 12));
		date.setForeground(new Color(0, 0, 255));
		date.setPreferredSize(new Dimension(80, 20));
		runAmountPanel.add(date);

		infoPanel.add(runAmountPanel);

		JPanel gasAmountPanel = new JPanel();
		gasAmountPanel.setPreferredSize(new Dimension(325, 24));
		gasAmountPanel.setBackground(new Color(225, 225, 225));
		gasAmountPanel.setLayout(new FlowLayout());

		gasExpenses = new JLabel("Расходы на заправку за текущий месяц");
		gasExpenses.setPreferredSize(new Dimension(242, 20));
		gasAmountPanel.add(gasExpenses);

		gasAmountExpenses = new JLabel();
		gasAmountExpenses.setFont(new Font("Tahoma", Font.BOLD, 12));
		gasAmountExpenses.setHorizontalAlignment(JLabel.RIGHT);
		gasAmountExpenses.setForeground(new Color(0, 0, 255));
		gasAmountExpenses.setPreferredSize(new Dimension(45, 20));
		gasAmountPanel.add(gasAmountExpenses);

		gasExpensesMoney = new JLabel("р");
		gasExpensesMoney.setPreferredSize(new Dimension(16, 20));
		gasAmountPanel.add(gasExpensesMoney);

		infoPanel.add(gasAmountPanel);

		JPanel gasAmountlastMonthPanel = new JPanel();
		gasAmountlastMonthPanel.setPreferredSize(new Dimension(325, 24));
		gasAmountlastMonthPanel.setBackground(new Color(225, 225, 225));
		gasAmountlastMonthPanel.setLayout(new FlowLayout());

		gasLastMonthExpenses = new JLabel("Расходы на заправку за прошлый месяц");
		gasLastMonthExpenses.setPreferredSize(new Dimension(242, 20));
		gasAmountlastMonthPanel.add(gasLastMonthExpenses);
		gasAmountLastMonthExpenses = new JLabel();
		gasAmountLastMonthExpenses.setFont(new Font("Tahoma", Font.BOLD, 12));
		gasAmountLastMonthExpenses.setHorizontalAlignment(JLabel.RIGHT);
		gasAmountLastMonthExpenses.setForeground(new Color(0, 0, 255));
		gasAmountLastMonthExpenses.setPreferredSize(new Dimension(45, 20));
		gasAmountlastMonthPanel.add(gasAmountLastMonthExpenses);

		gasLastMonthExpensesMoney = new JLabel("р");
		gasLastMonthExpensesMoney.setPreferredSize(new Dimension(16, 20));
		gasAmountlastMonthPanel.add(gasLastMonthExpensesMoney);

		infoPanel.add(gasAmountlastMonthPanel);

		JPanel totalExpensesPanel = new JPanel();
		totalExpensesPanel.setPreferredSize(new Dimension(325, 24));
		totalExpensesPanel.setBackground(new Color(225, 225, 225));
		totalExpensesPanel.setLayout(new FlowLayout());

		totalExpenses = new JLabel("Общие расходы за текущий месяц");
		totalExpenses.setPreferredSize(new Dimension(242, 20));
		totalExpensesPanel.add(totalExpenses);

		totalAmountExpenses = new JLabel();
		totalAmountExpenses.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalAmountExpenses.setHorizontalAlignment(JLabel.RIGHT);
		totalAmountExpenses.setForeground(new Color(0, 0, 255));
		totalAmountExpenses.setPreferredSize(new Dimension(45, 20));
		totalExpensesPanel.add(totalAmountExpenses);

		totalExpensesMoney = new JLabel("р");
		totalExpensesMoney.setPreferredSize(new Dimension(16, 20));
		totalExpensesPanel.add(totalExpensesMoney);

		infoPanel.add(totalExpensesPanel);

		JPanel totalLastMonthExpensesPanel = new JPanel();
		totalLastMonthExpensesPanel.setPreferredSize(new Dimension(325, 24));
		totalLastMonthExpensesPanel.setBackground(new Color(225, 225, 225));
		totalLastMonthExpensesPanel.setLayout(new FlowLayout());

		totalLastMonthExpenses = new JLabel("Общие расходы за прошлый месяц");
		totalLastMonthExpenses.setPreferredSize(new Dimension(242, 20));
		totalLastMonthExpensesPanel.add(totalLastMonthExpenses);

		totalLastMonthAmountExpenses = new JLabel();
		totalLastMonthAmountExpenses.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalLastMonthAmountExpenses.setHorizontalAlignment(JLabel.RIGHT);
		totalLastMonthAmountExpenses.setForeground(new Color(0, 0, 255));
		totalLastMonthAmountExpenses.setPreferredSize(new Dimension(45, 20));
		totalLastMonthExpensesPanel.add(totalLastMonthAmountExpenses);

		totalLastMonthExpensesMoney = new JLabel("р");
		totalLastMonthExpensesMoney.setPreferredSize(new Dimension(16, 20));
		totalLastMonthExpensesPanel.add(totalLastMonthExpensesMoney);

		totalLastMonthExpensesPanel.add(totalLastMonthExpensesMoney);
		infoPanel.add(totalLastMonthExpensesPanel);

		JPanel totalRunPanel = new JPanel();
		totalRunPanel.setPreferredSize(new Dimension(325, 24));
		totalRunPanel.setBackground(new Color(225, 225, 225));
		totalRunPanel.setLayout(new FlowLayout());

		run = new JLabel("Пробег за текущий месяц");
		run.setPreferredSize(new Dimension(227, 20));
		totalRunPanel.add(run);

		monthRun = new JLabel();
		monthRun.setFont(new Font("Tahoma", Font.BOLD, 12));
		monthRun.setHorizontalAlignment(JLabel.RIGHT);
		monthRun.setForeground(new Color(0, 0, 255));
		monthRun.setPreferredSize(new Dimension(60, 20));
		totalRunPanel.add(monthRun);

		monthRunValue = new JLabel("км");
		monthRunValue.setPreferredSize(new Dimension(16, 20));
		totalRunPanel.add(monthRunValue);
		infoPanel.add(totalRunPanel);

		JPanel totalLastMonthRunPanel = new JPanel();
		totalLastMonthRunPanel.setPreferredSize(new Dimension(325, 24));
		totalLastMonthRunPanel.setBackground(new Color(225, 225, 225));
		totalLastMonthRunPanel.setLayout(new FlowLayout());

		run = new JLabel("Пробег за прошлый месяц");
		run.setPreferredSize(new Dimension(227, 20));
		totalLastMonthRunPanel.add(run);

		lastMonthRun = new JLabel();
		lastMonthRun.setFont(new Font("Tahoma", Font.BOLD, 12));
		lastMonthRun.setHorizontalAlignment(JLabel.RIGHT);
		lastMonthRun.setForeground(new Color(0, 0, 255));
		lastMonthRun.setPreferredSize(new Dimension(60, 20));
		totalLastMonthRunPanel.add(lastMonthRun);

		lastMonthRunValue = new JLabel("км");
		lastMonthRunValue.setPreferredSize(new Dimension(16, 20));
		totalLastMonthRunPanel.add(lastMonthRunValue);
		infoPanel.add(totalLastMonthRunPanel);

		JPanel oilReminderPanel = new JPanel();
		oilReminderPanel.setPreferredSize(new Dimension(325, 24));
		oilReminderPanel.setBackground(new Color(225, 225, 225));
		oilReminderPanel.setLayout(new FlowLayout());

		oil = new JLabel("Пробег после замены масла");
		oil.setPreferredSize(new Dimension(227, 20));
		oilReminderPanel.add(oil);

		oilReminderRun = new JLabel();
		oilReminderRun.setFont(new Font("Tahoma", Font.BOLD, 12));
		oilReminderRun.setHorizontalAlignment(JLabel.RIGHT);
		oilReminderRun.setForeground(new Color(0, 0, 255));
		oilReminderRun.setPreferredSize(new Dimension(60, 20));
		oilReminderPanel.add(oilReminderRun);

		oilReminderValue = new JLabel("км");
		oilReminderValue.setPreferredSize(new Dimension(16, 20));
		oilReminderPanel.add(oilReminderValue);
		infoPanel.add(oilReminderPanel);
		
		frame.setVisible(true);
	}

	public OpenNewWindowController getOpenController() {
		return openController;
	}

	public void setOpenController(OpenNewWindowController openController) {
		this.openController = openController;
		gasButton.addActionListener(openController);
		expensesButton.addActionListener(openController);
		tasksButton.addActionListener(openController);
		oilButton.addActionListener(openController);
		carwashButton.addActionListener(openController);
		carButton.addActionListener(openController);
	}

	public ReadController getReadController() {
		return readController;
	}

	public void setReadController(ReadController readController) {
		this.readController = readController;
		gasButton.addActionListener(readController);
		expensesButton.addActionListener(readController);
		tasksButton.addActionListener(readController);
		oilButton.addActionListener(readController);
		carwashButton.addActionListener(readController);
		carButton.addActionListener(readController);
	}

	public JLabel getMonthRun() {
		return monthRun;
	}

	public void setMonthRun(JLabel monthRun) {
		this.monthRun = monthRun;
	}

	public JLabel getLastMonthRun() {
		return lastMonthRun;
	}

	public void setLastMonthRun(JLabel lastMonthRun) {
		this.lastMonthRun = lastMonthRun;
	}

	public JLabel getTotalLastMonthAmountExpenses() {
		return totalLastMonthAmountExpenses;
	}

	public void setTotalLastMonthAmountExpenses(JLabel totalLastMonthAmountExpenses) {
		this.totalLastMonthAmountExpenses = totalLastMonthAmountExpenses;
	}

	public JLabel getGasAmountLastMonthExpenses() {
		return gasAmountLastMonthExpenses;
	}

	public void setGasAmountLastMonthExpenses(JLabel gasAmountLastMonthExpenses) {
		this.gasAmountLastMonthExpenses = gasAmountLastMonthExpenses;
	}

	public JLabel getGasExpenses() {
		return gasExpenses;
	}

	public void setGasExpenses(JLabel gasExpenses) {
		this.gasExpenses = gasExpenses;
	}

	public JLabel getRunAmount() {
		return runAmount;
	}

	public void setRunAmount(String runAmount) {
		this.runAmount.setText(runAmount);
	}

	public JLabel getGasAmountExpenses() {
		return gasAmountExpenses;
	}

	public void setGasAmountExpenses(JLabel gasAmountExpenses) {
		this.gasAmountExpenses = gasAmountExpenses;
	}

	public JLabel getTotalAmountExpenses() {
		return totalAmountExpenses;
	}

	public void setTotalAmountExpenses(JLabel totalAmountExpenses) {
		this.totalAmountExpenses = totalAmountExpenses;
	}

	public JLabel getGasExpensesMoney() {
		return gasExpensesMoney;
	}

	public void setGasExpensesMoney(JLabel gasExpensesMoney) {
		this.gasExpensesMoney = gasExpensesMoney;
	}

	public JLabel getOilReminderRun() {
		return oilReminderRun;
	}

	public void setOilReminderRun(JLabel oilReminderRun) {
		this.oilReminderRun = oilReminderRun;
	}

	public JLabel getOilReminderValue() {
		return oilReminderValue;
	}

	public JLabel getCarLabel() {
		return carLabel;
	}

	public void setCarLabel(String carLabel) {
		this.carLabel.setText(carLabel);
	}

	public void setOilReminderValue(JLabel oilReminderValue) {
		this.oilReminderValue = oilReminderValue;
	}

	public JButton getGasButton() {
		return gasButton;
	}

	public void setGasButton(JButton gasButton) {
		this.gasButton = gasButton;
	}

	public JButton getExpensesButton() {
		return expensesButton;
	}

	public void setExpensesButton(JButton expensesButton) {
		this.expensesButton = expensesButton;
	}

	public JButton getTasksButton() {
		return tasksButton;
	}

	public void setTasksButton(JButton tasksButton) {
		this.tasksButton = tasksButton;
	}

	public JButton getOilButton() {
		return oilButton;
	}

	public void setOilButton(JButton oilButton) {
		this.oilButton = oilButton;
	}

	public JButton getCarwashButton() {
		return carwashButton;
	}

	public void setCarwashButton(JButton carwashButton) {
		this.carwashButton = carwashButton;
	}

	public JButton getCarButton() {
		return carButton;
	}

	public void setCarButton(JButton carButton) {
		this.carButton = carButton;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getRun() {
		return run;
	}

	public void setRun(JLabel run) {
		this.run = run;
	}

	public JLabel getExpenses() {
		return gasExpenses;
	}

	public void setExpenses(JLabel expenses) {
		this.gasExpenses = expenses;
	}

	public JLabel getOil() {
		return oil;
	}

	public void setOil(JLabel oil) {
		this.oil = oil;
	}

	public JLabel getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date.setText(date);
	}

	public MouseControllerForWindow getMouseControllerForWindow() {
		return mouseControllerForWindow;
	}

	public void setMouseControllerForWindow(MouseControllerForWindow mouseControllerForWindow) {
		this.mouseControllerForWindow = mouseControllerForWindow;
		carButton.addMouseMotionListener(mouseControllerForWindow);
	}

	public InfoPanelController getInfoPanelController() {
		return infoPanelController;
	}

	public void setInfoPanelController(InfoPanelController infoPanelController) {
		this.infoPanelController = infoPanelController;
		frame.addWindowListener(infoPanelController);
	}
}
