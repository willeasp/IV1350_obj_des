package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.dto.PaymentDTO;

/**
 * The cash register holds the balance of the pay desk.
 */
public class Register {

	private double balance;

	/**
	 * Increases the amount present in the register.
	 * @param amountPaid	The amount to be added to the register.
	 */
	public void increaseBalance(PaymentDTO amountPaid) {
		this.balance += amountPaid.getAmount();
	}

	public Register() {
		this.balance = 1003.98;
	}

	public double getBalance() {
		return balance;
	}

}
