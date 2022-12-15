package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Executions_2 
{
	@Test
	public void tc0()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		System.out.println("this is tc");
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		driver.quit();
	}

	@Test
	public void tc1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		System.out.println("this is tc1");
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		driver.quit();
	}
	
	@Test
	public void tc2()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		System.out.println("this is tc2");
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		driver.quit();
	}
}
