package com.scm.Admin_manufacturerEditprofile;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.scm.genericUtilities.ExcelFetchUtility;
import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.EditManufacturerProfilePage;
import com.scm.pageObjectModel.LoginPage;

public class EditManufactureProfileTest {
	public static void main(String[] args) throws IOException, InterruptedException {


		ExcelFetchUtility ffeu=new ExcelFetchUtility();
		String name1 = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile",  1, 1);
		String email = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 2);
		String phone = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 3);
		String name2 = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 4);
		//String name =df.formatCellValue(w.getSheet("editprofile").getRow(1).getCell(1));
		//String email = df.formatCellValue(w.getSheet("editprofile").getRow(1).getCell(2));
		//String phone = df.formatCellValue(w.getSheet("editprofile").getRow(1).getCell(3));
		//String username = df.formatCellValue(w.getSheet("editprofile").getRow(1).getCell(4));

		PropertyFileFetchUtility pffu=new PropertyFileFetchUtility();
		String url = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
		String usersname = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
		String password = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
		long timeout = Long.parseLong(pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
		String browser = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");

		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get(p.getProperty("url"));
		WebDriverUtility wdu=new WebDriverUtility();
		WebDriver driver = wdu.launch(browser, url, timeout);

		//driver.findElement(By.id("login:username")).sendKeys(usersname);
		//driver.findElement(By.id("login:password")).sendKeys(password);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUsername(usersname);
		loginPage.getPassword(password);
		
		WebElement admin = loginPage.getLoginTypedd();
		//WebElement sel = driver.findElement(By.id("login:type"));
		//Select s=new Select(sel);
		//s.selectByValue("admin");
		Select s = wdu.SelectMethod(admin);
		s.selectByValue("admin");

		//login
		//driver.findElement(By.xpath("//input[@class='submit_button']")).click();
		loginPage.getLoginbutton();
		
		//click on manufacturers button
		//driver.findElement(By.linkText("Manufacturers")).click();
		EditManufacturerProfilePage editManufacturerProfilePage=new EditManufacturerProfilePage(driver);
		editManufacturerProfilePage.getManufacturersbutton();
		
		
		//click on edit
		//driver.findElement(By.xpath("//a[@href='edit_manufacturer.php?id=1']")).click();
		editManufacturerProfilePage.getClickeditbutton();
		
		//name
		String expectedname="Ankit Pandya";
		List<WebElement> nameList = driver.findElements(By.xpath("//th[.='Name']/../../tr/td[3]"));


		for(int i=0;i<nameList.size();i++)
		{

			String actualname=nameList.get(i).getText();
			System.out.println(actualname);
			if(actualname.equals(expectedname)) 
			{

				driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr["+(i+1)+"]/td[7]/a")).click();

				//WebElement el = driver.findElement(By.xpath("//input[@id='manufacturer:name' and @name='txtManufacturerName']"));
				//el.clear();
				//el.sendKeys(name);
				editManufacturerProfilePage.getManufacturerusernametextbox().clear();
				editManufacturerProfilePage.getManufacturerusernametextbox().sendKeys(name1);
				
				//driver.findElement(By.xpath("//input[@id='manufacturer:email' and @name='txtManufacturerEmail']")).clear();
				//driver.findElement(By.xpath("//input[@id='manufacturer:email' and @name='txtManufacturerEmail']")).sendKeys(email);
				editManufacturerProfilePage.getManufactureremailtextbox().clear();
				editManufacturerProfilePage.getManufactureremailtextbox().sendKeys(email);
				
				//driver.findElement(By.xpath("//input[@id='manufacturer:phone' and @name='txtManufacturerPhone']")).clear();
				//driver.findElement(By.xpath("//input[@id='manufacturer:phone' and @name='txtManufacturerPhone']")).sendKeys(phone);
				editManufacturerProfilePage.getManufacturerphonetextbox().clear();
				editManufacturerProfilePage.getManufacturerphonetextbox().sendKeys(phone);
				
				//driver.findElement(By.xpath("//input[@id='manufacturer:username' and @name='txtManufacturerUname']")).clear();
				//driver.findElement(By.xpath("//input[@id='manufacturer:username' and @name='txtManufacturerUname']")).sendKeys(username);
				editManufacturerProfilePage.getManufacturerusernametextbox().clear();
				editManufacturerProfilePage.getManufacturerusernametextbox().sendKeys(name2);
				
				//update manufacturer
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				driver.switchTo().alert().accept();
			}
		}
		driver.quit();
	}
}




