package keyword.tests;

import org.testng.annotations.Test;

import utilities.DriverScript;

public class KeywordDrivenTest1 {
	
	@Test
	public void keywordDrivenTest1() throws Exception {
		DriverScript driverScript=new DriverScript();
		driverScript.runScript("testdata\\MyTestData.xlsx", "Module1", "TC1");
	}
	
	@Test
	public void keywordDrivenTest2() throws Exception {
		DriverScript driverScript=new DriverScript();
		driverScript.runScript("testdata\\MyTestData.xlsx", "Module1", "TC2");
	}

}
