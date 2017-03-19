package com.hackerrank.logging;

import java.util.logging.*;

public class LoggingUtils {

	Logger logger = Logger.getLogger("com.hackerrank.logging");
	private void testLogging(){
		logger.setLevel(Level.FINEST);
		logger.entering(LoggingUtils.class.getName(), "testLogging");
		logger.log(Level.INFO, "this is the log");
		logger.log(Level.INFO, "this is the second log");
	}
	public static void main(String[] args) {
		new LoggingUtils().testLogging();
	}
}
