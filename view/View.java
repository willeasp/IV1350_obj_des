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
			this.currentSale = this.controller.getCurrentSale();
		}
		else {
			System.out.println("Item not found.\n");
		}
		
		displayCurrentSale();
	}
	
	public void startNewSale() {
		this.controller.startNewSale();
	}
	
	public void displayCurrentSale() {
		StringBuilder sb = new StringBuilder();
		sb.append("Total: " + this.currentSale.getTotalBeforeDiscount() + "$");
		
		
		sb.append("\n\nItems: \n");
		for(ItemDTO item : this.currentSale.getItemList()) {
			sb.append(item.getName() + ", " + item.getPrice() + "$ * " + item.getQuantity() + " : " + item.getPrice()*item.getQuantity() + "$\n");
		}
		System.out.println(sb.toString());
	}

}
