package com.scm.addRetailer;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.StartClass;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.AddRetailerPage;
import com.scm.pageObjectModel.HomePage;

public class AddRetailerTest extends StartClass {
	@Test
	public void createNewRetailer() throws InterruptedException {
		Random r = new Random();
		wdu = new WebDriverUtility();
		HomePage homePage = new HomePage(driver);
		AddRetailerPage addRetailerPage = new AddRetailerPage(driver);

		int rnum = r.nextInt(100);
		String un = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "retailer", 1, 0) + "" + rnum + "";
		String pw = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "retailer", 1, 1);
		String areacodevalue = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "retailer", 2, 2);
		long ph = r.nextInt(1000000000);
		String ph2 = "" + 9 + "" + "" + ph + "";
		String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
		System.out.println("Expected email: " + email);
		String address = RandomStringUtils.randomAlphabetic(10);

		homePage.clickretailerButton();
		addRetailerPage.retailerNmaeTextBoxmethod(un);
		addRetailerPage.retailerpasswordTextBoxmethod(pw);
		WebElement areacodedd = addRetailerPage.retailerAreaCodedd();
		wdu = new WebDriverUtility();
		Select s = wdu.SelectMethod(areacodedd);
		s.selectByVisibleText(areacodevalue);
		addRetailerPage.retailerPhoneTextBoxmethod(ph2);
		addRetailerPage.retaileremailTextBoxmethod(email);
		addRetailerPage.retaileraddressTextBoxmethod(address);

		// Thread.sleep(3000);
		addRetailerPage.retailersubmitbuttonmethod();

		// Thread.sleep(5000);
		wdu.alertPopUpAccept(driver);

		addRetailerPage.retailersbuttonmethod();
		List<WebElement> retailerList = addRetailerPage.ratailerEmailListmethod();
		boolean flag = false;
		for (WebElement rel : retailerList) {
			if (email.equals(rel.getText())) {
				System.out.println("Actual email: " + rel.getText());
				flag = true;
			}
		}
		Assert.assertEquals(flag, true);
	}
}
