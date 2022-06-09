package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory or Object repositories
	@FindBy(name="email")
	WebElement email_textbox;
	
	@FindBy(name="password")
	WebElement password_textbox;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement lgn_btn;
	
	
	//Actions
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage validateLoginFunctionality(String username, String password)
	{
		email_textbox.sendKeys(username);
		password_textbox.sendKeys(password);
		lgn_btn.click();
		return new HomePage();
	}

	

}
