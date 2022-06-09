package com.crm.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.qa.util.TestUtil;


//class for the initial set up like driver initialization, basic browser settings
public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try 
		{
			prop = new Properties();
			FileInputStream fin = new FileInputStream("D:\\Selenium_Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fin);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			//options.addArguments("--headless");
			//options.addArguments("--window-size=1920,1080");
			//options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			//options.addArguments("--dns-prefetch-disable");
			//options.addArguments("--disable-gpu");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "D:\\Selenium_Java\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitTimeWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
