package model;

import dto.PaymentDTO;

public class Register {

	private double balance;

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
