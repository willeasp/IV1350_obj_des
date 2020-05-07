package se.kth.iv1350.seminar3.dto;

import java.lang.StringBuilder;
import java.time.LocalTime;
import java.util.LinkedList;

import se.kth.iv1350.seminar3.model.Sale;

import java.time.LocalDate;

/**
 * DTO for the class <code>Sale</code>
 *
 */
public class SaleDTO {
	private java.time.LocalTime startTime;
	private double totalPrice;
	private LinkedList<ItemDTO> itemList;
	private double change;
	private DiscountDTO discount;
	private double totalVAT;
	private String storeName;
	private String storeAddress;
	private java.time.LocalDate date;
	private int amountPaid;
	
	/**
	 * Carrier for Sale information
	 * @param sale
	 */
	public SaleDTO(Sale sale) {
		this.startTime = sale.getStartTime();
		this.totalPrice = sale.gettotalPrice();
		this.itemList = sale.getItemList();
		this.change = sale.getChange();
		this.discount = sale.getDiscount();
		this.totalVAT = sale.getTotalVAT();
		this.storeName = Sale.getStoreName();
		this.storeAddress = Sale.getStoreAddress();
		this.date = sale.getDate();
		this.amountPaid = sale.getAmountPaid();
	}
	
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("Total: " + this.totalPrice + "$");
//		sb.append("\n\nItems: \n");
//		for(ItemDTO item : this.itemList) {
//			sb.append(item.getName() + ", " + item.getPrice() + "$\n");
//		}
//		return sb.toString();
//	}
	
	public java.time.LocalTime getStartTime() {
		return startTime;
	}
	public double gettotalPrice() {
		return totalPrice;
	}
	public LinkedList<ItemDTO> getItemList() {
		return itemList;
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
	public String getStoreName() {
		return storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public java.time.LocalDate getDate() {
		return date;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	
}
