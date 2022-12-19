package com.scm.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage 
{
	@FindBy(linkText="Orders")
	private WebElement OrdersButton;
	
	@FindBy(xpath = "//div[@class='input-box']/descendant::select[@name='cmbFilter' and @id='cmbFilter']")
	private WebElement searchbydd;
	
	@FindBy(xpath ="//div[@class='input-box']/input")
	private WebElement ranidtextBox;
	
	@FindBy(xpath ="//span[@class='error_message']/preceding-sibling::input[@type='submit']")
	private WebElement clicksearchButton;
	
	@FindBy(xpath = "//tbody/tr[2]/td[1]")
	private WebElement actualidnum;
	
	public OrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement actualidnumber()
	{
		return actualidnum;
	}
	
	/**
	 * this method used to click on orders button
	 */
	public void getOrdersButton() {
		OrdersButton.click();
	}

	/**
	 * this method used to select value in search by dropdown
	 * @return
	 */
	public WebElement getSearchbydd() {
		return searchbydd;
	}

	/**
	 * this method used to enter random id number to search
	 * @param ranid
	 */
	public void getRanidtextBox(int ranid) {
		ranidtextBox.sendKeys(""+ranid+"");
	}

	/**
	 * this method used to click on search button 
	 */
	public void getClicksearchButton() {
		clicksearchButton.click();
	}
}
