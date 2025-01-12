package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.BagsPage;
import com.odel.pages.HomePage;

public class BagsPageTest extends BaseClass{
	
	HomePage homePage;
	BagsPage bagsPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		bagsPage = new BagsPage();
		bagsPage = homePage.clickOnBagsLink();
	}
	
	@Test(priority=1)
	public void verifyBagsPageTitleTest() {
		String bagsPageTitle = bagsPage.verifyBagsPageTitle();
		Assert.assertEquals(bagsPageTitle, " | Odel.lk","Bags page title not matched");
	}
}
