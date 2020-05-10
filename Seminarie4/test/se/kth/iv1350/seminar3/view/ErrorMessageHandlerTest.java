package se.kth.iv1350.seminar3.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ErrorMessageHandlerTest {
	private ErrorMessageHandler errMsgHandler;
	private PrintStream originalSysOut;
	private ByteArrayOutputStream outContent;

	@BeforeEach
	void setUp() throws Exception {
		this.errMsgHandler = new ErrorMessageHandler();
		originalSysOut = System.out;
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void tearDown() throws Exception {
		this.errMsgHandler = null;
		outContent = null;
		System.setOut(originalSysOut);
	}

	@Test
	final void testShowErrorMsg() {
		LocalTime now = LocalTime.now().withNano(0);
		String message = "This is a test";
		errMsgHandler.showErrorMsg(message);
		String expResult = now + " ERROR: " + message;
		String result = outContent.toString();
		assertTrue(result.contains(expResult), "Wrong message.");
	}
	
}
