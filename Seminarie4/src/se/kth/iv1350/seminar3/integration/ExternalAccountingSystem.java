package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.dto.SaleDTO;

/**
 * Integration for the External Accounting System. For updating accounting information.
 *
 */
public class ExternalAccountingSystem {
	private int income;

	public void updateAccounting(SaleDTO completedSale) {
		this.income += completedSale.getAmountPaid() - completedSale.getChange();
	}

	public ExternalAccountingSystem() {
		this.income = 0;
	}
	
	public int getIncome() {
		return income;
	}

}
