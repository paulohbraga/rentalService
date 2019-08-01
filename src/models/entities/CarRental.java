package models.entities;

import java.io.Serializable;
import java.util.Date;

public class CarRental implements Serializable {

	private Vehicle vehicle; // Depedencies > new
	private Invoice invoice; // Depedencies > new 
	
	private Date start;
	private Date finish;
	
	public CarRental() {
	}

	public CarRental(Vehicle vehicle, Date start, Date finish) { // Vehicle is instantiate with new - Aggregation
		this.vehicle = vehicle;
		this.start = start;
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}
	
	
	
	
}
