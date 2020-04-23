package integration;

import dto.ItemDTO;
import dto.ItemEntryDTO;
import dto.SaleDTO;

public class ExternalInventorySystem {

	public ItemDTO getItem(ItemEntryDTO itemEntry) {
		ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
									"Senapslök", 
									69.420, 
									itemEntry.getQuantity(), 
									"Senapslök odlad i mellersta Grums.", 
									0.15, 
									true									);
		return item;
	}

	public void updateInventory(SaleDTO completedSale) {

	}

	public ExternalInventorySystem() {
	}

}
