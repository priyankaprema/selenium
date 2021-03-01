package orangeHRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.AdminTabNavigation;
import pageobjects.DeleteUserObjects;
import resources.base;

public class DeleteUser extends base{

	public WebDriver driver;

	@BeforeTest
	public void initiateDriver() throws IOException
	{
		driver=selectDriver();
	}
	
	@Test
	public void deleteUser()
	{
		loginOperation();
		AdminTabNavigation adminObj=new AdminTabNavigation(driver);
		adminObj.getDropdown().click();
		adminObj.getUserManagement().click();
		adminObj.getUsers().click();
		DeleteUserObjects deleteUserObject=new DeleteUserObjects(driver);
		Actions action=new Actions(driver);
		action.moveToElement(deleteUserObject.getDeleteRecords()).build().perform();
		deleteUserObject.getDeleteRecords().click();
		deleteUserObject.getDeleteButton().click();
		deleteUserObject.getdialogDeleteButton();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
