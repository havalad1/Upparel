package com.scm.password;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangePasswordTest {
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/projectdata.properties");
			Properties p=new Properties();
			p.load(fis);
			String url= p.getProperty("url");
			String userName= p.getProperty("username");
			String password= p.getProperty("password");
			
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("login:username")).sendKeys(userName);
		driver.findElement(By.id("login:password")).sendKeys(password);
		WebElement path = driver.findElement(By.id("login:type"));
		Select s=new Select(path);
		s.selectByValue("manufacturer");
		driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		driver.findElement(By.xpath("//a[text()='Edit Profile']")).click();
		driver.findElement(By.xpath("//input[@value='Change Password']")).click();
		driver.findElement(By.id("oldPassword")).sendKeys("admin1234");
		driver.findElement(By.id("newPassword")).sendKeys("admin123");
		driver.findElement(By.id("confirmPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@value='Change Password']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@value='Log out']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
