package se.kth.iv1350.seminar3.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.seminar3.dto.ItemDTO;
import se.kth.iv1350.seminar3.dto.PaymentDTO;
import se.kth.iv1350.seminar3.dto.ReceiptDTO;
import se.kth.iv1350.seminar3.dto.SaleDTO;
import se.kth.iv1350.seminar3.integration.Printer;
import se.kth.iv1350.seminar3.model.Sale;

class PrinterTest {
	private PrintStream originalSysOut;
	private ByteArrayOutputStream outContent;

	@BeforeEach
	void setUp() throws Exception {
		originalSysOut = System.out;
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void tearDown() throws Exception {
		outContent = null;
		System.setOut(originalSysOut);
	}

	@Test
	final void testPrintReceipt() {
		Printer printer = new Printer();
		Sale sale = new Sale(printer);
		LocalDateTime startTime = LocalDateTime.now();
		int itemID = 12345;
		String name = "Korv";
		double price = 100.0;
		int quantity = 3;
		String description = "Godaste korven";
		double VAT = 0.5;
		boolean isFound = true;
		ItemDTO newItem = new ItemDTO(itemID, name, price, quantity, description, VAT, isFound);
		sale.addItem(newItem);
		PaymentDTO amountPaid = new PaymentDTO(450);
		SaleDTO completedSale = sale.saleCompleted(amountPaid);
		ReceiptDTO receipt = new ReceiptDTO(completedSale);
		printer.printReceipt(receipt);
		String expResult = startTime.toLocalDate().toString() + " " + startTime.toLocalTime().withNano(0).toString() + "\n"
				+ "Willes Feta Matbutik\n" + "Matgatan 3000";
		String result = outContent.toString();
		assertTrue(result.contains(expResult), "Wrong printout.");
		assertTrue(result.contains(name), "Name missing.");
		assertTrue(result.contains(Integer.toString(quantity)), "quantity missing");
	}

}
