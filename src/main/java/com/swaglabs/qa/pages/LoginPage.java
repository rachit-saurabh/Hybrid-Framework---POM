package com.swaglabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglabs.qa.base.BaseTest;

public class LoginPage extends BaseTest{

	//Page Factory or Object Repository
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//div[@class = 'login_logo']")
	WebElement loginlogo;
	
	//create a constructor:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Create the methods
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateloginPageImage() {
		return loginlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage(); //after login user will land on the Home Page
	}
	
}
