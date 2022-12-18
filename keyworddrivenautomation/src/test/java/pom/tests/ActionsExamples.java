package pom.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.BrowserUtility;
import utilities.WebActions;

public class ActionsExamples {
	
	@Test(enabled=false)
	public void test1() throws IOException, InterruptedException {
		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebActions.openUrl(driver, "http://www.uitestpractice.com/Students/Actions");
		WebElement e1=driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		
		Actions actions=new Actions(driver);
//		actions.dragAndDrop(e1, e2).build().perform();
//		Thread.sleep(5000);
//		actions.dragAndDropBy(e1, 20, 60).build().perform();
		actions.clickAndHold(e1).release(e2).build().perform();
		WebElement clickButton=driver.findElement(By.name("click"));
		actions.click(clickButton).build().perform();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		
		WebElement doubleClickButton=driver.findElement(By.name("dblClick"));
		actions.doubleClick(doubleClickButton).build().perform();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		
		
		
		
	}
	
	@Test(enabled=false)
	public void test2() throws IOException, InterruptedException {
		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebActions.openUrl(driver, "http://www.uitestpractice.com/Students/Actions");
		WebElement e1=driver.findElement(By.id("div2"));
		Actions actions=new Actions(driver);
		Thread.sleep(5000);
		actions.moveToElement(e1).build().perform();
		Thread.sleep(5000);
		actions.moveByOffset(50, 100).build().perform();
	}
	@Test(enabled=false)
	public void contextMenuTest() throws InterruptedException {
		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebActions.openUrl(driver, "http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement e1=driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions actions=new Actions(driver);
		Thread.sleep(5000);
		actions.contextClick(e1).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Paste']")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void fbLogin() {
		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebActions.openUrl(driver, "http://www.uitestpractice.com/Students/Form");
		WebElement e1=driver.findElement(By.id("firstname"));
		e1.click();
		Actions actions=new Actions(driver);
		
		actions.keyDown(Keys.SHIFT).sendKeys("bharath").keyUp(Keys.SHIFT).build().perform();
		
	}
}
