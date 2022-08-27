package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Window extends JFrame {

	private JButton gasButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("gas.jpg"))));
	private JButton expensesButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("expenses.jpg"))));
	private JButton tasksButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("tasks.jpg"))));
	private JButton oilButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("oil.jpg"))));
	private JButton carwashButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("carwash.jpg"))));
	private JButton carButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("car.jpg"))));
	private JButton addgasButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource(("addgas.jpg"))));
	private JButton addexpenseButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("addexpense.jpg"))));
	private JButton addtaskButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("addtask.jpg"))));

	private JFrame frame;
	
	private JLabel run;
	private JLabel expenses;
	private JLabel oil;
	private JLabel remind;
	private JList myList;
	private JScrollPane myScrollpane;
	private DefaultListModel listModel;

	public Window() throws IOException {

		frame = new JFrame("Car log");
		frame.setSize(500, 810);
		// по центру
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());

		JPanel gasPanel = new JPanel();
		gasPanel.setPreferredSize(new Dimension(150, 185));
		gasPanel.setLayout(new FlowLayout());
		gasButton.setBorderPainted(false);
		gasButton.setFocusPainted(false);
		gasButton.setContentAreaFilled(false);
		gasButton.setName("Заправки");
		JLabel gasLabel = new JLabel("Заправки");
		gasPanel.add(gasButton);
		gasPanel.add(gasLabel);
		container.add(gasPanel);

		JPanel expensesPanel = new JPanel();
		expensesPanel.setPreferredSize(new Dimension(150, 185));
		expensesPanel.setLayout(new FlowLayout());
		expensesButton.setBorderPainted(false);
		expensesButton.setFocusPainted(true);
		expensesButton.setContentAreaFilled(false);
		expensesButton.setName("Расходы");
		JLabel expensesLabel = new JLabel("Расходы");
		expensesPanel.add(expensesButton);
		expensesPanel.add(expensesLabel);
		container.add(expensesPanel);

		JPanel tasksPanel = new JPanel();
		tasksPanel.setPreferredSize(new Dimension(150, 185));
		tasksPanel.setLayout(new FlowLayout());
		tasksButton.setBorderPainted(false);
		tasksButton.setFocusPainted(true);
		tasksButton.setContentAreaFilled(false);
		tasksButton.setName("Задачи");
		JLabel tasksLabel = new JLabel("Задачи");
		tasksPanel.add(tasksButton);
		tasksPanel.add(tasksLabel);
		container.add(tasksPanel);

		JPanel oilPanel = new JPanel();
		oilPanel.setPreferredSize(new Dimension(150, 185));
		oilPanel.setLayout(new FlowLayout());
		oilButton.setBorderPainted(false);
		oilButton.setFocusPainted(true);
		oilButton.setContentAreaFilled(false);
		oilButton.setName("Масло");
		JLabel oilLabel = new JLabel("Масло");
		oilPanel.add(oilButton);
		oilPanel.add(oilLabel);
		container.add(oilPanel);

		JPanel carwashPanel = new JPanel();
		carwashPanel.setPreferredSize(new Dimension(150, 185));
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
		carPanel.setPreferredSize(new Dimension(150, 185));
		carPanel.setLayout(new FlowLayout());
		carButton.setBorderPainted(false);
		carButton.setFocusPainted(true);
		carButton.setContentAreaFilled(false);
		carButton.setName("Машина");
		JLabel carLabel = new JLabel("Машина");
		carPanel.add(carButton);
		carPanel.add(carLabel);
		container.add(carPanel);

		JPanel addgasPanel = new JPanel();
		addgasPanel.setPreferredSize(new Dimension(150, 185));
		addgasPanel.setLayout(new FlowLayout());
		addgasButton.setBorderPainted(false);
		addgasButton.setFocusPainted(true);
		addgasButton.setContentAreaFilled(false);
		addgasButton.setName("Добавить заправку");
		JLabel addgasLabel = new JLabel("Добавить заправку");
		addgasPanel.add(addgasButton);
		addgasPanel.add(addgasLabel);
		container.add(addgasPanel);

		JPanel addexpensePanel = new JPanel();
		addexpensePanel.setPreferredSize(new Dimension(150, 185));
		addexpensePanel.setLayout(new FlowLayout());
		addexpenseButton.setBorderPainted(false);
		addexpenseButton.setFocusPainted(true);
		addexpenseButton.setContentAreaFilled(false);
		addexpenseButton.setName("Добавить расход");
		JLabel addexpenseLabel = new JLabel("Добавить расход");
		addexpensePanel.add(addexpenseButton);
		addexpensePanel.add(addexpenseLabel);
		container.add(addexpensePanel);

		JPanel addtaskPanel = new JPanel();
		addtaskPanel.setPreferredSize(new Dimension(150, 185));
		addtaskPanel.setLayout(new FlowLayout());
		addtaskButton.setBorderPainted(false);
		addtaskButton.setFocusPainted(true);
		addtaskButton.setContentAreaFilled(false);
		addtaskButton.setName("Добавить задачу");
		JLabel addtaskLabel = new JLabel("Добавить задачу");
		addtaskPanel.add(addtaskButton);
		addtaskPanel.add(addtaskLabel);
		container.add(addtaskPanel);
		
		
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(460, 180));
		infoPanel.setBackground(new Color(240, 255, 240));
		infoPanel.setLayout(new FlowLayout());

		container.add(infoPanel, BorderLayout.SOUTH);
		
		run = new JLabel("км пробег на дату");
		run.setForeground(new Color(0, 0, 160));
		run.setPreferredSize(new Dimension(450, 20));
		infoPanel.add(run);

		expenses = new JLabel("Расходы за текущий месяц");
		expenses.setForeground(new Color(0, 0, 160));
		expenses.setPreferredSize(new Dimension(450, 20));
		infoPanel.add(expenses);

		oil = new JLabel("Пробег после замены масла");
		oil.setForeground(new Color(0, 0, 160));
		oil.setPreferredSize(new Dimension(450, 20));
		infoPanel.add(oil);
		
		remind = new JLabel("Напоминания:");
		remind.setForeground(new Color(0, 0, 160));
		remind.setPreferredSize(new Dimension(450, 20));
		infoPanel.add(remind);
		
		myList = new JList();
		myScrollpane = new JScrollPane(myList);
		myScrollpane.setPreferredSize(new Dimension(450, 70));
		myList.setLayoutOrientation(JList.VERTICAL);
		listModel = new DefaultListModel();
		infoPanel.add(myScrollpane);
	

		frame.setResizable(false);
		frame.setVisible(true);

	}

}
