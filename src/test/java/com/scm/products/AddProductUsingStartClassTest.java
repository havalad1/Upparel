package com.scm.products;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.StartClass;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.addProductPage;

@Listeners(com.scm.genericUtilities.ListenerImplementationClass_1.class)
public class AddProductUsingStartClassTest extends StartClass {

	@Test
	public void addProduct() throws IOException, InterruptedException {
		Random random = new Random();
		int rnum = random.nextInt(23);
		int price = random.nextInt(100);

		String expectedProname = ffeu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "product_addproducts", 1, 1) + ""+ rnum + "";

		addProductPage app = new addProductPage(driver);

		// click on addproduct
		app.getAddproductsbutton();

		// product name
		app.getProductnametextbox(expectedProname);

		// product price
		app.getProductpricetextbox(price);

		// unit type dd
		WebElement unitdd = driver.findElement(By.id("product:unit"));
		WebDriverUtility wdu = new WebDriverUtility();
		Select s2 = wdu.SelectMethod(unitdd);
		s2.selectByValue("2");

		// category dropdown
		WebElement categorydd = driver.findElement(By.id("product:category"));
		Select s3 = wdu.SelectMethod(categorydd);
		s3.selectByValue("3");

		// click on enable radio button
		app.getEnableradiobutton();

		app.getProductdescriptiontextbox(expectedProname);

		// click on addproduct
		app.getAddproductbutton();

		driver.switchTo().alert().accept();

		// click on addproduct
		driver.findElement(By.linkText("Products")).click();
		Thread.sleep(3000);

		// verify
		List<WebElement> actualpronameList = driver.findElements(By.xpath("//section/form/table/tbody/tr/td[3]"));
		System.out.println("expectedName= " + expectedProname);
		boolean flag = false;
		for (int i = 0; i < actualpronameList.size(); i++) {
			String actualName = actualpronameList.get(i).getText();
			if (actualName.equals(expectedProname)) {
				System.out.println("Actualname= "+actualName);
				System.out.println("product added successfully");
				flag = true;
				break;
			}
		}
		Assert.assertEquals(flag, true);
		Assert.fail();
	}
}
