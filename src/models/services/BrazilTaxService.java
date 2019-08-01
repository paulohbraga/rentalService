package models.services;

import java.io.Serializable;

public class BrazilTaxService implements TaxService, Serializable {

	public double tax(double amount ) {
		
		if(amount <= 100.0) {
			return amount * 0.2;
		}else {
			return amount *0.15;
		}
		
	}
	
}
