package com.scm.orders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.scm.genericUtilities.BrowserAndApplicationLaunch;
import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.LoginPage;
import com.scm.pageObjectModel.OrdersPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orders_sortingIdTest 
{
public static void main(String[] args) throws InterruptedException, IOException 
{
	//Properties p=new Properties();
	//FileInputStream fis=new FileInputStream("src/test/resources/scmcommondata.properties");
	//p.load(fis);
	//String url = p.getProperty("url");
	//String username = p.getProperty("username");
	//String password = p.getProperty("password");
	PropertyFileFetchUtility pfu=new PropertyFileFetchUtility();
	String url=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
	String username=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
	String password=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
	String browser=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");
	long timeout=Long.parseLong(pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
	
	Random random=new Random();
	int ranid=random.nextInt(23);
	System.out.println(ranid);
	
	//WebDriverManager.chromedriver().setup();
	//WebDriver driver=new ChromeDriver();
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.get(url);
	BrowserAndApplicationLaunch bal=new BrowserAndApplicationLaunch();
	WebDriver driver = bal.launch(browser, url, timeout);
	
	LoginPage loginPage=new LoginPage(driver);
	//driver.findElement(By.name("txtUsername")).sendKeys(username);
	//driver.findElement(By.id("login:password")).sendKeys(password);
	loginPage.getUsername(username);
	loginPage.getPassword(password);
	
	//WebElement admin = driver.findElement(By.id("login:type"));
	WebElement logintype = loginPage.getLoginTypedd();
	//Select s=new Select(admin);
	//s.selectByVisibleText("Admin");
	WebDriverUtility wdu=new WebDriverUtility();
	Select s1 = wdu.SelectMethod(logintype);
	s1.selectByValue("admin");
	
	//click login button
	//driver.findElement(By.xpath("//span[@class='error_message']/preceding-sibling::input[@type='submit']")).click();
	loginPage.getLoginbutton();
	
	//click on orders button
	//driver.findElement(By.linkText("Orders")).click();
	OrdersPage ordersPage=new OrdersPage(driver);
	ordersPage.getOrdersButton();
	
	//searchby dropdown
	WebElement idnum = driver.findElement(By.xpath("//div[@class='input-box']/descendant::select[@name='cmbFilter' and @id='cmbFilter']"));
	//Select s2=new Select(idnum);
	//s2.selectByValue("id");
	Select s2=wdu.SelectMethod(idnum);
	s2.selectByValue("id");
	
	//send id number to search
	//driver.findElement(By.xpath("//div[@class='input-box']/input")).sendKeys(""+ranid+"");
	
	ordersPage.getRanidtextBox(ranid);
	Thread.sleep(3000);
	
	//click on search
	//driver.findElement(By.xpath("//span[@class='error_message']/preceding-sibling::input[@type='submit']")).click();
	ordersPage.getClicksearchButton();
	
	String actualid = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
	if(actualid.equals(""+ranid+"")) {
		System.out.println("successfully sorted using id");
	}
	else {
		System.out.println("not sorted accordingly");
	}
	Thread.sleep(3000);
	driver.quit();
}
}
