package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginOb;
	HomePage homeOb;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginOb = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		String actuatitle = loginOb.validatePageTitle();
		Assert.assertEquals(actuatitle, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void verifyLoginFunctionality()
	{
		homeOb = loginOb.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void afterExecution()
	{
		driver.quit();
	}
	
}
