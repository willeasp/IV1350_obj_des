
package se.kth.iv1350.seminar3.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.model.Sale;
import se.kth.iv1350.seminar3.model.SaleLog;

class SaleLogTest {
	private SaleLog log;

	@BeforeEach
	void setUp() throws Exception {
		this.log = new SaleLog();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.log = null;
	}

	@Test
	final void testAddSale() {
		Printer printer = new Printer();
		Sale sale = new Sale(printer);
		SaleDTO completedSale = new SaleDTO(sale);
		this.log.addSale(completedSale);
		boolean result = this.log.getSaleLog().contains(completedSale);
		assertTrue(result, "The Sale was not added to the SaleLog");
	}

}
