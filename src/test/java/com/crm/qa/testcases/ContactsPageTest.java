package com.crm.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	public ContactsPageTest()
	{
		super();
	}
	LoginPage loginob;
	HomePage homeob;
	ContactsPage contactOb;
	public static String getTestData = "Contacts";
	
	@BeforeMethod
	public void initial_setup()
	{
		initialization();
		loginob = new LoginPage();
		homeob = loginob.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		contactOb = homeob.navigateToContactsSection();
	}
	
	@DataProvider
	public Object[][] getContactDataFromFile() throws FileNotFoundException
	{
		Object data[][] = TestUtil.getTestData(getTestData);
		return data;
	}
	
	@Test(priority=1, dataProvider = "getContactDataFromFile")
	public void verify_create_newContact_Test(String firstname, String lastname, String address)
	{
		contactOb.create_new_contact(firstname , lastname, address);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
