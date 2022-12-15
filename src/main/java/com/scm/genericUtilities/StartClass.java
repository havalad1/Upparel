/**
 * this package contain classes which are used in all most all the test scripts
 */

package com.scm.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.scm.pageObjectModel.LoginPage;

public class StartClass {
	public static final WebDriver sdriver = null;
	//public static WebDriver sdriver;
	//public static WebDriverUtility swebDriverUtility;
	protected WebDriver driver;
	public WebDriverUtility wdu;
	protected ExcelFetchUtility ffeu = new ExcelFetchUtility();;
	protected PropertyFileFetchUtility pffu;
	protected BrowserAndApplicationLaunch bapl;
	LoginPage loginPage;
	protected boolean flag = false;

	@BeforeClass
	public void openApp() {
		wdu = new WebDriverUtility();
		ThreadSafe.setWebdriverutility(wdu);
		
		pffu = new PropertyFileFetchUtility();
		bapl = new BrowserAndApplicationLaunch();
		String url = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
		String usersname = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
		String password = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
		long timeout = Long.parseLong(pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "timeout"));
		String browser = pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");

		driver = bapl.launch(browser, url, timeout);
		//sdriver = driver;
		loginPage = new LoginPage(driver);
		loginPage.getUsername(usersname);
		loginPage.getPassword(password);

		WebElement admin = loginPage.getLoginTypedd();

		Select s = wdu.SelectMethod(admin);
		s.selectByValue("admin");

		// login
		loginPage.getLoginbutton();
	}

	@AfterClass
	public void closeApp() {
		driver.close();
	}
}
