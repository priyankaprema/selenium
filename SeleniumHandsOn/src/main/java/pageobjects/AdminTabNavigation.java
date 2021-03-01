package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminTabNavigation 
{
	public WebDriver driver;

	By dropdown=By.id("menu_admin_viewAdminModule");
	By userManagement=By.id("menu_admin_UserManagement");
	By users=By.id("menu_admin_viewSystemUsers");
	By userRoleDropdown=By.id("searchSystemUser_userType");
	By statusDropdown=By.id("searchSystemUser_status");
	By nameButton=By.name("_search");
	By countOfUsers=By.xpath("//table[@id='resultTable']//tbody//tr");
	
	public AdminTabNavigation(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement getDropdown()
	{
		return driver.findElement(dropdown);
	}

	public WebElement getUserManagement()
	{
		return driver.findElement(userManagement);
	}

	public WebElement getUsers()
	{
		return driver.findElement(users);
	}
	
	public void getUserRoleDropdown()
	{
		Select drop1=new Select(driver.findElement(userRoleDropdown));
		drop1.selectByVisibleText("Admin");
	}
	public void getStatusDropdown()
	{
		Select drop=new Select(driver.findElement(statusDropdown));
		drop.selectByValue("1");
		
	}
	
	public WebElement getNameButton()
	{
		return driver.findElement(nameButton);
	}
	
	public int getCountOfUsers()
	{
		List<WebElement> count=driver.findElements(countOfUsers);
		return count.size();
	}
}
