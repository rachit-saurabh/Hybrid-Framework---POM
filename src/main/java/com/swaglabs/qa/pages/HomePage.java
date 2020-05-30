package com.swaglabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.swaglabs.qa.base.BaseTest;

public class HomePage extends BaseTest {

	// Page Factory or Object Repository

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement homePageLogo;

	@FindBy(xpath = "//img[@class='inventory_item_img']")
	WebElement inventoryitemimage;

	@FindBy(xpath = "//button[contains(text(), 'ADD TO CART')]")
	WebElement addToCart;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement sorting;

//create a constructor

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean HomePageLogoTest() {
		return homePageLogo.isDisplayed();
	}

	public boolean InventoryItemImage() {
		return inventoryitemimage.isDisplayed();
	}

	public void AddToCart() {
		addToCart.click();
	}

	public void Sort() {
		Select s = new Select(sorting);
		s.selectByVisibleText("Price (low to high)");
	}
}
