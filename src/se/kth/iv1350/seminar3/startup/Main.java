package se.kth.iv1350.seminar3.startup;

import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.integration.DiscountDatabase;
import se.kth.iv1350.seminar3.integration.ExternalAccountingSystem;
import se.kth.iv1350.seminar3.integration.ExternalInventorySystem;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.model.Register;
import se.kth.iv1350.seminar3.model.SaleLog;
import se.kth.iv1350.seminar3.view.View;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();
		ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
		DiscountDatabase discountDB = new DiscountDatabase();
		Printer printer = new Printer();
		
		Controller contr = new Controller(externalInventorySystem, externalAccountingSystem, discountDB, printer);
		View view = new View(contr);
		
		// simulating the cashier pressing buttons
		view.startNewSale();
		view.registerItem(42069, 3);	// Register Senapslök, 3 items
		view.registerItem(55555, 1);	// Register Spökbullar, 1 item
		view.registerItem(42069, 2);	// Register 2 more Senapslök
		view.registerItem(55555, 5);	// Register 5 more Spökbullar
		view.registerItem(11111, 3);	// Try to register an item that does not exist
		view.registerItem(12173, 3);	// Try to register an item that does not exist
		view.registerItem(10721, 5);	// Register Mos, 5 items
		view.endSale();	
		view.payment(1000);				// Pay 1000 dollars #money
	}

}
