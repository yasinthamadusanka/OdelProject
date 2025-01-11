package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.UniSexPage;

public class UniSexPageTest extends BaseClass{
	UniSexPage uniSexPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		uniSexPage = new UniSexPage();
		uniSexPage = homePage.clickOnUniSexLink();
	}
	
	@Test(priority=1)
	public void verifyUniSexPageLabelTest() {
		Assert.assertTrue(uniSexPage.verifyUniSexLabel(),"UniSex Label is missing");
	}
	
}

