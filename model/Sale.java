package model;

import java.util.LinkedList;

import dto.DiscountDTO;
import dto.SaleDTO;
import integration.Printer;
import dto.ItemDTO;
import dto.PaymentDTO;

public class Sale {
	private java.time.LocalTime startTime;
	private double totalBeforeDiscount;
	private double totalAfterDiscount;
	private LinkedList<ItemDTO> itemList;
	private double change;
	private DiscountDTO discount;
	private double VAT;
	private static String storeName = "Willes Feta Matbutik";
	private static String storeAddress = "Matgatan 3000";
	private java.time.LocalDate date;
	private Printer printer;

	public Sale(Printer printer) {
		this.startTime = java.time.LocalTime.now();
		this.date = java.time.LocalDate.now();
		this.itemList = new LinkedList<ItemDTO>();
	}

	/**
	 * Adds an <code>item</code> to the list of items in the current sale.
	 * @param item The item to be added in the sale.
	 */
	public void addItem(ItemDTO newItem) {
		if(newItem.itemFound()) {
			boolean equalID = false;
			for(ItemDTO item : this.itemList) {
				if(equalIdentifier(newItem, item)) {
					item.setQuantity(newQuantity(item, newItem));
					equalID = true;
					break;
				}
			}
			if(!(equalID))
				this.itemList.addLast(newItem);
		}
		updateInfo();
	}
	
	/**
	 * Adds the quantities of items. Usable when an item has to update its 
	 * @param item	First item
	 * @param newItem	Second item
	 * @return	The new quantity.
	 */
	private int newQuantity(ItemDTO item, ItemDTO newItem) {
		return item.getQuantity() + newItem.getQuantity();
	}
	
	private boolean equalIdentifier(ItemDTO newItem, ItemDTO item) {
		return item.getItemIdentifier() == newItem.getItemIdentifier();
	}

	/**
	 * Updates <code>price</code> and <code>VAT</code> for the current sale.
	 */
	private void updateInfo() {
		this.totalBeforeDiscount = 0;
		this.VAT = 0;
		for(ItemDTO item : itemList) {
			this.totalBeforeDiscount += item.getPrice() * item.getQuantity();
			this.VAT += item.getVAT();
		}		
	}

	public SaleDTO getCurrent() {
		return new SaleDTO(this);
	}

	public void applyDiscount(DiscountDTO discount) {

	}

	public void saleCompleted(PaymentDTO amountPaid) {

	}
	

	public java.time.LocalTime getStartTime() {
		return startTime;
	}

	public double getTotalBeforeDiscount() {
		return totalBeforeDiscount;
	}

	public double getTotalAfterDiscount() {
		return totalAfterDiscount;
	}

	public LinkedList<ItemDTO> getItemList() {
		return new LinkedList<ItemDTO>(itemList);
	}

	public double getChange() {
		return change;
	}

	public DiscountDTO getDiscount() {
		return discount;
	}

	public double getVAT() {
		return VAT;
	}

	public static String getStoreName() {
		return storeName;
	}

	public static String getStoreAddress() {
		return storeAddress;
	}

	public java.time.LocalDate getDate() {
		return date;
	}

	public Printer getPrinter() {
		return printer;
	}

	

}
