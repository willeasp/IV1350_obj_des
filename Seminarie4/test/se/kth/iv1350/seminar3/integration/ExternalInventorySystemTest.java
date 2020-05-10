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
	final void testGetExistingItem() throws ItemNotFoundException {
		ItemEntryDTO itemEntry = new ItemEntryDTO(55555, 5);
		ItemDTO item = null;
		item = this.externalInventorySystem.getItem(itemEntry);
		assertTrue(item.itemFound(), "Item was not found");
	}
	
	@Test
	final void testGetNonexistantItem() {
		assertThrows(ItemNotFoundException.class, () -> {
			ItemEntryDTO itemEntry = new ItemEntryDTO(Integer.MAX_VALUE, 5);
			ItemDTO item = this.externalInventorySystem.getItem(itemEntry);
		}, "Found a nonexistent item.");
	}
	
	@Test
	final void testGetExistingItemQuantity() throws ItemNotFoundException{ 
		ItemEntryDTO itemEntry = new ItemEntryDTO(55555, 5);
		ItemDTO item = this.externalInventorySystem.getItem(itemEntry);
		assertTrue(item.itemFound(), "Item did not have the correct quantity");
	}
	
	@Test
	final void testInventoryException() {
		assertThrows(InventoryException.class, () -> {
			ItemEntryDTO itemEntry = new ItemEntryDTO(404, 5);
			ItemDTO item = this.externalInventorySystem.getItem(itemEntry);
		}, "Returned item when no connection to inventory system.");
	}

}
