package com.bianxintong.logging.log4j2;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

/**
 * Demonstration of how to set log level (w/ code and w/ config xml) for log4j2.
 * */
public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		Configuration config = ctx.getConfiguration();
		LoggerConfig rootLoggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME); 
		LoggerConfig loggerConfig = config.getLoggerConfig("com.bianxintong"); 
		loggerConfig.setLevel(Level.TRACE);
		ctx.updateLoggers();  // This causes all Loggers to refetch information from their LoggerConfig.
		new ComJournalDevApp();
	}

}
