package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.WomenPage;

public class WomenPageTest extends BaseClass{
	HomePage homePage;
	WomenPage womenPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		womenPage = new WomenPage();
		womenPage = homePage.clickOnWomenLink();
	}
	
	@Test(priority=1)
	public void verifyUniSexPageLabelTest() {
		Assert.assertTrue(womenPage.verifyWomenLabel(),"UniSex Label is missing");
	}
}
