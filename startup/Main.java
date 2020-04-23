package startup;

import view.View;
import controller.Controller;
import model.SaleLog;
import model.Register;
import integration.DiscountDatabase;
import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
import integration.Printer;

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
		view.registerItem(42069, 3);
	}

}
