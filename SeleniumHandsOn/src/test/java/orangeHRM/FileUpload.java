package orangeHRM;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.PIMObjects;
import resources.base;

public class FileUpload extends base {

	public WebDriver driver;

	@BeforeTest
	public void initiateDriver() throws IOException
	{
		driver=selectDriver();
	}

	@Test
	public void fileUpload()
	{
		loginOperation();
		PIMObjects pim=new PIMObjects(driver);
		pim.getpimDropdown().click();
		pim.getconfigMenu().click();
		Actions dataImportClick=new Actions(driver);
		dataImportClick.moveToElement(pim.getdataImport()).build().perform();
		pim.getdataImport().click();
		pim.getchooseFileButton().sendKeys(property.getProperty("dataImportPath"));
		pim.getuploadButton().click();
	} 
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
