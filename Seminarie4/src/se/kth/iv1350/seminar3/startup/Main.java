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
		view.doStuffLikeACashier();
		
	}

}
