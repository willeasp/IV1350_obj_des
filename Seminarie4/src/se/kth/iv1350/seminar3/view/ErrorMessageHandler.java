package se.kth.iv1350.seminar3.view;

import java.time.LocalTime;

/**
 * Handles printing error messages to the user.
 */
public class ErrorMessageHandler {
	
	/**
	 * Prints the error message to the user. States that it is and error and includes the time.
	 * @param msg The message that will be shown to the user.
	 */
	public void showErrorMsg (String msg) {
		StringBuilder sb = new StringBuilder();
		sb.append(makeTime());
		sb.append(" ERROR: ");
		sb.append(msg);
		System.out.println(sb);
		System.out.println();
	}
	
	private LocalTime makeTime() {
		LocalTime time = LocalTime.now().withNano(0);
		return time;
	}
}
