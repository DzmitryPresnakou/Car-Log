package model;

import java.time.LocalDate;

public class GasExpense extends Expense {

	protected int gas;

	public GasExpense(String name, int run, String date, int price, String type, int gas) {
		super(name, run, date, price, type);
		this.gas = gas;
	}

	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}

	@Override
	public String toString() {
		return name + " - " + gas + "л, " + price + " р, пробег: " + run + " км, " + date;
	}

}
