package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.ItemEntryDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;

/**
 * Integration for the External Inventory System. Hardcoded to simulate calls to the external inv. system.
 *
 */
public class ExternalInventorySystem {

	public ItemDTO getItem(ItemEntryDTO itemEntry) {
		if(itemEntry.getItemIdentifier() == 42069) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Senapsl�k", 
					69.420, 
					itemEntry.getQuantity(), 
					"Senapsl�k odlad i mellersta Grums.", 
					0.25, 
					true									);
			return item;
		}
		if(itemEntry.getItemIdentifier() == 55555) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Sp�kbullar", 
					3.1415, 
					itemEntry.getQuantity(), 
					"L�skiga bullar som sp�kar i magen", 
					0.12, 
					true									);
			return item;
		}
		if(itemEntry.getItemIdentifier() == 10721) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Mos", 
					6.99, 
					itemEntry.getQuantity(), 
					"Rotmos ur Centralamerikas djupaste skogar.", 
					0.06, 
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
