package se.kth.iv1350.seminar4.util;
/**
 * Specifies an object that can print to a log. It is up to the implementing class to decide where the log is.
 */
public interface Logger {
	/**
	 * Prints message to log.
	 * @param message The message to be logged.
	 */
	void log(String message);
	/**
	 * Prints information about the exception to the log.
	 * @param exception Exception to be logged.
	 */
	void log(Exception exception);
}
