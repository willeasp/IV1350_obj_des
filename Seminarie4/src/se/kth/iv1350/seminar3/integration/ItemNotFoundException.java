package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.ItemEntryDTO;

/**
 * Thrown when an itemID is not found.
 */
public class ItemNotFoundException extends Exception {
	private ItemEntryDTO itemEntryNotFound;
	
	/**
	 * Creates an instance with a message specifying for which itemID was not found.
	 * @param itemEntry The item that was not found.
	 */
	public ItemNotFoundException(ItemEntryDTO itemEntry) {
		super("Did not find item by ID: " + itemEntry.getItemIdentifier());
		this.itemEntryNotFound = itemEntry;
	}
	
	public ItemEntryDTO getItemEntry () {
		return this.itemEntryNotFound;
	}
}
