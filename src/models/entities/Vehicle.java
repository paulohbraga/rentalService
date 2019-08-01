package models.entities;

import java.io.Serializable;

public class Vehicle implements Serializable {
	
	private String model;
	
	public Vehicle() {
	}

	public Vehicle(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
	
	
}
