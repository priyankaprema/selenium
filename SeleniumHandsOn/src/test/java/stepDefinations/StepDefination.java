package stepDefinations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AdminTabNavigation;
import pageobjects.DeleteUserObjects;
import pageobjects.LeaveMenuObjects;
import pageobjects.PIMObjects;
import pageobjects.ResumeDownloadObjects;
import resources.base;

public class StepDefination extends base {

	public WebDriver driver;
	public PIMObjects pim;
	public ResumeDownloadObjects resume;
	public LeaveMenuObjects leave;
	public AdminTabNavigation adminObj;
	
	/*---------------Delete user Module------------------*/
	@Given("^usermanagement page with multiple users$")
	public void usermanagement_page_with_multiple_users() throws Throwable  
	{
		driver=selectDriver();
		loginOperation();
		AdminTabNavigation adminObj=new AdminTabNavigation(driver);
		adminObj.getDropdown().click();
		adminObj.getUserManagement().click();
		adminObj.getUsers().click();

	}

	@When("^user select to delete empoyee details$")
	public void user_select_to_delete_empoyee_details() throws Throwable 
	{
		DeleteUserObjects deleteUserObject=new DeleteUserObjects(driver);
		Actions action=new Actions(driver);
		action.moveToElement(deleteUserObject.getDeleteRecords()).build().perform();
		deleteUserObject.getDeleteRecords().click();
		deleteUserObject.getDeleteButton().click();
		deleteUserObject.getdialogDeleteButton();
	}

	@Then("^employee records should be deleted$")
	public void employee_records_should_be_deleted() throws Throwable 
	{
        driver.close();
	}
	
	@Given("^user is navigated to File Upload page$")	
    public void user_is_navigated_to_file_upload_page() throws Throwable 
	{
		
		driver=selectDriver();
		loginOperation();
		pim=new PIMObjects(driver);
		pim.getpimDropdown().click();
		pim.getconfigMenu().click();	
		
    }

    @When("^user upload the file$")
    public void user_upload_the_file() throws Throwable 
    {
		Actions dataImportClick=new Actions(driver);
		dataImportClick.moveToElement(pim.getdataImport()).build().perform();
		pim.getdataImport().click();
		pim.getchooseFileButton().sendKeys(property.getProperty("dataImportPath"));
		pim.getuploadButton().click();
    }

    @Then("^file upload successful message is displayed$")
    public void file_upload_successful_message_is_displayed() throws Throwable 
    {
    	driver.close();
    }
    
    /*------Resume Download Module------*/
    @Given("^user is in recruitment section$")
    public void user_is_in_recruitment_section() throws Throwable 
    {
    	driver=selectDriver();
    	loginOperation();
		resume=new ResumeDownloadObjects(driver);
		resume.getrecruitmentMenu().click();
		resume.getcandidate().click();
		
    }

    @When("^user select Job title$")
    public void user_select_job_title() throws Throwable 
    {
    	resume.getjobRole();
		resume.getsearchBtn().click();
    }

    @And("^clicks on download$")
    public void clicks_on_download() throws Throwable 
    {
    	Actions action=new Actions(driver);
		action.moveToElement(resume.getresumeDownload()).build().perform();
		resume.getresumeDownload().click();
    }

    @Then("^resume should get download$")
    public void resume_should_get_download() throws Throwable 
    {
       driver.close();
    }
    
    /*------Search Leave Module------*/
    @Given("^user is on search leave page$")
    public void user_is_on_search_leave_page() throws Throwable 
    {
    	driver=selectDriver();
    	loginOperation();
		leave=new LeaveMenuObjects(driver);
		leave.getleaveOption().click();
		leave.getconfigLeave().click();
		Actions action=new Actions(driver);
		action.moveToElement(leave.getholidayOption()).build().perform();
		leave.getholidayOption().click();
		
    }

    @When("^user enters From and To date$")
    public void user_enters_from_and_to_date() throws Throwable 
    {
    	leave.getcalenderFromDate().click();
		leave.getfromMonth();
		leave.getfromYear();
		leave.getfromDate();
		leave.getCalenderToDate().click();
		leave.getToMonth();
		leave.getToYear();
		leave.getToDate();
		
    }

    @Then("^all the leaves should be displayed in between selected date$")
    public void all_the_leaves_should_be_displayed_in_between_selected_date() throws Throwable 
    {
    	leave.getSearchBtn();
    	if(leave.getResults()>0)
    	{
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		Assert.assertTrue(false);
    	}
    	
    	driver.close();
    }

    /*------Get User Count Module------*/
    @Given("^user is in user management page$")
    public void user_is_in_user_management_page() throws Throwable 
    {
    	driver=selectDriver();
    	loginOperation();
    	adminObj=new AdminTabNavigation(driver);
		adminObj.getDropdown().click();
		adminObj.getUserManagement().click();
		adminObj.getUsers().click();
		
    }

    @When("^status is set to Enabled$")
    public void status_is_set_to_enabled() throws Throwable 
    {
    	adminObj.getUserRoleDropdown();
		adminObj.getStatusDropdown();
		adminObj.getNameButton().click();
    }

    @Then("^retrieve the count of users with status Enabled$")
    public void retrieve_the_count_of_users_with_status_enabled() throws Throwable 
    {
    	
		adminObj.getCountOfUsers();
		driver.close();
    }
    
}
