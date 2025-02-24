package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class Hooks extends Base {

//	WebDriver driver;
//	Properties p;
	
	@Before
	public void setup() throws IOException
	{
//	driver=Base.initilizeBrowser();
//	p=Base.getProperties();
	initilizeBrowser();
	getProperties();
	driver.get(p.getProperty("appURL"));
	driver.manage().window().maximize();
	}
	
	@AfterStep
	public void attachScreenShot(Scenario scenario)
	{
	String scenarioName = scenario.getName();
	scenario.attach(takeScreenshot(), "image/png", scenarioName);
		
	}
	
	@After
	public void teardown()
	{
	driver.quit();
	}
}
