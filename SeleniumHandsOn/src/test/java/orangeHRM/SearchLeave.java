package orangeHRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.LeaveMenuObjects;
import resources.base;

public class SearchLeave extends base
{
	private static Logger log=LogManager.getLogger(DeleteUser.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initiateDriver() throws IOException
	{
		driver=selectDriver();
	}
	
	@Test
	public void selectLeave()
	{
		log.info("SearchLeave");
		loginOperation();
		LeaveMenuObjects leave=new LeaveMenuObjects(driver);
		leave.getleaveOption().click();
		leave.getconfigLeave().click();
		Actions action=new Actions(driver);
		action.moveToElement(leave.getholidayOption()).build().perform();
		leave.getholidayOption().click();
		leave.getcalenderFromDate().click();
		leave.getfromMonth();
		leave.getfromYear();
		leave.getfromDate();
		leave.getCalenderToDate().click();
		leave.getToMonth();
		leave.getToYear();
		leave.getToDate();
		leave.getSearchBtn();
		leave.getResults();
		
		if(leave.getResults()>0)
    	{
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		Assert.assertTrue(false);
    	}
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
