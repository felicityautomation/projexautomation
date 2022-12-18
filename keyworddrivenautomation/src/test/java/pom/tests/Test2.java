package pom.tests;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.FbLoginPage;
import utilities.BrowserUtility;
import utilities.Logging;
import utilities.WebActions;

public class Test2 {
	//private static final Logger logger = LogManager.getLogger(Test.class);  

	public static void main(String[] args) throws InterruptedException {
		//		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		//		WebActions.openUrl(driver, "http://www.uitestpractice.com/Students/Actions");
		//BasicConfigurator.configure(); 
		
		
		//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		//		Actions actions=new Actions(driver);
		//		WebElement e1=driver.findElement(By.id("draggable"));
		//		WebElement e2=driver.findElement(By.id("droppable"));
		////		actions.dragAndDrop(e1, e2).build().perform();
		//		actions.clickAndHold(e1).release(e2).build().perform();
		//		//actions.dragAndDropBy(e1, e2.getLocation().x, e2.getLocation().y).build().perform();
		//		
		//		
		//		WebElement e3=driver.findElement(By.name("dblClick"));
		//		actions.doubleClick(e3).build().perform();
		//		Thread.sleep(5000);
		//		wait.until(ExpectedConditions.alertIsPresent());
		//		System.out.println(driver.switchTo().alert().getText());
		//		driver.switchTo().alert().accept();
		//		Thread.sleep(5000);
		//		WebElement e4=driver.findElement(By.id("div2"));
		//		actions.moveByOffset(100, 500).build().perform();
		//		actions.moveToElement(e4).build().perform();
		//		Thread.sleep(5000);
		//		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		//		WebElement button=driver.findElement(By.xpath("//span[text()='right click me']"));
		//		actions.contextClick(button).build().perform();
		//		//driver.findElement(By.xpath("//span[text()='Paste']")).click();
		//		driver.navigate().to("http://www.uitestpractice.com/Students/Form");
		//		By emailLocator = RelativeLocator.with(By.tagName("h1")).below(By.tagName("input"));;
		//		driver.findElement(emailLocator).sendKeys("test");
		//driver.quit();

	}
	
	
	@Test
	public void loginTest() throws IOException {
		Logger logger=Logger.getLogger(this.getClass()+"loginTest");
		String a=System.getProperty("java.class.path");
		PropertyConfigurator.configure("log4j.properties");
		System.out.println(a);
		Logging.debug("testing with debug message");
		Logging.info("we are in logger info mode");
		Logging.warn("Hello.. im in Warn method");
		Logging.error("Hello.. im in Error method");
		Logging.fatal("Hello.. im in Fatal method");
		RemoteWebDriver driver=(RemoteWebDriver)BrowserUtility.getDriver();
		WebActions.openUrl(driver, "https://www.facebook.com");
		FbLoginPage loginPage=new FbLoginPage(driver);
		loginPage.login("lksjfldf@lksjfljdf.com", "sffslsjfls");
		boolean flag=loginPage.isErrorMessageInvalidLoginExist();
		Assert.assertEquals(flag, true,"Verify invalid loing error message");
		WebActions.takeScreenshot(driver, "target/errorPage.png");
		WebActions.closeBrowser(driver);
		
	}
	
	
	@Test
	public void loginTest2() throws IOException {
//		Logger logger=Logger.getLogger(this.getClass()+"loginTest2");
//		String a=System.getProperty("java.class.path");
//		PropertyConfigurator.configure("log4j.properties");
//		System.out.println(a);
		Logging.debug("testing with debug message");
		Logging.info("we are in logger info mode");
		Logging.warn("Hello.. im in Warn method");
		Logging.error("Hello.. im in Error method");
		Logging.fatal("Hello.. im in Fatal method");
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
