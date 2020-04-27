package integration;

import dto.SaleDTO;

public class ExternalAccountingSystem {
	private int income;

	public void updateAccounting(SaleDTO completedSale) {
		this.income += completedSale.getAmountPaid();
	}

	public ExternalAccountingSystem() {
		this.income = 0;
	}

}
