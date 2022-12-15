package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Executions 
{
	
	@Parameters("browser")
	@Test
	public void test1(String browser)
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void test2(String browser)
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void test3(String browser)
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void test4(String browser)
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void test5(String browser)
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		System.out.println("this is test5");
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void test6(String browser)
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		System.out.println("this is test6");
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void test7(String browser)
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		System.out.println("this is test7");
		driver.quit();
	}
	
	@Parameters("browser")
	@Test
	public void test8(String browser)
	{
		WebDriver driver=null;
		if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.get("https://www.google.com");
		System.out.println("this is test8");
		driver.quit();
	}
}
