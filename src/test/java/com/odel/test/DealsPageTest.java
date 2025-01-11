package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.DealsPage;
import com.odel.pages.HomePage;


public class DealsPageTest extends BaseClass{
	HomePage homePage;
	DealsPage dealsPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		dealsPage = new DealsPage();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=1)
	public void verifyDealsPageTitleTest() {
		String dealsPageTitle = dealsPage.verifyDealsPageTitle();
		Assert.assertEquals(dealsPageTitle, "Search Page | Odel.lk","Deals page title not matched");
	}
}
