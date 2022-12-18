package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class WebActions {
	
	public static void openUrl(WebDriver driver,String url) {
		Logging.debug("Start - Entered into openUrl() method");
		Reporter.log("Load the browser with the URL:="+url,true);
		driver.navigate().to(url);
		Logging.debug("End - Existed from openUrl() method");
	}
	
	public static void setText(WebDriver driver,By locator,String testData) {
		Reporter.log("Setting text:="+testData+" in the Webelement with locator:="+locator,true);
		driver.findElement(locator).sendKeys(testData);
	}
	
	public static void closeBrowser(WebDriver driver) {
		Reporter.log("Closing browser",true);
		driver.quit();
	}
	
	public static void click(WebDriver driver,By locator) {
		Reporter.log("Clicking the Webelement with locator:="+locator,true);
		driver.findElement(locator).click();
	}
	
	public static String getTitle(WebDriver driver) {
		String title=driver.getTitle();
		Reporter.log("Get browser title and the title is:="+title);
		return title;
	}
	
	public static boolean isElementExist(WebDriver driver,By locator) {
		Reporter.log("Check if element with locator:="+locator+" exist in the browser");
		try {
			return driver.findElement(locator).isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public static void takeScreenshot(RemoteWebDriver driver,String screenshotPath) throws IOException {
		File screenshot=driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(screenshotPath));
	}

}
