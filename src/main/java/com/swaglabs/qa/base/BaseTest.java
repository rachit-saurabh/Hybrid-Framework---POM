package com.swaglabs.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.swaglabs.qa.util.TestUtil;

public class BaseTest 
{
	public static Properties prop;
	public static WebDriver driver;

	//Create a Constructor
	public BaseTest() 
	{
		prop = new Properties();
		try 
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\Swag_Labs\\src\\main\\java\\com\\swaglabs\\qa\\config\\config.properties");
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	//create a method : initialization
	public static void initialization() 
	{
		String browser = prop.getProperty("browser");
		
		if (browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browser.equals("FF")) 
		{
			System.setProperty("webdriver.gecko.driver", "D:\\library\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize(); //maximize the window
		driver.manage().deleteAllCookies(); //delete all the cookies
		
		//create static and public variables for timeouts() inside the util class: 
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS); //page load timeout
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_wait_timeout, TimeUnit.SECONDS); //implicit wait
		driver.get(prop.getProperty("url")); //call the url from the .properties file
	}

}
