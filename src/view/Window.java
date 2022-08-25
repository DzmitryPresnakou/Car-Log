package view;

import java.awt.BorderLayout;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	
	private JButton gasButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("gas.jpg"))));
	private JButton expensesButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("expenses.jpg"))));
	private JButton tasksButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("tasks.jpg"))));
	private JButton oilButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("oil.jpg"))));
	private JButton carwashButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("carwash.jpg"))));
	private JButton carButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("car.jpg"))));
	private JButton addgasButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("addgas.jpg"))));
	private JButton addexpenseButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("addexpense.jpg"))));
	private JButton addtaskButton = new JButton(
			new ImageIcon(getClass().getClassLoader().getResource(("addtask.jpg"))));
	

	private JFrame frame;
	
	public Window() throws IOException {
		
		frame = new JFrame("Car log");
		frame.setSize(500, 800);
		// по центру
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());
		
		JPanel gasPanel = new JPanel();
		gasPanel.setPreferredSize(new Dimension(150, 175));
		gasPanel.setLayout(new BorderLayout());
		gasButton.setBorderPainted(false);
		gasButton.setFocusPainted(false);
		gasButton.setContentAreaFilled(false);
		gasButton.setName("Заправки");
		JLabel gasLabel = new JLabel("Заправки");
		gasPanel.add(gasButton, BorderLayout.NORTH);
		gasPanel.add(gasLabel, BorderLayout.SOUTH);
		container.add(gasPanel);
		
		JPanel expensesPanel = new JPanel();
		expensesPanel.setPreferredSize(new Dimension(150, 175));
		expensesPanel.setLayout(new BorderLayout());
		expensesButton.setBorderPainted(false);
		expensesButton.setFocusPainted(true);
		expensesButton.setContentAreaFilled(false);
		expensesButton.setName("Расходы");
		JLabel expensesLabel = new JLabel("Расходы");
		expensesPanel.add(expensesButton, BorderLayout.NORTH);
		expensesPanel.add(expensesLabel, BorderLayout.SOUTH);
		container.add(expensesPanel);

		
		JPanel tasksPanel = new JPanel();
		tasksPanel.setPreferredSize(new Dimension(150, 175));
		tasksPanel.setLayout(new BorderLayout());
		tasksButton.setBorderPainted(false);
		tasksButton.setFocusPainted(true);
		tasksButton.setContentAreaFilled(false);
		tasksButton.setName("Задачи");
		JLabel tasksLabel = new JLabel("Задачи");
		tasksPanel.add(tasksButton, BorderLayout.NORTH);
		tasksPanel.add(tasksLabel, BorderLayout.SOUTH);
		container.add(tasksPanel);
		
		JPanel oilPanel = new JPanel();
		oilPanel.setPreferredSize(new Dimension(150, 175));
		oilPanel.setLayout(new BorderLayout());
		oilButton.setBorderPainted(false);
		oilButton.setFocusPainted(true);
		oilButton.setContentAreaFilled(false);
		oilButton.setName("Масло");
		JLabel oilLabel = new JLabel("Масло");
		oilPanel.add(oilButton, BorderLayout.NORTH);
		oilPanel.add(oilLabel, BorderLayout.SOUTH);
		container.add(oilPanel);
		
		JPanel carwashPanel = new JPanel();
		carwashPanel.setPreferredSize(new Dimension(150, 175));
		carwashPanel.setLayout(new BorderLayout());
		carwashButton.setBorderPainted(false);
		carwashButton.setFocusPainted(true);
		carwashButton.setContentAreaFilled(false);
		carwashButton.setName("Автомойка");
		JLabel carwashLabel = new JLabel("Автомойка");
		carwashPanel.add(carwashButton, BorderLayout.NORTH);
		carwashPanel.add(carwashLabel, BorderLayout.SOUTH);
		container.add(carwashPanel);
		
		JPanel carPanel = new JPanel();
		carPanel.setPreferredSize(new Dimension(150, 175));
		carPanel.setLayout(new BorderLayout());
		carButton.setBorderPainted(false);
		carButton.setFocusPainted(true);
		carButton.setContentAreaFilled(false);
		carButton.setName("Машина");
		JLabel carLabel = new JLabel("Машина");
		carPanel.add(carButton, BorderLayout.NORTH);
		carPanel.add(carLabel, BorderLayout.SOUTH);
		container.add(carPanel);
		
		JPanel addgasPanel = new JPanel();
		addgasPanel.setPreferredSize(new Dimension(150, 175));
		addgasPanel.setLayout(new BorderLayout());
		addgasButton.setBorderPainted(false);
		addgasButton.setFocusPainted(true);
		addgasButton.setContentAreaFilled(false);
		addgasButton.setName("Добавить заправку");
		JLabel addgasLabel = new JLabel("Добавить заправку");
		addgasPanel.add(addgasButton, BorderLayout.NORTH);
		addgasPanel.add(addgasLabel, BorderLayout.SOUTH);
		container.add(addgasPanel);
		
		JPanel addexpensePanel = new JPanel();
		addexpensePanel.setPreferredSize(new Dimension(150, 175));
		addexpensePanel.setLayout(new BorderLayout());
		addexpenseButton.setBorderPainted(false);
		addexpenseButton.setFocusPainted(true);
		addexpenseButton.setContentAreaFilled(false);
		addexpenseButton.setName("Добавить расход");
		JLabel addexpenseLabel = new JLabel("Добавить расход");
		addexpensePanel.add(addexpenseButton, BorderLayout.NORTH);
		addexpensePanel.add(addexpenseLabel, BorderLayout.SOUTH);
		container.add(addexpensePanel);
		
		JPanel addtaskPanel = new JPanel();
		addtaskPanel.setPreferredSize(new Dimension(150, 175));
		addtaskPanel.setLayout(new BorderLayout());
		addtaskButton.setBorderPainted(false);
		addtaskButton.setFocusPainted(true);
		addtaskButton.setContentAreaFilled(false);
		addtaskButton.setName("Добавить задачу");
		JLabel addtaskLabel = new JLabel("Добавить задачу");
		addtaskPanel.add(addtaskButton, BorderLayout.NORTH);
		addtaskPanel.add(addtaskLabel, BorderLayout.SOUTH);
		container.add(addtaskPanel);
		
		

		

		
		
		
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		
		
		
	}
	

}
