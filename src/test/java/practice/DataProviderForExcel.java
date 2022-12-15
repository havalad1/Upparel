package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scm.genericUtilities.ExcelFetchUtility;
import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.WebDriverUtility;
import com.scm.pageObjectModel.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderForExcel 
{
	@DataProvider
	public String[][] getData() throws EncryptedDocumentException, IOException
	{
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream(IConstantPath.EXCEL_PATH);
		Workbook w = WorkbookFactory.create(fis);
		//ExcelFetchUtility ffeu=new ExcelFetchUtility();
		int lastrownum=w.getSheet("practice").getLastRowNum();
		int lastcolnum=w.getSheet("practice").getRow(0).getLastCellNum();
		String[][] arr=new String[lastrownum][lastcolnum];
		for(int i=0;i<lastrownum;i++)
		{
			for(int j=0;j<lastcolnum;j++)
			{
				arr[i][j]=df.formatCellValue(w.getSheet("practice").getRow(i+1).getCell(j));
			}
		}
		return arr;
	}
	
	@Test(dataProvider="getData")
	public void main(String username,String password )
	{
		System.out.println("username----->"+username+"      password------->"+password);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/index.php");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUsername(username);
		loginPage.getPassword(password);
		WebElement ldd = loginPage.getLoginTypedd();
		
		WebDriverUtility wdu=new WebDriverUtility();
		Select s = wdu.SelectMethod(ldd);
		s.selectByValue("admin");
		loginPage.getLoginbutton();
		WebElement wp = driver.findElement(By.xpath("//h1[text()='Welcome Admin']"));
		System.out.println(wp.getText());
		Assert.assertEquals(wp.getText(),true, "welcome page not displayed");
		loginPage.getLogoutbutton();
		//Assert.fail();
		
		driver.quit();
	}
}
