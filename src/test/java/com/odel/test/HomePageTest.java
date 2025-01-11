package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.BagsPage;
import com.odel.pages.DealsPage;
import com.odel.pages.FoodAndBeveragePage;
import com.odel.pages.FootwearPage;
import com.odel.pages.HomeAndLifeStylePage;
import com.odel.pages.HomePage;
import com.odel.pages.JewelleryPage;
import com.odel.pages.KidsPage;
import com.odel.pages.LoginPage;
import com.odel.pages.MenPage;
import com.odel.pages.NewCollectionPage;
import com.odel.pages.ShopByBrandsPage;
import com.odel.pages.SignUpPage;
import com.odel.pages.SouvenirsAndGiftsPage;
import com.odel.pages.SportsPage;
import com.odel.pages.UniSexPage;
import com.odel.pages.WatchesAndSunglassesPage;
import com.odel.pages.WomenPage;


public class HomePageTest extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	DealsPage dealsPage;
	NewCollectionPage newCollectionPage;
	ShopByBrandsPage shopByBrandsPage;
	UniSexPage uniSexPage;
	WomenPage womenPage;
	MenPage menPage;
	SportsPage sportsPage;
	FootwearPage footwearPage;
	BagsPage bagsPage;
	WatchesAndSunglassesPage watchesAndSunglassesPage;
	JewelleryPage jewelleryPage;
	KidsPage kidsPage;
	HomeAndLifeStylePage homeAndLifeStylePage;
	FoodAndBeveragePage foodAndBeveragePage;
	SouvenirsAndGiftsPage souvenirsAndGiftsPage;
	
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		loginPage = new LoginPage();
		signUpPage = new SignUpPage();
		dealsPage = new DealsPage();
		newCollectionPage = new NewCollectionPage();
		shopByBrandsPage = new ShopByBrandsPage();
		uniSexPage = new UniSexPage();
		womenPage = new WomenPage();
		menPage = new MenPage();
		sportsPage = new SportsPage();
		footwearPage = new FootwearPage();
		bagsPage = new BagsPage();
		watchesAndSunglassesPage = new WatchesAndSunglassesPage();
		jewelleryPage = new JewelleryPage();
		kidsPage = new KidsPage();
		homeAndLifeStylePage = new HomeAndLifeStylePage();
		foodAndBeveragePage	= new FoodAndBeveragePage();
		souvenirsAndGiftsPage = new SouvenirsAndGiftsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Home | Odel.lk","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyHomePageLogoTest() {
		Assert.assertTrue(homePage.verifyHomePageLogo());
	}
	
	@Test(priority=3)
	public void verifyHomePageLogoClickTest() {
		homePage = homePage.clickOnLogo();
	}
	
	@Test(priority=4)
	public void verifyHomePageSearchIconTest() {
		Assert.assertTrue(homePage.verifySearchIconDisplay());
	}
	
	@Test(priority=5)
	public void verifyHomePageCartIconTest() {
		Assert.assertTrue(homePage.verifyCartIconDisplay());
	}
	
	@Test(priority=6)
	public void verifyHomePageProfileIconTest() {
		Assert.assertTrue(homePage.verifyProfileIconDisplay());
	}
	
	@Test(priority=7)
	public void verifyHomePageAccountIconTest() {
		Assert.assertTrue(homePage.verifyAccountIconDisplay());
	}
	
	@Test(priority=8)
	public void verifyDealsLinkTest() {
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=9)
	public void verifyNewCollectionLinkTest() {
		newCollectionPage = homePage.clickOnNewCollectionLink();
	}
	
	@Test(priority=10)
	public void verifyShopByBrandsLinkTest() {
		shopByBrandsPage = homePage.clickOnShopByBrandsLink();
	}
	
	@Test(priority=11)
	public void verifyUniSexLinkTest() {
		uniSexPage = homePage.clickOnUniSexLink();
	}
	
	@Test(priority=12)
	public void verifyWomenLinkTest() {
		womenPage = homePage.clickOnWomenLink();
	}
	
	@Test(priority=13)
	public void verifyMenLinkTest() {
		menPage = homePage.clickOnMenLink();
	}
	
	@Test(priority=14)
	public void verifySportsLinkTest() {
		sportsPage = homePage.clickOnSportsLink();
	}
	
	@Test(priority=15)
	public void verifyFootwearLinkTest() {
		footwearPage = homePage.clickOnFootwearLink();
	}
	
	@Test(priority=16)
	public void verifyBagsLinkTest() {
		bagsPage = homePage.clickOnBagsLink();
	}
	
	@Test(priority=17)
	public void verifyWatchesAndSunglassesLinkTest() {
		watchesAndSunglassesPage = homePage.clickOnWatchesAndSunglassesLink();
	}
	
	@Test(priority=18)
	public void verifyJewelleryLinkTest() {
		jewelleryPage = homePage.clickOnJewelleryLink();
	}
	
	@Test(priority=19)
	public void verifyKidsLinkTest() {
		kidsPage = homePage.clickOnKidsLink();
	}
	
	@Test(priority=20)
	public void verifyHomeAndLifeStyleLinkTest() {
		homeAndLifeStylePage = homePage.clickOnHomeAndLifeStyleLink();
	}
	
	@Test(priority=21)
	public void verifyFoodAndBeverageLinkTest() {
		foodAndBeveragePage = homePage.clickOnFoodAndBeverageLink();
	}
	
	@Test(priority=22)
	public void verifySouvenirsAndGiftsLinkTest() {
		souvenirsAndGiftsPage = homePage.clickOnSouvenirsAndGiftsLink();
	}
	
	@Test(priority=23)
	public void verifyLoginPageLinkTest() {
		loginPage = homePage.clickOnLoginLink();
	}
	
	@Test(priority=24)
	public void verifySignUpLinkTest() {
		signUpPage = homePage.clickOnSignUpLink();
	}
	
}
