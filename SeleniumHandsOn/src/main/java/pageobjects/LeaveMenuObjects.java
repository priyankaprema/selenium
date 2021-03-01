package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeaveMenuObjects {

	public WebDriver driver;
	
	By leaveOption=By.id("menu_leave_viewLeaveModule");
	By configLeave=By.id("menu_leave_Configure");
	By holidayOption=By.id("menu_leave_viewHolidayList");
	By calenderFromDate=By.id("calFromDate");
    By fromMonth=By.cssSelector("Select.ui-datepicker-month");
    By fromYear=By.cssSelector("Select.ui-datepicker-year");
    By fromDate=By.cssSelector("a.ui-state-default");
    
    By calenderToDate=By.id("calToDate");
    By toMonth=By.cssSelector("Select.ui-datepicker-month");
    By toYear=By.cssSelector("Select.ui-datepicker-year");
    By toDate=By.cssSelector("a.ui-state-default");
    
    By searchBtn=By.id("btnSearch");
    By results=By.xpath("//table[@id='resultTable']//tbody//tr");
    
	public LeaveMenuObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getleaveOption()
	{
		return driver.findElement(leaveOption);
	}
	public WebElement getconfigLeave()
	{
		return driver.findElement(configLeave);
	}
	public WebElement getholidayOption()
	{
		return driver.findElement(holidayOption);
	}
	public WebElement getcalenderFromDate()
	{
		return driver.findElement(calenderFromDate);
	}
	public void getfromMonth()
	{
		Select month=new Select(driver.findElement(fromMonth));
		month.selectByVisibleText("Nov");
	}
	public void getfromYear()
	{
		Select year=new Select(driver.findElement(fromYear));
		year.selectByVisibleText("2019");
	}
	public void getfromDate()
	{
		List<WebElement> fromDateList=driver.findElements(fromDate);
	    for(int i=0;i<fromDateList.size();i++)
	    {
	    	if(fromDateList.get(i).getText().equals("17"))
	    	{
	    		fromDateList.get(i).click();
	    		break;
	    	}
	    }
    
	}
	public WebElement getCalenderToDate()
	{
		return driver.findElement(calenderToDate);
	}
	public void getToMonth()
	{
		Select month=new Select(driver.findElement(toMonth));
		month.selectByVisibleText("Feb");
	}
	
	public void getToYear()
	{
		Select year=new Select(driver.findElement(toYear));
		year.selectByVisibleText("2020");
	}
	public void getToDate()
	{
		List<WebElement> fromDateList=driver.findElements(toDate);
	    for(int i=0;i<fromDateList.size();i++)
	    {
	    	if(fromDateList.get(i).getText().equals("20"))
	    	{
	    		fromDateList.get(i).click();
	    		break;
	    	}
	    }
    
	}
	public WebElement getSearchBtn()
	{
		return driver.findElement(searchBtn);
	}
	
	public int getResults()
	{
		List<WebElement> resutSize=driver.findElements(results);
		return resutSize.size();
	}
	
}
