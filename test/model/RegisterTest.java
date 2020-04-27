package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.PaymentDTO;

class RegisterTest {
	private Register reg;

	@BeforeEach
	void setUp() throws Exception {
		this.reg = new Register();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.reg = null;
	}

	@Test
	final void testIncreaseBalance() {
		boolean expResult = true;
		double balance = this.reg.getBalance();
		int amount = 10;
		this.reg.increaseBalance(new PaymentDTO(amount));
		boolean result = this.reg.getBalance() == balance + amount;
		assertEquals(expResult, result, "The right amount was not added to the register.");
	}

}
