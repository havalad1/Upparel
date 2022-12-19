package com.scm.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * this class used to define methods which are common for many test scripts
 */
public class WebDriverUtility 
{
	WebDriver driver;
	Actions a;
	Select s;
	
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
	
	/**
	 * this method is used to wait untill visibility of element
	 * @param to
	 * @param ele
	 */
	public void ExpliciteVisibilityWaitClass(long to,WebElement ele)
	{
		WebDriverWait wdw=new WebDriverWait(driver, to);
		wdw.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void customWait(WebElement element) {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
				count++;
			}
		}
	}
	
	/**
	 * this method used to take screenshot and return path of screenshot
	 * @param testCaseName
	 */
	public void takescreenshot(String testCaseName)
	{
		String fileName=testCaseName+"_"+new JavaUtility().getDateTime();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./photo/"+fileName+".png");
		try {
			Files.copy(src, dst);
		} catch (IOException e) {
		}
		//return dst.getAbsolutePath();
	}
	
	/**
	 * this method is used to wait untill invisibility of element
	 * @param to
	 * @param ele
	 */
	public void ExpliciteInvisibilityWaitClass(long to,WebElement ele)
	{
		WebDriverWait wdw=new WebDriverWait(driver, to);
		wdw.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	/**
	 * this method used to select and deselect element from dropdown
	 * @param ele
	 * @return
	 */
	public Select SelectMethod(WebElement ele)
	{
		s=new Select(ele);
		return s;
	}
	
	/**
	 * this method used to double click on element
	 */
	public void dblClick()
	{
		a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * this method used to right click on element
	 */
	public void rightClick()
	{ 
		a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * this method used to drag and drop an element
	 * @param src
	 * @param dest
	 */
	public void dragandDrop(WebElement src,WebElement dest)
	{
		a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	
	/**
	 * this method used to mousehover on an element
	 * @param ele
	 */
	public void moveToElement(WebElement ele)
	{
		a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	/**
	 * this method used to scroll up and down in the webpage
	 * @param x
	 * @param y
	 */
	public void scrollBar(int x,int y)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("\"window.scrollBy("+x+","+y+")");
	}
	
	/**
	 * this method used to take screenshot
	 * @param target
	 * @param path
	 */
	public void screenShot(WebElement target,String path)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		}
	}
	
	/*
	 * this method used to accept alert popup
	 */
	public void alertPopUpAccept(WebDriver driver )
	{
		//this.driver=driver;
		driver.switchTo().alert().accept();
	}
	

	/**
	 * this method used to dismiss alert popup
	 */
	public void alertPopUpDismiss(WebDriver driver)
	{
		this.driver=driver;
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method used to generate random number within given bound
	 * @param bound
	 * @return
	 */
	public int randomNumberWithBound(int bound)
	{
		Random r=new Random();
		int z=r.nextInt(bound);
		return z;
	}
}
