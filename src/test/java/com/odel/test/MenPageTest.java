package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.MenPage;

public class MenPageTest extends BaseClass{
	
	HomePage homePage;
	MenPage menPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		menPage = new MenPage();
		menPage = homePage.clickOnMenLink();
	}
	
	@Test(priority=1)
	public void verifyMenPageTitleTest() {
		String menPageTitle = menPage.verifyMenPageTitle();
		Assert.assertEquals(menPageTitle, "MENS | Odel.lk","Deals page title not matched");
	}
}
