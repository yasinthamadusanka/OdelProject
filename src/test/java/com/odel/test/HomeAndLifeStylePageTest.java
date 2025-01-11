package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomeAndLifeStylePage;
import com.odel.pages.HomePage;

public class HomeAndLifeStylePageTest extends BaseClass{
	
	HomePage homePage;
	HomeAndLifeStylePage homeAndLifeStylePage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		homeAndLifeStylePage = new HomeAndLifeStylePage();
		homeAndLifeStylePage = homePage.clickOnHomeAndLifeStyleLink();
	}
	
	@Test(priority=1)
	public void verifyHomeAndLifeStylePageTitleTest() {
		String homeAndLifeStylePageTitle = homeAndLifeStylePage.verifyHomeAndLifeStylePageTitle();
		Assert.assertEquals(homeAndLifeStylePageTitle, "HOME & LIFESTYLE | Odel.lk","HOME & LIFESTYLE page title not matched");
	}
}
