package com.scm.pageObjectModel;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageStockPage 
{
	
	@FindBy(xpath = "//a[text()='Manage Stock']")
	private WebElement manageStockButton;
		
	@FindBy(xpath = "//table/tbody/tr/td[3]/preceding-sibling::td[1]")
	private List<WebElement>  proNameList;
	
	@FindBy(id="btnSubmit")
	private WebElement updateStockButton;
	
	/**
	 * this method used to convert string to webelement
	 */
	String quantitytextBoxXpath="//td[.='%s']/following-sibling::td[2]/input";
	private WebElement StringToWebElement(WebDriver driver, String partialXpath, String replaceData)
	{
		String Xpath = String.format(quantitytextBoxXpath, replaceData);
		return driver.findElement(By.xpath(Xpath));
	}
	
	public ManageStockPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	/**
	 * this method used to click on manage stock button
	 */
	public void getManageStockButton() 
	{
		manageStockButton.click();
	}
	
	/**
	 * this method used to send quantity value
	 * @param driver
	 * @param expectedProName
	 * @param expectedqty
	 */
	public void getStringToWebElement(WebDriver driver, String expectedProName, String expectedqty)
	{
		StringToWebElement(driver,quantitytextBoxXpath, expectedProName).clear();
		StringToWebElement(driver,quantitytextBoxXpath, expectedProName).sendKeys(expectedqty);
	}
	
	/**
	 * this method used to get product names from the table
	 * @return
	 */
	public List<WebElement> getproNameList()
	{
		return proNameList;
	}
	
	/**
	 * this method used to click on update button
	 */
	public void getupdateStockButton()
	{
		updateStockButton.click();
	}
}
