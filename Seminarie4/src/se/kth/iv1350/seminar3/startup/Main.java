package se.kth.iv1350.seminar3.startup;

import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.integration.DiscountDatabase;
import se.kth.iv1350.seminar3.integration.ExternalAccountingSystem;
import se.kth.iv1350.seminar3.integration.ExternalInventorySystem;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.model.Register;
import se.kth.iv1350.seminar3.model.SaleLog;
import se.kth.iv1350.seminar3.view.View;

/**
 * Starts the entire program and simulates the cashier
 */
public class Main {
	public static void main(String[] args) {
		ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();
		ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
		DiscountDatabase discountDB = new DiscountDatabase();
		Printer printer = new Printer();
		
		Controller contr = new Controller(externalInventorySystem, externalAccountingSystem, discountDB, printer);
		View view = new View(contr);
		
		// simulating the cashier pressing buttons
		System.out.println("'Start new sale'");
		view.startNewSale();
		System.out.println("'Register Senapslök'");
		view.registerItem(42069, 3);	// Register Senapslök, 3 items
//		System.out.println("'Register spökbullar'");
//		view.registerItem(55555, 1);	// Register Spökbullar, 1 item
		System.out.println("'Register spökbullar'");
		view.registerItem(55555, 5);	// Register 5 more Spökbullar
		System.out.println("'Try to register an item that does not exist'");
		view.registerItem(11111, 3);	// Try to register an item that does not exist
		System.out.println("'Register Senapslök'");
		view.registerItem(42069, 2);	// Register 2 more Senapslök
//		System.out.println("'Try to register an other item that does not exist'");
//		view.registerItem(12173, 3);	// Try to register an item that does not exist
//		System.out.println("'Register mos'");
//		view.registerItem(10721, 5);	// Register Mos, 5 items
		System.out.println("'End Sale'");
		view.endSale();	
		System.out.println("'Pay 1000$");
		view.payment(1000);				// Pay 1000 dollars #money
	}

}
