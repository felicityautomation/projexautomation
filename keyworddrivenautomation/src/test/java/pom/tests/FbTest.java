package pom.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.FbLoginPage;
import utilities.BrowserUtility;
import utilities.WebActions;

public class FbTest {
	
	@Test
	public void loginTest() throws IOException {
		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		WebActions.openUrl(driver, "https://www.facebook.com");
		FbLoginPage loginPage=new FbLoginPage(driver);
		loginPage.login("lksjfldf@lksjfljdf.com", "sffslsjfls");
		boolean flag=loginPage.isErrorMessageInvalidLoginExist();
		Assert.assertEquals(flag, true,"Verify invalid loing error message");
		WebActions.takeScreenshot(driver, "target/errorPage.png");
		WebActions.closeBrowser(driver);
		
	}

}
