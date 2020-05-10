package se.kth.iv1350.seminar3.view;

import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.controller.OperationFailedException;
import se.kth.iv1350.seminar3.dto.CustomerDTO;
import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.ItemEntryDTO;
import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.integration.ItemNotFoundException;

public class View {
	private Controller controller;
	private SaleDTO currentSale;
	private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();

	public View (Controller contr) {
		this.controller = contr;
	}
	
	public void registerItem(int itemIdentifier, int quantity) {
		ItemEntryDTO itemEntry = new ItemEntryDTO(itemIdentifier, quantity);
		ItemDTO item = null;
		try {
			item = this.controller.registerItem(itemEntry);
			displayItem(item);
			this.currentSale = this.controller.getCurrentSale();
		} catch (ItemNotFoundException e) {
			this.errorMsgHandler.showErrorMsg("Item not found. ID: " + e.getItemEntry().getItemIdentifier());
		} catch (OperationFailedException e) {
			this.errorMsgHandler.showErrorMsg("Could not register item. Check connection and try again.");
		}
		displayCurrentSale();
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
		System.out.println(item.getName() + ", " + item.getDescription() + " : " + item.getPrice() + "$, " + item.getVAT()*100 + "% VAT\n");
	}
	
	private void displayCurrentSale() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nItems: \n");
		for(ItemDTO item : this.currentSale.getItemList()) {
			sb.append(item.getName() + ", " + item.getPrice() + "$ * " + item.getQuantity() + " : " + item.getPrice()*item.getQuantity() + "$\n");
		}
		sb.append("\nTotal: " + this.currentSale.gettotalPrice() + "$  |  of which VAT: " + this.currentSale.getTotalVAT() + "$\n");
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
	

}
