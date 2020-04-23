package integration;

import dto.ItemDTO;
import dto.ItemEntryDTO;
import dto.SaleDTO;

public class ExternalInventorySystem {

	public ItemDTO getItem(ItemEntryDTO itemEntry) {
		if(itemEntry.getItemIdentifier() == 42069) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Senapsl�k", 
					69.420, 
					itemEntry.getQuantity(), 
					"Senapsl�k odlad i mellersta Grums.", 
					0.15, 
					true									);
			return item;
		}
		if(itemEntry.getItemIdentifier() == 55555) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Sp�kbullar", 
					3.1415, 
					itemEntry.getQuantity(), 
					"L�skiga bullar som sp�kar i magen", 
					0.13, 
					true									);
			return item;
		}
		else {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"", 
					0.0, 
					0, 
					"", 
					0.0, 
					false									);
			return item;
		}
		
	}

	public void updateInventory(SaleDTO completedSale) {

	}

	public ExternalInventorySystem() {
	}

}
