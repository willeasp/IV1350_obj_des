package se.kth.iv1350.seminar3.view;

import java.util.concurrent.TimeUnit;

import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.controller.OperationFailedException;
import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.ItemEntryDTO;
import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.integration.ItemNotFoundException;
import se.kth.iv1350.seminar4.util.FileLogger;
import se.kth.iv1350.seminar4.util.Logger;

public class View {
	private Controller controller;
	private SaleDTO currentSale;
	private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
	private Logger logger = FileLogger.getFileLogger();

	public View (Controller contr) {
		this.controller = contr;
		this.controller.addSaleObserver(new TotalRevenueView());
	}
	
	public void registerItem(int itemIdentifier, int quantity) {
		ItemEntryDTO itemEntry = new ItemEntryDTO(itemIdentifier, quantity);
		ItemDTO item = null;
		try {
			item = this.controller.registerItem(itemEntry);
			displayItem(item);
			this.currentSale = this.controller.getCurrentSale();
			displayCurrentSale();
		} catch (ItemNotFoundException e) {
			handleException("Item not found. ItemID: " + e.getItemEntry().getItemIdentifier(), e);
		} catch (OperationFailedException e) {
			handleException("Could not register item. Check connection and try again.", e);
		}
	}
	
	private void handleException (String message, Exception exception) {
		this.errorMsgHandler.showErrorMsg(message);
		this.logger.log(exception);
	}
	
	public void startNewSale() {
		this.controller.startNewSale();
	}
	
	public void endSale() {
		this.currentSale = this.controller.endSale();
	}
	
	public void payment (int amount) {
		PaymentDTO amountPaid = new PaymentDTO(amount);
		double change = this.controller.payment(amountPaid);
		System.out.println(String.format("Change: %.2f$", change));		
	}
	
	private void displayItem(ItemDTO item) {
		System.out.println(	item.getName() + ", " + 
							item.getDescription() + " : " + 
							item.getPrice() + "$, " + 
							item.getVAT()*100 + "% VAT\n");
	}
	
	private void displayCurrentSale() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nItems: \n");
		for (ItemDTO item : this.currentSale.getItemList()) {
			sb.append(item.getName() + ", " + item.getPrice() + "$ * " + item.getQuantity() + " : "
					+ item.getPrice() * item.getQuantity() + "$\n");
		}
		sb.append("\nTotal: " + this.currentSale.gettotalPrice() + 
				"$  |  of which VAT: " + this.currentSale.getTotalVAT() + "$\n");
		sb.append("\n***************************************\n");
		System.out.println(sb.toString());
	}
	
	public void doStuffLikeACashier() {
		System.out.println("'Start new sale'");
		this.startNewSale();
		
		System.out.println("'Register Senapslök'");
		this.registerItem(42069, 3);	// Register Senapslök, 3 items
		
		System.out.println("'Register spökbullar'");
		this.registerItem(55555, 5);	// Register 5 more Spökbullar
		
		System.out.println("'Try to register an item that does not exist'");
		this.registerItem(11111, 3);	// Try to register an item that does not exist
		
		System.out.println("'Register Senapslök'");
		this.registerItem(42069, 2);	// Register 2 more Senapslök
		
		System.out.println("'Not connecting to Inventory System'");
		this.registerItem(404, 1);
		
		System.out.println("'End Sale'");
		this.endSale();	
		
		System.out.println("'Pay 1000$");
		this.payment(1000);				// Pay 1000 dollars #money
	}
	
	public void doOtherStuff() {
		this.startNewSale();
		System.out.println("\n'Sale for 20$'");
		this.payment(20);
		
		System.out.println("\n'Sale for 50$'");
		this.payment(50);
		
		System.out.println("\n'Sale for 100$'");
		this.payment(100);
	}
	
	public void sampleRunTaskOne() {
		this.startNewSale();
		
		System.out.println("'Register Senapslök'");
		this.registerItem(42069, 2);	// Register 2 more Senapslök
		
		System.out.println("'Try to register an item that does not exist'");
		this.registerItem(11111, 3);	// Try to register an item that does not exist
		
		System.out.println("'Try to register item but not connecting to Inventory System'");
		this.registerItem(404, 1);
		
	}
	
	public void sampleRunDiscount() {
		this.startNewSale();
		
		System.out.println("'Register Senapslök'");
		this.registerItem(42069, 3);	// Register Senapslök, 3 items
		
		System.out.println("'Discount Request using NiceCalculator'");
		this.controller.discountRequest(new CustomerDTO(710123));
		this.currentSale = this.controller.getCurrentSale();
		displayCurrentSale();
		
	}
	
}
