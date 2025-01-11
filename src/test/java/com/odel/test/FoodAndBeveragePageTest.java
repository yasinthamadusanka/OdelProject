package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.FoodAndBeveragePage;
import com.odel.pages.HomePage;

public class FoodAndBeveragePageTest extends BaseClass{
	
	HomePage homePage;
	FoodAndBeveragePage foodAndBeveragePage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		foodAndBeveragePage = new FoodAndBeveragePage();
		foodAndBeveragePage = homePage.clickOnFoodAndBeverageLink();
	}
	
	@Test(priority=1)
	public void verifyFoodAndBeveragePageTitleTest() {
		String foodAndBeveragePageTitle = foodAndBeveragePage.verifyFoodAndBeveragePageTitle();
		Assert.assertEquals(foodAndBeveragePageTitle, "FOOD & BEVERAGES | Odel.lk","Deals page title not matched");
	}
}
