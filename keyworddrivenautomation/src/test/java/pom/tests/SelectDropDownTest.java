package pom.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.BrowserUtility;
import utilities.WebActions;

public class SelectDropDownTest {
	
	@Test
	public void dropdownTest() throws InterruptedException {
			RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
			WebActions.openUrl(driver, "https://www.amazon.com/");
			WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
			Select dropDownList=new Select(dropdown);
			dropDownList.selectByIndex(3);
			//Thread.sleep(5000);
			dropDownList.selectByValue("search-alias=computers-intl-ship");//Computers
			//Thread.sleep(5000);
			dropDownList.selectByVisibleText("Industrial & Scientific");
			System.out.println(dropDownList.isMultiple());
			driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
			driver.switchTo().frame("iframeResult");
			WebElement dropdownCar=driver.findElement(By.id("cars"));
			Select dropDownCarList=new Select(dropdownCar);
			System.out.println(dropDownCarList.isMultiple());
			dropDownCarList.selectByVisibleText("Volvo");
			dropDownCarList.selectByVisibleText("Saab");
			dropDownCarList.selectByVisibleText("Audi"); 
			List<WebElement> options=dropDownCarList.getOptions();
			for(WebElement option:options) {
				System.out.println(option.getText());
			}
			Thread.sleep(5000);
			dropDownCarList.deselectAll();
	}

}
