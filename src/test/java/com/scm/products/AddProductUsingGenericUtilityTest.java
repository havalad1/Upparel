package com.scm.products;


import java.io.IOException;
import java.util.List;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import com.scm.genericUtilities.BrowserAndApplicationLaunch;
import com.scm.genericUtilities.ExcelFetchUtility;
import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.LoginPage;
import com.scm.pageObjectModel.addProductPage;


public class AddProductUsingGenericUtilityTest 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		PropertyFileFetchUtility pfu=new PropertyFileFetchUtility();
		ExcelFetchUtility efu=new ExcelFetchUtility();
		BrowserAndApplicationLaunch bal=new BrowserAndApplicationLaunch();
		
		
		Random random=new Random();
		int rnum=random.nextInt(23);
		int price=random.nextInt(100);

		
		String url=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
		String username=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
		String password=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
		long timeout =Long.parseLong(pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
		String browser = pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");

		
		String expectedProname =efu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "product_addproducts", 1, 1)+""+rnum+"";
		
		WebDriver driver = bal.launch(browser, url, timeout);

		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUsername(username);
		loginPage.getPassword(password);
		WebElement admin = driver.findElement(By.id("login:type"));
		Select s1=new Select(admin);
		s1.selectByVisibleText("Admin");

		//click on login
		loginPage.getLoginbutton();

		addProductPage app=new addProductPage(driver);

		//click on addproduct
		app.getAddproductsbutton();

		//product name
		app.getProductnametextbox(expectedProname);

		//product price
		app.getProductpricetextbox(price);

		//unit type dd
		WebElement unitdd = driver.findElement(By.id("product:unit"));
		WebDriverUtility wdu=new WebDriverUtility();
		Select s2 = wdu.SelectMethod(unitdd);
		s2.selectByValue("2");

		//category dropdown
		WebElement categorydd = driver.findElement(By.id("product:category"));
		Select s3 = wdu.SelectMethod(categorydd);
		s3.selectByValue("3");

		//click on enable radio button
		app.getEnableradiobutton();


		app.getProductdescriptiontextbox(expectedProname);

		//click on addproduct
		app.getAddproductbutton();

		driver.switchTo().alert().accept();
		
		//click on addproduct
		driver.findElement(By.linkText("Products")).click();
		Thread.sleep(3000);
		
		//verify
		List<WebElement> actualpronameList = driver.findElements(By.xpath("//section/form/table/tbody/tr/td[3]"));
		System.out.println("expectedName= "+expectedProname);
		boolean flag=false;
		for(int i=0;i<actualpronameList.size();i++)
		{
			String actualName=actualpronameList.get(i).getText();
			if(actualName.equals(expectedProname)) 
			{
			//System.out.println("Actualname= "+actualName);
			//System.out.println("product added successfully");
			flag=true;
			break;
			}
		}
		
		if(flag==false)
			{
				System.out.println("product not added ");
			}
			else
			{
				System.out.println("product added");
			}
		
		driver.quit();	
	}
}
