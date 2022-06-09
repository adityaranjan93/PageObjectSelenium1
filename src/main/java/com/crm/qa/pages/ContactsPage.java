package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "New")
	WebElement new_button;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="address")
	WebElement addressTextBox;
	
	@FindBy(linkText = "Save")
	WebElement save_button;
	
	
	
	public void create_new_contact(String firstname, String lastname, String addressvalue)
	{
		new_button.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		addressTextBox.sendKeys(addressvalue);
		save_button.click();
		
	}
}
