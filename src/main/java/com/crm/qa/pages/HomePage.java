package com.crm.qa.pages;

//Also called page library
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Object Repo
	@FindBy(xpath="//div[contains(text(), 'Deals Summary')]")
	WebElement deal_summary_label;
	
	@FindBy(xpath="//span[contains(text(), 'Contacts')]")
	WebElement contactLink;
	
	
	
	//Actions
	public boolean verifyDealsSummarySectionAvailability()
	{
		return deal_summary_label.isDisplayed();
	}
	
	public ContactsPage navigateToContactsSection()
	{
		contactLink.click();
		return new ContactsPage();
	}
}
