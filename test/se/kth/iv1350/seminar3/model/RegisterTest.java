package se.kth.iv1350.seminar3.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.model.Register;

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
