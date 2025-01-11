package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.ShopByBrandsPage;

public class ShopByBrandsPageTest extends BaseClass{
	HomePage homePage;
	ShopByBrandsPage shopByBrandsPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		shopByBrandsPage = new ShopByBrandsPage();
		shopByBrandsPage = homePage.clickOnShopByBrandsLink();
	}
	
	@Test(priority=1)
	public void verifyShopByBrandsPageTitleTest() {
		String shopByBrandsPageTitle = shopByBrandsPage.verifyShopByBrandsPageTitle();
		Assert.assertEquals(shopByBrandsPageTitle, "Shop by Brands | Odel.lk","Shop By Brands page title not matched");
	}
	
	@Test(priority=2)
	public void verifyShopByBrandsPageLabelTest() {
		Assert.assertTrue(shopByBrandsPage.verifyShopByBrandsLabel(),"Shop by Brands Label is missing");
	}
}
