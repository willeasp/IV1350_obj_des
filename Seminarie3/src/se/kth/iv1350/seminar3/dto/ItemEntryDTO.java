package se.kth.iv1350.seminar3.dto;

/**
 * Carrier of item identifier and quantity.
 * 
 */
public class ItemEntryDTO {
	private int itemIdentifier;
	private int quantity;

	public ItemEntryDTO (int itemIdentifier, int quantity) {
		this.itemIdentifier = itemIdentifier;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getItemIdentifier() {
		return itemIdentifier;
	}

}
