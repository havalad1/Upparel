package com.scm.Admin_manufacturerEditprofile;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.scm.genericUtilities.BrowserAndApplicationLaunch;
import com.scm.genericUtilities.ExcelFetchUtility;
import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;
import com.scm.genericUtilities.StartClass;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.EditManufacturerProfilePage;
import com.scm.pageObjectModel.LoginPage;

public class EditManufactureProfileUsingGenericUtilitiesTest
{
	public static void main(String[] args) throws InterruptedException 
	{
		ExcelFetchUtility ffeu=new ExcelFetchUtility();
		//String name1 = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile",  1, 1);
		String email = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 2);
		String phone = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 3);
		//String name2 = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 4);
		String name1 = RandomStringUtils.randomAlphabetic(10);
		String name2 = RandomStringUtils.randomAlphabetic(10);
		
		PropertyFileFetchUtility pffu=new PropertyFileFetchUtility();
		String url = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
		String usersname = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
		String password = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
		long timeout = Long.parseLong(pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
		String browser = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");

		BrowserAndApplicationLaunch bapl=new BrowserAndApplicationLaunch();
		WebDriver driver = bapl.launch(browser, url, timeout);

		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUsername(usersname);
		loginPage.getPassword(password);
		
		WebElement admin = loginPage.getLoginTypedd();
		WebDriverUtility wdu=new WebDriverUtility();
		Select s = wdu.SelectMethod(admin);
		s.selectByValue("admin");

		//login
		loginPage.getLoginbutton();
		
		//click on manufacturers button
		EditManufacturerProfilePage editManufacturerProfilePage=new EditManufacturerProfilePage(driver);
		editManufacturerProfilePage.getManufacturersbutton();
		
		//name
		String expectedname="dSRhHtsanM";
		List<WebElement> nameList = editManufacturerProfilePage.getnameList();
		boolean flag=false;
		for(int i=0;i<nameList.size();i++)
		{
			String actualname=nameList.get(i).getText();
			if(actualname.equals(expectedname)) 
			{
				System.out.println("Actual Name= "+actualname);
				
				//click on edit
				editManufacturerProfilePage.getStringToWebElement(driver,actualname);
				
				editManufacturerProfilePage.getManufacturernametextbox().clear();
				editManufacturerProfilePage.getManufacturernametextbox().sendKeys(name1);
				
				editManufacturerProfilePage.getManufactureremailtextbox().clear();
				editManufacturerProfilePage.getManufactureremailtextbox().sendKeys(email);
				
				editManufacturerProfilePage.getManufacturerphonetextbox().clear();
				editManufacturerProfilePage.getManufacturerphonetextbox().sendKeys(phone);
				
				editManufacturerProfilePage.getManufacturerusernametextbox().clear();
				editManufacturerProfilePage.getManufacturerusernametextbox().sendKeys(name2);
				
				//update manufacturer
				editManufacturerProfilePage.getupdateManufactureButton();
				wdu.alertPopUpAccept(driver);
				flag=true;
				break;
			}
		}
		
		if(flag==true)
		{
			System.out.println("edited successfully");
		}
		else
		{
			System.out.println("editing not successfull");
		}
		
		driver.quit();	
	}
}
