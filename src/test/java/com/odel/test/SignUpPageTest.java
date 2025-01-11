package com.odel.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.odel.base.BaseClass;
import com.odel.pages.HomePage;
import com.odel.pages.LoginPage;
import com.odel.pages.SignUpPage;

public class SignUpPageTest extends BaseClass{
	HomePage homePage;
	SignUpPage signUpPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		signUpPage = new SignUpPage();
		loginPage = new LoginPage();
	}
	
	private void navigateToSignUpPage() {
		homePage.clickOnAccountCircleSignUp();
	}
	
	@Test(priority=1)
	public void verifySignUpPageTitleTest() {
		navigateToSignUpPage();
		String loginPageTitle = signUpPage.verifySignUpPageTitle();
		Assert.assertEquals(loginPageTitle, "Register | Odel.lk","Register page title not matched");
	}
	
	
	@Test(priority=2)
	public void verifySignUpPageLabelTest() {
		navigateToSignUpPage();
		Assert.assertTrue(signUpPage.verifySignUpPageLogo(),"Sign Up label is missing");
	}
	
	@Test(priority=3)
	public void verifyLoginPageButtonClickTest() {
		navigateToSignUpPage();
		loginPage = signUpPage.clickOnSignUpPageButton();
		Assert.assertNotNull(loginPage, "Failed to navigate to Login page");
	}
	
	@Test(priority = 4)
    public void forgotPasswordLinkTest() {
		navigateToSignUpPage();
        Assert.assertTrue(signUpPage.verifyForgotPasswordLink(), "Forgot Password link is not displayed");
        signUpPage.clickForgotPasswordLink();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("forgot"), "Forgot Password page URL is incorrect");
    }
	
	@Test(priority = 4)
	public void welcomeTextDisplayTest() {
		navigateToSignUpPage();
		Assert.assertTrue(signUpPage.verifyWelcomeTextDisplay(),"Message is not display");
	}
	
	@Test(priority=5)
	public void verifySignUpPageLogoClickTest() {
		navigateToSignUpPage();
		homePage = signUpPage.clickOnLoginPageLogo();
		Assert.assertNotNull(homePage, "Failed to navigate to Home page");
	}
	
}
