package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KeywordActions {
	WebDriver driver;
	public void performAction(String action,String locatorType,String locatorValue,String testData) throws Exception {

		switch(action) {
		case "openBrowser":
			driver=BrowserUtility.getDriver();
			break;
		case "openUrl":
			WebActions.openUrl(driver, testData);
			break;
		case "setText":
			WebActions.setText(driver, getLocator(locatorType, locatorValue), testData);
			break;
		case "click":
			WebActions.click(driver, getLocator(locatorType, locatorValue));
			break;
		case "verifyTitle":
			String title=WebActions.getTitle(driver);
			Assert.assertEquals(title, testData);
			break;
		case "closeBrowser":
			WebActions.closeBrowser(driver);
			break;
			
		case "wait":
			Thread.sleep(Long.parseLong(testData));
			break;
		default:
			throw new Exception("Invalid action:="+action+", it is not supported.");
		}
	}

	private By getLocator(String locatorType,String locatorValue) throws Exception {
		switch(locatorType) {
		case "id":
			return By.id(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "xpath":
			return By.xpath(locatorValue);
		default:
			throw new Exception("Invalid locatorType:="+locatorType+", it is not supported");
		}
	}

}
