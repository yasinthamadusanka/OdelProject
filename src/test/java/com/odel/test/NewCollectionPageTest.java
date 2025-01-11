package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.NewCollectionPage;

public class NewCollectionPageTest extends BaseClass{
	HomePage homePage;
	NewCollectionPage newCollectionPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		newCollectionPage = new NewCollectionPage();
		newCollectionPage = homePage.clickOnNewCollectionLink();
	}
	
	@Test(priority=1)
	public void verifyNewCollectionPageTitleTest() {
		String newCollectionPageTitle = newCollectionPage.verifyNewCollectionPageTitle();
		Assert.assertEquals(newCollectionPageTitle, "New Products | Odel.lk","New Collection page title not matched");
	}

}
