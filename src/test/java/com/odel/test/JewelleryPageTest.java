package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.JewelleryPage;

public class JewelleryPageTest extends BaseClass{
	
	HomePage homePage;
	JewelleryPage jewelleryPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		jewelleryPage = new JewelleryPage();
		jewelleryPage = homePage.clickOnJewelleryLink();
	}
	
	@Test(priority=1)
	public void verifyJewelleryPageTitleTest() {
		String jewelleryPageTitle = jewelleryPage.verifyJewelleryPageTitle();
		Assert.assertEquals(jewelleryPageTitle, "JEWELLERY & WATCHES | Odel.lk","Jewellery page title not matched");
	}
}
