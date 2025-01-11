package com.odel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class ShopByBrandsPage extends BaseClass{
	
	@FindBy(xpath="//h3[@class='page-title']")
	WebElement shopByBrandsLabel;
	
	public ShopByBrandsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyShopByBrandsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyShopByBrandsLabel() {
		return shopByBrandsLabel.isDisplayed();
	}
}
