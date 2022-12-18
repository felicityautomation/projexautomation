package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {
	
	public static WebDriver getDriver(String browser) {
		WebDriver driver=null;
		if(browser==null) {
			//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("remote")){
			//Define the logic to run the tests on the Grid
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver getDriver() {
		String browser=System.getProperty("browser");
		System.out.println("Browser value passed from the command-line:="+browser);
		return getDriver(browser);
	}

}
