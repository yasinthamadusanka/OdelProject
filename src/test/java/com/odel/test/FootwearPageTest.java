package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.FootwearPage;
import com.odel.pages.HomePage;

public class FootwearPageTest extends BaseClass{
	
	HomePage homePage;
	FootwearPage footwearPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		footwearPage = new FootwearPage();
		footwearPage = homePage.clickOnFootwearLink();
	}
	
	@Test(priority=1)
	public void verifyFootwearPageTitleTest() {
		String footwearPageTitle = footwearPage.verifyFootwearPageTitle();
		Assert.assertEquals(footwearPageTitle, "BAGS & SHOES | Odel.lk","BAGS & SHOES page title not matched");
	}

}
