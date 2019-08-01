package models.services;

import java.io.Serializable;

public class USATaxService implements TaxService, Serializable {

	public double tax(double amount ) {
		
		if(amount <= 100.0) {
			return amount * 0.1;
		}else {
			return amount *0.10;
		}
		
	}
	
}
