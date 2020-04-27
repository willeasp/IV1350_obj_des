package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.DiscountDTO;
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
	final void testRegisterItem() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testEndSale() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetCurrentSale() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testDiscountRequest() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testPayment() {
		fail("Not yet implemented"); // TODO
	}

}
