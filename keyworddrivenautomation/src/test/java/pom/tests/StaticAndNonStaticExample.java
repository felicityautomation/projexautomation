package pom.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.ControlsPage;
import utilities.BrowserUtility;
import utilities.WebActions;

public class StaticAndNonStaticExample {
	
	public void t2() {
		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebActions.openUrl(driver, "http://www.uitestpractice.com/Students/Actions");
		ControlsPage page=new ControlsPage(driver);
		page.setFirstName("bharath");
		
	}

}
