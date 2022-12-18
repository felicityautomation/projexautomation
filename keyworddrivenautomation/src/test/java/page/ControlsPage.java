package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ControlsPage {
	WebDriver driver;
	By name=By.id("firstname");
	
	public ControlsPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	public void setFirstName(String firstName) {
		driver.findElement(name).sendKeys("FirstName");
	}
	
	public void setLastName() {
		
	}

}
