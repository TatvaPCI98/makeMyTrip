package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetBrowser {

	 private static FirefoxDriver fireFox = null;
	 private static ChromeDriver chrome = null;
	 
	  public static FirefoxDriver getFirefoxDriver() {
	      if(fireFox == null) {
	    	  
	    	  fireFox=new FirefoxDriver();
	      }
	      return fireFox;
	   }	  
	  public static ChromeDriver getChromeDriver() {
		  
	      if(chrome == null) {
	    	  ChromeOptions options = new ChromeOptions();
	  		options.addArguments("--disable-notifications");
	    	  chrome = new ChromeDriver(options);
	      }
	      return chrome;
	   }
	  
	  
}
