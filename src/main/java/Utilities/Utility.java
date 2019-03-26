package Utilities;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import common.GetBrowser;


public class Utility 
{
	public static WebDriver driver =null;
	
	public static String userName;
	public static String pwd;
	public static String TMail;
	
	
	@Parameters({"browser","url","uName", "password","ToMail"})
	@BeforeSuite(alwaysRun=true)  
	public void setUp(@Optional("chrome")String browser, @Optional("https://www.gmail.com/") String url, @Optional("test@test.com") String uName,@Optional("test123") String password,@Optional("ToMail")  String ToMail)
	{
		userName = uName;
		pwd = password;
		TMail= ToMail;
		
		if(StringUtils.equals(browser, "firefox"))
		{				
			System.setProperty("webdriver.gecko.driver",".\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver =GetBrowser.getFirefoxDriver();
		}
		else if(StringUtils.equals(browser, "chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver= GetBrowser.getChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);// URL will be fatch from testng.xml and if not provide in testng.xml then it will take @optional value
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		preConditions();
	}
	
	public void preConditions () {

	}
	
	public void postConditions() {

	}
	public static int randInt() {
		return new Random().nextInt((1000 - 1) + 1) + 1;
	}
	
	// Create common wait function for visibility of an elements
	public void waifForElementPresent(WebElement element, long waitTime )
	{
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// Create common wait function for elements to be clickable
	public void waifForElementClickable(WebElement element, long waitTime )
	{
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	// This will run after test suite to close the browser.
	@AfterSuite(alwaysRun=true)
	public void shutDown()
	{
		postConditions();
		driver.quit();
	}

}
