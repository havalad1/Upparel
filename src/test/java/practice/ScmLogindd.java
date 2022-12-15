package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.scm.genericUtilities.BrowserAndApplicationLaunch;
import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.LoginPage;

public class ScmLogindd 
{
	public static void main(String[] args) throws InterruptedException 
	{
		BrowserAndApplicationLaunch bal=new BrowserAndApplicationLaunch();
		WebDriverUtility wu=new WebDriverUtility();
		
		PropertyFileFetchUtility pfu=new PropertyFileFetchUtility();
		String username=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
		String password=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
		String url=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
		String browser=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");
		long timeout=Long.parseLong(pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
		String admin=pfu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "admin");
		
		WebDriver driver = bal.launch(browser, url, timeout);
		LoginPage loginPage=new LoginPage(driver);
		
		
		loginPage.getUsername(username);
		loginPage.getPassword(password);
		WebElement logindd = loginPage.getLoginTypedd();
		Select s1 = wu.SelectMethod(logindd);
		s1.selectByValue(admin);
		
		loginPage.getLoginbutton();
		driver.quit();
	}
}
