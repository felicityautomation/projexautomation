package pom.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentExample {
	
	@Test
	public void k() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		ExtentTest extentTest=extent.createTest("MyFirstTest");
		extentTest.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extentTest.log(Status.WARNING, "this is warning");
		extentTest.log(Status.FAIL, "this is warning");
		extent.flush();
	}

}
