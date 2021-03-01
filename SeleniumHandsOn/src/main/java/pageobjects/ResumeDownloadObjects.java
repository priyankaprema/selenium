package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ResumeDownloadObjects {

	public WebDriver driver;
	
	By recruitmentMenu=By.id("menu_recruitment_viewRecruitmentModule");
	By candidate=By.id("menu_recruitment_viewCandidates");
	By jobRole=By.id("candidateSearch_jobTitle");
	By searchBtn=By.id("btnSrch");
	By resumeDownload=By.xpath("//a[contains(@href,'viewCandidateAttachment?')]");
	
	public ResumeDownloadObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getrecruitmentMenu()
	{
		return driver.findElement(recruitmentMenu);
	}
	public WebElement getcandidate()
	{
		return driver.findElement(candidate);
	}
	public void getjobRole()
	{
		Select roleDropdown=new Select(driver.findElement(jobRole));
		roleDropdown.selectByVisibleText("Software Engineer");
	}
	public WebElement getsearchBtn()
	{
		return driver.findElement(searchBtn);
	}
	public WebElement getresumeDownload()
	{
		return driver.findElement(resumeDownload);
	}
}
