package pom.tests;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.FbLoginPage;
import utilities.BrowserUtility;
import utilities.Logging;
import utilities.WebActions;

public class TestWithLogger {
	
	@Test
	public void test1() throws IOException {
		Logging.debug("Start - test1() method execution started.");
		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		WebActions.openUrl(driver, "https://www.facebook.com");
		FbLoginPage loginPage=new FbLoginPage(driver);
		Logging.info("Login page is loaded successfully");
		loginPage.login("lksjfldf@lksjfljdf.com", "sffslsjfls");
		boolean flag=loginPage.isErrorMessageInvalidLoginExist();
		Assert.assertEquals(flag, true,"Verify invalid loing error message");
		WebActions.takeScreenshot(driver, "target/errorPage.png");
		WebActions.closeBrowser(driver);
		Logging.debug("End - test1() method execution completed.");
	}

}
