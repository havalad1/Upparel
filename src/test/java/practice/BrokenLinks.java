package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks 
{
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.microsoft.com/en-in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for (int i = 0; i < allLinks.size(); i++) {
			String url = allLinks.get(i).getAttribute("href");
			try {
				URL u = new URL(url);
				URLConnection urlConnection = u.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				int statusCode = httpURLConnection.getResponseCode();
				if (statusCode != 200) {
					System.out.println("Broken Link=====>" + url + "======>" + httpURLConnection.getResponseMessage());
				}
			} catch (Exception e) {
				System.out.println("something wrong with this url =======>" + url);
			}
		}
		driver.quit();	
	}
}
