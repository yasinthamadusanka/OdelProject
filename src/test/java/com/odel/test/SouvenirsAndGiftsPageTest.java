package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.SouvenirsAndGiftsPage;

public class SouvenirsAndGiftsPageTest extends BaseClass{
	
	HomePage homePage;
	SouvenirsAndGiftsPage souvenirsAndGiftsPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		souvenirsAndGiftsPage = new SouvenirsAndGiftsPage();
		souvenirsAndGiftsPage = homePage.clickOnSouvenirsAndGiftsLink();
	}
	
	@Test(priority=1)
	public void verifySouvenirsAndGiftsPageTitleTest() {
		String souvenirsAndGiftsPageTitle = souvenirsAndGiftsPage.verifySouvenirsAndGiftsPageTitle();
		Assert.assertEquals(souvenirsAndGiftsPageTitle, "SOUVENIRS & GIFTS | Odel.lk","SOUVENIRS & GIFTS page title not matched");
	}
}
