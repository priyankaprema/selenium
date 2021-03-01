package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIMObjects {

	public WebDriver driver;
	
	By pimDropdown=By.id("menu_pim_viewPimModule");
	By configMenu=By.id("menu_pim_Configuration");
	By dataImport=By.id("menu_admin_pimCsvImport");
	By chooseFileButton=By.id("pimCsvImport_csvFile");
	By uploadButton=By.id("btnSave");
	
	public PIMObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getpimDropdown()
	{
		return driver.findElement(pimDropdown);
	}
	
	public WebElement getconfigMenu()
	{
		return driver.findElement(configMenu);
	}
	
	public WebElement getdataImport()
	{
		return driver.findElement(dataImport);
	}
	
	public WebElement getchooseFileButton()
	{
		return driver.findElement(chooseFileButton);
	}
	
	public WebElement getuploadButton()
	{
		return driver.findElement(uploadButton);
	}
}
