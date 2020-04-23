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
		ItemEntryDTO itemEntry = new ItemEntryDTO(420, 69);
		ItemDTO item = this.controller.registerItem(itemEntry);
		if(item.itemFound()) {
			this.currentSale = this.controller.getCurrentSale();
		}
		else {
			System.out.println("Item not found.");
		}
	}
	
	public void startNewSale() {
		this.controller.startNewSale();
	}

}
