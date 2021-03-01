package orangeHRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.AdminTabNavigation;
import resources.base;

public class UserCount extends base{
	private static Logger log=LogManager.getLogger(DeleteUser.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initiateDriver() throws IOException
	{
		driver=selectDriver();
	}

	@Test
	public void userEnabledStatusCount()  //get the count of users with status 'Enabled' under Admin tab
	{

		log.info("userEnabled count");
		AdminTabNavigation adminObj=new AdminTabNavigation(driver);
		loginOperation();
		adminObj.getDropdown().click();
		adminObj.getUserManagement().click();
		adminObj.getUsers().click();
		adminObj.getUserRoleDropdown();
		adminObj.getStatusDropdown();
		adminObj.getNameButton().click();
		adminObj.getCountOfUsers(); // it will get the count of users with enabled status
	}

	@AfterClass
	public void tearDown()
	{
		driver.close();
	}



}
