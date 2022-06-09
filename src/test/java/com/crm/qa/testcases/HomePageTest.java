package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	public HomePageTest()
	{
	  super();	
	}
	
	LoginPage loginob;
	HomePage homeob;
	//ContactsPage contactsob1;
	ContactsPage contactsob;
	
@BeforeMethod
public void initialSetUp()
{
	initialization();
	loginob = new LoginPage();
	homeob = loginob.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	contactsob = new ContactsPage();
	
}

@Test(priority=1)
public void validateDealsSummarySectionTest()
{
	Assert.assertTrue(homeob.verifyDealsSummarySectionAvailability());
}

@Test(priority=2)
public void verifyNavigationToContactsPageTest()
{
	contactsob = homeob.navigateToContactsSection();
	//Assert.assertEquals(contactsob1, contactsob, "Assertion failed : Objects does not match"); WHY??
}

	
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
