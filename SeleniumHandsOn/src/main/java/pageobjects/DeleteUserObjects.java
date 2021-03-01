package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteUserObjects {
	public WebDriver driver;
	
	By deleteRecords=By.id("ohrmList_chkSelectAll");
	By deleteButton=By.id("btnDelete");
	By dialogDeleteButton=By.id("dialogDeleteBtn");
	public DeleteUserObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getDeleteRecords()
	{
		return driver.findElement(deleteRecords);
	}
	
	public WebElement getDeleteButton()
	{
		return driver.findElement(deleteButton);
	}
	public WebElement getdialogDeleteButton()
	{
		return driver.findElement(dialogDeleteButton);
	}
}
