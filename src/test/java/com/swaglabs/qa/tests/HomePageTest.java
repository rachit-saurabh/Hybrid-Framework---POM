package com.swaglabs.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglabs.qa.base.BaseTest;
import com.swaglabs.qa.pages.HomePage;
import com.swaglabs.qa.pages.LoginPage;

public class HomePageTest extends BaseTest {

	HomePage homepage;
	LoginPage loginpage;

	// Create a constructor
	public HomePageTest() {
			super();
		}

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test (priority = 1)
	public void VerifyHomePageTitleTest() {
		String title = homepage.validateHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Swag Labs", "The title is not matched");
	}
	
	@Test(priority = 2)
	public void verifyHomePageLogoTest() {
		Assert.assertTrue(homepage.HomePageLogoTest());
	}
	
	@Test(priority = 3)
	public void verifyInventoryImageTest() {
		Assert.assertTrue(homepage.InventoryItemImage());
	}
	
	@Test(priority = 4)
	public void verifyAddToCartOptionTest() {
		homepage.AddToCart();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
