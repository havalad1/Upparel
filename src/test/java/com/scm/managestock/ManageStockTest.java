package com.scm.managestock;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;
import com.scm.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageStockTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		//Random r=new Random();
		//int expectedqty=r.nextInt(100);
		WebDriverUtility wdu=new WebDriverUtility();
		int expectedqty = wdu.randomNumberWithBound(100);
		
		//Properties p=new Properties();
		//FileInputStream fis=new FileInputStream("src/test/resources/scmcommondata.properties");
		//p.load(fis);
		PropertyFileFetchUtility pfu=new PropertyFileFetchUtility();
		String url = pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
		String username = pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
		String password = pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
		long timeout = Long.parseLong(pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriver driver = wdu.launch("chrome", url, timeout);
		driver.findElement(By.id("login:username")).sendKeys(username);
		driver.findElement(By.id("login:password")).sendKeys(password);
		
		
		WebElement path = driver.findElement(By.id("login:type"));
		//Select s=new Select(path);
		//s.selectByValue("manufacturer");
		Select s = wdu.SelectMethod(path);
		s.selectByValue("manufacturer");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//manastock click
		driver.findElement(By.xpath("//a[text()='Manage Stock']")).click();
		
		driver.findElement(By.name("txtQuantity[17]")).clear();
		
		WebElement cake21 = driver.findElement(By.xpath("//tr/td[.='cake21']"));
		Point loc = cake21.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy("+x+","+y+")");
				
		//wdu.scrollBar(x, y);
		//cake21.clear();
		//cake21.sendKeys(""+expectedqty+"");
		driver.findElement(By.id("btnSubmit")).click();
		//driver.switchTo().alert().accept();
		
		String actualqty =driver.findElement(By.xpath("//input[@type='text' and @name='txtQuantity[50]']")).getAttribute("value");
		
		if(actualqty.equals(""+expectedqty+"")) {
			System.out.println("quantity added successfully");
		}
		else {
			System.out.println("quantity not added");
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
