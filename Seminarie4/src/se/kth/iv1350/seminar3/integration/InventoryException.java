package se.kth.iv1350.seminar3.integration;

/**
 * Thrown when something goes wrong performing an operation in the <code>ExternalInventorySystem</code>
 */
public class InventoryException extends RuntimeException {
	/**
	 * Creates a new instance describing what went wrong in the specific message.
	 * 
	 * @param message Describes what went wrong.
	 */
	public InventoryException (String message) {
		super(message);
	}
}
