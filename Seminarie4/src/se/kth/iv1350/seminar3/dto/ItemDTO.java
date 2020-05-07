package se.kth.iv1350.seminar3.dto;

/**
 * Class for describing an item.
 * @author Dell
 *
 */
public class ItemDTO {

	private int itemIdentifier;
	private String name;
	private int quantity;
	private String description;
	private double price;
	private double VAT;
	private boolean itemFound;

	public ItemDTO(int itemIdentifier, String name, double price, int quantity, String description, double VAT, boolean itemFound) {
		this.itemIdentifier = itemIdentifier;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.VAT = VAT;
		this.itemFound = itemFound;
	}

	public int getItemIdentifier() {
		return itemIdentifier;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public double getVAT() {
		return VAT;
	}

	public boolean itemFound() {
		return itemFound;
	}
	
	public void setQuantity (int quantity) {
		this.quantity = quantity;
	}



}
