package com.scm.products;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		Random random=new Random();
		int rnum=random.nextInt(23);
		int price=random.nextInt(100);
		
		FileInputStream fis=new FileInputStream("./src/test/resources/scmcommondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url").trim();;
		String username = p.getProperty("username").trim();;
		String password = p.getProperty("password").trim();;
		long timeout = Long.parseLong(p.getProperty("timeout").trim());
		
		
		FileInputStream fis2=new FileInputStream("./src/test/resources/scmtestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String expectedProname =(wb.getSheet("product_addproducts").getRow(1).getCell(1).getStringCellValue())+""+rnum+"";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.id("login:password")).sendKeys(password);
		WebElement admin = driver.findElement(By.id("login:type"));
		Select s1=new Select(admin);
		s1.selectByVisibleText("Admin");
		
		//click on login
		driver.findElement(By.xpath("//span[@class='error_message']/preceding-sibling::input[@type='submit']")).click();
		
		//click on addproduct
		driver.findElement(By.linkText("Add Products")).click();
		
		//product name
		//String expectedProname="cake_"+""+rnum+"";
		driver.findElement(By.id("product:name")).sendKeys(expectedProname);
		
		//product price
		driver.findElement(By.id("product:price")).sendKeys(""+price+"");
		
		//unit type dd
		WebElement unitdd = driver.findElement(By.id("product:unit"));
		Select s2=new Select(unitdd);
		s2.selectByValue("2");
		
		//category dropdown
		WebElement categorydd = driver.findElement(By.id("product:category"));
		Select s3=new Select(categorydd);
		s3.selectByValue("3");
		
		//click on enable radio button
		driver.findElement(By.xpath("//div[@class='label-block']/following-sibling::input[1]")).click();
		
		//product description
		driver.findElement(By.id("product:description")).sendKeys(expectedProname);
		driver.findElement(By.xpath("//input[@value='Add Product']")).click();
		driver.switchTo().alert().accept();
		
		//click on addproduct
		driver.findElement(By.linkText("Products")).click();
		
		//verify
		String actualproname = driver.findElement(By.xpath("//th[text()=' Name ']/../../descendant::td[3]")).getText();
		if(actualproname.equals(expectedProname)) {
			System.out.println("product added successfully");
			wb.getSheet("product_addproducts").getRow(1).createCell(4).setCellValue("pass");
			FileOutputStream fos=new FileOutputStream("./src/test/resources/scmtestdata.xlsx");
			wb.write(fos);
		}
		else {
			System.out.println("prodcut not added");
		}
		
		driver.quit();
	}
}
