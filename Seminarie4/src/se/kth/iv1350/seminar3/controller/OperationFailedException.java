package se.kth.iv1350.seminar3.controller;

/**
 * Generic Exception class for when something went wrong.
 */
public class OperationFailedException extends Exception {
	/**
	 * Creates an instance for when something went wrong.
	 * @param msg Describes what happened.
	 * @param origin Cause of the exception.
	 */
	public OperationFailedException(String msg, Exception origin) {
		super(msg, origin);
	}
}
