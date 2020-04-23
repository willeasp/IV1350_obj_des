package dto;

import java.time.LocalTime;
import java.time.LocalDate;

import model.Sale;

public class ReceiptDTO {

	private LocalDate date;

	private LocalTime startTime;

	private String storeName;

	private String storeAddress;

	private java.util.Arrays items;

	private float totalPrice;

	private float VAT;

	public ReceiptDTO ReceiptDTO(Sale completedSale) {
		return null;
	}

	public float getVAT() {
		return 0;
	}

	public float getTotalPrice() {
		return 0;
	}

	public java.util.Arrays getItems() {
		return null;
	}

	public String getStoreAddress() {
		return null;
	}

	public String getStoreName() {
		return null;
	}

	public LocalTime getStartTime() {
		return null;
	}

	public LocalDate getDate() {
		return null;
	}

}
