package se.kth.iv1350.seminar3.model;

import java.util.LinkedList;

import se.kth.iv1350.seminar3.dto.DiscountDTO;
import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.dto.ReceiptDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.integration.Printer;

/**
 * Class for an event sale.
 */
public class Sale {
	private java.time.LocalTime startTime;
	private double totalPrice;		// Including VAT
	private double totalVAT;		// VAT value added to total
	private LinkedList<ItemDTO> itemList;
	private int amountPaid;
	private double change;
	private DiscountDTO discount;
	private static String storeName = "Willes Feta Matbutik";
	private static String storeAddress = "Matgatan 3000";
	private java.time.LocalDate date;
	private Printer printer;

	public Sale(Printer printer) {
		this.startTime = java.time.LocalTime.now();
		this.date = java.time.LocalDate.now();
		this.itemList = new LinkedList<ItemDTO>();
		this.printer = printer;
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
					newQuantity(item, newItem);
					equalID = true;
					break;
				}
			}
			if(!equalID)
				this.itemList.addLast(newItem);
		}
		updateInfo();
	}
	
	/**
	 * Adds the quantities of items. Usable when an item has to update its quantity
	 * @param item	First item
	 * @param newItem	Second item
	 * @return	The new quantity.
	 */
	private void newQuantity(ItemDTO item, ItemDTO newItem) {
		item.setQuantity(item.getQuantity() + newItem.getQuantity());
	}
	
	private boolean equalIdentifier(ItemDTO newItem, ItemDTO item) {
		return item.getItemIdentifier() == newItem.getItemIdentifier();
	}

	/**
	 * Updates <code>price</code> and <code>VAT</code> for the current sale.
	 */
	private void updateInfo() {
		this.totalPrice = 0;
		this.totalVAT = 0;
		for(ItemDTO item : itemList) {
			this.totalPrice += itemTotalPrice(item);
			this.totalVAT += itemTotalVAT(item);
		}	
	}
	
	private double itemTotalVAT (ItemDTO item) {
		return item.getPrice() * item.getQuantity() * item.getVAT();
	}
	
	private double itemTotalPrice (ItemDTO item) {
		return item.getPrice() * item.getQuantity() * (1 + item.getVAT());
	}

	/**
	 * 
	 * @return Current state of the <code>Sale</code>.
	 */
	public SaleDTO getCurrent() {
		return new SaleDTO(this);
	}

	public void applyDiscount(DiscountDTO discount) {

	}

	public SaleDTO saleCompleted(PaymentDTO amountPaid) {
		this.amountPaid = amountPaid.getAmount();
		this.change = this.amountPaid - this.totalPrice;
		SaleDTO completedSale = new SaleDTO(this);
		ReceiptDTO receipt = new ReceiptDTO(completedSale);
		this.printer.printReceipt(receipt);
		return completedSale;
	}
	

	public java.time.LocalTime getStartTime() {
		return startTime;
	}

	public double gettotalPrice() {
		return totalPrice;
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

	public double getTotalVAT() {
		return totalVAT;
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
	
	public int getAmountPaid() {
		return amountPaid;
	}

	

}
