package pom.tests;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.Logging;

public class TestsForLoggingExamples {
	
	@Test
	public void logExample() {
		
		Logger logger=Logger.getLogger("MyLogger");
		//BasicConfigurator.configure(); 
		PropertyConfigurator.configure("log4j.properties");
		
		logger.debug("testing with debug message");
		logger.info("info message");
		logger.warn("warning message");
		logger.error("Error message");
		logger.fatal("Fatal message");
		
	}

}
