package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMLoginObjects {

	public WebDriver driver;
	By username=By.id("txtUsername");
	By password=By.id("txtPassword");
	By loginButton=By.id("btnLogin");
	
	public OrangeHRMLoginObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getButtonClick()
	{
		return driver.findElement(loginButton);
	}
}
