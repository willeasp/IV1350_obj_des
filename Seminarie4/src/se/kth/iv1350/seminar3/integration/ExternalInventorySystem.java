package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.ItemEntryDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;

/**
 * Integration for the External Inventory System. Hardcoded to simulate calls to the external inv. system.
 *
 */
public class ExternalInventorySystem {
	private static final ExternalInventorySystem INSTANCE = new ExternalInventorySystem();

	public ItemDTO getItem(ItemEntryDTO itemEntry) throws ItemNotFoundException {
		if(itemEntry.getItemIdentifier() == 42069) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Senapslök", 
					69.420, 
					itemEntry.getQuantity(), 
					"Senapslök odlad i mellersta Grums.", 
					0.25, 
					true									);
			return item;
		}
		if(itemEntry.getItemIdentifier() == 55555) {
			ItemDTO item = new ItemDTO(	itemEntry.getItemIdentifier(), 
					"Spökbullar", 
					3.1415, 
					itemEntry.getQuantity(), 
					"Läskiga bullar som spökar i magen", 
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
		if(itemEntry.getItemIdentifier() == 404) {
			throw new InventoryException("Could not access the inventory.");
		}
		else {
			throw new ItemNotFoundException(itemEntry);
		}
		
	}

	public void updateInventory(SaleDTO completedSale) {
		
	}
	
	public static ExternalInventorySystem getExternalInventorySystem() {
		return INSTANCE;
	}

	private ExternalInventorySystem() {
	}

}
