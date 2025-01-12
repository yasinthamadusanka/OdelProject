package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.WatchesAndSunglassesPage;

public class WatchesAndSunglassesPageTest extends BaseClass{
	
	HomePage homePage;
	WatchesAndSunglassesPage watchesAndSunglassesPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		watchesAndSunglassesPage = new WatchesAndSunglassesPage();
		watchesAndSunglassesPage = homePage.clickOnWatchesAndSunglassesLink();
	}
	
	@Test(priority=1)
	public void verifyWatchesAndSunglassesPageTitleTest() {
		String watchesAndSunglassesPageTitle = watchesAndSunglassesPage.verifyWatchesAndSunglassesPageTitle();
		Assert.assertEquals(watchesAndSunglassesPageTitle, " | Odel.lk","WATECHES & SUNGLASSES page title not matched");
	}
}
