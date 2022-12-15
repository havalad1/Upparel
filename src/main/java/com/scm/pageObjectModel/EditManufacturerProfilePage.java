package com.scm.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditManufacturerProfilePage 
{
	WebDriver driver;
	
	@FindBy(linkText = "Manufacturers")
	private WebElement manufacturersbutton;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement updateManufactureButton;
	
	@FindBy(xpath = "//th[.='Name']/../../tr/td[3]")
	private List<WebElement> nameList;
	
	@FindBy(xpath="//a[@href='edit_manufacturer.php?id=1']")
	private WebElement clickeditbutton;
	
	@FindBy(xpath="//input[@id='manufacturer:name' and @name='txtManufacturerName']")
	private WebElement manufacturernametextbox;
	
	@FindBy(xpath="//input[@id='manufacturer:email' and @name='txtManufacturerEmail']")
	private WebElement manufactureremailtextbox;
	
	@FindBy(xpath="//input[@id='manufacturer:phone' and @name='txtManufacturerPhone']")
	private WebElement manufacturerphonetextbox;
	
	@FindBy(xpath="//input[@id='manufacturer:username' and @name='txtManufacturerUname']")
	private WebElement manufacturerusernametextbox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement manufacturersupdatebutton;
	
	String editbuttonXpath="//table/tbody/tr/td[.=' %s ']/following-sibling::td[4]/a";
	
	
	public EditManufacturerProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this method used to click on manufacturer button
	 */
	public void getupdateManufactureButton()
	{
		updateManufactureButton.click();
	}
	
	/**
	 * this method used to return namelist of manufacturers
	 * @return
	 */
	public List<WebElement> getnameList()
	{
		return nameList;
	}
	
	/**
	 * this method used to convert string to web element and returns web element
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement StringToWebElement(String partialXpath, String replaceData)
	{
		String xPath=String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
	}
	
	/**
	 *  this method used to convert string to web element
	 * @param driver
	 * @param expectedName
	 */
	public void getStringToWebElement(WebDriver driver, String expectedName)
	{
		this.driver=driver;
		WebElement editButton = StringToWebElement(editbuttonXpath, expectedName);
		editButton.click();
	}

	//getter methods
	/**
	 * this method used to click on manufacturers button
	 */
	public void getManufacturersbutton() {
		manufacturersbutton.click();
	}

	/*
	 * this method used to click on edit button
	 */
	public void getClickeditbutton() {
		clickeditbutton.click();
	}
	
	/**
	 * this method used to enter manufacturers name
	 * @return
	 */
	public WebElement getManufacturernametextbox() {
		return manufacturernametextbox;
	}
	
	/**
	 * this method used to enter manufacturers email
	 * @return
	 */
	public WebElement getManufactureremailtextbox() {
		return manufactureremailtextbox;
	}

	/**
	 * this method used to enter manufacturers phone
	 * @return
	 */
	public WebElement getManufacturerphonetextbox() {
		return manufacturerphonetextbox;
	}
	
	/**
	 * this method used to enter manufacturers username
	 * @return
	 */
	public WebElement getManufacturerusernametextbox() {
		return manufacturerusernametextbox;
	}
	
	/**
	 * this method used to click on manufacturer update button 
	 */
	public void getManufacturersupdatebutton() {
		manufacturersupdatebutton.click();
	}
}
