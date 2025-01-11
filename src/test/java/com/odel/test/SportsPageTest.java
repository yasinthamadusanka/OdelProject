package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.SportsPage;

public class SportsPageTest extends BaseClass{
	HomePage homePage;
	SportsPage sportsPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		sportsPage = new SportsPage();
		sportsPage = homePage.clickOnSportsLink();
	}
	
	@Test(priority=1)
	public void verifySportsPageTitleTest() {
		String sportsPageTitle = sportsPage.verifySportsPageTitle();
		Assert.assertEquals(sportsPageTitle, "Sports & Fitness | Odel.lk","Sports & Fitness page title not matched");
	}
}
