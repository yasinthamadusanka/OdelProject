package com.odel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.odel.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//img[@src='/images/logo_white.png']")
	WebElement logo;
	
	@FindBy(xpath="//ul[@class='main-menu']//a[normalize-space()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//ul[@class='main-menu']//a[normalize-space()='New Collection']")
	WebElement newCollectionLink;
	
	@FindBy(xpath="//ul[@class='main-menu']//a[normalize-space()='Shop By Brands']")
	WebElement shopByBrandsLink;
	
	@FindBy(xpath="//body/div[@class='super_container']/div[contains(@class,'header-container')]/header/div[@class='container-menu-desktop']/div[@class='wrap-menu-desktop']/nav[@class='limiter-menu-desktop container']/div[@class='container-dep-menu-desktop menu-desktop']/div[1]/div[1]/a[1]")
	WebElement uniSexLink;

	@FindBy(xpath="//body/div[@class='super_container']/div[contains(@class,'header-container')]/header/div[@class='container-menu-desktop']/div[@class='wrap-menu-desktop']/nav[@class='limiter-menu-desktop container']/div[@class='container-dep-menu-desktop menu-desktop']/div[1]/div[2]/a[1]")
	WebElement womenLink;
	
	@FindBy(xpath="//body/div[@class='super_container']/div[contains(@class,'header-container')]/header/div[@class='container-menu-desktop']/div[@class='wrap-menu-desktop']/nav[@class='limiter-menu-desktop container']/div[@class='container-dep-menu-desktop menu-desktop']/div[1]/div[3]/a[1]")
	WebElement menLink;
	
	@FindBy(xpath="//div[@class='dep_nav_item dep_li']//a[contains(text(),'SPORTS')]")
	WebElement sportsLink;
	
	@FindBy(xpath="//div[@class='dep_nav_item dep_li']//a[contains(text(),'FOOTWEAR')]")
	WebElement footwearLink;
	
	@FindBy(xpath="//div[@class='dep_nav_item dep_li']//a[contains(text(),'BAGS')]")
	WebElement bagsLink;
	
	@FindBy(xpath="//div[@class='dep_nav_item dep_li']//a[contains(text(),'WATCHES & SUNGLASSES')]")
	WebElement watchesAndSunglassesLink;
	
	@FindBy(xpath="//div[@class='dep_nav_item dep_li']//a[contains(text(),'JEWELLERY')]")
	WebElement jewelleryLink;
	
	@FindBy(xpath="//body/div[@class='super_container']/div[contains(@class,'header-container')]/header/div[@class='container-menu-desktop']/div[@class='wrap-menu-desktop']/nav[@class='limiter-menu-desktop container']/div[@class='container-dep-menu-desktop menu-desktop']/div[2]/div[1]/a[1]")
	WebElement kidsLink;
	
	@FindBy(xpath="//div[@class='dep_nav_item dep_li']//a[contains(text(),'HOME & LIFESTYLE')]")
	WebElement homeAndLifeStyleLink;
	
	@FindBy(xpath="//div[@class='dep_nav_item dep_li']//a[contains(text(),'FOOD & BEVERAGES')]")
	WebElement foodAndBeverageLink;
	
	@FindBy(xpath="//div[@class='dep_nav_item dep_li']//a[contains(text(),'SOUVENIRS & GIFTS')]")
	WebElement souvenirsAndGiftsLink;
	
	@FindBy(xpath="//i[@class='zmdi zmdi-account-circle']")
	WebElement accountCircle;
	
	@FindBy(xpath="//a[normalize-space()='LogIn']")
	WebElement loginLink;
	
	@FindBy(xpath="//a[@class='flex-c-m trans-04 p-lr-25'][normalize-space()='Register']")
	WebElement signUpLink;
	
	@FindBy(xpath = "//a[@class='flex-c-m trans-04 p-lr-25'][normalize-space()='My Account']")
    WebElement accountLink;
	
	@FindBy(xpath = "//div[@class='icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search col-4']//i[@class='zmdi zmdi-search']")
    WebElement searchIcon;
	
	@FindBy(xpath = "//a[@class='icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-cart col-4']//i[@class='zmdi zmdi-shopping-cart']")
    WebElement cartIcon;
	
	
	@FindBy(xpath = "//a[@class='dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 col-4 my_fav_icon__']//i[@class='zmdi zmdi-favorite-outline']")
    WebElement profileIcon;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyHomePageLogo() {
		return logo.isDisplayed();
	}
	
	public boolean verifyAccountLinkDisplay() {
		Actions action = new Actions(driver);
		action.moveToElement(accountCircle).build().perform();
		return accountLink.isDisplayed();
	}
	
	public boolean verifySearchIconDisplay() {
		return searchIcon.isDisplayed();
	}
	
	public boolean verifyCartIconDisplay() {
		return cartIcon.isDisplayed();
	}
	
	public boolean verifyProfileIconDisplay() {
		return profileIcon.isDisplayed();
	}
	
	public boolean verifyAccountIconDisplay() {
		return accountCircle.isDisplayed();
	}
	
	public HomePage clickOnLogo() {
		logo.click();
		return new HomePage();
	}
	
	public LoginPage clickOnLoginLink() {
		Actions action = new Actions(driver);
		action.moveToElement(accountCircle).build().perform();
		loginLink.click();
		return new LoginPage();
	}
	
	public SignUpPage clickOnSignUpLink() {
		Actions action = new Actions(driver);
		action.moveToElement(accountCircle).build().perform();
		signUpLink.click();
		return new SignUpPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public NewCollectionPage clickOnNewCollectionLink() {
		newCollectionLink.click();
		return new NewCollectionPage();
	}
	
	public ShopByBrandsPage clickOnShopByBrandsLink() {
		shopByBrandsLink.click();
		return new ShopByBrandsPage();
	}
	
	public UniSexPage clickOnUniSexLink() {
		uniSexLink.click();
		return new UniSexPage();
	}
	
	public WomenPage clickOnWomenLink() {
		womenLink.click();
		return new WomenPage();
	}
	
	public MenPage clickOnMenLink() {
		menLink.click();
		return new MenPage();
	}
	
	public SportsPage clickOnSportsLink() {
		sportsLink.click();
		return new SportsPage();
	}
	
	public FootwearPage clickOnFootwearLink() {
		footwearLink.click();
		return new FootwearPage();
	}
	
	public BagsPage clickOnBagsLink() {
		bagsLink.click();
		return new BagsPage();
	}
	
	public WatchesAndSunglassesPage clickOnWatchesAndSunglassesLink() {
		watchesAndSunglassesLink.click();
		return new WatchesAndSunglassesPage();
	}
	
	public JewelleryPage clickOnJewelleryLink() {
		jewelleryLink.click();
		return new JewelleryPage();
	}
	
	public KidsPage clickOnKidsLink() {
		kidsLink.click();
		return new KidsPage();
	}
	
	public HomeAndLifeStylePage clickOnHomeAndLifeStyleLink() {
		homeAndLifeStyleLink.click();
		return new HomeAndLifeStylePage();
	}
	
	public FoodAndBeveragePage clickOnFoodAndBeverageLink() {
		foodAndBeverageLink.click();
		return new FoodAndBeveragePage();
	}
	
	public SouvenirsAndGiftsPage clickOnSouvenirsAndGiftsLink() {
		souvenirsAndGiftsLink.click();
		return new SouvenirsAndGiftsPage();
	}
	
	public void clickOnAccountCircleLogin() {
		Actions action = new Actions(driver);
		action.moveToElement(accountCircle).build().perform();
		loginLink.click();
	}
	
	public void clickOnAccountCircleSignUp() {
		Actions action = new Actions(driver);
		action.moveToElement(accountCircle).build().perform();
		signUpLink.click();
	}
}
