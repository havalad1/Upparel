package com.scm.genericUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class used to store method which is used to launch the browser and application
 * @author HP
 *
 */
public class  BrowserAndApplicationLaunch 
{
	WebDriver driver=null;
	
	/**
	 * this method used to launch browser and application
	 * @param value
	 * @param url
	 * @param to
	 * @return
	 */
	public WebDriver launch(String value, String url, long to) 
	{
		if(value.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(value.equals("internet explorer")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(to, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
	}
}
