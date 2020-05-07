package se.kth.iv1350.seminar3.dto;

/**
 * Carries amount paid for sale.
 */
public class PaymentDTO {

	private int amount;

	public PaymentDTO(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

}
