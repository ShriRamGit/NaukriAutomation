package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProfilePageObj extends BaseClass{
	String msg;
	public ProfilePageObj(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath="//div[@class='view-profile-wrapper']/a")
	WebElement view_profile_button; 
	
	@FindBy(xpath="//*[@id=\"_nj1mrmev4Navbar\"]/div")	WebElement	chat_close;
	@FindBy(xpath="//div[contains(@class,\"quickLink \")]//span[contains(.,\"Career profile\")]")	WebElement	carrer_profile_link;
	@FindBy(xpath="//div[@id=\"lazyDesiredProfile\"]//span[contains(.,\"editOneTheme\")]")	WebElement	carrer_profile_edit;
	@FindBy(id="desiredProfileForm")	WebElement	carrer_profile_form;
	@FindBy(id="locationSugg")	WebElement	location_preference;
	@FindBy(xpath="//*[text()=\"Chennai\"]/i")	WebElement	location_add;
	@FindBy(id="saveDesiredProfile")	WebElement	cp_save_button;
	@FindBy(xpath="//div[@class=\"mod-date\"]/span[contains(.,\"Today\")]")	WebElement	last_profile_update_status;
	@FindBy(xpath="//*[@id=\"desiredProfileForm\"]//child::span[contains(.,\"Preferred work\")]")	WebElement location_label;
	
//	@FindBy(xpath="//a[text()='Update']")
	@FindBy(xpath="//input[@value='Update resume']")
	WebElement update_link;
	
	@FindBy(xpath="//div[contains(@class,\"resume-name\")]/div")
	WebElement resume_name;
	
	public void clickViewProfile()
	{
		view_profile_button.click();
		visibilityOfElement(update_link);	
	}
	public void clickUpdateLink() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(update_link).click().perform();
	}
	public void uploadResume() throws AWTException
	{
		
//		StringSelection ss = new StringSelection("C:\\Users\\rohin\\Downloads\\Shriram_Resume_QA.pdf");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		
//		Robot rb = new Robot();
//		rb.delay(2000);
//		rb.keyPress(KeyEvent.VK_ENTER);
//		rb.keyRelease(KeyEvent.VK_ENTER);
//		rb.keyPress(KeyEvent.VK_CONTROL);
//		rb.keyPress(KeyEvent.VK_V);
//		rb.keyRelease(KeyEvent.VK_CONTROL);
//		rb.keyRelease(KeyEvent.VK_V);
//		rb.keyPress(KeyEvent.VK_ENTER);
//		rb.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement uploadres = driver.findElement(By.xpath("//input[@value='Update resume']"));
		uploadres.sendKeys("C:\\Users\\rohin\\Downloads\\Shriram_Resume_QA.pdf");
	}
	public String validateResumeName()
	{
		String name=resume_name.getText();
		return name;
	}
	
	public void closeChat()
	{
		boolean res=chat_close.isDisplayed();
		
		if(res)
		chat_close.click();
	}
	public void clickCarrerProfile()
	{
		carrer_profile_link.click();
	}
	public void editCarrerProfile()
	{
		carrer_profile_edit.click();
	}
	public String verifyProfileUpdateStatus()
	{
		
	    msg=last_profile_update_status.getText();
		return msg;
	}
	public boolean verifyFormIsPresent()
	{
		boolean res=carrer_profile_form.isDisplayed();
		return res;
	}
	public void clickLocationLabel()
	{
		location_label.click();
		
	}
	public void clickForLocation()
	{
		location_preference.click();
	}
	public void clickcpSaveButton()
	{
		cp_save_button.click();
	}
	public void addLocation()
	{
		location_add.click();
	}
	public boolean isLocationSelected()
	{
		boolean isSelected=location_add.isSelected();
		return isSelected;
	}
	
	
}
