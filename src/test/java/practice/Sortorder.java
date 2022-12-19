package practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.LoginPage;
import com.scm.pageObjectModel.OrdersPage;

public class Sortorder {
	@Test

	void main() throws InterruptedException 
	{

		WebDriverUtility wdu=new WebDriverUtility();
		PropertyFileFetchUtility pfu=new PropertyFileFetchUtility();
		String url=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
		String username=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
		String password=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
		String browser=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");
		long timeout=Long.parseLong(pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
		
		Random random=new Random();
		int ranid=random.nextInt(23);
		System.out.println(ranid);
		WebDriver driver = wdu.launch(browser, url, timeout);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUsername(username);
		loginPage.getPassword(password);
		
		WebElement logintype = loginPage.getLoginTypedd();
		Select s1 = wdu.SelectMethod(logintype);
		s1.selectByValue("admin");
		
		loginPage.getLoginbutton();
		
		//click on orders button
		OrdersPage ordersPage=new OrdersPage(driver);
		ordersPage.getOrdersButton();
		
		//searchby dropdown
		WebElement idnum = driver.findElement(By.xpath("//div[@class='input-box']/descendant::select[@name='cmbFilter' and @id='cmbFilter']"));
		Select s2=wdu.SelectMethod(idnum);
		s2.selectByValue("id");
		
		ordersPage.getRanidtextBox(ranid);
		Thread.sleep(3000);
		
		//click on search
		ordersPage.getClicksearchButton();
		
		String actualid = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
		if(actualid.equals(""+ranid+"")) {
			System.out.println("successfully sorted using id");
		}
		else {
			System.out.println("not sorted accordingly");
		}
		Thread.sleep(3000);
		driver.quit();	
	}
}
