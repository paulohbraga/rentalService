package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import models.entities.CarRental;
import models.entities.Vehicle;
import models.services.BrazilTaxService;
import models.services.RentalService;


public class Program implements Serializable {
	
	private static final Long  serialVersionUID = 1L;
	
	public static void main(String[] args) throws ParseException, FileNotFoundException, ClassNotFoundException{
		
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Ender rental data ");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:ss)");
		Date start = sdf.parse(sc.nextLine());
		System.out.println("Return ( dd/MM/yyyy hh:ss)");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental cr = new CarRental(new Vehicle(carModel), start, finish); // cr contains Vehicle and Invoice attributes and methods accessible by . 
		
		System.out.print("Enter price hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day");
		double pricePerDay = sc.nextDouble();
		sc.close();
		
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		RentalService rentalService2 = new RentalService();
		rentalService.processInvoice(cr);
		
		System.out.println("Invoice: ");
		System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		
		String file = "CarRental.ser";
		
		try {
			FileOutputStream serialfileout = new FileOutputStream(file);
			ObjectOutputStream fileoutput = new ObjectOutputStream(serialfileout);
			fileoutput.writeObject(rentalService);
			fileoutput.close();
			
			FileInputStream	serialfileinput = new FileInputStream(file);
			ObjectInputStream fileinput = new ObjectInputStream(serialfileinput);
			rentalService2 = (RentalService) fileinput.readObject();
			fileinput.close();
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		
		
	}

}
