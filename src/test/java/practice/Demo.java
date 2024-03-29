package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.beust.jcommander.Strings;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo 
{
	public static void main(Strings[]args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try 
		{
		driver.get("https://www.google.com");
		Assert.fail();
		}
		finally 
		{
			driver.quit();
		}
	}
}
