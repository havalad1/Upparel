package com.scm.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRetailerPage {
@FindBy(id="retailer:username")
private WebElement retailerNameTextBox;

@FindBy(id="retailer:password")
private WebElement retailerPasswordTextBox;

@FindBy(id="retailer:areaCode")
private WebElement retailerAreaCodedd;

@FindBy(id="retailer:phone")
private WebElement retailerphonetextbox;

@FindBy(id="retailer:email")
private WebElement retaileremailtextbox;

@FindBy(id="retailer:address")
private WebElement retaileraddresstextbox;

@FindBy(xpath="//input[@type=\"submit\"]")
//input[@class='submit_button']/following-sibling::span[@class='error_message']
private WebElement submitbutton;

@FindBy(linkText ="Retailers")
private WebElement retailersbutton;

@FindBy(xpath="//h1[.='View Retailer']/ancestor::section/descendant::tr/td[6]")
private List<WebElement> ratailerEmailList;

public AddRetailerPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void retailerNmaeTextBoxmethod(String retailerName)
{
	retailerNameTextBox.sendKeys(retailerName);
}

public void retailerpasswordTextBoxmethod(String retailerpassword)
{
	retailerPasswordTextBox.sendKeys(retailerpassword);
}

public WebElement retailerAreaCodedd()
{
	return retailerAreaCodedd;
}

public void retailerPhoneTextBoxmethod(String retailerphoneno)
{
	retailerphonetextbox.sendKeys(retailerphoneno);
}

public void retaileremailTextBoxmethod(String retailerEmail)
{
	retaileremailtextbox.sendKeys(retailerEmail);
}

public void retaileraddressTextBoxmethod(String retailerName)
{
	retaileraddresstextbox.sendKeys(retailerName);
}

public void retailersubmitbuttonmethod()
{
	submitbutton.click();
}

public void retailersbuttonmethod()
{
	retailersbutton.click();
}

public List<WebElement> ratailerEmailListmethod()
{
	return ratailerEmailList;
}

}
