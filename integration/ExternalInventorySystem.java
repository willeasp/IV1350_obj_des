package integration;

import dto.ItemDTO;
import dto.ItemEntryDTO;
import dto.SaleDTO;

public class ExternalInventorySystem {

	public ItemDTO getItem(ItemEntryDTO itemEntry) {
		if(itemEntry.getItemIdentifier() == 42069) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Senapslök", 
					69.420, 
					itemEntry.getQuantity(), 
					"Senapslök odlad i mellersta Grums.", 
					0.15, 
					true									);
			return item;
		}
		if(itemEntry.getItemIdentifier() == 55555) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Spökbullar", 
					3.1415, 
					itemEntry.getQuantity(), 
					"Läskiga bullar som spökar i magen", 
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
