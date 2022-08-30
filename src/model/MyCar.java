package model;

import java.io.Serializable;
import java.time.LocalDate;

public class MyCar implements Serializable {

	private String name;
	private String id;
	private LocalDate made;
	private int tank;
	private int run;

	public MyCar(String name, String id, LocalDate made, int tank, int run) {

		this.name = name;
		this.id = id;
		this.made = made;
		this.tank = tank;
		this.run = run;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getMade() {
		return made;
	}

	public void setMade(LocalDate made) {
		this.made = made;
	}

	public int getTank() {
		return tank;
	}

	public void setTank(int tank) {
		this.tank = tank;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return "MyCar [name=" + name + ", id=" + id + ", made=" + made + ", tank=" + tank + ", run=" + run + "]";
	}

}