package stepDefinitions;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObj;
import pageObjects.ProfilePageObj;

public class ProfileStepDef {
	
	WebDriver driver;
	LoginPageObj lp;
	ProfilePageObj pp;
	WebDriverWait wait=new WebDriverWait(Base.getDriver(),Duration.ofSeconds(15));
	
	@Given("user navigate to Naukri Application")
	public void i_navigate_to_naukri_application() {
		lp=new LoginPageObj(Base.getDriver());
		lp.selectLogin();
		
		
	}

	@Given("enter the user credentials {string} and {string}")
	public void enter_the_credentials(String uname , String pwd) {
		lp.enterCredentials(uname,pwd);
		lp.selectLoginButton();
	}
	@Given("user navigate to my profile")
	public void i_naviagte_to_my_profile() {
		pp=new ProfilePageObj(Base.getDriver());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("View")));
	    pp.clickViewProfile();
	    //pp.closeChat();
	}
	@Given("Click on carrer profile")
	public void click_on_carrer_profile() throws InterruptedException {
	    pp.clickCarrerProfile();
	    Thread.sleep(3000);
	    pp.editCarrerProfile();
	    boolean res=pp.verifyFormIsPresent();
	    assertTrue(res);
	}
	@When("user click on {string}, select\\/deslect a {string}")
	public void i_click_on_select_deslect_a(String string, String string2) throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationSugg")));
		Thread.sleep(4000);
		pp.clickForLocation();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Chennai']/i")));
	    boolean isSelected=pp.isLocationSelected();
	    if(isSelected)
	    {
	    	pp.addLocation();
	    	System.out.print("Added Chennai to location prefernce");
	    }
	    else
	    {
	    	pp.addLocation();
	    	System.out.print("Removed Chennai to location prefernce");
	    }
	    pp.clickLocationLabel();
	}
	@When("click on save button")
	public void clcik_on_save_button() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveDesiredProfile")));
		pp.clickcpSaveButton();
	}
	@Then("user should see profile updated as {string}")
	public void i_should_see_message(String exp_text) {
	    String msg=pp.verifyProfileUpdateStatus();
	    assertTrue(msg.contains(exp_text));
	}
	@When("Click on {string} in resume")
	public void click_on_in_resume(String string) throws InterruptedException {
	    pp.clickUpdateLink();
	}

	@When("user click on resume that has to be uploaded")
	public void i_click_on_resume_that_has_to_be_uploaded() throws AWTException {
	    pp.uploadResume();
	}

	@Then("Resume should be uploaded successfully")
	public void resume_should_br_uploaded_successfully() {
	    String name=pp.validateResumeName();
	    assertTrue(name.contains("Shriram_Resume_QA.pdf"));
	}   
	@And("Download the resume")
	public void resume_download() throws InterruptedException, IOException
	{
		pp.cleandownloadfolder();
		pp.downloadResume();
	}
	
	@Then("Verify if the resume is downloaded sucessfully")
	public void verifyDownload()
	{
		assertTrue(pp.verifyDownload());
	}
	@And("Verify if the downloaded resume contains {string} and {string}")
	public void verifydownloaded_file(String email , String mobno) throws IOException
	{
		pp.validateDownloadedPDF(email, mobno);
	}
	    
	}

