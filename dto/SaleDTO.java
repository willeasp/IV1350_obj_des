package dto;

import model.Sale;
import java.time.LocalTime;
import java.util.LinkedList;

import integration.Printer;

import java.time.LocalDate;

/**
 * DTO for the class <code>Sale</code>
 *
 */
public class SaleDTO {
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
	
	public SaleDTO(Sale sale) {
		this.startTime = sale.getStartTime();
		this.totalBeforeDiscount = sale.getTotalBeforeDiscount();
		this.totalAfterDiscount = sale.getTotalAfterDiscount();
		this.itemList = sale.getItemList();
		this.change = sale.getChange();
		this.discount = sale.getDiscount();
		this.VAT = sale.getVAT();
		this.date = sale.getDate();
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
		return itemList;
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
	
}
