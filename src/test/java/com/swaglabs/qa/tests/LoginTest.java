package com.swaglabs.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglabs.qa.base.BaseTest;
import com.swaglabs.qa.pages.HomePage;
import com.swaglabs.qa.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	LoginPage login;
	HomePage homepage;

	//Create a constructor
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage();
	}
	
	@Test(priority = 1)
	public void titleTest() {
		String title = login.validateLoginPageTitle();
		Assert.assertEquals(title,"Swag Labs");
	}
	
	@Test(priority = 2)
	public void logoTest() {
		login.validateloginPageImage();
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3)
	public void login() {
		login.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
