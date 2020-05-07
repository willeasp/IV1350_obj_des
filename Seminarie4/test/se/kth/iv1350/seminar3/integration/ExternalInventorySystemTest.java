package se.kth.iv1350.seminar3.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.ItemEntryDTO;
import se.kth.iv1350.seminar3.integration.ExternalInventorySystem;

class ExternalInventorySystemTest {
	
	private ExternalInventorySystem externalInventorySystem;

	@BeforeEach
	void setUp() throws Exception {
		this.externalInventorySystem = new ExternalInventorySystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.externalInventorySystem = null;
	}

	@Test
	final void testGetExistingItem() {
		ItemEntryDTO itemEntry = new ItemEntryDTO(55555, 5);
		ItemDTO item = this.externalInventorySystem.getItem(itemEntry);
		assertTrue(item.itemFound(), "Item was not found");
	}
	
	@Test
	final void testGetNonexistantItem() {
		ItemEntryDTO itemEntry = new ItemEntryDTO(Integer.MAX_VALUE, 5);
		ItemDTO item = this.externalInventorySystem.getItem(itemEntry);
		boolean result = item.itemFound();
		assertFalse(result, "A nonexistent item declared found.");
	}
	
	@Test
	final void testGetExistingItemQuantity() {
		ItemEntryDTO itemEntry = new ItemEntryDTO(55555, 5);
		ItemDTO item = this.externalInventorySystem.getItem(itemEntry);
		assertTrue(item.itemFound(), "Item did not have the correct quantity");
	}
	
	@Test
	final void testGetNonexistantItemQuantity() {
		ItemEntryDTO itemEntry = new ItemEntryDTO(Integer.MAX_VALUE, 5);
		ItemDTO item = this.externalInventorySystem.getItem(itemEntry);
		boolean result = item.getQuantity() == 0;
		assertTrue(result, "A nonexistent had a quantity");
	}

}
