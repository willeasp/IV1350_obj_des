package model;

import dto.PaymentDTO;

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
