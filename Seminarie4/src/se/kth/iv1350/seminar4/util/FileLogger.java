package se.kth.iv1350.seminar4.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Logs to a file
 */
public class FileLogger implements Logger {
	private final static String FILE_NAME = "saleprocess-log.txt";
	private PrintWriter logWriter;
	private final static FileLogger INSTANCE = new FileLogger();
	
	private FileLogger() {
		try {
			logWriter = new PrintWriter(new FileWriter(FILE_NAME), true);
		} catch (IOException e) {
			System.out.println("Couldn't create FileLogger.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return A singleton filelogger.
	 */
	public static FileLogger getFileLogger() {
		return INSTANCE;
	}

	
	@Override
	public void log(Exception exception) {
		StringBuilder sb = new StringBuilder();
		sb.append(createTime());
		sb.append(", Exception: ");
		sb.append(exception.getMessage());
		logWriter.println(sb);
		exception.printStackTrace(logWriter);
	}


	@Override
	public void log(String message) {
		logWriter.println(createTime() + ", " + message);
	}
	
	private LocalDateTime createTime() {
		return LocalDateTime.now();
	}

}
