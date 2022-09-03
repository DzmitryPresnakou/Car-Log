package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Expense implements Serializable {

	protected String name;
	protected int run;
	protected String date;
	protected int price;
	protected String type;

	public Expense(String name, int run, String date, int price, String type) {
		this.name = name;
		this.run = run;
		this.date = date;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getGas() {
		return 0;
		
	}

	public void setGas(int gas) {

	}

	@Override
	public String toString() {
		return name + " - " + price + " р, пробег: " + run + " км, " + date;
	}

}
