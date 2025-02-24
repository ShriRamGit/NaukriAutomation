package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	 public static WebDriver driver;
     public static Properties p;
  	     
public static WebDriver initilizeBrowser() throws IOException
{
	p = getProperties();
    String executionEnv = p.getProperty("execution_env");
    String browser = p.getProperty("browser").toLowerCase();
    String os = p.getProperty("os").toLowerCase();
	
	if(executionEnv.equalsIgnoreCase("remote"))
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//os
		 switch (os) {
         case "windows":
             capabilities.setPlatform(Platform.WINDOWS);
             break;
         case "mac":
             capabilities.setPlatform(Platform.MAC);
             break;
         case "linux":
             capabilities.setPlatform(Platform.LINUX);
             break;
         default:
             System.out.println("No matching OS");
             return null;
        }
		
		//browser
		 switch (browser) {
         case "chrome":
        	 ChromeOptions op=new ChromeOptions();// 3 lines to skip the session not created exception
        	 op.addArguments("--no-sandbox");
        	 op.addArguments("--disable-dev-shm-usage");
             capabilities.setBrowserName("chrome");
             break;
         case "edge":
        	 //WebDriverManager.edgedriver().setup();
             capabilities.setBrowserName("MicrosoftEdge");
             break;
         case "firefox":
             capabilities.setBrowserName("firefox");
             break;
         default:
             System.out.println("No matching browser");
             return null;
         }
       
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		
	}
	else if(executionEnv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase()) 
			{
			case "chrome":
				WebDriverManager.chromedriver().setup();
		        driver=new ChromeDriver();
		        break;
		    case "edge":
		    	WebDriverManager.edgedriver().setup(); //wbmanager installs the compatible version of browser with driver and runs
		    	driver=new EdgeDriver();
		        break;
		    case "firefox":
		    	WebDriverManager.firefoxdriver().setup();
		    	driver=new FirefoxDriver();
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
	 driver.manage().deleteAllCookies(); 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	 
	 return driver;
	 
}

public static WebDriver getDriver() {
		return driver;
	}

public void visibilityOfElement(WebElement element) {
	WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	driverWait.until(ExpectedConditions.visibilityOf(element));
}

public static Properties getProperties() throws IOException
{		 
    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
   	p=new Properties();
	p.load(file);
	return p;
}

public byte[] takeScreenshot()
{
	TakesScreenshot screenshot = (TakesScreenshot)driver;
	{
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
}
}
}
