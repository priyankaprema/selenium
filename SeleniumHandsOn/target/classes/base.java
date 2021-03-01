package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pageobjects.OrangeHRMLoginObjects;

public class base {

	public WebDriver driver;
	public Properties property;

	public WebDriver selectDriver() throws IOException
	{
		property=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\priya\\eclipse-workspace\\SeleniumHandsOn\\src\\main\\java\\resources\\data.properties");
		property.load(fis);
		String browserName = property.getProperty("browser");

		if(browserName.equals("Chrome")) //Chrome driver
		{
			System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}

		else if(browserName.equals("firefox"))  //Firefox driver
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Desktop\\Selenium Files\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))  // IE driver
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Desktop\\Selenium Files\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			//some other default drivers (if any)
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void loginOperation()    //Perform Login operation
	{
		driver.get(property.getProperty("OrangeHRMURL"));
		driver.manage().window().maximize();
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		OrangeHRMLoginObjects loginObj=new OrangeHRMLoginObjects(driver);
		loginObj.getUsername().sendKeys(username);
		loginObj.getPassword().sendKeys(password);
		loginObj.getButtonClick().click();
	}


}
