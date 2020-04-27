package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.DiscountDTO;
import dto.ItemEntryDTO;
import dto.PaymentDTO;
import dto.SaleDTO;
import integration.DiscountDatabase;
import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
import integration.Printer;
import model.Sale;

class ControllerTest {
	private Controller contr;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ExternalInventorySystem extinvsys = new ExternalInventorySystem();
		ExternalAccountingSystem extaccsys = new ExternalAccountingSystem();
		DiscountDatabase discountDB = new DiscountDatabase();
		Printer printer = new Printer();
		this.contr = new Controller(extinvsys, extaccsys, discountDB, printer);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testRegisterItemID() {
		contr.startNewSale();
		ItemEntryDTO itemEntry = new ItemEntryDTO(55555, 5);
		contr.registerItem(itemEntry);
		int itemID = contr.getCurrentSale().getItemList().getFirst().getItemIdentifier();
		assertTrue(itemID == itemEntry.getItemIdentifier(), "Item was not registered correctly.");
	}
	
	@Test
	final void testRegisterItemQuantity() {
		contr.startNewSale();
		ItemEntryDTO itemEntry = new ItemEntryDTO(55555, 5);
		contr.registerItem(itemEntry);
		contr.registerItem(new ItemEntryDTO(55555, 2));
		int itemQuantity = contr.getCurrentSale().getItemList().getFirst().getQuantity();
		assertTrue(itemQuantity == 7, "Item quantity was not updated.");
	}

	@Test
	final void testPaymentMaxValue() {
		contr.startNewSale();
		ItemEntryDTO itemEntry = new ItemEntryDTO(55555, 5);
		contr.registerItem(itemEntry);
		contr.registerItem(new ItemEntryDTO(55555, 2));
		PaymentDTO amountPaid = new PaymentDTO(Integer.MAX_VALUE);
		boolean result = contr.payment(amountPaid) < 0;
		assertFalse(result, "The change back was less then zero");
		contr.payment(amountPaid);
	}

}
