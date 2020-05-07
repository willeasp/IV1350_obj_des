package se.kth.iv1350.seminar3.dto;

import java.time.LocalTime;
import java.util.LinkedList;

import se.kth.iv1350.seminar3.dto.SaleDTO;

import java.time.LocalDate;

/**
 * Carries information to be displayed on the receipt.
 */
public class ReceiptDTO {
	private java.time.LocalTime startTime;
	private double totalPrice;
	private LinkedList<ItemDTO> itemList;
	private double change;
	private DiscountDTO discount;
	private double totalVAT;
	private String storeName;
	private String storeAddress;
	private java.time.LocalDate date;

	public ReceiptDTO(SaleDTO completedSale) {
		this.date = completedSale.getDate();
		this.startTime = completedSale.getStartTime();
		this.itemList = completedSale.getItemList();
		this.totalPrice = completedSale.gettotalPrice();
		this.change = completedSale.getChange();
		this.discount = completedSale.getDiscount();
		this.totalVAT = completedSale.getTotalVAT();
		this.storeName = completedSale.getStoreName();
		this.storeAddress = completedSale.getStoreAddress();
		
	}

	public java.time.LocalTime getStartTime() {
		return startTime;
	}

	public double getTotalPrice() {
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

	
}
