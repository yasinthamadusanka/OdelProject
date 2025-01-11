package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.KidsPage;

public class KidsPageTest extends BaseClass{
	
	HomePage homePage;
	KidsPage kidsPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		kidsPage = new KidsPage();
		kidsPage = homePage.clickOnKidsLink();
	}
	
	@Test(priority=1)
	public void verifyKidsPageTitleTest() {
		String kidsPageTitle = kidsPage.verifyKidsPageTitle();
		Assert.assertEquals(kidsPageTitle, "KIDS | Odel.lk","KIDS page title not matched");
	}
}
