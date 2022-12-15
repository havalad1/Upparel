package com.scm.Admin_manufacturerEditprofile;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.StartClass;
import com.scm.pageObjectModel.EditManufacturerProfilePage;

public class EditManufactureProfileUsingStartClassTest extends StartClass
{
	@Test
	public void editmanuprof() throws InterruptedException 
	{
		//String name1 = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile",  1, 1);
		String email = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 2);
		String phone = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 3);
		//String name2 = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "editprofile", 1, 4);
		String name1 = RandomStringUtils.randomAlphabetic(10);
		String name2 = RandomStringUtils.randomAlphabetic(10);

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
		Assert.assertEquals(flag, true);	
	}
}
