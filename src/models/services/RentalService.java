package models.services;

import java.io.Serializable;

import models.entities.CarRental;
import models.entities.Invoice;

public class RentalService implements Serializable{
	
	private Double pricePerHour;
	@Override
	public String toString() {
		return "RentalService [pricePerHour=" + pricePerHour + ", pricePerDay=" + pricePerDay + ", taxService="
				+ taxService + "]";
	}

	private Double pricePerDay;
	private TaxService taxService; // Now using interface TaxService.  Any class that implements TaxService could be used with this class.
	
	public RentalService() {
	}

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		super();
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public TaxService getTaxService() {
		return taxService;
	}
	
	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public void processInvoice(CarRental carRental) {
		
		long t1  = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		
		double basicPayment;
		if(hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

	
	
}
