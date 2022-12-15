package com.scm.orders;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.genericUtilities.StartClass;
import com.scm.pageObjectModel.OrdersPage;
@Listeners(com.scm.genericUtilities.ListenerImplementationClass_1.class)
public class Orders_sortingIdUsingStartClassTest extends StartClass {

	@Test
	public void orderSort() {
		Random random = new Random();
		int ranid = random.nextInt(23);
		System.out.println(ranid);

		// click on orders button
		OrdersPage ordersPage = new OrdersPage(driver);
		ordersPage.getOrdersButton();

		// searchby dropdown
		//WebElement idtype = driver.findElement(By.xpath("//div[@class='input-box']/descendant::select[@name='cmbFilter' and @id='cmbFilter']"));
		WebElement searchby = ordersPage.getSearchbydd();
		Select s2 = wdu.SelectMethod(searchby);
		s2.selectByValue("id");

		ordersPage.getRanidtextBox(ranid);

		// click on search
		ordersPage.getClicksearchButton();

		//String actualid = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
		String actualid = ordersPage.actualidnumber().getText();
		
		Assert.assertEquals(actualid, ""+ranid+"");
		Assert.assertEquals("A", "B");
	}
}
