package practice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.scm.genericUtilities.BrowserAndApplicationLaunch;
import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;
import com.scm.genericUtilities.StartClass;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.LoginPage;
import com.scm.pageObjectModel.ManageStockPage;

public class ManageStockStartClass extends StartClass
{
	@Test
	public void manageStock() throws InterruptedException 
	{
				int randomqty = wdu.randomNumberWithBound(1000);
				String expectedqty=Integer.toString(randomqty);
				
				String url = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
				String username = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
				String password = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
				long timeout = Long.parseLong(pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
				
				BrowserAndApplicationLaunch bal=new BrowserAndApplicationLaunch();
				WebDriver driver = bal.launch("chrome", url, timeout);
				LoginPage loginPage=new LoginPage(driver);
				loginPage.getUsername(username);
				loginPage.getPassword(password);
				WebElement manufac= loginPage.getLoginTypedd();				
				Select s = wdu.SelectMethod(manufac);
				s.selectByValue("manufacturer");
				
				loginPage.getLoginbutton();
								
				//manastock click
				ManageStockPage manageStockPage=new ManageStockPage(driver);
				manageStockPage.getManageStockButton();
				
				//Fetching names from table
				List<WebElement> proNameList = manageStockPage.getproNameList();
				boolean flag=false;
				String expectedProName="Pizza Sauce";
				System.out.println("expectedProName= "+expectedProName);
				for(int i=0;i<=proNameList.size();i++)
				{
					String actualProName = proNameList.get(i).getText();
					if(actualProName.contains(expectedProName))
					{
						System.out.println("Actual Name= "+actualProName);
						manageStockPage.getStringToWebElement(driver,expectedProName,expectedqty);
						manageStockPage.getupdateStockButton();
						wdu.alertPopUpAccept(driver);
						flag=true;
						break;
					}
				}
				
				if(flag==true)
				{
					System.out.println("quantity added successfully");
				}
				else
				{
					System.out.println("quantity not added");
				}
				Thread.sleep(3000);
				driver.quit();
		}

}
