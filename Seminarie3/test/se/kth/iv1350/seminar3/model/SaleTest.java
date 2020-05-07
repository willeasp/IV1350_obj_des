package se.kth.iv1350.seminar3.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.model.Sale;

class SaleTest {
	private Sale sale;
	private Printer printer;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		this.printer = new Printer();
		this.sale = new Sale(printer);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.printer = null;
		this.sale = null;
	}

	@Test
	final void testSalesNotEqual() {
		boolean expResult = false;
		Sale salle = new Sale(printer);
		boolean result = salle.equals(sale);
		assertEquals(expResult, result, "Different sales equal.");
	}
	
	@Test
	final void testSalesAreEqual() {
		boolean expResult = true;
		Sale salle = new Sale(printer);
		boolean result = salle.equals(salle);
		assertEquals(expResult, result, "Same sale is different.");
	}

	@Test
	final void testAddItemNew() {
		boolean expResult = true;
		ItemDTO existingItem = new ItemDTO(55555, "Sill", 0, 0, null, 0, true);
		this.sale.addItem(existingItem);
		boolean result = sale.getItemList().contains(existingItem);
		assertEquals(expResult, result, "The item was not added.");
	}
	
	@Test
	final void testAddItemIdenticalID() {
		boolean expResult = true;
		ItemDTO existingItem = new ItemDTO(55555, "Sill", 0, 0, null, 0, true);
		this.sale.addItem(existingItem);
		ItemDTO newItem = new ItemDTO(55555, "Sill", 0, 0, null, 0, true);
		this.sale.addItem(newItem);
		boolean result = sale.getItemList().size() == 1;
		assertEquals(expResult, result, "A duplicate was added instead of changing the quantity.");
	}
	
	@Test
	final void testAddItemDifferentID() {
		boolean expResult = true;
		ItemDTO existingItem = new ItemDTO(55555, "Sill", 0, 0, null, 0, true);
		this.sale.addItem(existingItem);
		ItemDTO newItem = new ItemDTO(11111, "Sill", 0, 0, null, 0, true);
		this.sale.addItem(newItem);
		boolean result = sale.getItemList().size() == 2;
		assertEquals(expResult, result, "The new item was not added.");
	}

	@Test
	final void testSaleCompletedChange() {
		ItemDTO existingItem = new ItemDTO(55555, "Sill", 10.0, 1, "description", 0, true);
		this.sale.addItem(existingItem);
		ItemDTO newItem = new ItemDTO(11111, "Sill", 15.0, 1, "description", 0, true);
		this.sale.addItem(newItem);
		PaymentDTO amountPaid = new PaymentDTO(26);
		SaleDTO completedSale = this.sale.saleCompleted(amountPaid);
		assertTrue(completedSale.getChange() == 1.0, "The amount of change back is not correct.");
	}
	
	@Test
	final void testSaleCompletedChangeNegative() {
		ItemDTO existingItem = new ItemDTO(55555, "Sill", 10.0, 1, "description", 0, true);
		this.sale.addItem(existingItem);
		ItemDTO newItem = new ItemDTO(11111, "Sill", 15.0, 1, "description", 0, true);
		this.sale.addItem(newItem);
		PaymentDTO amountPaid = new PaymentDTO(15);
		SaleDTO completedSale = this.sale.saleCompleted(amountPaid);
		assertTrue(completedSale.getChange() == -10.0, "The amount of change back is not correct.");
	}

}
