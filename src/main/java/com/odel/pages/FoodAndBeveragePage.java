package com.odel.pages;

import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class FoodAndBeveragePage extends BaseClass{
	
	public FoodAndBeveragePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyFoodAndBeveragePageTitle() {
		return driver.getTitle();
	}
	
}
