package com.scm.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addProductPage 
{
	
	@FindBy(linkText="Add Products")
	private WebElement addproductsbutton;
	
	@FindBy(id="product:name")
	private WebElement productnametextbox;
	
	@FindBy(id="product:price")
	private WebElement productpricetextbox;
	
	@FindBy(xpath="//div[@class='label-block']/following-sibling::input[1]")
	private WebElement enableradiobutton;
	
	@FindBy(id="product:description")
	private WebElement productdescriptiontextbox;
	
	@FindBy(xpath="//input[@value='Add Product']")
	private WebElement addproductbutton;
	
	public addProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this method used to click on addproducts button
	 */
	public void getAddproductsbutton() 
	{
		addproductsbutton.click();
	}
	
	/*
	 * this method used to enter text in product name text box
	 */
	public void getProductnametextbox(String expectedProname) 
	{
		productnametextbox.sendKeys(expectedProname);
	}
	
	/**
	 * this method used to enter price in price text box
	 * @param price
	 */
	public void getProductpricetextbox(int price) 
	{
		productpricetextbox.sendKeys(""+price+"");
	}
	
	/**
	 * this method used to click on enable radio button
	 */
	public void getEnableradiobutton() 
	{
		enableradiobutton.click();
	}
	
	/**
	 * this method used to enter text in description box
	 * @param expectedProname
	 */
	public void getProductdescriptiontextbox(String expectedProname) 
	{
		productdescriptiontextbox.sendKeys(expectedProname);
	}
	
	/**
	 * this method used to click on add product button
	 */
	public void getAddproductbutton() 
	{
		addproductbutton.click();
	}
}
