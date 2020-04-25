package view;

import controller.Controller;
import dto.CustomerDTO;
import dto.ItemEntryDTO;
import dto.PaymentDTO;
import dto.SaleDTO;
import dto.ItemDTO;

public class View {
	private Controller controller;
	private SaleDTO currentSale;

	public View (Controller contr) {
		this.controller = contr;
	}
	
	public void registerItem(int itemIdentifier, int quantity) {
		ItemEntryDTO itemEntry = new ItemEntryDTO(itemIdentifier, quantity);
		ItemDTO item = this.controller.registerItem(itemEntry);
		if(item.itemFound()) {
			displayItem(item);
			this.currentSale = this.controller.getCurrentSale();
		}
		else {
			System.out.println("*Item not found.* ID: " + item.getItemIdentifier());
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
		System.out.println("Change: " + change);		
	}
	
	private void displayItem(ItemDTO item) {
		System.out.println(item.getName() + ", " + item.getDescription() + " : " + item.getPrice() + "$, " + item.getVAT()*100 + "% VAT\n");
	}
	
	private void displayCurrentSale() {
		StringBuilder sb = new StringBuilder();
		sb.append("Total: " + this.currentSale.gettotalPrice() + "$  |  of which VAT: " + this.currentSale.getTotalVAT() + "$");
		
		sb.append("\n\nItems: \n");
		for(ItemDTO item : this.currentSale.getItemList()) {
			sb.append(item.getName() + ", " + item.getPrice() + "$ * " + item.getQuantity() + " : " + item.getPrice()*item.getQuantity() + "$\n");
		}
		sb.append("\n***************************************\n");
		System.out.println(sb.toString());
	}
	

}
