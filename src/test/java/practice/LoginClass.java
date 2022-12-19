package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginClass 
{
	@Test
	public void tc()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/index.php");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUsername("admin");
		loginPage.getPassword("admin123");
		WebElement ldd = loginPage.getLoginTypedd();
		
		WebDriverUtility wdu=new WebDriverUtility();
		Select s = wdu.SelectMethod(ldd);
		s.selectByValue("admin");
		loginPage.getLoginbutton();
		loginPage.getLogoutbutton();
		Assert.fail();
		driver.quit();
	}
}
