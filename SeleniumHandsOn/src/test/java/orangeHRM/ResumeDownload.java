package orangeHRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.ResumeDownloadObjects;
import resources.base;

public class ResumeDownload extends base {

	public WebDriver driver;
	private static Logger log=LogManager.getLogger(DeleteUser.class.getName());
	@BeforeTest
	public void initiateDriver() throws IOException
	{
		driver=selectDriver();
	}
	
	@Test
	public void resumeDownload()
	{
		log.info("resume download");
		loginOperation();
		ResumeDownloadObjects resume=new ResumeDownloadObjects(driver);
		resume.getrecruitmentMenu().click();
		resume.getcandidate().click();
		resume.getjobRole();
		resume.getsearchBtn().click();
		Actions action=new Actions(driver);
		action.moveToElement(resume.getresumeDownload()).build().perform();
		resume.getresumeDownload().click();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
