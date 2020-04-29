package se.kth.iv1350.seminar3.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.integration.ExternalAccountingSystem;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.model.Sale;

class ExternalAccountingSystemTest {
	private ExternalAccountingSystem externalAccountingSystem;
	
	@BeforeEach
	void setUp() throws Exception {
		this.externalAccountingSystem = new ExternalAccountingSystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.externalAccountingSystem = null;
	}

	@Test
	final void testUpdateAccounting() {
		int income = 10;
		Printer printer = new Printer();
		Sale sale = new Sale(printer);
		PaymentDTO amountPaid = new PaymentDTO(income);
		sale.saleCompleted(amountPaid);
		SaleDTO completedSale = new SaleDTO(sale);
		int incomeBefore = this.externalAccountingSystem.getIncome();
		this.externalAccountingSystem.updateAccounting(completedSale);
		int incomeAfter = this.externalAccountingSystem.getIncome();
		int difference = incomeAfter - incomeBefore;
		boolean result = difference == income;
		assertTrue(result, "The right amount was not added to the accounting system.");
	}
}
