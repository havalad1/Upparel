package com.scm.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//declaration of web elements
	@FindBy(name="txtUsername")
	private WebElement usernametextbox;
	
	@FindBy(id="login:password")
	private WebElement passwordtextbox;
	
	@FindBy(xpath="//span[@class='error_message']/preceding-sibling::input[@type='submit']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//li[3]/div[2]/select")
	private WebElement loginTypedd;
	
	@FindBy(xpath = "//input[@type='button' and @value='Log out']")
	private WebElement logoutbutton;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//usage
	/**
	 * this method used to select login type
	 * @return
	 */
	public WebElement getLoginTypedd() {
		return loginTypedd;
	}

	/**
	 * this method used to click on logout button
	 * @return
	 */
	public WebElement getLogoutbutton() {
		return logoutbutton;
	}

	/**
	 * this method used to enter username
	 * @param username
	 */
	public void getUsername(String username) {
		usernametextbox.sendKeys(username);
	}

	/**
	 * this method used to enter password
	 * @param password
	 */
	public void getPassword(String password) {
		passwordtextbox.sendKeys(password);
	}

	/**
	 * this method used to click on login button
	 */
	public void getLoginbutton() {
		loginbutton.click();
	}	
}
